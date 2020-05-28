package com.btl.backend.btlbackend.dao.repository;

import com.btl.backend.btlbackend.dao.model.SubjectEntity;
import com.btl.backend.btlbackend.dto.SubjectDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends BaseRepository<SubjectEntity, SubjectDTO, Long> {
}
