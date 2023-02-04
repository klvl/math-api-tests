package io.klvl;

public class Variables {

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
            negativeOneAndOneAdditionExpectedResult = "0";

    public static String
            integerBelowUpperBoundaryAndEmptyAdditionExpectedResultForGet = "Error: Unexpected end of expression (char 5)",
            integerOnUpperBoundaryAndCharacterAdditionExpectedResultForGet = "Error: Value expected (char 6)",
            integerBelowUpperBoundaryAndEmptyAdditionExpectedResultForPost = null,
            integerOnUpperBoundaryAndCharacterAdditionExpectedResultForPost = null;

}
