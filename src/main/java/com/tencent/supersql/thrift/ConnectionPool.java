package com.tencent.supersql.thrift;

import org.apache.hadoop.util.hash.Hash;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by waixingren on 3/7/17.
 */
public class ConnectionPool {


    static class ConnectionInfo{

        private Connection connection = null;
        private String url = null;

        public ConnectionInfo(Connection connection, String url) {
            this.connection = connection;
            this.url = url;
        }

        public Connection getConnection() {
            return connection;
        }

        public String getUrl() {
            return url;
        }
    }

    private static Logger logger  =  Logger.getLogger(ConnectionPool.class);
    private static Map<String, List<ConnectionInfo>> pool = new HashMap<>();
    public static void init(){

        for(Map.Entry<String, String> entry: Config.drivers.entrySet()){

            String driverName = entry.getKey();
            String values[] = entry.getValue().split(",");
            String driverUrl = values[0];
            String userName = values[1];
            String password = values[2].equalsIgnoreCase("null") ? null : values[2];
            List<ConnectionInfo> connectionInfos = new ArrayList<>();
            for (int i = 0; i < Config.connectionPoolSize; i++) {

                try {
                    Connection con = DriverManager.getConnection(driverUrl, userName, password);
                    connectionInfos.add(new ConnectionInfo(con, driverUrl));
                    logger.info("one connection to "  + driverName + " created");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            pool.put(driverName, connectionInfos);
        }


//        List<ConnectionInfo> prestoCons = new ArrayList<>();
//        for (int i = 0; i < Config.connectionPoolSize; i++) {
//
//            try {
//                String prestoUrl = "jdbc:presto://localhost:8081/hive";
//                Connection con = DriverManager.getConnection(prestoUrl, "test", null);
//                prestoCons.add(new ConnectionInfo(con, prestoUrl));
//                logger.info("one presto connection created");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        pool.put("presto", prestoCons);
//
//        ////////////////////////////////////////
//        List<ConnectionInfo> hiveCons = new ArrayList<>();
//        for (int i = 0; i < Config.connectionPoolSize; i++) {
//
//            try {
//                String hiveUrl = "jdbc:hive2://localhost:10000/default";
//                Connection con = DriverManager.getConnection(hiveUrl, "waixingren", null);
//                hiveCons.add(new ConnectionInfo(con, hiveUrl));
//                logger.info("one hive connection created");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

//        pool.put("hive", hiveCons);

    }

    public static Connection getConnection(String driverName){

        List<ConnectionInfo> cons = pool.get(driverName);
        if(cons != null){

            return pool.get(driverName).get(0).getConnection();
        }else{

            return null;
        }
    }

    public static String getConnectionUrl(String driverName){

        List<ConnectionInfo> cons = pool.get(driverName);
        if(cons != null){

            return pool.get(driverName).get(0).getUrl();
        }else{

            return null;
        }
    }
}
