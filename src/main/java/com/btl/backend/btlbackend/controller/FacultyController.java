package com.btl.backend.btlbackend.controller;

import com.btl.backend.btlbackend.dto.FacultyDTO;
import com.btl.backend.btlbackend.dto.ResponseMsg;
import com.btl.backend.btlbackend.service.FacultyService;
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
@RequestMapping(path = "/faculties")
public class FacultyController extends BaseController<FacultyDTO, FacultyService> {

    private final static Logger logger = LoggerFactory.getLogger(FacultyController.class);

    @Autowired
    FacultyService service;

    @Override
    protected FacultyService getService() {
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
    public ResponseEntity<ResponseMsg> create(@RequestBody FacultyDTO dto) {
        return super.create(dto);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header")})
    @Override
    public ResponseEntity<ResponseMsg> update(@PathVariable("id") Long id, @RequestBody FacultyDTO dto) {
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
