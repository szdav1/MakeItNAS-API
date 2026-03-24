package com.szdp.makeitnas.converter;

import java.util.ArrayList;
import java.util.List;

import com.szdp.makeitnas.dto.UserRead;
import com.szdp.makeitnas.dto.UserSave;
import com.szdp.makeitnas.model.User;

public class UserConverter {
    
    public static List<UserRead> convertListToRead(final List <User> users) {
        List <UserRead> reads = new ArrayList<>();
        users.forEach(user -> reads.add(convertModelToRead(user)));
        return reads;
    }

    public static UserRead convertModelToRead(final User user) {
        return new UserRead(user.getId(), user.getUsername(), user.getPassword());
    }

    public static User convertSaveToModel(final UserSave save) {
        return new User(save.username(), save.password());
    }

}
