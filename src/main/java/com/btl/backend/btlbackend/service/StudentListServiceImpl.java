package com.btl.backend.btlbackend.service;

import com.btl.backend.btlbackend.dao.model.StudentListEntity;
import com.btl.backend.btlbackend.dao.repository.StudentListRepository;
import com.btl.backend.btlbackend.dao.repository.StudentRepository;
import com.btl.backend.btlbackend.dto.StudentDTO;
import com.btl.backend.btlbackend.dto.StudentListDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentListServiceImpl extends AbstractBaseService<StudentListEntity, StudentListDTO, StudentListRepository> implements StudentListService {

    private final static Logger logger = LoggerFactory.getLogger(StudentListServiceImpl.class);

    private static ModelMapper modelMapper = null;

    @Autowired
    private StudentListRepository repository;

    @Autowired
    private UserService userService;


    @Override
    protected StudentListRepository getRepository() {
        return repository;
    }

    @Override
    protected void specificMapToDTO(StudentListEntity entity, StudentListDTO dto) {
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
    protected Class<StudentListEntity> getEntityClass() {
        return StudentListEntity.class;
    }

    @Override
    protected Class<StudentListDTO> getDtoClass() {
        return StudentListDTO.class;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    public StudentListDTO create(StudentListDTO dto) {
        userService.init();
        return super.create(dto);
    }

    @Override
    public StudentListDTO update(Long id, StudentListDTO dto) {
        userService.init();
        return super.update(id, dto);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
        userService.init();
    }
}
