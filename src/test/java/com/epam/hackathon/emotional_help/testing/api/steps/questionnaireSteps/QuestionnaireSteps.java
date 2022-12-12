package com.epam.hackathon.emotional_help.testing.api.steps.questionnaireSteps;

import java.util.HashMap;
import java.util.Map;

import com.epam.hackathon.emotional_help.testing.api.dataProviders.Endpoints;
import com.epam.hackathon.emotional_help.testing.api.dataProviders.TestDataProvider;
import com.epam.hackathon.emotional_help.testing.api.steps.emotionalMapSteps.EmotionalMap;
import com.epam.hackathon.emotional_help.testing.api.utils.RequestUtils;
import com.epam.hackathon.emotional_help.testing.api.utils.ResponseUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuestionnaireSteps {
    private final Logger logger = LoggerFactory.getLogger(EmotionalMap.class);
    @When("Get existing questionnaire")
    public void get_existing_questionnaire() {
        String existingTitle = TestDataProvider.getPropertyValue("existingQuestionnaireTitle");
        logger.info("Existing questionnaire title is {}", existingTitle);
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("title", existingTitle);
        RequestUtils.getByQueryParams(Endpoints.QUESTIONAIRES.getEndpoint(), queryParams);
    }
    @Then("Questionnaire has correct schema")
    public void questionnaire_has_correct_schema() {
        ResponseUtils.validateResponseAgainstJSONSchema("schemas/QuestionnaireResponseBodySchema.json");
    }

    @When("Get nonexistent questionnaire")
    public void getNonexistentQuestionnaire() {
        String nonexistentTitle = TestDataProvider.getPropertyValue("nonexistentQuestionnaireTitle");
        logger.info("Nonexistent questionnaire title is {}", nonexistentTitle);
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("title", nonexistentTitle);
        RequestUtils.getByQueryParams(Endpoints.QUESTIONAIRES.getEndpoint(), queryParams);
    }
}
