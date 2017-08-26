/**
 * Copyright (c) 2017, TP-Link Co.,Ltd.
 * Author:  jiangdanyang <jiangdanyang@tp-link.com.cn>
 * Created: 2017-08-24
 */

package simulator;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;

import common.ApiResponse;
import org.apache.http.Consts;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class ClientSimulator {
    private final static int RESPONSE_TIME = 3000;
    private static RequestConfig config =
            RequestConfig.custom().setConnectionRequestTimeout(RESPONSE_TIME).setConnectTimeout(RESPONSE_TIME)
                         .setSocketTimeout(RESPONSE_TIME).build();

    public static JSONObject PostAndResponse(JSONObject request) throws URISyntaxException, IOException {

        //create client
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //create post and config
        URI uri = new URI(request.getString("uri"));
        JSONObject body_parmas = request.getJSONObject("body_params");
        JSONObject head_parmas = request.getJSONObject("head_params");
        HttpPost post = new HttpPost(uri);

        post.setConfig(config);
        for (Iterator<String> iterator = head_parmas.keys(); iterator.hasNext(); ) {
            String key = iterator.next();
            post.addHeader(key, (String)head_parmas.get(key));
        }

        post.setEntity(new StringEntity(body_parmas.toString()));

        //execute post
        CloseableHttpResponse httpResponse = httpClient.execute(post);

        //response status & body
        JSONObject response = new JSONObject();
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        JSONObject values = new JSONObject(EntityUtils.toString(httpResponse.getEntity(), Consts.UTF_8));
        response.put("status_code", statusCode);
        response.put("values", values);

        httpResponse.close();
        httpClient.close();

        return response;
    }

    public ApiResponse PutAndResponse(final URI uri, final JSONObject jsonObject)
            throws URISyntaxException, IOException {
        return null;
    }

    public ApiResponse GetAndResponse(final URI uri, final JSONObject jsonObject)
            throws URISyntaxException, IOException {
        return null;
    }

    public ApiResponse DeleteAndResponse(final URI uri, final JSONObject jsonObject)
            throws URISyntaxException, IOException {
        return null;
    }
}
