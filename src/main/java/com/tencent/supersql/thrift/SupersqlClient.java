package com.tencent.supersql.thrift;

/**
 * Created by waixingren on 2/21/17.
 */

import com.tencent.supersql.jdbc.SSqlConnection;
import com.tencent.supersql.jdbc.SSqlDriver;
import com.tencent.supersql.jdbc.SSqlStatement;

import java.sql.*;
public class SupersqlClient {

    public static void main( String[] args ) throws SQLException, ClassNotFoundException {



        //创建uae连接
        Class.forName("com.tencent.supersql.jdbc.SSqlDriver");
        String uaeJdbcString = "jdbc:SSql://localhost:7911";
        Connection con = DriverManager.getConnection(uaeJdbcString);
        SSqlConnection supersqlConnection = (SSqlConnection)con;
        supersqlConnection.createLink("jdbc:presto://10.70.79.81:8081/mysql/tpch","link2presto","test", "");
        System.out.println(supersqlConnection.getAllLinks().toString());

        supersqlConnection.usingLink("link2presto");
        Statement statement = supersqlConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from nation");

        resultSet.next();
        System.out.println(resultSet.getInt("n_nationkey"));


    }
}
