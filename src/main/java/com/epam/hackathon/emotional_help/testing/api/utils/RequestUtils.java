package com.epam.hackathon.emotional_help.testing.api.utils;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class RequestUtils {
    private final static Logger logger = LoggerFactory.getLogger(RequestUtils.class);

    private static ValidatableResponse response;

    public static ValidatableResponse getResponse() {
        return response;
    }

    public static void get(String endpoint) {
        response = RestAssured
                .given()
                .when()
                .get(endpoint)
                .then();
        logger.info(response.extract().body().asPrettyString());
    }

    public static void getByQueryParams(String endpoint, Map<String, Object> queryParam) {
        response = RestAssured
                .given()
                .queryParams(queryParam)
                .get(endpoint)
                .then();
        logger.info(response.extract().body().asPrettyString());
    }

}
