package io.klvl;

import io.klvl.requests.RequestHelper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BaseTest {

    protected RequestHelper requestHelper;

    protected void assertTwoArgumentsResponse(String arg1, String arg2, String expectedResponse) throws Exception {
        String response = requestHelper.sendRequestForAddition(arg1, arg2);

        assertThat(response).isEqualTo(expectedResponse);
    }

}
