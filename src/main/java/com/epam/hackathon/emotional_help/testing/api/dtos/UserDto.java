package com.epam.hackathon.emotional_help.testing.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class UserDto {

    private String name;
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
}

