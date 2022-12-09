package com.epam.hackathon.emotional_help.testing.api.utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class RequestUtils {
    private final static Logger logger = LoggerFactory.getLogger(RequestUtils.class);

    private static ValidatableResponse response;

    public static ValidatableResponse getResponse() {
        return response;
    }

    public static void get(String endpoint, String token) {
        response = RestAssured
                .given()
                .header("Authorization", token)
                .when()
                .get(endpoint)
                .then();
        logger.info(response.extract().body().asPrettyString());
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

    public static void postByQueryParam(String endpoint, Object body, Map<String, Object> query) {
        logger.info(endpoint, body);
        response = RestAssured
                .given()
                .spec(getRequestSpecification())
                .body(body)
                .queryParams(query)
                .when()
                .post(endpoint)
                .then();
        logger.info(response.extract().body().asPrettyString());
    }

    public static void post(String endpoint, Object body) {
        logger.info(endpoint, body);
        response = RestAssured
                .given()
                .spec(getRequestSpecification())
                .body(body)
                .when()
                .post(endpoint)
                .then();
        logger.info(response.extract().body().asPrettyString());
    }

    private static RequestSpecification getRequestSpecification() {
        RequestSpecBuilder spec = new RequestSpecBuilder();
        return spec
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    public static void postByQueryParam(String endpoint, Map<String, Object> query) {
        logger.info(endpoint);
        response = RestAssured
                .given()
                .spec(getRequestSpecification())
                .queryParams(query)
                .when()
                .post(endpoint)
                .then();
        logger.info(response.extract().body().asPrettyString());
    }
}
