package com.szdp.makeitnas.dto;

public record UserSave(String username, String password) {
    
    public UserSave() {
        this("", "");
    }

}