package com.btl.backend.btlbackend.service;

import com.btl.backend.btlbackend.dao.model.LearningDayEntity;
import com.btl.backend.btlbackend.dao.repository.LearningDayRepository;
import com.btl.backend.btlbackend.dto.LearningDayDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearningDayServiceImpl extends AbstractBaseService<LearningDayEntity, LearningDayDTO, LearningDayRepository> implements LearningDayService {

    private final static Logger logger = LoggerFactory.getLogger(LearningDayServiceImpl.class);

    private static ModelMapper modelMapper = null;

    @Autowired
    private LearningDayRepository repository;

    @Autowired
    private UserService userService;

    @Override
    protected LearningDayRepository getRepository() {
        return repository;
    }

    @Override
    protected void specificMapToDTO(LearningDayEntity entity, LearningDayDTO dto) {
        super.specificMapToDTO(entity, dto);
        dto.setCreatedName(userService.getUsernameById(entity.getCreatedBy()));
    }

    @Override
    protected ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE).setMatchingStrategy(MatchingStrategies.STRICT);
        }
        return modelMapper;    }

    @Override
    protected Class<LearningDayEntity> getEntityClass() {
        return LearningDayEntity.class;
    }

    @Override
    protected Class<LearningDayDTO> getDtoClass() {
        return LearningDayDTO.class;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    public LearningDayDTO create(LearningDayDTO dto) {
        userService.init();
        return super.create(dto);
    }

    @Override
    public LearningDayDTO update(Long id, LearningDayDTO dto) {
        userService.init();
        return super.update(id, dto);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
        userService.init();
    }
}
