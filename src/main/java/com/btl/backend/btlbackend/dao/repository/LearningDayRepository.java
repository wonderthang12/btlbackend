package com.btl.backend.btlbackend.dao.repository;

import com.btl.backend.btlbackend.dao.model.LearningDayEntity;
import com.btl.backend.btlbackend.dto.LearningDayDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningDayRepository extends BaseRepository<LearningDayEntity, LearningDayDTO, Long> {
}
