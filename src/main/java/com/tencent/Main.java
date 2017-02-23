package com.tencent;

/**
 * Created by waixingren on 2/21/17.
 */

import java.sql.*;
public class Main {

    public static void main( String[] args ) throws SQLException {


//        String jdbcUrl = "jdbc:presto://10.70.79.157:8081/mysql/tpch";
//        Connection con1 = DriverManager.getConnection(jdbcUrl,"test",null);

        //创建uae连接
        String uaeJdbcString = "jdbc:uae://localhost:8888";
        Connection con = new UaeConnection();
        UaeConnection uaeConnection = (UaeConnection)con;


        //通过uae连接创建prestolink
        String prestoJdbcUrl = "jdbc:presto://10.70.79.157:8081/mysql/tpch";
        String createPrestoLinkStr = "create link link2Presto connect to prestouser1 identified by 'password' using " + prestoJdbcUrl;
        uaeConnection.createLink(createPrestoLinkStr, "link2presto", "test", null);
        uaeConnection.usingLink("using link link2Presto");
        Connection currentLink = uaeConnection.getCurrentLink();

        //测试presto link的使用
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from nation");
        resultSet.next();
        System.out.println(resultSet.getInt("n_nationkey"));

        /*********************************************************/
        //通过uae连接创建hivelink
        String hiveJdbcUrl = "jdbc:hive2://localhost:10000/default";
        String createHiveLinkStr = "create link link2Hive connect to hiveuser1 identified by 'password' using " + hiveJdbcUrl;
        uaeConnection.createLink(createHiveLinkStr,"link2Hive","waixingren", null);
        uaeConnection.usingLink("using link link2Hive");
        currentLink = uaeConnection.getCurrentLink();

        statement = con.createStatement();
        resultSet = statement.executeQuery("select * from user limit 2");
        resultSet.next();
        System.out.println(resultSet.getInt("userid"));

        /*********************************************************/
        //通过uae连接创建sparksqllink
//        String sparksqlJdbcUrl = ""


    }
}
