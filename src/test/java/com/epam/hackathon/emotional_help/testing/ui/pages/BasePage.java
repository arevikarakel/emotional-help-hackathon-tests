package com.epam.hackathon.emotional_help.testing.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public abstract class BasePage extends LoadableComponent<BasePage> {
    protected static String BASE_URI = "https://www.google.com";

    protected WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
