package com.epam.hackathon.emotional_help.testing.api.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserDto {
    private String name;
    private String username;
    private String password;
    private String confirmPassword;
    private String email;

}
