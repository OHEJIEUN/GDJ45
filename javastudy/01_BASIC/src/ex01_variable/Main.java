package ex01_variable;

import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;

import java.io.*;

import java.net.URL;import java.net.URLEncoder;

import java.text.SimpleDateFormat;import java.util.Date;

 
import java.io.BufferedReader;

import java.io.BufferedWriter;

import java.io.DataOutputStream;

import java.io.File;

import java.io.FileWriter;

import java.io.InputStreamReader;

import java.net.HttpURLConnection;

import java.net.URL;

import java.net.URLEncoder;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.swing.JOptionPane;

import org.json.JSONObject;

 

public class Main {

    public static void main(String[] args) {

        String clientId = "C4eZVVUAQJzuEShVgST4";

        String clientSecret ="v8KS5FKYHn";

 

        String apiURL = "https://openapi.naver.com/v1/papago/n2mt";

        String korean = JOptionPane.showInputDialog("번역할 한국어를 입력하세요"); 

        String text;

        try {

            text = URLEncoder.encode(korean, "UTF-8");

            URL url = new URL(apiURL);

            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            String postParams = "source=ko&target=en&text=" + text;

            con.setRequestMethod("POST");

            con.setRequestProperty("X-Naver-Client-Id", clientId);

            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            con.setDoOutput(true);

 

            try(DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {

                wr.write(postParams.getBytes());

                wr.flush();

            }

 

            BufferedReader br = null;

            int responseCode = con.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK) {

                br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            } else {

                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));

            }

 

            StringBuilder sb = new StringBuilder();

            String line;

            while ((line = br.readLine()) != null) {

                sb.append(line);

            }

 

            String res = sb.toString();

            JSONObject obj = new JSONObject(res);

            String translatedText =  obj.getJSONObject("message").getJSONObject("result").getString("translatedText");

            File dir = new File("C:" + File.separator + "download");

            if(dir.exists() == false) {

                dir.mkdirs();

            }

 

            String filename = System.currentTimeMillis() + ".txt";

            File file = new File(dir, filename);

 

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            bw.write(korean + " -> " + translatedText);

            System.out.println(filename + " 파일이 생성되었습니다.");

            bw.close();

            br.close();

            con.disconnect();

        } catch (Exception e) {

            File dir = new File("C:" + File.separator + "download" + File.separator +"log");

            if(dir.exists() == false) {

                dir.mkdirs();

            }

            String filename = "error_log.txt";

            File file = new File(dir, filename);

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

                bw.write(e.getMessage() + " " + new SimpleDateFormat("a h:mm yyyy-MM-dd").format(new Date()));

                System.out.println(filename + " 파일이 생성되었습니다.");

            } catch (Exception e2) {

                e2.printStackTrace();

            }

        }

    }

}