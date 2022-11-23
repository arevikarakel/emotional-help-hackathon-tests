package utils;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
