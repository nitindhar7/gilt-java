package com.nitindhar.giltjava;

import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;
import com.ning.http.client.Response;

public class HttpRequest {

    private static final int MAX_HTTP_GET_WAIT = 5;
    private static final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

    /**
     * Workhorse method that GETs data from a URL and
     * returns the result as a json string
     *
     * @param requestURI The Gilt endpoint requested
     * @return String containing the full GiltAPI response
     */
    @SuppressWarnings("deprecation")
    public String get(String endpointUrl, Map<String,Object> params) {
        String json = null;

        try {
            BoundRequestBuilder builder = asyncHttpClient.prepareGet(endpointUrl);
            for(String key : params.keySet()) {
                builder.addQueryParameter(URLEncoder.encode(key), URLEncoder.encode((String) params.get(key)));
            }
            Future<Response> f = builder.execute();
            Response resp = f.get(MAX_HTTP_GET_WAIT, TimeUnit.SECONDS);
            json = resp.getResponseBody();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get data from: " + endpointUrl, e);
        }

        return json;
    }

}