package com.btl.backend.btlbackend.dao.repository;

import com.btl.backend.btlbackend.dao.model.StudentListEntity;
import com.btl.backend.btlbackend.dto.StudentListDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentListRepository extends BaseRepository<StudentListEntity, StudentListDTO, Long> {
}
