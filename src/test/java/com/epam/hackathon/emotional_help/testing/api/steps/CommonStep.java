package com.epam.hackathon.emotional_help.testing.api.steps;

import com.epam.hackathon.emotional_help.testing.api.utils.ResponseUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonStep {

    private final Logger logger = LoggerFactory.getLogger(CommonStep.class);
    private static final String BASE_URL = "http://localhost:8080";
    private static final String BASE_PATH = "";

    @Given("Setup Rest Assured")
    public void setupRestAssured() {
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "";
        logger.info("The BASE_URL is {}", BASE_URL);
        logger.info("The BASE_PATH is {}", BASE_PATH);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int expectedStatusCode) {
        logger.info("The expected status code is {}", expectedStatusCode);
        logger.info("The actual status code is {}", expectedStatusCode);
        int actualStatusCode = ResponseUtils.getStatusCodeFromResponse();
        Assertions.assertThat(actualStatusCode).isEqualTo(expectedStatusCode);
    }

}
