package com.btl.backend.btlbackend.dao.repository;

import com.btl.backend.btlbackend.dao.model.ScheduleEntity;
import com.btl.backend.btlbackend.dto.ScheduleDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends BaseRepository<ScheduleEntity, ScheduleDTO, Long> {
}
