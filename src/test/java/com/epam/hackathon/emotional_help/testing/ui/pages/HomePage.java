package com.epam.hackathon.emotional_help.testing.ui.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class HomePage extends BasePage{

    @FindBy(css = "[href=\"/selftest\"]")
    private WebElement selfTestButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.navigate().to(BASE_URI);
    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        assertEquals("Expected to be on the home page, but was on " + url, BASE_URI + "/", url);
    }

    public void assertIsLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(BASE_URI + "/"));
    }

    public void navigateToRegistrationPage() {
        driver.findElement(By.cssSelector("[href='/registration']")).click();
    }

    public SelfTestPage startSelfTest() {
        selfTestButton.click();
        return new SelfTestPage(driver);
    }
}
