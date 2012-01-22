package com.giltjava.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpUtil {
    
    public static String get(String url) {
        String response = null;
        HttpsURLConnection conn = null;

        try {
            conn = (HttpsURLConnection) (new URL(url)).openConnection();
            conn.connect();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();

            for (String line = in.readLine(); line != null; line = in.readLine()) {
                sb.append(line);
            }
            
            response = sb.toString();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error connecting to url", e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading from url", e);
        } finally {
            conn.disconnect();
        }
        
        return response;
    }

}
