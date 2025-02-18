package utils;
//import Model.payloads;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import static io.restassured.RestAssured.given;
public class SpecBuilder {
    public final static String ENVIRONMENT_PATH = "src/test/java/ApiTests/EnvironmentVariables.properties";

//        public static RequestSpecification getRequestSpec() {
//            return new RequestSpecBuilder()
//                    .setBaseUri(getEnvironmentPropertyValue("Beta_BASE_URL"))
//                    .setContentType(ContentType.JSON)
//                    .log(LogDetail.BODY).log(LogDetail.URI).log(LogDetail.METHOD).log(LogDetail.HEADERS)
//                    .build();
//        }
        public static RequestSpecification RequestSpecWithParams(HashMap<String,Object> paramsData) {
            return given()

                    .contentType(ContentType.JSON)
                    .body(paramsData)
                    .log().all();
        }
        public static HashMap<String, String> readPayloadFromFile(String filePath, String testCase) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(filePath));
            JsonNode testCaseNode = rootNode.path(testCase);
            return objectMapper.convertValue(testCaseNode, HashMap.class);
        }
        public static Response PrintAllResponse(Response response) {
        return response
                .then()
                .log()
                .all()
                .extract()
                .response();
        }


    //TODO: get properties from .properties file
//    public static String getEnvironmentPropertyValue(String key) {
//        try {
//            Properties properties = new Properties();
//            properties.load(new FileInputStream(ENVIRONMENT_PATH));
//            return properties.getProperty(key);
//        } catch (Exception e) {
//
//        }
//
//    }
}


