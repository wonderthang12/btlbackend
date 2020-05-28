package com.btl.backend.btlbackend.controller;

import com.btl.backend.btlbackend.dto.ClassesDTO;
import com.btl.backend.btlbackend.dto.ResponseMsg;
import com.btl.backend.btlbackend.service.ClassesService;
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
@RequestMapping(path = "/class")
public class ClassesController extends BaseController<ClassesDTO, ClassesService> {

    private final static Logger logger = LoggerFactory.getLogger(ClassesController.class);

    @Autowired
    ClassesService service;

    @Override
    protected ClassesService getService() {
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
    public ResponseEntity<ResponseMsg> create(@RequestBody ClassesDTO dto) {
        return super.create(dto);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header")})
    @Override
    public ResponseEntity<ResponseMsg> update(@PathVariable("id") Long id, @RequestBody ClassesDTO dto) {
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
