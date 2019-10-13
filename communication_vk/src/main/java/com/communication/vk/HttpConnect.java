package com.communication.vk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class HttpConnect {
        public static void sendGet (String SuspectIsFriendID ) throws Exception{

            Gson GSON = new GsonBuilder().setPrettyPrinting().create();

            String USER_AGENT = "Mozilla/5.0";


            String API_VK = "https://api.vk.com/method/";

            String access_token = "&access_token=";
            String vVKapi = "&v=5.101";


          //  String methodName = "friends.getMutual?source_uid=" + suspectID + "&target_uids=" + SuspectIsFriendID;
            String methodName = "friends.areFriends?user_ids="  + SuspectIsFriendID +"&need_sign=1" ;


            String url = API_VK + methodName + access_token + vVKapi;

            URL obj = new URL(url);
//            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.37.19", 8080));
//            HttpURLConnection con = (HttpURLConnection) obj.openConnection(proxy);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
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
            System.out.println("response:" + response.toString());
        }

        }

