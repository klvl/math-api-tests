package helpers.requesthelpers;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Response;

import java.util.concurrent.CompletableFuture;

import static org.asynchttpclient.Dsl.asyncHttpClient;

public class GetRequestHelper implements RequestHelper {

    private static AsyncHttpClient asyncHttpClient;

    public GetRequestHelper() {
        asyncHttpClient = asyncHttpClient();
    }

    public String sendRequest(String targetUrl) throws Exception {
        CompletableFuture<String> response = asyncHttpClient
                .prepareGet(targetUrl)
                .execute()
                .toCompletableFuture()
                .thenApply(Response::getResponseBody);
        return response.get();
    }

    public String sendRequestForAddition(String arg1, String arg2) throws Exception {
        String targetUrl = UrlExpressionHelper.getTargetUrlForAdditionExpression(arg1, arg2);
        return sendRequest(targetUrl);
    }
}
