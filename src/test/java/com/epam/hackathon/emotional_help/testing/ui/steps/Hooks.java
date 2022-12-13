package com.epam.hackathon.emotional_help.testing.ui.steps;

import java.time.Duration;
import java.util.HashMap;

import com.epam.hackathon.emotional_help.testing.api.data_provider.TestDataProvider;
import com.epam.hackathon.emotional_help.testing.ui.drivers.DriverFactory;
import com.epam.hackathon.emotional_help.testing.ui.drivers.Drivers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private final TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void before() {
        String driverType = TestDataProvider.getPropertyValue("driver");
        WebDriver driver = DriverFactory.createDriver(Drivers.valueOf(driverType));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        testContext.setDriver(driver);
        testContext.setSharedData(new HashMap<>());
    }

    @After
    public void after() {
        testContext.getDriver().quit();
    }
}
