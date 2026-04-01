package com.szdp.makeitnas.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserRead(
    @Schema(name = "User ID", example = "1") long id,
    @Schema(name = "Username", example = "John Doe") String username,
    @Schema(name = "Password", example = "Password123") String password
) {

    public UserRead() {
        this(0L, "", "");
    }
    
}
