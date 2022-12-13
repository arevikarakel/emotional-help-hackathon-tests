package com.epam.hackathon.emotional_help.testing.ui.steps;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class TestContext {
    private WebDriver driver;

    private Map<String, Object> sharedData;
}
