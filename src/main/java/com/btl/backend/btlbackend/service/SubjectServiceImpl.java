package com.btl.backend.btlbackend.service;

import com.btl.backend.btlbackend.dao.model.SubjectEntity;
import com.btl.backend.btlbackend.dao.repository.SubjectRepository;
import com.btl.backend.btlbackend.dto.SubjectDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl extends AbstractBaseService<SubjectEntity, SubjectDTO, SubjectRepository> implements SubjectService {

    private final static Logger logger = LoggerFactory.getLogger(SubjectServiceImpl.class);

    private static ModelMapper modelMapper = null;

    @Autowired
    private SubjectRepository repository;

    @Autowired
    private UserService userService;

    @Override
    protected SubjectRepository getRepository() {
        return repository;
    }

    @Override
    protected void specificMapToDTO(SubjectEntity entity, SubjectDTO dto) {
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
    protected Class<SubjectEntity> getEntityClass() {
        return SubjectEntity.class;
    }

    @Override
    protected Class<SubjectDTO> getDtoClass() {
        return SubjectDTO.class;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    public SubjectDTO create(SubjectDTO dto) {
        userService.init();
        return super.create(dto);
    }

    @Override
    public SubjectDTO update(Long id, SubjectDTO dto) {
        userService.init();
        return super.update(id, dto);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
        userService.init();
    }
}
