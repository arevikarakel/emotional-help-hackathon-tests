package com.epam.hackathon.emotional_help.testing.api.steps.adviceSteps;

import com.epam.hackathon.emotional_help.testing.api.dataProviders.Endpoints;
import com.epam.hackathon.emotional_help.testing.api.utils.RequestUtils;
import com.epam.hackathon.emotional_help.testing.api.utils.ResponseUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class AdviceSteps {

    @And("Validate advise response body by jsonSchema")
    public void validateAdviseResponseBodyByJsonSchema() {
        ResponseUtils.validateResponseAgainstJSONSchema("schemas/AdviseResponseBodySchema.json");
    }

    @When("Get advise by {string}")
    public void getAdviseBy(String feelings) {
        RequestUtils.get(Endpoints.ADVICE.getEndpoint()+ feelings);
    }


    @Then("Validate that response tip and video is not empty")
    public void validateThatResponseTipAndVideoIsNotEmpty() {
        Assertions.assertThat(ResponseUtils.getStringFromResponse("tip")).isNotEmpty();
        Assertions.assertThat(ResponseUtils.getStringFromResponse("video")).isNotEmpty();
    }
}
