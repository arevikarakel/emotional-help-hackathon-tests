package com.epam.hackathon.emotional_help.testing.api.data_provider;

import com.epam.hackathon.emotional_help.testing.utils.PropertiesReader;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class TestDataProvider {
    private final PropertiesReader propertiesReader = PropertiesReader
            .getInstance("testData.properties");

    public String getPropertyValue(String propertyName) {
        return propertiesReader.getPropety(propertyName);
    }
}
