package com.btl.backend.btlbackend.dao.repository;

import com.btl.backend.btlbackend.dao.model.StudentEntity;
import com.btl.backend.btlbackend.dto.StudentDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends BaseRepository<StudentEntity, StudentDTO, Long> {
}
