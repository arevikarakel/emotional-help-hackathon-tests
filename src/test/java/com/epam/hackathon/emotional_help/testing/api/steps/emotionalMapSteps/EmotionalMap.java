package com.epam.hackathon.emotional_help.testing.api.steps.emotionalMapSteps;

import com.epam.hackathon.emotional_help.testing.api.data_provider.TestDataProvider;
import com.epam.hackathon.emotional_help.testing.api.steps.CommonStep;
import com.epam.hackathon.emotional_help.testing.api.utils.RequestUtils;
import com.epam.hackathon.emotional_help.testing.api.utils.ResponseUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class EmotionalMap {

    private final Map<String, Object> queryParam = new HashMap<>();

    private final Logger logger = LoggerFactory.getLogger(EmotionalMap.class);

    @When("Get existing user's emotional-map")
    public void getExistingUserSEmotionalMap() {
        logger.info("Existing user id is {}", TestDataProvider.getPropertyValue("ExistingUserId"));
        queryParam.put("userId", TestDataProvider.getPropertyValue("ExistingUserId"));
        RequestUtils.getByQueryParams("emotional-maps", queryParam);
    }

    @Then("Validate nonExistent users emotional map response error message")
    public void validateNonExistentUsersEmotionalMapResponseErrorMessage() {
        String errorMessage = ResponseUtils.getResponse().extract().asPrettyString();
        Assertions.assertThat(errorMessage).contains(TestDataProvider.getPropertyValue("nonExistentUsersErrorMessage"));
    }

    @When("Get {} emotional-map response body")
    public void getNonExistentUserSEmotionalMapResponseBody(Object nonExistentUserId) {
        queryParam.put("userId", nonExistentUserId);
        RequestUtils.getByQueryParams("emotional-maps", queryParam);
    }
}
