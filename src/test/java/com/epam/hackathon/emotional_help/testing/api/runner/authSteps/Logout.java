package com.epam.hackathon.emotional_help.testing.api.runner.authSteps;

import com.epam.hackathon.emotional_help.testing.api.dataProviders.Endpoints;
import com.epam.hackathon.emotional_help.testing.api.dataProviders.SharedTestData;
import com.epam.hackathon.emotional_help.testing.api.utils.RequestUtils;
import com.epam.hackathon.emotional_help.testing.api.utils.ResponseUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class Logout {
    @When("User should be logout")
    public void userShouldBeLogout() {
        RequestUtils.get(Endpoints.LOGOUT.getEndpoint(), "Bearer " + SharedTestData.getToken());
    }

    @Then("Validate successful logout response message")
    public void validateSuccessfulLogoutResponseMessage() {
        Assertions.assertThat(ResponseUtils.getResponse().extract().asString())
                .isEqualTo("true");
    }

    @When("Without token is not possible logout")
    public void withoutTokenIsNotPossibleLogout() {
        RequestUtils.get(Endpoints.LOGOUT.getEndpoint());
    }

}
