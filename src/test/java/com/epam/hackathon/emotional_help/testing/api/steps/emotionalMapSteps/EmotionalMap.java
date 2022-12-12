package com.epam.hackathon.emotional_help.testing.api.steps.emotionalMapSteps;

import com.epam.hackathon.emotional_help.testing.api.dataProviders.SharedTestData;
import com.epam.hackathon.emotional_help.testing.api.dtos.AnswerDto;
import com.epam.hackathon.emotional_help.testing.api.dtos.AnswerGroup;
import com.epam.hackathon.emotional_help.testing.api.dataProviders.Endpoints;
import com.epam.hackathon.emotional_help.testing.api.dataProviders.TestDataProvider;
import com.epam.hackathon.emotional_help.testing.api.dtos.AnswersDto;
import com.epam.hackathon.emotional_help.testing.api.utils.RequestUtils;
import com.epam.hackathon.emotional_help.testing.api.utils.ResponseUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
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
    String jsonData;
    private final Map<String, Object> queryParam = new HashMap<>();

    private final Logger logger = LoggerFactory.getLogger(EmotionalMap.class);

    @When("Get existing user's emotional-map")
    public void getExistingUserSEmotionalMap() {
        logger.info("Existing user id is {}", SharedTestData.getExistingUserId());
        queryParam.put("userId", SharedTestData.getExistingUserId());
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

    @Then("Validate user's saved emotional-map response body by jsonSchema")
    public void validateUserSSavedEmotionalMapResponseBodyByJsonSchema() {
        ResponseUtils.validateResponseAgainstJSONSchema("schemas/UsersEmotionalMapResponseBodySchema.json");
    }

    @Then("Validate user's emotional-map response body by jsonSchema")
    public void validateUserSEmotionalMapResponseBodyByJsonSchema() {
        ResponseUtils.validateResponseAgainstJSONSchema("schemas/UsersEmotionalMapResponseBodySchema.json");
    }

    @SneakyThrows
    @When("Save new emotional-map for anonymous user who has none")
    public void saveNewEmotionalMapForAnonymousUserWhoHasNone() {
        int markForHappyAnswer = Integer.parseInt(TestDataProvider.getPropertyValue("markForHappyAnswer"));
        AnswerDto answerDto = new AnswerDto("OK", markForHappyAnswer, AnswerGroup.HAPPY);
        list.add(answerDto);
        map.put("answers", list);
        jsonData = mapper.writeValueAsString(map);
        logger.info("New emotional-map's body for anonymous user who has none is - {}", jsonData);
        queryParam.put("userId", TestDataProvider.getPropertyValue("anonymousUUID"));
        RequestUtils.postByQueryParam(Endpoints.EMOTIONAL_MAP.getEndpoint(), jsonData, queryParam);
    }

    @SneakyThrows
    @When("Save new emotional-map for existing user who has none")
    public void saveNewEmotionalMapForExistingUserWhoHasNone() {
        int markForHappyAnswer = Integer.parseInt(TestDataProvider.getPropertyValue("markForHappyAnswer"));
        AnswerDto answerDto = new AnswerDto("OK", markForHappyAnswer, AnswerGroup.HAPPY);
        list.add(answerDto);
        map.put("answers", list);
        jsonData = mapper.writeValueAsString(map);
        logger.info("New emotional-map's body for anonymous user who has none is - {}", jsonData);
        queryParam.put("userId", SharedTestData.getExistingUserId());
        RequestUtils.postByQueryParam(Endpoints.EMOTIONAL_MAP.getEndpoint(), jsonData, queryParam);
    }

    @SneakyThrows
    @When("Replace the saved emotional-map for anonymous user")
    public void replaceTheSavedEmotionalMapForAnonymousUser()  {
        int markForSadnessAnswer = Integer.parseInt(TestDataProvider.getPropertyValue("markForSadnessAnswer"));
        AnswerDto replacedAnswer = new AnswerDto("SAD", markForSadnessAnswer, AnswerGroup.SADNESS);
        List<AnswerDto> list = new ArrayList<>();
        list.add(replacedAnswer);
        map.put("answers", list);
        jsonData = mapper.writeValueAsString(map);
        logger.info("New emotional-map's body is - {}", jsonData);
        queryParam.put("userId", TestDataProvider.getPropertyValue("anonymousUUID"));
        RequestUtils.postByQueryParam(Endpoints.EMOTIONAL_MAP.getEndpoint(), jsonData, queryParam);
    }

    @Then("Check replaced emotional-map's values for anonymous user")
    public void checkReplacedEmotionalMapSValuesForAnonymousUser() {
        Assertions.assertThat(ResponseUtils.getDoubleFromResponse("diagramValues[2].value")).isGreaterThan(0);
        logger.info("Saved user's emotional-map value is - {}", ResponseUtils.getDoubleFromResponse("diagramValues[2].value"));
    }

    @When("Get emotional map without userId")
    public void getEmotionalMapWithoutUserId() {
        RequestUtils.get(Endpoints.EMOTIONAL_MAP.getEndpoint());
    }

    @SneakyThrows
    @When("Save new emotional-map for anonymous user without mark")
    public void saveNewEmotionalMapForAnonymousUserWithoutMark() {
        AnswerDto answerDto = new AnswerDto("SAD", 0, AnswerGroup.SADNESS);
        list.add(answerDto);
        map.put("answers", list);
        jsonData = mapper.writeValueAsString(map);
        logger.info("New emotional-map's body is - {}", jsonData);
        queryParam.put("userId", TestDataProvider.getPropertyValue("anonymousUUID"));
        RequestUtils.postByQueryParam(Endpoints.EMOTIONAL_MAP.getEndpoint(), jsonData, queryParam);
    }

    @SneakyThrows
    @When("Replace the saved emotional-map for existing user")
    public void replaceTheSavedEmotionalMapForExistingUser() {
        int markForSadnessAnswer = Integer.parseInt(TestDataProvider.getPropertyValue("markForSadnessAnswer"));
        AnswerDto answerDto = new AnswerDto("SAD", markForSadnessAnswer, AnswerGroup.SADNESS);
        List<AnswerDto> list = new ArrayList<>();
        list.add(answerDto);
        map.put("answers", list);
        jsonData = mapper.writeValueAsString(map);
        logger.info("New emotional-map's body for anonymous user who has none is - {}", jsonData);
        queryParam.put("userId", SharedTestData.getExistingUserId());
        RequestUtils.postByQueryParam(Endpoints.EMOTIONAL_MAP.getEndpoint(), jsonData, queryParam);
    }

    @Then("Check replaced emotional-map's values for existing user")
    public void checkReplacedEmotionalMapSValuesForExistingUser() {
        Assertions.assertThat(ResponseUtils.getDoubleFromResponse("diagramValues[2].value")).isGreaterThan(0d);
        logger.info("Saved user's emotional-map value is - {}", ResponseUtils.getDoubleFromResponse("diagramValues[2].value"));
    }

    @SneakyThrows
    @When("Save new emotional-map for every possible answerGroup")
    public void saveNewEmotionalMapForEveryPossibleAnswerGroup() {
        list.add(new AnswerDto("OK", 1, AnswerGroup.HAPPY));
        list.add(new AnswerDto("SAD", 2, AnswerGroup.SADNESS));
        list.add(new AnswerDto("SAD", 4, AnswerGroup.SURPRISE));
        list.add(new AnswerDto("SAD", 3, AnswerGroup.FEAR));
        list.add(new AnswerDto("SAD", 5, AnswerGroup.JOY));
        list.add(new AnswerDto("SAD", 6, AnswerGroup.ANGRY));
        map.put("answers", list);
        jsonData = mapper.writeValueAsString(map);
        logger.info("New emotional-map's body for anonymous user who has none is - {}", jsonData);
        queryParam.put("userId", TestDataProvider.getPropertyValue("anonymousUUID"));
        RequestUtils.postByQueryParam(Endpoints.EMOTIONAL_MAP.getEndpoint(), jsonData, queryParam);
    }

    @SneakyThrows
    @When("Save new emotional-map for multiple answers with the same answerGroup")
    public void saveNewEmotionalMapForMultipleAnswersWithTheSameAnswerGroup() {
        list.add(new AnswerDto("OK", 1, AnswerGroup.HAPPY));
        list.add(new AnswerDto("SAD", 4, AnswerGroup.SURPRISE));
        list.add(new AnswerDto("SAD", 4, AnswerGroup.SURPRISE));
        list.add(new AnswerDto("OK", 1, AnswerGroup.HAPPY));
        map.put("answers", list);
        jsonData = mapper.writeValueAsString(map);
        logger.info("New emotional-map's body for anonymous user who has none is - {}", jsonData);
        queryParam.put("userId", TestDataProvider.getPropertyValue("anonymousUUID"));
        RequestUtils.postByQueryParam(Endpoints.EMOTIONAL_MAP.getEndpoint(), jsonData, queryParam);
    }
}
