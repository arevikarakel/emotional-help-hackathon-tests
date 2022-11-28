package com.epam.hackathon.emotional_help.testing.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class GoogleHomePage extends BasePage{

    @FindBy(css = "[name=\"q\"]")
    private WebElement input;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.navigate().to(BASE_URI);
        // Accept cookies
        driver.findElement(By.id("L2AGLb")).click();
    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        assertEquals("Expected to be on Google home page, but was on " + url, "https://www.google.com/", url);
    }

    public GoogleSearchResultsPage search(String query) {
        input.sendKeys(query);
        input.sendKeys(Keys.ENTER);
        return (GoogleSearchResultsPage) new GoogleSearchResultsPage(driver).get();
    }
}
