package tests.addition;

import helpers.requesthelpers.PostRequestHelper;
import helpers.testhelpers.Variables;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

class AdditionPostTest extends BaseTest {

    AdditionPostTest() {
        requestHelper = new PostRequestHelper();
    }

    @Test
    void zeroAndZeroAdditionPostTest() throws Exception {
        assertTwoArgumentsResponse(
                Variables.zeroArgument,
                Variables.zeroArgument,
                Variables.zeroAndZeroAdditionExpectedResult
        );
    }

    @Test
    void negativeIntegerBelowLowerBoundaryAndNegativeFloatAdditionGetTest() throws Exception {
        assertTwoArgumentsResponse(
                Variables.negativeIntegerBelowLowerBoundaryArgument,
                Variables.negativeFloatArgument,
                Variables.negativeIntegerBelowLowerBoundaryAndNegativeFloatAdditionExpectedResult
        );
    }

    @Test
    void integerBelowUpperBoundaryAndEmptyAdditionGetTest() throws Exception {
        assertTwoArgumentsResponse(
                Variables.integerBelowUpperBoundaryArgument,
                Variables.emptyArgument,
                Variables.integerBelowUpperBoundaryAndEmptyAdditionExpectedResultForPost
        );
    }

    @Test
    void integerOnUpperBoundaryAndCharacterAdditionGetTest() throws Exception {
        assertTwoArgumentsResponse(
                Variables.integerOnUpperBoundaryArgument,
                Variables.characterArgument,
                Variables.integerOnUpperBoundaryAndCharacterAdditionExpectedResultForPost
        );
    }

    @Test
    void negativeOneAndOneAdditionGetTest() throws Exception {
        assertTwoArgumentsResponse(
                Variables.negativeOneArgument,
                Variables.oneArgument,
                Variables.negativeOneAndOneAdditionExpectedResult
        );
    }
}