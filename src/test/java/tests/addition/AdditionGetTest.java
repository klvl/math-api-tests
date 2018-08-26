package tests.addition;

import helpers.requesthelpers.GetRequestHelper;
import helpers.testhelpers.Variables;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

class AdditionGetTest extends BaseTest {

    AdditionGetTest() {
        requestHelper = new GetRequestHelper();
    }

    @Test
    void zeroAndZeroAdditionGetTest() throws Exception {
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
                Variables.integerBelowUpperBoundaryAndEmptyAdditionExpectedResultForGet
        );
    }

    @Test
    void integerOnUpperBoundaryAndCharacterAdditionGetTest() throws Exception {
        assertTwoArgumentsResponse(
                Variables.integerOnUpperBoundaryArgument,
                Variables.characterArgument,
                Variables.integerOnUpperBoundaryAndCharacterAdditionExpectedResultForGet
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