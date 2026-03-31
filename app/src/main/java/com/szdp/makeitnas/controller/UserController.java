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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

@Data
@RestController
@RequestMapping("/api/user")
@Tag(name = "User Controller")
public class UserController {
    
    private final UserService service;

    @GetMapping("/")
    @Operation(summary = "List all the users from the database")
    @ApiResponse(responseCode = "200", description = "Every user has been successfully returned")
    public List <UserRead> findAll() {
        return this.service.findAll();
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Finds the user with the specified id")
    @ApiResponse(responseCode = "200", description = "The user has been successfully returned")
    @ApiResponse(responseCode = "404", description = "No user was found in the database with the specified id")
    public UserRead findUserById(@PathVariable long id) {
        return this.service.findUserById(id);
    }

    @PostMapping("/save")
    @Operation(summary = "Saves the specified user in the database")
    @ApiResponse(responseCode = "200", description = "The user has been successfully saved")
    @ApiResponse(responseCode = "400", description = "Can not save user due to empty or partially empty input")
    public UserRead saveUser(@RequestBody UserSave save) {
        return this.service.saveUser(save);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary = "Updates the user with the specified id")
    @ApiResponse(responseCode = "200", description = "The user has been successfully updated")
    @ApiResponse(responseCode = "400", description = "Can not save user due to empty or partially empty input")
    @ApiResponse(responseCode = "404", description = "No user was found in the database with the specified id")
    public UserRead updateUser(@PathVariable long id, @RequestBody UserSave save) {
        return this.service.updateUser(id, save);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Deletes the user with the specified id from the database")
    @ApiResponse(responseCode = "200", description = "The user has been successfully deleted")
    @ApiResponse(responseCode = "404", description = "No user was found in the database with the specified id")
    public UserRead deleteUser(@PathVariable long id) {
        return this.service.deleteUser(id);
    }

}
