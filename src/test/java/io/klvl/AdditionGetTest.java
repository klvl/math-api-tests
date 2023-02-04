package io.klvl;

import io.klvl.requests.GetRequestHelper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AdditionGetTest extends BaseTest {

    AdditionGetTest() {
        requestHelper = new GetRequestHelper();
    }

    @Test @Tag("zeroAndZeroAdditionGetTest")
    void zeroAndZeroAdditionGetTest() throws Exception {
        assertTwoArgumentsResponse(
                Variables.zeroArgument,
                Variables.zeroArgument,
                Variables.zeroAndZeroAdditionExpectedResult
        );
    }

    @Test @Tag("negativeIntegerBelowLowerBoundaryAndNegativeFloatAdditionGetTest")
    void negativeIntegerBelowLowerBoundaryAndNegativeFloatAdditionGetTest() throws Exception {
        assertTwoArgumentsResponse(
                Variables.negativeIntegerBelowLowerBoundaryArgument,
                Variables.negativeFloatArgument,
                Variables.negativeIntegerBelowLowerBoundaryAndNegativeFloatAdditionExpectedResult
        );
    }

    @Test @Tag("integerBelowUpperBoundaryAndEmptyAdditionGetTest")
    void integerBelowUpperBoundaryAndEmptyAdditionGetTest() throws Exception {
        assertTwoArgumentsResponse(
                Variables.integerBelowUpperBoundaryArgument,
                Variables.emptyArgument,
                Variables.integerBelowUpperBoundaryAndEmptyAdditionExpectedResultForGet
        );
    }

    @Test @Tag("integerOnUpperBoundaryAndCharacterAdditionGetTest")
    void integerOnUpperBoundaryAndCharacterAdditionGetTest() throws Exception {
        assertTwoArgumentsResponse(
                Variables.integerOnUpperBoundaryArgument,
                Variables.characterArgument,
                Variables.integerOnUpperBoundaryAndCharacterAdditionExpectedResultForGet
        );
    }

    @Test @Tag("negativeOneAndOneAdditionGetTest")
    void negativeOneAndOneAdditionGetTest() throws Exception {
        assertTwoArgumentsResponse(
                Variables.negativeOneArgument,
                Variables.oneArgument,
                Variables.negativeOneAndOneAdditionExpectedResult
        );
    }
}