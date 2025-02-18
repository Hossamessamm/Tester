package utils;

import io.restassured.response.Response;

public class AssertionUtils {

    public static void assertStatusCode(Response respons, int expectedStatusCode) {
        int actualStatusCode = respons.getStatusCode();
        if (actualStatusCode != expectedStatusCode) {
            throw new AssertionError("Expected status code: " + expectedStatusCode + " but found: " + actualStatusCode);
        }
    }

    public static void assertResponseBody(String actualResponseBody, String expectedResponseBody) {
        if (!actualResponseBody.equals(expectedResponseBody)) {
            throw new AssertionError("Expected response body: " + expectedResponseBody + " but found: " + actualResponseBody);
        }
    }
    public static void assertValue(Response response, String key, Object expectedValue) {
       Object actualValue = response.jsonPath().get(key);
        if (!actualValue.equals(expectedValue)) {
            throw new AssertionError("Expected value: " + expectedValue + " but found: " + actualValue);
        }

    
    }



}
