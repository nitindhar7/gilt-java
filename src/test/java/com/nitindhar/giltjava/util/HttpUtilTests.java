package com.nitindhar.giltjava.util;

import java.net.URL;

import junit.framework.TestCase;

import org.testng.annotations.Test;

import com.nitindhar.giltjava.util.HttpUtil;

public class HttpUtilTests {
    
    private static final HttpUtil http = new HttpUtil();
    
    @Test (groups={"ready"})
    public void testGet() {
        URL url = getClass().getClassLoader().getResource("sales_without_options.json");
        String json = http.get(url.toString());
        TestCase.assertNotNull(json);
        TestCase.assertEquals(861, json.length());
    }

}
