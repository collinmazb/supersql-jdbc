package com.tencent.supersql.thrift;

import java.sql.*;

/**
 * Created by waixingren on 3/2/17.
 */
public class HivejdbcTest {

    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:hive2://10.70.79.33:10000/default","waixingren", "");
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("desc parquetorders");
        resultSet.next();

        System.out.println(resultSet.getInt(0));
    }
}
