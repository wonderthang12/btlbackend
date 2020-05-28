package com.btl.backend.btlbackend.dao.repository;

import com.btl.backend.btlbackend.dao.model.RoomEntity;
import com.btl.backend.btlbackend.dto.RoomDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends BaseRepository<RoomEntity, RoomDTO, Long> {
}
