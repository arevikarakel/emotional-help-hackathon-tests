package com.epam.hackathon.emotional_help.testing.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class GoogleSearchResultsPage extends BasePage{

    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        assertTrue("Expected to be on Google search results page, but was on " + url,
                url.startsWith("https://www.google.com/search"));
    }
}
