package com.communication.vk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import org.codehaus.jackson.map.util.JSONPObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HttpURLConnectionExample {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        HttpURLConnectionExample http = new HttpURLConnectionExample();



        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet();




//        System.out.println("\nTesting 2 - Send Http POST request");
//        http.sendPost();

    }

    // HTTP GET request
    private void sendGet() throws Exception {

        JsonObject jsonObject = new JsonObject();


        //name = jsonObject.getAsJsonObject("response").getAsJsonArray("id");


       // System.out.println(jsonObject.getAsJsonObject("response").getAsString("id"));
    }

//class Mutual{
//        private int ID;
//        private List<String> CommonFriend = new ArrayList<String>();
//        private  String CommonCount;
//
//
//
//        public int getID(){
//            return ID;
//        }
//
//        public List<String> getCommonFriend(){
//            return CommonFriend;
//        }
//
//        public String getCommonCount(){
//            return CommonCount;
//        }
//
//
//        public Mutual(int ID, List<String> CommonFriend,String CommonCount ){
//            this.ID = ID;
//            this.CommonFriend = CommonFriend;
//            this.CommonCount = CommonCount;
//        }
//
//
//
//
//}















    // HTTP POST request
    private void sendPost() throws Exception {

        String url = "https://selfsolve.apple.com/wcResults.do";
        URL obj = new URL(url);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.37.19", 8080));
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection(proxy);

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

}
