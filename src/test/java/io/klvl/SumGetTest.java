package io.klvl;

import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumGetTest {

    @Test
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
    public void testGetNegativeLargeSum() {
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