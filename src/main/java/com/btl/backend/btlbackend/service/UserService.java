package com.btl.backend.btlbackend.service;

import com.btl.backend.btlbackend.dto.LoginDTO;
import com.btl.backend.btlbackend.dto.UserDTO;

public interface UserService extends BaseService<UserDTO> {

    String validateLogin(LoginDTO loginDTO);

    UserDTO block(Long id);

    UserDTO resetPassword(Long id);

    UserDTO updatePassword(Long id, UserDTO userDto);

    UserDTO updateEmail(Long id, UserDTO userDto);

    UserDTO updateAvatar(Long id, UserDTO userDto);
}
