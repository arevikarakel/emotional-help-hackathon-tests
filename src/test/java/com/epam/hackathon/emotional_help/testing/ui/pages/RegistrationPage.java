package com.epam.hackathon.emotional_help.testing.ui.pages;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class RegistrationPage extends BasePage{

    @FindBy(id = ":r0:")
    private WebElement nameField;

    @FindBy(id = ":r1:")
    private WebElement emailField;

    @FindBy(id = ":r2:")
    private WebElement passwordField;

    @FindBy(id = ":r3:")
    private WebElement passwordAgainField;

    @FindBy(css = "form input[type='checkbox']")
    private WebElement acceptCheckBox;

    @FindBy(css = "form button")
    private WebElement submitButton;



    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        HomePage homePage = (HomePage) new HomePage(driver).get();
        homePage.navigateToRegistrationPage();
    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        assertTrue("Expected to be on the registration page, but was on " + url, url.contains("registration"));
    }

    public HomePage registerRandomisedUser() {
        String randomizedName = generateRandomizedName();
        nameField.sendKeys(randomizedName);
        emailField.sendKeys(randomizedName + "@gmail.com");
        passwordField.sendKeys(randomizedName);
        passwordAgainField.sendKeys(randomizedName);
        acceptCheckBox.click();
        submitButton.click();

        return new HomePage(driver);
    }

    private String generateRandomizedName() {
        Random random = new Random(Duration.between(
                    LocalDateTime.of(2000, 1, 1, 0, 0, 0),
                    LocalDateTime.now())
                .getSeconds());
        return "testuser-" + random.nextInt(100000);
    }
}
