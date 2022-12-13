package com.epam.hackathon.emotional_help.testing.ui.pages;

import com.epam.hackathon.emotional_help.testing.api.data_provider.TestDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public abstract class BasePage extends LoadableComponent<BasePage> {
    protected static String BASE_URI = TestDataProvider.getPropertyValue("frontend.base_uri");

    protected WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
