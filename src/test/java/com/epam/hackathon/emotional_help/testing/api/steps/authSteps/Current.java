package com.epam.hackathon.emotional_help.testing.api.steps.authSteps;

import com.epam.hackathon.emotional_help.testing.api.dataProviders.Endpoints;
import com.epam.hackathon.emotional_help.testing.api.dataProviders.SharedTestData;
import com.epam.hackathon.emotional_help.testing.api.utils.RequestUtils;
import com.epam.hackathon.emotional_help.testing.api.utils.ResponseUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Current {

    private final static Logger logger = LoggerFactory.getLogger(Registration.class);
    @Then("Get registered user's body")
    public void getRegisteredUserSBody() {
        RequestUtils.get(Endpoints.CURRENT.getEndpoint(), "Bearer " + SharedTestData.getToken());
        SharedTestData.setExistingUserId(ResponseUtils.getIntFromResponse("id"));
    }

    @Then("Validate new registered user's response body by jsonSchema")
    public void validateNewRegisteredUserSResponseBodyByJsonSchema() {
        ResponseUtils.validateResponseAgainstJSONSchema("schemas/RegisteredUsersResponseBodySchema.json");
    }

    @Then("New registered user's response body encrypt password")
    public void newRegisteredUserSResponseBodyEncryptPassword() {
        logger.info("Encrypted password from response is {}",ResponseUtils.getStringFromResponse("password"));
        logger.info("Password for registration is {}", SharedTestData.getPassword());
        Assert.assertNotEquals(ResponseUtils.getStringFromResponse("password"), SharedTestData.getPassword());
    }
}
