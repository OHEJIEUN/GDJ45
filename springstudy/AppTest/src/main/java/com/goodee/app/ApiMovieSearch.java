package com.goodee.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiMovieSearch {

	public static void main(String[] args) {
		
		String clientId = "XvHSzjB4Bj49XBbfspdN";
		String clientSecret = "ARhr4OmF6r";
		
		String text = JOptionPane.showInputDialog("영화 관련 검색어를 입력하세요.");
		try {
            text = URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }
		
		String apiURL = "https://openapi.naver.com/v1/search/movie.json?query=" + text;
		
		Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        
        try {
        	URL url = new URL(apiURL);
        	HttpURLConnection con = (HttpURLConnection)url.openConnection();
        	con.setRequestMethod("GET");
            for(Map.Entry<String, String> header : requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }
            // con.setRequestProperty("X-Naver-Client-Id", clientId);
            // con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            
            InputStream body = null;
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
            	body = con.getInputStream();
            } else {
            	body = con.getErrorStream();
            }
            
            InputStreamReader streamReader = new InputStreamReader(body);

            StringBuilder responseBody = new StringBuilder();

            try (BufferedReader lineReader = new BufferedReader(streamReader)) {
                String line;
                while ((line = lineReader.readLine()) != null) {
                    responseBody.append(line);
                }
            } catch (Exception e) {
				e.printStackTrace();
			}
            
            System.out.println(responseBody.toString());
            
        } catch (Exception e) {
			e.printStackTrace();
		}
        
	}

}