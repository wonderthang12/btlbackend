package com.btl.backend.btlbackend.service;

import com.btl.backend.btlbackend.dao.model.TeacherEntity;
import com.btl.backend.btlbackend.dao.repository.TeacherRepository;
import com.btl.backend.btlbackend.dto.TeacherDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends AbstractBaseService<TeacherEntity, TeacherDTO, TeacherRepository> implements TeacherService {

    private final static Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);

    private static ModelMapper modelMapper = null;

    @Autowired
    private TeacherRepository repository;

    @Autowired
    private UserService userService;

    @Override
    protected TeacherRepository getRepository() {
        return repository;
    }

    @Override
    protected void specificMapToDTO(TeacherEntity entity, TeacherDTO dto) {
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
    protected Class<TeacherEntity> getEntityClass() {
        return TeacherEntity.class;
    }

    @Override
    protected Class<TeacherDTO> getDtoClass() {
        return TeacherDTO.class;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    public TeacherDTO create(TeacherDTO dto) {
        userService.init();
        return super.create(dto);
    }

    @Override
    public TeacherDTO update(Long id, TeacherDTO dto) {
        userService.init();
        return super.update(id, dto);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
        userService.init();
    }
}
