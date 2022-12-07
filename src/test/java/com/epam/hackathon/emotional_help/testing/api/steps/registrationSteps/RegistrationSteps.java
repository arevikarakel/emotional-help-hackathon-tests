package com.epam.hackathon.emotional_help.testing.api.steps.registrationSteps;

import com.epam.hackathon.emotional_help.testing.api.dtos.CreateUserDto;
import com.epam.hackathon.emotional_help.testing.api.utils.RequestUtils;
import com.epam.hackathon.emotional_help.testing.api.utils.ResponseUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class RegistrationSteps {

    private CreateUserDto newUser;

    @When("Register a user with valid data")
    public void register_a_user_with_valid_data() {
        newUser = CreateUserDto.builder()
                .email("user@epam.com")
                .name("User User")
                .username("user")
                .password("1234567")
                .confirmPassword("1234567")
                .build();
        RequestUtils.postWithJsonBody("/api/user/create", newUser);
    }


    @And("Returned user contains correct data")
    public void returnedUserHasContainsCorrectData() {
        assertEquals(ResponseUtils.getStringFromResponse("email"), newUser.getEmail());
        assertEquals(ResponseUtils.getStringFromResponse("name"), newUser.getName());
        assertEquals(ResponseUtils.getStringFromResponse("username"), newUser.getUsername());
    }
}
