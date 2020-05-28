package com.btl.backend.btlbackend.dao.repository;

import com.btl.backend.btlbackend.dao.model.ClassesEntity;
import com.btl.backend.btlbackend.dto.ClassesDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends BaseRepository<ClassesEntity, ClassesDTO, Long> {
}
