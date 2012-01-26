package com.giltjava.util;

import java.net.URL;

import junit.framework.TestCase;

import org.testng.annotations.Test;

public class HttpUtilTests {
    
    @Test (groups={"ready"})
    public void testGet() {
        URL url = getClass().getClassLoader().getResource("sales_without_options.json");
        String json = HttpUtil.get(url.toString());
        TestCase.assertNotNull(json);
        TestCase.assertEquals(861, json.length());
    }

}
