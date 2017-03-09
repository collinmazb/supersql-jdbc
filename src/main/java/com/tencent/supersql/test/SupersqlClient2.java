package com.tencent.supersql.test;

import com.tencent.supersql.jdbc.SSqlConnection;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by waixingren on 3/6/17.
 */
public class SupersqlClient2 {

    public static void main( String[] args ) throws SQLException, ClassNotFoundException {


        //创建uae连接
        String createTable = "CREATE EXTERNAL TABLE nation(\n" +
                "  n_nationkey int,\n" +
                "  n_name string,\n" +
                "  n_regionkey int,\n" +
                "  n_comment string)\n" +
                " ROW FORMAT DELIMITED\n" +
                "  FIELDS TERMINATED BY '|' " +
                "ssoptions(model columnstore, realtime false, transaction true)";


        Class.forName("com.tencent.supersql.jdbc.SSqlDriver");
        String ssqlJdbcString = "jdbc:SSql://localhost:7911/Default";
        Connection con = DriverManager.getConnection(ssqlJdbcString);
        SSqlConnection ssqlConnection = (SSqlConnection)con;

        Statement statement = ssqlConnection.createStatement();

//
//        statement.executeUpdate(createTable);

        ResultSet resultSet = statement.executeQuery("show databases");
        resultSet.next();
        System.out.println("result:");
        System.out.println(resultSet.getString(1));
        resultSet.next();
        System.out.println(resultSet.getString(1));
        resultSet.next();
        System.out.println(resultSet.getString(1));

//        ssqlConnection.createLink("jdbc:presto://10.70.79.88:8081/mysql/tpch","link2presto","test", "");
    }
}
