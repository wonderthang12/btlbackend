package com.btl.backend.btlbackend.dao.repository;

import com.btl.backend.btlbackend.dao.model.PoetryEntity;
import com.btl.backend.btlbackend.dto.PoetryDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface PoetryRepository extends BaseRepository<PoetryEntity, PoetryDTO, Long> {
}
