package com.epam.hackathon.emotional_help.testing.api.steps.emotionalMapSteps;

import com.epam.hackathon.emotional_help.testing.api.dtos.AnswerDto;
import com.epam.hackathon.emotional_help.testing.api.dtos.AnswerGroup;
import com.epam.hackathon.emotional_help.testing.api.dataProviders.Endpoints;
import com.epam.hackathon.emotional_help.testing.api.dataProviders.TestDataProvider;
import com.epam.hackathon.emotional_help.testing.api.utils.RequestUtils;
import com.epam.hackathon.emotional_help.testing.api.utils.ResponseUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmotionalMap {
    ObjectMapper mapper = new ObjectMapper();
    List<AnswerDto> list = new ArrayList<>();
    Map<String, Object> map = new HashMap<>();
    AnswerDto answerDto;
    String jsonData;
    private final Map<String, Object> queryParam = new HashMap<>();

    private final Logger logger = LoggerFactory.getLogger(EmotionalMap.class);

    @When("Get existing user's emotional-map")
    public void getExistingUserSEmotionalMap() {
        logger.info("Existing user id is {}", TestDataProvider.getPropertyValue("ExistingUserId"));
        queryParam.put("userId", TestDataProvider.getPropertyValue("ExistingUserId"));
        RequestUtils.getByQueryParams(Endpoints.EMOTIONAL_MAP.getEndpoint(), queryParam);
    }

    @Then("Validate nonExistent users emotional map response error message")
    public void validateNonExistentUsersEmotionalMapResponseErrorMessage() {
        String errorMessage = ResponseUtils.getResponse().extract().asPrettyString();
        Assertions.assertThat(errorMessage).contains("not found");
        logger.info("NonExistent users emotional map response error message is - {}", errorMessage);
    }

    @When("Get {} emotional-map response body")
    public void getNonExistentUserSEmotionalMapResponseBody(String nonExistentUserId) {
        queryParam.put("userId", nonExistentUserId);
        RequestUtils.getByQueryParams(Endpoints.EMOTIONAL_MAP.getEndpoint(), queryParam);
    }

    @When("Save emotional-map for anonymous user")
    public void saveEmotionalMapForAnonymousUser() throws JsonProcessingException {
        int markForHappyAnswer = Integer.parseInt(TestDataProvider.getPropertyValue("markForHappyAnswer"));
        answerDto = new AnswerDto("OK", markForHappyAnswer, AnswerGroup.HAPPY);
        list.add(answerDto);
        map.put("answers", list);
        jsonData = mapper.writeValueAsString(map);
        queryParam.put("userId", TestDataProvider.getPropertyValue("anonymousUUID"));
        RequestUtils.postByQueryParam(Endpoints.EMOTIONAL_MAP.getEndpoint(), jsonData, queryParam);
    }

    @Then("Validate user's saved emotional-map response body by jsonSchema")
    public void validateUserSSavedEmotionalMapResponseBodyByJsonSchema() {
        ResponseUtils.validateResponseAgainstJSONSchema("schemas/UsersEmotionalMapResponseBodySchema.json");
    }

    @Then("Check saved user's emotional-map value")
    public void checkSavedUserSEmotionalMapValue() {
        Assertions.assertThat(ResponseUtils.getIntFromResponse("[5].value")).isEqualTo(3);
        logger.info("Saved user's emotional-map value is - {}", ResponseUtils.getIntFromResponse("[5].value"));
    }

    @Then("Validate user's emotional-map response body by jsonSchema")
    public void validateUserSEmotionalMapResponseBodyByJsonSchema() {
        ResponseUtils.validateResponseAgainstJSONSchema("schemas/UsersEmotionalMapResponseBodySchema.json");
    }
}