package com.epam.hackathon.emotional_help.testing.utils;

import io.restassured.response.ValidatableResponse;

public class ResponseUtils {
    public static ValidatableResponse getResponse() {
        return RequestUtils.getResponse();
    }

    public static int getStatusCodeFromResponse() {
        return getResponse()
                .extract()
                .statusCode();
    }
}
