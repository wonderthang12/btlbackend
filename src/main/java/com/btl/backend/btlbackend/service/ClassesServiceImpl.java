package com.btl.backend.btlbackend.service;

import com.btl.backend.btlbackend.dao.model.ClassesEntity;
import com.btl.backend.btlbackend.dao.repository.ClassesRepository;
import com.btl.backend.btlbackend.dto.ClassesDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
 class ClassesServiceImpl extends AbstractBaseService<ClassesEntity, ClassesDTO, ClassesRepository> implements ClassesService {

    private final static Logger logger = LoggerFactory.getLogger(ClassesServiceImpl.class);

    private static ModelMapper modelMapper = null;

    @Autowired
    private ClassesRepository repository;

    @Autowired
    private UserService userService;

    @Override
    protected ClassesRepository getRepository() {
        return null;
    }

    @Override
    protected void specificMapToDTO(ClassesEntity entity, ClassesDTO dto) {
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
    protected Class<ClassesEntity> getEntityClass() {
        return ClassesEntity.class;
    }

    @Override
    protected Class<ClassesDTO> getDtoClass() {
        return ClassesDTO.class;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    public ClassesDTO create(ClassesDTO dto) {
        userService.init();
        return super.create(dto);
    }

    @Override
    public ClassesDTO update(Long id, ClassesDTO dto) {
        userService.init();
        return super.update(id, dto);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
        userService.init();
    }
}
