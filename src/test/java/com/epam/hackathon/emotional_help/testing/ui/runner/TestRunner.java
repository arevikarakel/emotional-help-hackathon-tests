package com.epam.hackathon.emotional_help.testing.ui.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/epam/hackathon/emotional_help/testing/ui/features/MyFeature.feature",
        glue = {"com/epam/hackathon/emotional_help/testing/ui/steps"}
)
public class TestRunner {
}