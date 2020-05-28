package com.btl.backend.btlbackend.service;

import com.btl.backend.btlbackend.dao.model.PoetryEntity;
import com.btl.backend.btlbackend.dao.repository.PoetryRepository;
import com.btl.backend.btlbackend.dto.PoetryDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoetryServiceImpl extends AbstractBaseService<PoetryEntity, PoetryDTO, PoetryRepository> implements PoetryService {

    private final static Logger logger = LoggerFactory.getLogger(PoetryServiceImpl.class);

    private static ModelMapper modelMapper = null;

    @Autowired
    private PoetryRepository repository;

    @Autowired
    private UserService userService;

    @Override
    protected PoetryRepository getRepository() {
        return repository;
    }

    @Override
    protected void specificMapToDTO(PoetryEntity entity, PoetryDTO dto) {
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
    protected Class<PoetryEntity> getEntityClass() {
        return PoetryEntity.class;
    }

    @Override
    protected Class<PoetryDTO> getDtoClass() {
        return PoetryDTO.class;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    public PoetryDTO create(PoetryDTO dto) {
        userService.init();
        return super.create(dto);
    }

    @Override
    public PoetryDTO update(Long id, PoetryDTO dto) {
        userService.init();
        return super.update(id, dto);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
        userService.init();
    }
}
