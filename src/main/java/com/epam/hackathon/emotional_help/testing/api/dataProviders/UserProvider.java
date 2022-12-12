package com.epam.hackathon.emotional_help.testing.api.dataProviders;

import com.epam.hackathon.emotional_help.testing.api.dtos.UserDto;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserProvider {

    private final static Logger logger = LoggerFactory.getLogger(UserProvider.class);

    private static String username;
    private static String password;
    private static String email;


    public static UserDto getRandomUser() {
        username = RandomStringUtils.randomAlphabetic(4);;
        password = username + "123";
        email = username + "@gmail.com";
        logger.info("Random user is {}", new UserDto( username, password, email));
        return new UserDto(username, password, email);
    }

    public static UserDto getRandomUserWithExistingUsername() {
        username = SharedTestData.getUsername();
        password = RandomStringUtils.randomAlphabetic(4) + "123";
        email = password + "@gmail.com";
        logger.info("Random user is {}", new UserDto(username, password, email));
        return new UserDto(username, password, email);
    }

    public static UserDto getRandomUserWithExistingEmail() {
        username = RandomStringUtils.randomAlphabetic(4);
        email = SharedTestData.getEmail();
        password = username + "123";
        logger.info("Random user is {}", new UserDto(username, password, email));
        return new UserDto(username, password, email);
    }

    public static UserDto getRandomUserWithInvalidPassword() {
        username = RandomStringUtils.randomAlphabetic(4);
        email = username + "@gmail.com";
        password = username + "12";
        logger.info("Random user is {}", new UserDto( username, password, email));
        return new UserDto(username, password, email);
    }
}
