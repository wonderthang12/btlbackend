package com.btl.backend.btlbackend.dao.repository;

import com.btl.backend.btlbackend.dao.model.TeacherEntity;
import com.btl.backend.btlbackend.dto.TeacherDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends BaseRepository<TeacherEntity, TeacherDTO, Long> {
}
