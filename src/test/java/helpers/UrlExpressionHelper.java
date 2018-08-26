package helpers;

class UrlExpressionHelper {

    private static String
            baseExpressionUrl = "http://api.mathjs.org/v4/?expr=",
            plusSign = "%2B";

    static String getTargetUrlForAdditionExpression(String arg1, String arg2) {
        return baseExpressionUrl + arg1 + plusSign + arg2;
    }
}
