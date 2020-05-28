package com.btl.backend.btlbackend.service;

import com.btl.backend.btlbackend.dao.model.ScheduleEntity;
import com.btl.backend.btlbackend.dao.repository.ScheduleRepository;
import com.btl.backend.btlbackend.dao.repository.StudentRepository;
import com.btl.backend.btlbackend.dto.ScheduleDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl extends AbstractBaseService<ScheduleEntity, ScheduleDTO, ScheduleRepository> implements ScheduleService {

    private final static Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    private static ModelMapper modelMapper = null;

    @Autowired
    private ScheduleRepository repository;

    @Autowired
    private UserService userService;

    @Override
    protected ScheduleRepository getRepository() {
        return repository;
    }

    @Override
    protected void specificMapToDTO(ScheduleEntity entity, ScheduleDTO dto) {
        super.specificMapToDTO(entity, dto);
        dto.setCreatedName(userService.getUsernameById(entity.getCreatedBy()));
    }

    @Override
    protected ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE).setMatchingStrategy(MatchingStrategies.STRICT);
        }
        return modelMapper;
    }

    @Override
    protected Class<ScheduleEntity> getEntityClass() {
        return ScheduleEntity.class;
    }

    @Override
    protected Class<ScheduleDTO> getDtoClass() {
        return ScheduleDTO.class;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    public ScheduleDTO create(ScheduleDTO dto) {
        userService.init();
        return super.create(dto);
    }

    @Override
    public ScheduleDTO update(Long id, ScheduleDTO dto) {
        userService.init();
        return super.update(id, dto);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
        userService.init();
    }
}
