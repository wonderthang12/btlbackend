package com.btl.backend.btlbackend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.btl.backend.btlbackend.config.constant.JWTConst;
import com.btl.backend.btlbackend.enums.GenderEnum;
import com.btl.backend.btlbackend.enums.ValidateTokenResult;
import com.btl.backend.btlbackend.util.DateTimeUtils;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {

//    private byte[] secret;

//    public Map<String, Object> generateToken(Long id, String username, String email, GenderEnum gender, String avatar, Map<String, Object> additionalInformation){
//        Date now = new Date();
//        Date exp = new Date(System.currentTimeMillis() + (1000*30));
//
//        JwtBuilder jwtBuilder = Jwts.builder()
//                .claim("id", id)
//                .claim("username", username)
//                .claim("email", email)
//                .claim("gender", gender)
//                .claim("avatar", avatar);
//
//        String jwt = jwtBuilder.setIssuedAt(now)
//                .setNotBefore(now)
//                .setId(String.valueOf(Long.valueOf(id)))
//                .setExpiration(exp).compact();
//
//        additionalInformation.put("access_token", jwt);
//        additionalInformation.put("token_type", "bearer");
//        additionalInformation.put("id", id);
//        additionalInformation.put("username", username);
//        additionalInformation.put("email", email);
//        additionalInformation.put("gender", gender);
//        additionalInformation.put("avatar", avatar);
//
//        return  additionalInformation;
//    }

    public static String generateToken() {
        return generateToken((Map<String, Object>) null);
    }

    public static String generateToken(long id) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", id);
        return generateToken(map);
    }

    /**
     * Tao token tu Map param truyen vao
     *
     * @param map
     * @return
     */
    public static String generateToken(Map<String, Object> map) {
        String token = "";
        try {

            String secrete = JWTConst.JWT_KEY;
            Algorithm algorithm = Algorithm.HMAC256(secrete);
            JWTCreator.Builder builder = JWT.create();
            Date currentDate = DateTimeUtils.getCurrentDate();
            builder.withIssuedAt(currentDate);
            builder.withExpiresAt(DateTimeUtils.addDays(currentDate, 365));

            if (map != null) {
                map.forEach((key, value) -> {

                    if (value instanceof String) {
                        builder.withClaim(key, (String) value);
                    } else if (value instanceof Boolean) {
                        builder.withClaim(key, (Boolean) value);
                    } else if (value instanceof Integer) {
                        builder.withClaim(key, (Integer) value);
                    } else if (value instanceof Long) {
                        builder.withClaim(key, (Long) value);
                    } else if (value instanceof Double) {
                        builder.withClaim(key, (Double) value);
                    } else if (value instanceof Date) {
                        builder.withClaim(key, (Date) value);
                    } else if (value instanceof String[]) {
                        builder.withArrayClaim(key, (String[]) value);
                    } else if (value instanceof Long[]) {
                        builder.withArrayClaim(key, (Long[]) value);
                    } else if (value instanceof Integer[]) {
                        builder.withArrayClaim(key, (Integer[]) value);
                    }
                });
            }

            token = builder.sign(algorithm);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;

    }

    /**
     * Get Decoded JWT from string token
     *
     * @param token
     * @return
     */
    public static DecodedJWT getDecodedJWT(String token) throws Exception {
        try {
            String secrete = JWTConst.JWT_KEY;
            Algorithm algorithm = Algorithm.HMAC256(secrete);
            JWTVerifier verifier = JWT.require(algorithm).build();
            return verifier.verify(token);
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Lay danh sach claim trong token
     *
     * @param token
     * @return
     */
    public static Map<String, Claim> getClaims(String token) throws Exception {
        DecodedJWT decodedJWT = getDecodedJWT(token);
        return decodedJWT.getClaims();
    }

    /**
     * Lay chi tiet key tu token
     *
     * @param token
     * @param key
     * @return
     */
    public static Claim getClaimsByKey(String token, String key) throws Exception {
        return getClaims(token).get(key);
    }

    public static Long getUserIdFromToken(String token) {
        try {
            return getClaimsByKey(token, "userId").asLong();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Check token status
     *
     * @param token
     * @return
     */
    public static ValidateTokenResult validateToken(String token) {
        try {
            DecodedJWT jwt = getDecodedJWT(token);
            if (jwt.getExpiresAt().getTime() < DateTimeUtils.getCurrentTimeInMilis()) {
                return ValidateTokenResult.EXPIRATED;
            }
            return ValidateTokenResult.SUCCESS;

        } catch (Exception ex) {
            ex.printStackTrace();
            return ValidateTokenResult.INVALID;
        }
    }


}
