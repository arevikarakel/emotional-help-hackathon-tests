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

    @Given("Setup Rest Assured")
    public void setupRestAssured() {
        RestAssured.baseURI = "http://localhost:8080/";
        RestAssured.basePath = "";
        logger.info("The BASE_URL is {}", RestAssured.baseURI);
        logger.info("The BASE_PATH is {}", RestAssured.basePath);

    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int expectedStatusCode) {
        logger.info("The expected status code is {}", expectedStatusCode);
        int actualStatusCode = ResponseUtils.getStatusCodeFromResponse();
        logger.info("The actual status code is {}", actualStatusCode);
        Assertions.assertThat(actualStatusCode).isEqualTo(expectedStatusCode);
    }

}
