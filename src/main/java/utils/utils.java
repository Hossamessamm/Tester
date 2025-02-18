package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class utils {
    public static HashMap<String, String> readPayloadFromFile(String filePath, String testCase) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(new File(filePath));
            JsonNode testCaseNode = rootNode.path(testCase);
            return objectMapper.convertValue(testCaseNode, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getDataFromJson( String key) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(new File("src/test/resources/Data.json"));
            JsonNode valueNode = rootNode.path(key);
            return valueNode.asText();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }




}
