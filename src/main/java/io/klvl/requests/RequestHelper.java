package io.klvl.requests;

public interface RequestHelper {

    String sendRequest(String expression) throws Exception;

    String sendRequestForAddition(String arg1, String arg2) throws Exception;
}
