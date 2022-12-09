package com.epam.hackathon.emotional_help.testing.api.dataProviders;

import com.epam.hackathon.emotional_help.testing.api.dtos.UserDto;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserProvider {

    private final static Logger logger = LoggerFactory.getLogger(UserProvider.class);

    private static String name;
    private static String username;
    private static String password;
    private static String confirmPassword;
    private static String email;


    public static UserDto getRandomUser() {
        name = RandomStringUtils.randomAlphabetic(4);
        username = name + "map";
        password = username + "123";
        confirmPassword = password;
        email = username + "@gmail.com";
        logger.info("Random user is {}", new UserDto(name, username, password, confirmPassword, email));
        return new UserDto(name, username, password, confirmPassword, email);
    }

    public static UserDto getRandomUserWithExistingUsername() {
        name = RandomStringUtils.randomAlphabetic(4);
        username = SharedTestData.getUsername();
        password = RandomStringUtils.randomAlphabetic(4) + "123";
        confirmPassword = password;
        email = password + "@gmail.com";
        logger.info("Random user is {}", new UserDto(name, username, password, confirmPassword, email));
        return new UserDto(name, username, password, confirmPassword, email);
    }

    public static UserDto getRandomUserWithExistingEmail() {
        name = RandomStringUtils.randomAlphabetic(4);
        username = RandomStringUtils.randomAlphabetic(4);
        email = SharedTestData.getEmail();
        password = username + "123";
        confirmPassword = password;
        logger.info("Random user is {}", new UserDto(name, username, password, confirmPassword, email));
        return new UserDto(name, username, password, confirmPassword, email);
    }

    public static UserDto getRandomUserWithInvalidPassword() {
        name = RandomStringUtils.randomAlphabetic(4);
        username = name + "map";
        email = username + "@gmail.com";
        password = name + "12";
        confirmPassword = password;
        logger.info("Random user is {}", new UserDto(name, username, password, confirmPassword, email));
        return new UserDto(name, username, password, confirmPassword, email);
    }
}
