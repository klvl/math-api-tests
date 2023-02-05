package io.klvl.tests;

import com.google.gson.Gson;
import io.klvl.api.MathAPI;
import io.klvl.api.RestUtil;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SumPostTest {

    @Test
    @Tag("positive")
    public void testPostZero() {
        String expression = "0+0";
        String expectedResult = "0";
        int statusCode = 200;

        HttpResponse<String> response = MathAPI.post(expression);
        RestUtil.validateResponseStatusCode(response, statusCode);

        String actualResult = new Gson().fromJson(response.body(), HashMap.class).get("result").toString();

        assertEquals(expectedResult, actualResult, "The actual result did not match expected!\n" +
                "Actual result: " + actualResult + "\n" +
                "Expected result: " + expectedResult + "\n" +
                "Expression: " + expression + "\n" +
                "Response body:\n" + response.body());
    }

    @Test
    @Tag("positive")
    public void testPostNegative() {
        String expression = "-1001+(-0.002)";
        String expectedResult = "-1001.002";
        int statusCode = 200;

        HttpResponse<String> response = MathAPI.post(expression);
        RestUtil.validateResponseStatusCode(response, statusCode);

        String actualResult = new Gson().fromJson(response.body(), HashMap.class).get("result").toString();

        assertEquals(expectedResult, actualResult, "The actual result did not match expected!\n" +
                "Actual result: " + actualResult + "\n" +
                "Expected result: " + expectedResult + "\n" +
                "Expression: " + expression + "\n" +
                "Response body:\n" + response.body());
    }

    @Test
    @Tag("negative")
    @SuppressWarnings("unchecked")
    public void testPostMissedValue() {
        String expression = "999+";
        String expectedError = "Error: Unexpected end of expression (char 5)";
        int statusCode = 400;

        HttpResponse<String> response = MathAPI.post(expression);
        RestUtil.validateResponseStatusCode(response, statusCode);

        HashMap<String, String> body = (HashMap<String, String>) new Gson().fromJson(response.body(), HashMap.class);
        assertNull(body.get("result"), "The result was not null!\n" +
                "Actual result: " + body.get("result"));

        String actualError = body.get("error");

        assertEquals(expectedError, actualError, "The actual result did not match expected!\n" +
                "Actual result: " + actualError + "\n" +
                "Expected result: " + expectedError + "\n" +
                "Expression: " + expression + "\n" +
                "Response body:\n" + response.body());
    }

    @Test
    @Tag("negative")
    @SuppressWarnings("unchecked")
    public void testPostWithCharacterSum() {
        String expression = "1000+*";
        String expectedError = "Error: Value expected (char 6)";
        int statusCode = 400;

        HttpResponse<String> response = MathAPI.post(expression);
        RestUtil.validateResponseStatusCode(response, statusCode);

        HashMap<String, String> body = (HashMap<String, String>) new Gson().fromJson(response.body(), HashMap.class);
        assertNull(body.get("result"), "The result was not null!\n" +
                "Actual result: " + body.get("result"));

        String actualError = body.get("error");

        assertEquals(expectedError, actualError, "The actual error did not match expected!\n" +
                "Actual error: " + actualError + "\n" +
                "Expected error: " + expectedError + "\n" +
                "Expression: " + expression + "\n" +
                "Response body:\n" + response.body());
    }

    @Test
    @Tag("positive")
    public void testPostMinusPlusSum() {
        String expression = "-1+1";
        String expectedResult = "0";
        int statusCode = 200;

        HttpResponse<String> response = MathAPI.post(expression);
        RestUtil.validateResponseStatusCode(response, statusCode);

        String actualResult = new Gson().fromJson(response.body(), HashMap.class).get("result").toString();

        assertEquals(expectedResult, actualResult, "The actual result did not match expected!\n" +
                "Actual result: " + actualResult + "\n" +
                "Expected result: " + expectedResult + "\n" +
                "Expression: " + expression + "\n" +
                "Response body:\n" + response.body());
    }

}
