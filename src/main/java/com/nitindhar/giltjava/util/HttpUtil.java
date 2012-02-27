package com.nitindhar.giltjava.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class HttpUtil {
    
    private static final String ENCODING = "UTF-8";
    
    public String get(String endpointUrl) {
        StringBuilder sb = null;
        URLConnection urlConn = null;

        try {
            sb = new StringBuilder();
            URL url = new URL(endpointUrl);

            if (url.getProtocol().toLowerCase().equals("https")) {
                urlConn = (HttpsURLConnection) url.openConnection();
            } else {
                urlConn = url.openConnection();
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), ENCODING));

            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }

            in.close();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error connecting to url", e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading from url", e);
        }
        
        return sb.toString();
    }
    
    public String appendAPIKey(String key) {
        return "?apikey=" + key;
    }

}
