package helpers.requesthelpers;

public class UrlExpressionHelper {

    private static String
            baseUrl = "http://api.mathjs.org/v4/",
            plusSign = "%2B";

    static String getBaseUrl() {
        return baseUrl;
    }

    private static String getBaseExpressionUrl() {
        return baseUrl + "?expr=";
    }

    static String getTargetUrlForAdditionExpression(String arg1, String arg2) {
        return getBaseExpressionUrl() + arg1 + plusSign + arg2;
    }
}
