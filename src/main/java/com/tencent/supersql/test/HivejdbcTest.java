package com.tencent.supersql.test;

import java.sql.*;

/**
 * Created by waixingren on 3/2/17.
 */
public class HivejdbcTest {

    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:hive2://10.70.79.77:10000/default","waixingren", "");
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("desc parquetorders");
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        //                String catalogName = resultSetMetaData.getCatalogName(1);
        String catalogName = "";
        String columnClassName = resultSetMetaData.getColumnClassName(1);
        int columnDisplaySize = resultSetMetaData.getColumnDisplaySize(1);
        String columnLabel = resultSetMetaData.getColumnLabel(1);
        String columnName = resultSetMetaData.getColumnName(1);
        int columnType = resultSetMetaData.getColumnType(1) == 1? 12:resultSetMetaData.getColumnType(1);

        String columnTypeName = resultSetMetaData.getColumnTypeName(1);
        int precision = resultSetMetaData.getPrecision(1);
        int scale = resultSetMetaData.getScale(1);
//                String schemaName = resultSetMetaData.getSchemaName(1);
        String schemaName = "";
//                String tableName = resultSetMetaData.getTableName(1);
        String tableName = "";
        boolean autoIncrement = resultSetMetaData.isAutoIncrement(1);
        boolean caseSensitve = resultSetMetaData.isCaseSensitive(1);
        boolean currency = resultSetMetaData.isCurrency(1);
//                boolean definitelyWritable = resultSetMetaData.isDefinitelyWritable(1);
        boolean definitelyWritable = true;
        int nullable = resultSetMetaData.isNullable(1);
        boolean readOnly = resultSetMetaData.isReadOnly(1);
//                boolean searchable = resultSetMetaData.isSearchable(1);
        boolean searchable = true;
//                boolean signed = resultSetMetaData.isSigned(1);
        boolean signed = true;
//                boolean writable = resultSetMetaData.isWritable(1);
        boolean writable = true;




        resultSet.next();

        System.out.println(resultSet.getInt(0));
    }
}
