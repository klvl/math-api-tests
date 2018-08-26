package tests;

import helpers.requesthelpers.RequestHelper;
import helpers.testhelpers.Variables;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BaseTest {

    protected RequestHelper requestHelper;

    protected Variables variables;

    protected void assertTwoArgumentsResponse(String arg1, String arg2, String expectedResponse) throws Exception {
        String response = requestHelper.sendRequestForAddition(arg1, arg2);

        assertThat(response).isEqualTo(expectedResponse);
    }

}
