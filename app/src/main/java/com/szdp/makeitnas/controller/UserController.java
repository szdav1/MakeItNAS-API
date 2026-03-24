package com.szdp.makeitnas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.szdp.makeitnas.dto.UserRead;
import com.szdp.makeitnas.dto.UserSave;
import com.szdp.makeitnas.service.UserService;

import lombok.Data;

@Data
@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private final UserService service;

    @GetMapping("/")
    public List<UserRead> findAll() {
        return this.service.findAll();
    }
    
    @GetMapping("/{id}")
    public UserRead findUserById(@PathVariable long id) {
        return this.service.findUserById(id);
    }

    @PostMapping("/save")
    public UserRead saveUser(@RequestBody UserSave save) {
        return this.service.saveUser(save);
    }
    
    @PutMapping("/update/{id}")
    public UserRead updateUser(@PathVariable long id, @RequestBody UserSave save) {
        return this.service.updateUser(id, save);
    }

    @DeleteMapping("/delete/{id}")
    public UserRead deleteUser(@PathVariable long id) {
        return this.service.deleteUser(id);
    }
}
