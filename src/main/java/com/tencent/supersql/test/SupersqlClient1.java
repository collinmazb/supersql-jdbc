package com.tencent.supersql.test;

/**
 * Created by waixingren on 2/21/17.
 */

import com.tencent.supersql.jdbc.SSqlConnection;
import com.tencent.supersql.jdbc.SSqlDriver;
import com.tencent.supersql.jdbc.SSqlStatement;

import java.sql.*;
public class SupersqlClient1 {

    public static void main( String[] args ) throws SQLException, ClassNotFoundException {



        //创建uae连接
        Class.forName("com.tencent.supersql.jdbc.SSqlDriver");
        String uaeJdbcString = "jdbc:SSql://localhost:7911";
        Connection con = DriverManager.getConnection(uaeJdbcString);
        SSqlConnection ssqlConnection = (SSqlConnection)con;
        ssqlConnection.createLink("jdbc:presto://10.70.79.88:8081/mysql/tpch","link2presto","test", "");
//        System.out.println(supersqlConnection.getAllLinks().toString());

//        ssqlConnection.usingLink("link2presto");
        Statement statement = ssqlConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from nation");

        resultSet.next();
        System.out.println(resultSet.getInt("n_nationkey"));


    }
}
