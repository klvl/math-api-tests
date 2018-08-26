package tests;

import helpers.RequestHelper;
import helpers.Variables;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AdditionGetTest {

    @Test
    void zeroAndZeroAdditionGetTest() throws Exception {
        String response = RequestHelper
                .sendRequestForAddition(
                        Variables.zeroArgument,
                        Variables.zeroArgument
                );

        assertThat(response).
                isEqualTo(
                        Variables.zeroAndZeroAdditionExpectedResult
                );
    }

    @Test
    void negativeIntegerBelowLowerBoundaryAndNegativeFloatAdditionGetTest() throws Exception {
        String response = RequestHelper
                .sendRequestForAddition(
                        Variables.negativeIntegerBelowLowerBoundaryArgument,
                        Variables.negativeFloatArgument
                );

        assertThat(response).
                isEqualTo(
                        Variables.negativeIntegerBelowLowerBoundaryAndNegativeFloatAdditionExpectedResult
                );
    }

    @Test
    void integerBelowUpperBoundaryAndEmptyAdditionGetTest() throws Exception {
        String response = RequestHelper
                .sendRequestForAddition(
                        Variables.integerBelowUpperBoundaryArgument,
                        Variables.emptyArgument
                );

        assertThat(response).
                isEqualTo(
                        Variables.integerBelowUpperBoundaryAndEmptyAdditionExpectedResult
                );

    }

    @Test
    void integerOnUpperBoundaryAndCharacterAdditionGetTest() throws Exception {
        String response = RequestHelper
                .sendRequestForAddition(
                        Variables.integerOnUpperBoundaryArgument,
                        Variables.characterArgument
                );

        assertThat(response).
                isEqualTo(
                        Variables.integerOnUpperBoundaryAndCharacterAdditionExpectedResult
                );
    }

    @Test
    void negativeOneAndOneAdditionGetTest() throws Exception {
        String response = RequestHelper
                .sendRequestForAddition(
                        Variables.negativeOneArgument,
                        Variables.oneArgument
                );

        assertThat(response).
                isEqualTo(
                        Variables.negativeOneAndOneAdditionExpectedResult
                );
    }

}
