package com.szdp.makeitnas.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserSave(
    @Schema(name = "Username", example = "John Doe") String username,
    @Schema(name = "Password", example = "Password123") String password
) {
    
    public UserSave() {
        this("", "");
    }

}