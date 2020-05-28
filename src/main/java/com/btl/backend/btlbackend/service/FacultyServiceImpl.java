package com.btl.backend.btlbackend.service;

import com.btl.backend.btlbackend.dao.model.FacultyEntity;
import com.btl.backend.btlbackend.dao.repository.FacultyRepository;
import com.btl.backend.btlbackend.dto.FacultyDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl extends AbstractBaseService<FacultyEntity, FacultyDTO, FacultyRepository> implements FacultyService {
    private final static Logger logger = LoggerFactory.getLogger(FacultyServiceImpl.class);

    private static ModelMapper modelMapper = null;

    @Autowired
    private FacultyRepository repository;

    @Autowired
    private UserService userService;

    @Override
    protected FacultyRepository getRepository() {
        return repository;
    }

    @Override
    protected void specificMapToDTO(FacultyEntity entity, FacultyDTO dto) {
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
    protected Class<FacultyEntity> getEntityClass() {
        return FacultyEntity.class;
    }

    @Override
    protected Class<FacultyDTO> getDtoClass() {
        return FacultyDTO.class;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    public FacultyDTO create(FacultyDTO dto) {
        userService.init();
        return super.create(dto);
    }

    @Override
    public FacultyDTO update(Long id, FacultyDTO dto) {
        userService.init();
        return super.update(id, dto);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
        userService.init();
    }
}
