package com.communication.vk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;


public class Main {




    public static void main(String[] args) throws Exception {

        TXTReader reader = new TXTReader();


       String SuspectIsFriendID = reader.readAllTXT("src/main/resources/data.txt");
       System.out.println(SuspectIsFriendID);


//      String SuspectID =  reader.getFirstIDfromTXT("src/main/resources/data.txt");
//
//      System.out.println(SuspectID);

        System.out.println("Testing 1 - Send Http GET request");
     HttpConnect.sendGet(SuspectIsFriendID );


    }


}
