package com.epam.hackathon.emotional_help.testing.ui.steps;

import com.epam.hackathon.emotional_help.testing.ui.pages.HomePage;
import com.epam.hackathon.emotional_help.testing.ui.pages.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps extends StepsBase{
    private RegistrationPage registrationPage;
    private HomePage homePage;

    public RegistrationSteps(TestContext testContext) {
        super(testContext);
    }
    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
        registrationPage = (RegistrationPage) new RegistrationPage(testContext.getDriver()).get();
    }
    @When("I register a new user")
    public void i_register_a_new_user() {
        homePage = registrationPage.registerRandomisedUser();
    }

    @Then("The home page is displayed")
    public void the_home_page_is_displayed() {
        homePage.assertIsLoaded();
    }
}
