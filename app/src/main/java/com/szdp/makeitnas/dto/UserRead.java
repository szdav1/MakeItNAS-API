package com.szdp.makeitnas.dto;

public record UserRead(long id, String username, String password) {

    public UserRead() {
        this(0L, "", "");
    }
    
}
