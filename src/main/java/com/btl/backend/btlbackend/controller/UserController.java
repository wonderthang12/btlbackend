package com.btl.backend.btlbackend.controller;

import com.btl.backend.btlbackend.dto.UserDTO;
import com.btl.backend.btlbackend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController extends BaseController<UserDTO, UserService> {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService service;


    @Override
    protected UserService getService() {
        return service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @PutMapping("{id}/block")
    public ResponseEntity<?> block(@PathVariable("id") Long id) {
        return response(service.block(id));
    }

    @PutMapping(path = "/{id}/reset-password")
    public ResponseEntity<?> resetPassword(@PathVariable("id") Long id) {
        return response(service.resetPassword(id));
    }

    @PutMapping(path = "/{id}/password")
    public ResponseEntity<?> updatePassword(@PathVariable("id") Long id, @RequestBody UserDTO userDto) {
        return response(service.updatePassword(id, userDto));
    }

    @PutMapping(path = "/{id}/email")
    public ResponseEntity<?> updateEmail(@PathVariable("id") Long id, @RequestBody UserDTO userDto) {
        return response(service.updateEmail(id, userDto));
    }

    @PutMapping(path = "/{id}/avatar")
    public ResponseEntity<?> updateAvatar(@PathVariable("id") Long id, @RequestBody UserDTO userDto) {
        return response(service.updateAvatar(id, userDto));
    }
}
