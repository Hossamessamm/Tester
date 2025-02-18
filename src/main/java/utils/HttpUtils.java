package utils;

import Data.Urls;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class HttpUtils {

        public static void setBaseURI(String baseURI) {
            RestAssured.baseURI = baseURI;
        }

        public static Response getRequest(String endpoint) {
            RequestSpecification request = RestAssured.given();
            request.baseUri(Urls.BASE_URL);
            return request.get(endpoint);
        }
    public static Response getRequestWithSerial(String endpoint, String serial) {
        RequestSpecification request = RestAssured.given();
        request.baseUri(Urls.BASE_URL);
       request.queryParam("serial", serial);
        return request.get(endpoint);
    }

        public static Response postRequest(String endpoint, Object body) {
            RequestSpecification request = RestAssured.given();
            request.baseUri(Urls.BASE_URL);
            request.header("Content-Type", "application/json");
            request.body(body);
            return request.post(endpoint);
        }

        public static Response putRequest(String endpoint, Object body) {
            RequestSpecification request = RestAssured.given();
            request.baseUri(Urls.BASE_URL);
            request.header("Content-Type", "application/json");
            request.body(body);
            return request.put(endpoint);
        }

        public static Response deleteRequest(String endpoint) {
            RequestSpecification request = RestAssured.given();
            request.baseUri(Urls.BASE_URL);
            return request.delete(endpoint);
        }
    }

