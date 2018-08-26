package helpers.requesthelpers;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Response;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static org.asynchttpclient.Dsl.asyncHttpClient;

public class PostRequestHelper implements RequestHelper {

    private static AsyncHttpClient asyncHttpClient;
    private static Gson gson;

    public PostRequestHelper() {
        asyncHttpClient = asyncHttpClient();
        gson = new Gson();
    }

    public String sendRequest(String expression) throws Exception {
        CompletableFuture<Response> response = asyncHttpClient
                .preparePost(UrlExpressionHelper.getBaseUrl())
                .setBody(
                        gson.toJson(
                                ImmutableMap.of("expr", expression
                )))
                .execute()
                .toCompletableFuture();

        return getResult(response);
    }

    private static String getResult(CompletableFuture<Response> response) throws Exception {
        Map responseJson = gson.fromJson(response.get().getResponseBody(), Map.class);
        return (String) responseJson.get("result");
    }

    public String sendRequestForAddition(String arg1, String arg2) throws Exception {
        String expression = arg1 + "+" + arg2;
        return sendRequest(expression);
    }
}
