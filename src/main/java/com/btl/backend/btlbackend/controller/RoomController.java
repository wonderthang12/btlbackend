package com.btl.backend.btlbackend.controller;

import com.btl.backend.btlbackend.dto.ResponseMsg;
import com.btl.backend.btlbackend.dto.RoomDTO;
import com.btl.backend.btlbackend.service.RoomService;
import com.btl.backend.btlbackend.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rooms")
public class RoomController extends BaseController<RoomDTO, RoomService> {

    private final static Logger logger = LoggerFactory.getLogger(ScheduleController.class);

    @Autowired
    private RoomService service;

    @Autowired
    UserService userService;
    @Override
    protected RoomService getService() {
        return service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header")})
    @Override
    public ResponseEntity<ResponseMsg> create(@RequestBody RoomDTO dto) {
        return super.create(dto);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header")})
    @Override
    public ResponseEntity<ResponseMsg> update(@PathVariable("id") Long id, @RequestBody RoomDTO dto) {
        return super.update(id, dto);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header")})
    @Override
    public ResponseEntity<ResponseMsg> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }
}
