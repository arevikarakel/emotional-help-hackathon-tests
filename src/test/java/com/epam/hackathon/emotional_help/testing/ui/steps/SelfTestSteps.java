package com.epam.hackathon.emotional_help.testing.ui.steps;

import com.epam.hackathon.emotional_help.testing.api.data_provider.TestDataProvider;
import com.epam.hackathon.emotional_help.testing.ui.pages.HomePage;
import com.epam.hackathon.emotional_help.testing.ui.pages.SelfTestPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class SelfTestSteps extends StepsBase{
    private static final int TEST_LENGTH =
            Integer.parseInt(TestDataProvider.getPropertyValue("frontend.test_length"));
    HomePage homePage;
    private SelfTestPage selfTestPage;

    public SelfTestSteps(TestContext testContext) {
        super(testContext);
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        homePage = (HomePage) new HomePage(testContext.getDriver()).get();
    }
    @When("I start the self-test")
    public void i_start_the_self_test() {
        selfTestPage = homePage.startSelfTest();
    }
    @When("I choose an answer for all the questions")
    public void i_choose_an_answer_for_all_the_questions() {
        // Pick every answer at least once
        for (int i = 0; i < TEST_LENGTH; i++) {
            selfTestPage.chooseAnswerByIndex(i % 6);
        }
    }
    @Then("The results diagram is displayed")
    public void the_results_diagram_is_displayed() {
        assertTrue(selfTestPage.isResultDiagramDisplayed());
    }
    @Then("A link to a helpful video is displayed")
    public void a_link_to_a_helpful_video_is_displayed() {
        assertTrue(selfTestPage.isVideoLinkDisplayed());
    }
    @Then("Helpful tips are displayed")
    public void helpful_tips_are_displayed() {
        assertTrue(selfTestPage.isTipParagraphDisplayed());
    }
}
