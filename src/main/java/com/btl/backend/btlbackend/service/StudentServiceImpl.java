package com.btl.backend.btlbackend.service;

import com.btl.backend.btlbackend.dao.model.StudentEntity;
import com.btl.backend.btlbackend.dao.repository.StudentRepository;
import com.btl.backend.btlbackend.dto.StudentDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends AbstractBaseService<StudentEntity, StudentDTO, StudentRepository> implements StudentService {

    private final static Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private static ModelMapper modelMapper = null;

    @Autowired
    private StudentRepository repository;

    @Autowired
    private UserService userService;

    @Override
    protected StudentRepository getRepository() {
        return repository;
    }

    @Override
    protected void specificMapToDTO(StudentEntity entity, StudentDTO dto) {
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
    protected Class<StudentEntity> getEntityClass() {
        return StudentEntity.class;
    }

    @Override
    protected Class<StudentDTO> getDtoClass() {
        return StudentDTO.class;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    public StudentDTO create(StudentDTO dto) {
        userService.init();
        return super.create(dto);
    }

    @Override
    public StudentDTO update(Long id, StudentDTO dto) {
        userService.init();
        return super.update(id, dto);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
        userService.init();
    }
}
