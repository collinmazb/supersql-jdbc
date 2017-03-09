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

    private static Logger logger  =  Logger.getLogger(ConnectionPool.class);
    private static Map<String, List<Connection>> pool = new HashMap<>();
    public static void init(){

        List<Connection> prestoCons = new ArrayList<>();
        for (int i = 0; i < 3; i++) {

            try {
                Connection con = DriverManager.getConnection("jdbc:presto://localhost:8081/hive", "test", null);
                prestoCons.add(con);
                logger.info("one presto connection created");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        pool.put("presto", prestoCons);

        ////////////////////////////////////////
        List<Connection> sparksqlCons = new ArrayList<>();
        for (int i = 0; i < 3; i++) {

            try {
                Connection con = DriverManager.getConnection("jdbc:hive2://localhost:10000/default", "waixingren", null);
                sparksqlCons.add(con);
                logger.info("one hive connection created");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        pool.put("hive", sparksqlCons);

    }

    public static Connection getConnection(String driverName){

        return pool.get(driverName).get(0);
    }
}
