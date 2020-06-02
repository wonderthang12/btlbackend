package com.btl.backend.btlbackend.service;

import com.btl.backend.btlbackend.dao.model.UserEntity;
import com.btl.backend.btlbackend.dto.LoginDTO;
import com.btl.backend.btlbackend.dto.UserDTO;
import com.btl.backend.btlbackend.dto.UserPrincipal;
import org.springframework.security.core.Authentication;

public interface UserService extends BaseService<UserDTO> {

    String validateLogin(LoginDTO loginDTO);

    UserDTO block(Long id);

    UserDTO resetPassword(Long id);

    UserDTO updatePassword(Long id, UserDTO userDto);

    UserDTO updateEmail(Long id, UserDTO userDto);

    UserDTO updateAvatar(Long id, UserDTO userDto);

    void init();

    String getUsernameById(Long id);

}
