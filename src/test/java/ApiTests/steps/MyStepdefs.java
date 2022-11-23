package ApiTests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import utils.RequestUtils;
import utils.ResponseUtils;

public class MyStepdefs {

    @Given("Setup Rest Assured")
    public void setupRestAssured() {
        RestAssured.baseURI = "https://gorest.co.in/";
        RestAssured.basePath = "public/v2/";
    }
    
    @When("Get all users")
    public void getAllUsers() {
        RequestUtils.get("users");
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int expectedStatusCode) {
        int actualStatusCode = ResponseUtils.getStatusCodeFromResponse();
        Assertions.assertThat(actualStatusCode).isEqualTo(expectedStatusCode);
    }
}
