package com.epam.hackathon.emotional_help.testing.api.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/epam/hackathon/emotional_help/testing/api/features",
        glue = {"com/epam/hackathon/emotional_help/testing/api/steps"}
)
public class TestRunner {
}