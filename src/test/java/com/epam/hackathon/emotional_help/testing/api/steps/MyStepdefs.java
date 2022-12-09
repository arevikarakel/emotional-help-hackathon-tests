package com.epam.hackathon.emotional_help.testing.api.steps;

import com.epam.hackathon.emotional_help.testing.utils.RequestUtils;
import com.epam.hackathon.emotional_help.testing.utils.ResponseUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;

public class MyStepdefs {

    @Given("Setup Rest Assured")
    public void setupRestAssured() {
        RestAssured.baseURI = "https://gorest.co.in/";
        RestAssured.basePath = "public/v2/";
    }
    
    @When("Get all users")
    public void getAllUsers() {
        RequestUtils.get("users");
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int expectedStatusCode) {
        int actualStatusCode = ResponseUtils.getStatusCodeFromResponse();
        Assertions.assertThat(actualStatusCode).isEqualTo(expectedStatusCode);
    }
}
