package com.btl.backend.btlbackend.controller;

import com.btl.backend.btlbackend.dto.StudentDTO;
import com.btl.backend.btlbackend.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/menus")
public class StudentController extends BaseController<StudentDTO, StudentService> {

    private final static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService service;

    @Override
    protected StudentService getService() {
        return service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }
}
