package io.klvl.tests;

import io.klvl.api.MathAPI;
import io.klvl.api.RestUtil;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumGetTest {

    @Test
    @Tag("positive")
    public void testGetZeroSum() {
        String expression = "0+0";
        String expectedResult = "0";
        int statusCode = 200;

        HttpResponse<String> response = MathAPI.get(expression);
        RestUtil.validateResponseStatusCode(response, statusCode);

        assertEquals(expectedResult, response.body(), "The response body did not match expected!\n" +
                "Actual result: " + response.body() + "\n" +
                "Expected result: " + expectedResult + "\n" +
                "Expression: " + expression);
    }

    @Test
    @Tag("positive")
    public void testGetLargeSum() {
        String expression = "-1001+(-0.002)";
        String expectedResult = "-1001.002";
        int statusCode = 200;

        HttpResponse<String> response = MathAPI.get(expression);
        RestUtil.validateResponseStatusCode(response, statusCode);

        assertEquals(expectedResult, response.body(), "The response body did not match expected!\n" +
                "Actual result: " + response.body() + "\n" +
                "Expected result: " + expectedResult + "\n" +
                "Expression: " + expression);
    }

    @Test
    @Tag("negative")
    public void testGetInvalidMissedValue() {
        String expression = "999+";
        String expectedResult = "Error: Unexpected end of expression (char 5)";
        int statusCode = 400;

        HttpResponse<String> response = MathAPI.get(expression);
        RestUtil.validateResponseStatusCode(response, statusCode);

        assertEquals(expectedResult, response.body(), "The response body did not match expected!\n" +
                "Actual result: " + response.body() + "\n" +
                "Expected result: " + expectedResult + "\n" +
                "Expression: " + expression);
    }

    @Test
    @Tag("negative")
    public void testGetInvalidWithCharacterSum() {
        String expression = "1000+*";
        String expectedResult = "Error: Value expected (char 6)";
        int statusCode = 400;

        HttpResponse<String> response = MathAPI.get(expression);
        RestUtil.validateResponseStatusCode(response, statusCode);

        assertEquals(expectedResult, response.body(), "The response body did not match expected!\n" +
                "Actual result: " + response.body() + "\n" +
                "Expected result: " + expectedResult + "\n" +
                "Expression: " + expression);
    }

    @Test
    @Tag("positive")
    public void testGetMinusPlusSum() {
        String expression = "-1+1";
        String expectedResult = "0";
        int statusCode = 200;

        HttpResponse<String> response = MathAPI.get(expression);
        RestUtil.validateResponseStatusCode(response, statusCode);

        assertEquals(expectedResult, response.body(), "The response body did not match expected!\n" +
                "Actual result: " + response.body() + "\n" +
                "Expected result: " + expectedResult + "\n" +
                "Expression: " + expression);
    }

}