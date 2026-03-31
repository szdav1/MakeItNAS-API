package com.szdp.makeitnas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.szdp.makeitnas.converter.UserConverter;
import com.szdp.makeitnas.dto.UserRead;
import com.szdp.makeitnas.dto.UserSave;
import com.szdp.makeitnas.exception.InvalidUserDataException;
import com.szdp.makeitnas.exception.UserNotFoundException;
import com.szdp.makeitnas.model.User;
import com.szdp.makeitnas.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class UserService {
    
    private final UserRepository repository;

    public List <UserRead> findAll() {
        return UserConverter.convertListToRead(this.repository.findAll());
    }

    public UserRead findUserById(final long id) {
        return UserConverter.convertModelToRead(this.repository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(String.format("User with id={%d} not found", id))));
    }

    public UserRead saveUser(final UserSave save) {
        if (save.username().isBlank() || save.password().isBlank())
            throw new InvalidUserDataException(String.format("%s can not be empty", save.username().isBlank() ? "Username" : "Password"));

        return UserConverter.convertModelToRead(this.repository.save(UserConverter.convertSaveToModel(save)));
    }

    public UserRead updateUser(final long id, final UserSave save) {
        User user = this.repository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(String.format("Can't update user: No user found with id={%d}", id)));

        if (save.username().isBlank() || save.password().isBlank())
            throw new InvalidUserDataException(String.format("%s can not be empty", save.username().isBlank() ? "Username" : "Password"));

        user.setUsername(save.username());
        user.setPassword(save.password());
        this.repository.save(user);

        return UserConverter.convertModelToRead(user);
    }

    public UserRead deleteUser(final long id) {
        User user = this.repository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(String.format("Can't delete user: No user found with id={%d}", id)));

        this.repository.delete(user);
        return UserConverter.convertModelToRead(user);
    }

}
