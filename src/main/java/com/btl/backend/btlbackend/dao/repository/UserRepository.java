package com.btl.backend.btlbackend.dao.repository;

import com.btl.backend.btlbackend.dao.model.UserEntity;
import com.btl.backend.btlbackend.dto.UserDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends BaseRepository<UserEntity, UserDTO, Long> {

    @Transactional
    boolean existsByUsername(String username);

    UserEntity findFirstByEmail(String email);

    UserEntity findFirstByUsername(String username);
}
