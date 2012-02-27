package com.nitindhar.giltjava.util;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.testng.annotations.Test;

import com.nitindhar.giltjava.util.URIBuilder;

public class URIBuilderTests {
    
    @Test (groups={"ready"})
    public void testBuild() {
        String resource = "sales";
        String store = "kids";
        String action = "active";
        String apikey = "abc";
        String params = null;
        
        URIBuilder builder = new URIBuilder();
        builder.resource(resource);
        builder.store(store);
        builder.action(action);
        builder.apikey(apikey);
        builder.params(params);
        TestCase.assertEquals("https://api.gilt.com/v1/sales/kids/active.json?apikey=abc", builder.build());
        
        params = "product_detail=true";
        builder = new URIBuilder();
        builder.resource(resource);
        builder.store(store);
        builder.action(action);
        builder.apikey(apikey);
        builder.params(params);
        TestCase.assertEquals("https://api.gilt.com/v1/sales/kids/active.json?apikey=abc&product_detail=true", builder.build());
        
        store = null;
        builder = new URIBuilder();
        builder.resource(resource);
        builder.store(store);
        builder.action(action);
        builder.apikey(apikey);
        builder.params(params);
        TestCase.assertEquals("https://api.gilt.com/v1/sales/active.json?apikey=abc&product_detail=true", builder.build());
        
        action = null;
        builder = new URIBuilder();
        builder.resource(resource);
        builder.store(store);
        builder.action(action);
        builder.apikey(apikey);
        builder.params(params);
        TestCase.assertEquals("https://api.gilt.com/v1/sales/apikey=abc&product_detail=true", builder.build());
    }

    @Test (groups={"ready"})
    public void testParametrizeMap() {
        Map<String,String> params = new HashMap<String,String>();
        params.put("product_detail", "true");
        params.put("abc", "def");
        TestCase.assertEquals("abc=def&product_detail=true", URIBuilder.parametrizeMap(params));
    }

}
