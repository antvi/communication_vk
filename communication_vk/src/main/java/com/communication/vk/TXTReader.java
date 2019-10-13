package com.communication.vk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TXTReader {





    public static String readAllTXT(String pathName) throws Exception {

        List<String>userID = new ArrayList<String>();
        //FileReader fr = new FileReader(new File("src/main/resources/data.txt"));

            FileReader fr = new FileReader(new File(pathName));
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                //delete "ID" out txt file
                StringBuffer stringBuffer = new StringBuffer(line);
                stringBuffer.delete(0, 2);

                line = stringBuffer.toString();

                userID.add(line);
                line = reader.readLine();
            }
//clear first count from list


          //  userID.remove(0);

//            for (String index : userID) {
//
//
//
//                    System.out.println(index);
//
//            }

        String userIDasStr = String.join(",",userID);


      //  System.out.println(userIDasStr);
        return (userIDasStr);





    }



    public static  String getFirstIDfromTXT(String pathName) throws Exception {



        FileReader first = new FileReader(new File(pathName));
        BufferedReader reader = new BufferedReader(first);


        //read first id from file
        String firstID = reader.readLine();


        //delete "ID" out txt file
        StringBuffer stringBuffer = new StringBuffer(firstID);
        stringBuffer.delete(0,2);
        firstID =stringBuffer.toString();

        return firstID;


    }






}
