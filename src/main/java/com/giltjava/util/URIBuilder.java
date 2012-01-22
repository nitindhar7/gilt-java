package com.giltjava.util;

import java.util.Map;

public class URIBuilder {
    
    private static final String BASE_URL = "https://api.gilt.com/v1/";
    
    private String resource;
    private String store;
    private String action;
    private String apikey;
    private String params;
    
    public URIBuilder() {
        resource = null;
        store = null;
        action = null;
        apikey = null;
        params = null;
    }
    
    public URIBuilder resource(String resource) {
        this.resource = resource;
        return this;
    }

    public URIBuilder store(String store) {
        this.store = store;
        return this;
    }

    public URIBuilder action(String action) {
        this.action = action;
        return this;
    }

    public URIBuilder apikey(String apikey) {
        this.apikey = apikey;
        return this;
    }

    public URIBuilder params(String params) {
        this.params = params;
        return this;
    }

    public String build() {
        StringBuilder sb = new StringBuilder(BASE_URL);
        if(resource != null)
            sb.append(resource).append("/");
        if(store != null)
            sb.append(store).append("/");
        if(action != null)
            sb.append(action).append(".json").append("?");
        if(apikey != null)
            sb.append("apikey=").append(apikey).append("&");
        if(params != null)
            sb.append(params);
        return sb.toString();
    }
    
    public static String parametrizeMap(Map<String,String> params) {
        StringBuilder sb = new StringBuilder();
        for(String key : params.keySet()) {
            sb.append(key).append("=").append(params.get(key)).append("&");
        }
        return sb.substring(0, sb.toString().length()-1);
    }

}
