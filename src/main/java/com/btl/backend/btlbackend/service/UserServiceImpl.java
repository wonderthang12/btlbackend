package com.btl.backend.btlbackend.service;

import com.btl.backend.btlbackend.dao.model.UserEntity;
import com.btl.backend.btlbackend.dao.repository.UserRepository;
import com.btl.backend.btlbackend.dto.LoginDTO;
import com.btl.backend.btlbackend.dto.UserDTO;
import com.btl.backend.btlbackend.enums.BlockEnum;
import com.btl.backend.btlbackend.exception.BaseException;
import com.btl.backend.btlbackend.msg.Msg;
import com.btl.backend.btlbackend.util.JWTokenUtils;
import com.btl.backend.btlbackend.util.StringUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Objects;
import java.util.UUID;

@Service
public class UserServiceImpl extends AbstractBaseService<UserEntity, UserDTO, UserRepository> implements UserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private static ModelMapper modelMapper = null;

    @Autowired
    private UserRepository repository;

    @Autowired
    private JWTokenUtils jwTokenUtils;

    @Override
    protected UserRepository getRepository() {
        return null;
    }

    @Override
    protected ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE).setMatchingStrategy(MatchingStrategies.STRICT);
        }
        return modelMapper;
    }

    @Override
    protected Class<UserEntity> getEntityClass() {
        return UserEntity.class;
    }

    @Override
    protected Class<UserDTO> getDtoClass() {
        return UserDTO.class;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    public UserDTO create(UserDTO dto) {
        UserEntity entity = mapToEntity(dto);

        if (Objects.isNull(entity.getUsername())) {
            entity.setUsername(generateUsername(entity.getName()));
        } else {
            if (repository.existsByUsername(dto.getUsername())) {
                throw new BaseException(100, Msg.getMessage("Tồn tại tên"));
            }
        }
        if (Objects.isNull(entity.getPassword())) {
            entity.setPassword(getHashPassword("123456", entity.getSalt()));
        } else {
            entity.setPassword(getHashPassword(entity.getPassword(), entity.getSalt()));
        }
        repository.save(entity);
        return mapToDTO(entity);
    }

    @Override
    public UserDTO update(Long id, UserDTO dto) {
        UserEntity entity = getById(id);
        if (!entity.getEmail().equals(dto.getEmail()) && repository.findFirstByEmail(dto.getEmail()) != null) {
            throw new BaseException(1001, Msg.getMessage("Tồn tại tài khoản"));
        }
        entity.setName(dto.getName());
        entity.setGender(dto.getGender());
        entity.setEmail(dto.getEmail());
        entity.setAvatar(dto.getAvatar());
        repository.save(entity);
        return mapToDTO(entity);
    }

    private String getRandomUUID() {
        return UUID.randomUUID().toString().replace('-', '_');
    }

    private String getHashPassword(String password, String salt) {
        if (salt == null) {
            salt = "";
        }

        return DigestUtils.sha256Hex(password + salt);
    }

    private String generateUsername(String name) {
        int index = 0;
        String nickName = StringUtil.deleteAccents(name).toLowerCase().replace(" ", "");
        while (repository.existsByUsername(nickName + (index == 0 ? "" : "" + index))) {
            index++;
        }
        return nickName + (index == 0 ? "" : "" + index);
    }

    @Override
    public String validateLogin(LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();

        if (username == null) {
            throw new BaseException(1, Msg.getMessage("Username null"));
        }

        if (password == null) {
            throw new BaseException(2, Msg.getMessage("Password null"));
        }

        UserEntity user = repository.findFirstByUsername(username.trim());
        if (!user.getPassword().equals(getHashPassword(password, user.getSalt()))) {
            throw new BaseException(3, Msg.getMessage("Tồn tại password"));
        }

        if (user.getBlock() == BlockEnum.BLOCKED) {
            throw new BaseException(4, Msg.getMessage("Tai khoan da bi khoa"));
        }

        user.setLoginToken(jwTokenUtils.generateToken(user.getId()));
        return jwTokenUtils.generateToken(user.getId());

    }

    @Override
    public UserDTO block(Long id) {
        UserEntity user = getById(id);

        user.setBlock(user.getBlock().equals(BlockEnum.BLOCKED) ? BlockEnum.UNBLOCKED : BlockEnum.BLOCKED);

        repository.save(user);
        return mapToDTO(user);
    }

    @Override
    public UserDTO resetPassword(Long id) {
        UserEntity user = getById(id);

        user.setPassword(getHashPassword("123456", user.getSalt()));
        repository.save(user);
        return mapToDTO(user);
    }

    @Override
    public UserDTO updatePassword(Long id, UserDTO userDto) {
        UserEntity entity = getById(id);
        if (!Objects.equals(entity.getPassword(), getHashPassword(userDto.getPassword(), entity.getSalt()))) {
            throw new BaseException(1001, "Tồn tại password");
        }
        String pasWordNew = userDto.getNewPassword();
        entity.setPassword(getHashPassword(pasWordNew, entity.getSalt()));
        repository.save(entity);
        return mapToDTO(entity);
    }

    @Override
    public UserDTO updateEmail(Long id, UserDTO userDto) {
        UserEntity user = getById(id);

        if (user.getEmail().equals(userDto.getEmail())) {
            return mapToDTO(user);
        }

        if (!Objects.equals(user.getPassword(), getHashPassword(userDto.getPassword(), user.getSalt()))) {
            throw new BaseException(1004, Msg.getMessage("Tồn tại password"));
        }

        if (!user.getEmail().equals(userDto.getEmail()) && repository.findFirstByEmail(userDto.getEmail()) != null) {
            throw new BaseException(1002, Msg.getMessage("Tồn tại email"));
        }

        user.setEmail(userDto.getEmail());

        repository.save(user);
        return mapToDTO(user);
    }

    @Override
    public UserDTO updateAvatar(Long id, UserDTO userDto) {
        UserEntity user = getById(id);
        user.setAvatar(userDto.getAvatar());

        repository.save(user);
        return mapToDTO(user);
    }
}