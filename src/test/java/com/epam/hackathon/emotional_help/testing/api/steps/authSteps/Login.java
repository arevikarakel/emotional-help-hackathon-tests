package com.epam.hackathon.emotional_help.testing.api.steps.authSteps;

import com.epam.hackathon.emotional_help.testing.api.dataProviders.Endpoints;
import com.epam.hackathon.emotional_help.testing.api.dataProviders.SharedTestData;
import com.epam.hackathon.emotional_help.testing.api.utils.RequestUtils;
import com.epam.hackathon.emotional_help.testing.api.utils.ResponseUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Login {

    private final static Logger logger = LoggerFactory.getLogger(RequestUtils.class);
    private final Map<String, Object> queryParam = new HashMap<>();

    @When("Login with random user's credentials")
    public void loginWithRandomUserScredentials() {
        queryParam.put("password", SharedTestData.getPassword());
        queryParam.put("username", SharedTestData.getUsername());
        RequestUtils.postByQueryParam(Endpoints.SIGN_IN.getEndpoint(), queryParam);
        SharedTestData.setToken(ResponseUtils.getResponse().extract().asString());
        logger.info("Token is {}", ResponseUtils.getResponse().extract().asString());
    }

    @When("Login with invalid {string} and {string}")
    public void loginWithInvalidAnd(String username, String password) {
        queryParam.put("password", password);
        queryParam.put("username", username);
        RequestUtils.postByQueryParam(Endpoints.SIGN_IN.getEndpoint(), queryParam);
    }

    @Then("Validate invalid credentials login response messages")
    public void validateInvalidcredentialsLoginResponseMessages() {
        String invalidUsernameAndPasswordErrorMessage = "Invalid login and/or password";
        Assertions.assertThat(ResponseUtils.getResponse().extract().asPrettyString())
                .isEqualTo(invalidUsernameAndPasswordErrorMessage);
        logger.info("Login expected error message is - {}", invalidUsernameAndPasswordErrorMessage);
        logger.info("Login actual error message is - {}", ResponseUtils.getResponse().extract().asPrettyString());
    }
}
