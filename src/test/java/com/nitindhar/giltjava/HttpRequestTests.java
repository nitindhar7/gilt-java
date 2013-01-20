package com.nitindhar.giltjava;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.testng.annotations.Test;

import com.nitindhar.giltjava.HttpRequest;

public class HttpRequestTests {

    private static final HttpRequest http = new HttpRequest();

    @Test (groups={"toBeFixed"})
    public void testGet() {
        URL url = getClass().getClassLoader().getResource("sales_without_options.json");
        Map<String,Object> params = new HashMap<String,Object>();
        String json = http.get(url.toString(), params);
        TestCase.assertNotNull(json);
        TestCase.assertEquals(861, json.length());
    }

}