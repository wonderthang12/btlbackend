package com.btl.backend.btlbackend.dao.repository;

import com.btl.backend.btlbackend.dao.model.FacultyEntity;
import com.btl.backend.btlbackend.dao.model.StudentEntity;
import com.btl.backend.btlbackend.dto.FacultyDTO;
import com.btl.backend.btlbackend.dto.StudentDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends BaseRepository<FacultyEntity, FacultyDTO, Long> {
}
