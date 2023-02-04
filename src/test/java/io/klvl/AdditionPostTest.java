package io.klvl;

import io.klvl.requests.PostRequestHelper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AdditionPostTest extends BaseTest {

    AdditionPostTest() {
        requestHelper = new PostRequestHelper();
    }

    @Test @Tag("zeroAndZeroAdditionPostTest")
    void zeroAndZeroAdditionPostTest() throws Exception {
        assertTwoArgumentsResponse(
                Variables.zeroArgument,
                Variables.zeroArgument,
                Variables.zeroAndZeroAdditionExpectedResult
        );
    }

    @Test @Tag("negativeIntegerBelowLowerBoundaryAndNegativeFloatAdditionPostTest")
    void negativeIntegerBelowLowerBoundaryAndNegativeFloatAdditionPostTest() throws Exception {
        assertTwoArgumentsResponse(
                Variables.negativeIntegerBelowLowerBoundaryArgument,
                Variables.negativeFloatArgument,
                Variables.negativeIntegerBelowLowerBoundaryAndNegativeFloatAdditionExpectedResult
        );
    }

    @Test @Tag("integerBelowUpperBoundaryAndEmptyAdditionPostTest")
    void integerBelowUpperBoundaryAndEmptyAdditionPostTest() throws Exception {
        assertTwoArgumentsResponse(
                Variables.integerBelowUpperBoundaryArgument,
                Variables.emptyArgument,
                Variables.integerBelowUpperBoundaryAndEmptyAdditionExpectedResultForPost
        );
    }

    @Test @Tag("integerOnUpperBoundaryAndCharacterAdditionPostTest")
    void integerOnUpperBoundaryAndCharacterAdditionPostTest() throws Exception {
        assertTwoArgumentsResponse(
                Variables.integerOnUpperBoundaryArgument,
                Variables.characterArgument,
                Variables.integerOnUpperBoundaryAndCharacterAdditionExpectedResultForPost
        );
    }

    @Test @Tag("negativeOneAndOneAdditionPostTest")
    void negativeOneAndOneAdditionPostTest() throws Exception {
        assertTwoArgumentsResponse(
                Variables.negativeOneArgument,
                Variables.oneArgument,
                Variables.negativeOneAndOneAdditionExpectedResult
        );
    }
}