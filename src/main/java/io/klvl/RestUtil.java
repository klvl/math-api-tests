package io.klvl;

import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestUtil {

    private static final Logger LOG = LoggerFactory.getLogger(RestUtil.class);

    private static HttpClient client;

    private RestUtil() {
    }

    private static HttpClient getClient() {
        if (client == null) client = HttpClient.newBuilder().build();
        return client;
    }

    public static HttpResponse<String> sendGet(String url) {
        LOG.info("GET: " + url);
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response;
        try {
            response = getClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        LOG.info("Response status code: " + response.statusCode());
        LOG.info("Response body:" + response.body() + "\n");
        return response;
    }

    public static HttpResponse<String> sendPost(String url, String json) {
        LOG.info("POST: " + url);
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("content-type", "application/json")
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response;
        try {
            response = getClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        LOG.info("Response status code: " + response.statusCode());
        LOG.info("Response body:" + response.body() + "\n");
        return response;
    }

    public static void validateResponseStatusCode(HttpResponse<String> response, int expectedStatusCode) {
        Assertions.assertEquals(expectedStatusCode, response.statusCode(),
                "The response code did not match expected!\n" +
                        "Actual response status code: " + response.body() + "\n" +
                        "Expected response status code: " + expectedStatusCode);
    }

}
