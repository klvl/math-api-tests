package helpers;

public class Variables {

    private static String
            unexpectedEndOfExpressionErrorMessage = "Error: Unexpected end of expression (char 5)",
            valueExpectedErrorMessage = "Error: Value expected (char 6)";

    public static String
            zeroArgument = "0",
            negativeIntegerBelowLowerBoundaryArgument = "-1001",
            negativeFloatArgument = "(-0.002)",
            integerBelowUpperBoundaryArgument = "999",
            emptyArgument = "",
            integerOnUpperBoundaryArgument = "1000",
            characterArgument = "*",
            negativeOneArgument = "-1",
            oneArgument = "1";

    public static String
            zeroAndZeroAdditionExpectedResult = "0",
            negativeIntegerBelowLowerBoundaryAndNegativeFloatAdditionExpectedResult = "-1001.002",
            integerBelowUpperBoundaryAndEmptyAdditionExpectedResult = unexpectedEndOfExpressionErrorMessage,
            integerOnUpperBoundaryAndCharacterAdditionExpectedResult = valueExpectedErrorMessage,
            negativeOneAndOneAdditionExpectedResult = "0";
}
