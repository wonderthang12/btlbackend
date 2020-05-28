package com.btl.backend.btlbackend.service;

import com.btl.backend.btlbackend.dao.model.RoomEntity;
import com.btl.backend.btlbackend.dao.repository.RoomRepository;
import com.btl.backend.btlbackend.dto.RoomDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl extends AbstractBaseService<RoomEntity, RoomDTO, RoomRepository> implements RoomService {

    private final static Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);

    private static ModelMapper modelMapper = null;

    @Autowired
    private RoomRepository repository;

    @Autowired
    private UserService userService;

    @Override
    protected RoomRepository getRepository() {
        return repository;
    }

    @Override
    protected void specificMapToDTO(RoomEntity entity, RoomDTO dto) {
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
    protected Class<RoomEntity> getEntityClass() {
        return RoomEntity.class;
    }

    @Override
    protected Class<RoomDTO> getDtoClass() {
        return RoomDTO.class;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    public RoomDTO create(RoomDTO dto) {
        userService.init();
        return super.create(dto);
    }

    @Override
    public RoomDTO update(Long id, RoomDTO dto) {
        userService.init();
        return super.update(id, dto);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
        userService.init();
    }
}
