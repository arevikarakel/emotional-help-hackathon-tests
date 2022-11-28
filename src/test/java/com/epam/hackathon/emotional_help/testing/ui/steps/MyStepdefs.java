package com.epam.hackathon.emotional_help.testing.ui.steps;

import com.epam.hackathon.emotional_help.testing.ui.drivers.DriverFactory;
import com.epam.hackathon.emotional_help.testing.ui.drivers.Drivers;
import com.epam.hackathon.emotional_help.testing.ui.pages.GoogleHomePage;
import com.epam.hackathon.emotional_help.testing.ui.pages.GoogleSearchResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

public class MyStepdefs {
    GoogleHomePage googleHomePage;
    GoogleSearchResultsPage searchResultsPage;
    private WebDriver driver;

    @Given("We are on the Google home page")
    public void weAreOnTheGoogleHomePage() {
        driver = DriverFactory.createDriver(Drivers.CHROME);
        googleHomePage = (GoogleHomePage) new GoogleHomePage(driver).get();
    }

    @When("We enter text into the search field and submit it")
    public void weEnterTextIntoTheSearchFieldAndSubmitIt() {
        searchResultsPage = googleHomePage.search("Selenium");
    }

    @Then("The search results page is displayed")
    public void theSearchResultsPageIsDisplayed() throws InterruptedException {
        sleep(5000);
        driver.quit();
    }
}
