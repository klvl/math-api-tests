package helpers;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Response;

import java.util.concurrent.CompletableFuture;

import static org.asynchttpclient.Dsl.asyncHttpClient;

public class RequestHelper {

    private static AsyncHttpClient asyncHttpClient;

    RequestHelper() {
        asyncHttpClient = asyncHttpClient();
    }

    private static String sendRequest(String targetUrl) throws Exception {
        asyncHttpClient = asyncHttpClient();
        CompletableFuture<String> response = asyncHttpClient
                .prepareGet(targetUrl)
                .execute()
                .toCompletableFuture()
                .thenApply(Response::getResponseBody);
        return response.get();
    }

    public static String sendRequestForAddition(String arg1, String arg2) throws Exception {
        String targetUrl = UrlExpressionHelper.getTargetUrlForAdditionExpression(arg1, arg2);
        return sendRequest(targetUrl);
    }
}
