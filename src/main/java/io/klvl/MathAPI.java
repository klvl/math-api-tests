package io.klvl;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;

import java.net.http.HttpResponse;

public class MathAPI {

    private static final String BASE_URL = "http://api.mathjs.org/v4/";

    public static HttpResponse<String> get(String expression) {
        expression = expression.replace("+", "%2B");
        return RestUtil.sendGet(BASE_URL + "?expr=" + expression);
    }

    public static HttpResponse<String> post(String expression) {
        String json = new Gson().toJson(ImmutableMap.of("expr", expression));
        return RestUtil.sendPost(BASE_URL, json);
    }

}
