package com.tencent.supersql.thrift;

import org.apache.log4j.PropertyConfigurator;

import java.io.*;
import java.util.*;

/**
 * Created by waixingren on 3/15/17.
 */
public class Config {

    public static int connectionPoolSize = 0;
    public static Map<String, String> drivers = new HashMap<>();
    public static int supersqlServerPort = 0;


    public static void initDrivers(){

        try{
            Properties prop = new Properties();
            InputStream in = new BufferedInputStream(new FileInputStream("conf/drivers.properties"));
            prop.load(in);
            Iterator<String> it=prop.stringPropertyNames().iterator();
            while(it.hasNext()){

                String driverName =it.next();
                String driverUrl = prop.getProperty(driverName);
                drivers.put(driverName, driverUrl);
            }
            in.close();

        }catch (FileNotFoundException e){

            e.printStackTrace();
        }catch (IOException e){

            e.printStackTrace();
        }

    }

    public static void initConf(){

        try {
            Properties prop = new Properties();
            InputStream in = new BufferedInputStream(new FileInputStream("conf/supersqlserver.properties"));
            prop.load(in);

            connectionPoolSize = Integer.parseInt(prop.getProperty("connection_pool_size", "10"));
            supersqlServerPort = Integer.parseInt(prop.getProperty("supersqlserver_port", "7911"));

            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Config() throws FileNotFoundException {
    }
}
