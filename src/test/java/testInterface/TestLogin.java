package testInterface;

import org.json.JSONObject;
import org.junit.Test;
import simulator.ClientSimulator;

/**
 * Copyright (c) 2017, TP-Link Co.,Ltd.
 * Author:  jiangdanyang <jiangdanyang@tp-link.com.cn>
 * Created: 2017-08-24
 */

public class TestLogin {
    //private static final ClientSimulator clientSimulator = new ClientSimulator();

    @Test
    public void loginTest() throws Exception {
        final String HOST = "localhost";
        final int PORT = 10726;
        final String SCHEME = "http";
        final String PATH = "/token";

        //URI uri = new URIBuilder().setScheme(SCHEME).setHost(HOST).setPort(PORT).setPath(PATH).build();
        String uri = SCHEME + "://" + HOST + ":" + PORT + PATH;

        /*JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", "testForParamas@testForParamas.com");
        jsonObject.put("password", "test123");*/
        //ApiResponse apiResponse = clientSimulator.PostAndResponse(uri, jsonObject.toString());
        JSONObject head_params = new JSONObject();
        JSONObject body_params= new JSONObject();
        head_params.put("Content-Type", "application/json");
        head_params.put("Accept","application/json");
        body_params.put("password","test123");
        body_params.put("displayName","testName");
        body_params.put("email","test@test.com");

        JSONObject request = new JSONObject();
        request.put("uri",uri);
        request.put("head_params",head_params);
        request.put("body_params",body_params);
        JSONObject response = ClientSimulator.PostAndResponse(request);
    }
}
