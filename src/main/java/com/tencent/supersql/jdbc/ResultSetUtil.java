package com.tencent.supersql.jdbc;

import com.tencent.supersql.gen.*;
import com.tencent.supersql.thrift.SSMetaData;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.tencent.supersql.gen.RawVal.*;
import static com.tencent.supersql.gen.RawVal.bool_val;
import static com.tencent.supersql.gen.RawVal.string_val;

/**
 * Created by waixingren on 3/8/17.
 */
public class ResultSetUtil {


    public static SupersqlResultSet convertDB(Set<String> dbs) {

        List<SupersqlRow> rows = new ArrayList<SupersqlRow>();
        ResultSetMetaData resultSetMetaData = null;
        List<SupersqlResultSetMetaDataPart> partlist = new ArrayList<SupersqlResultSetMetaDataPart>();


        int fieldCount = 1;
        //for data
        for (String db : dbs) {

            List<SupersqlValue> values = new ArrayList<SupersqlValue>();

            for (int i = 1; i < fieldCount + 1; i++) {

                RawVal rawVal = string_val(db);
                values.add(new SupersqlValue(false, rawVal));
            }
            rows.add(new SupersqlRow(values));
        }

        //for meta
        for (int i = 1; i < fieldCount + 1; i++) {

            String catalogName = "";
            String columnClassName = "java.lang.String";
            int columnDisplaySize = 2147483647;
            String columnLabel = "Database";
            String columnName = "Database";
            int columnType = 12;

            String columnTypeName = "string";
            int precision = 2147483647;
            int scale = 0;
//                String schemaName = resultSetMetaData.getSchemaName(i);
            String schemaName = "";
//                String tableName = resultSetMetaData.getTableName(i);
            String tableName = "";
            boolean autoIncrement = false;
            boolean caseSensitve = false;
            boolean currency = false;
//                boolean definitelyWritable = resultSetMetaData.isDefinitelyWritable(i);
            boolean definitelyWritable = true;
            int nullable = 1;
            boolean readOnly = true;
//                boolean searchable = resultSetMetaData.isSearchable(i);
            boolean searchable = true;
//                boolean signed = resultSetMetaData.isSigned(i);
            boolean signed = true;
//                boolean writable = resultSetMetaData.isWritable(i);
            boolean writable = true;

            SupersqlResultSetMetaDataPart supersqlResultSetMetaDataPart = new SupersqlResultSetMetaDataPart(
                    catalogName,
                    columnClassName,
                    columnDisplaySize,
                    columnLabel,
                    columnName,
                    columnType,
                    columnTypeName,
                    precision,
                    scale,
                    schemaName,
                    tableName,
                    autoIncrement,
                    caseSensitve,
                    currency,
                    definitelyWritable,
                    nullable,
                    readOnly,
                    searchable,
                    signed,
                    writable);
            partlist.add(supersqlResultSetMetaDataPart);
        }

        return new SupersqlResultSet(1, rows, new SupersqlResultSetMetaData(partlist));
    }


    public static SupersqlResultSet convertTable(List<SSMetaData.DriverInfo> driverInfos) {

        List<SupersqlRow> rows = new ArrayList<SupersqlRow>();
        ResultSetMetaData resultSetMetaData = null;
        List<SupersqlResultSetMetaDataPart> partlist = new ArrayList<SupersqlResultSetMetaDataPart>();


        int fieldCount = 4;
        //for data
        for (SSMetaData.DriverInfo driverInfo  : driverInfos) {

            List<SupersqlValue> values = new ArrayList<SupersqlValue>();

            for (int i = 1; i < fieldCount + 1; i++) {

                RawVal rawVal = null;
                switch (i){

                    case 1:
                        rawVal = string_val(driverInfo.getDriverTableName());
                        break;
                    case 2:
                        rawVal = string_val(driverInfo.getDriverDB());
                        break;
                    case 3:
                        rawVal = string_val(driverInfo.getDriverName());
                        break;
                    case 4:
                        rawVal = string_val(driverInfo.getDriverUrl());
                        break;
                }
                values.add(new SupersqlValue(false, rawVal));
            }
            rows.add(new SupersqlRow(values));
        }

        //for meta
        String str[] = {"Tablename", "Database", "Driver", "DriverUrl"};
        for (int i = 1; i < fieldCount + 1; i++) {

            String catalogName = "";
            String columnClassName = "java.lang.String";
            int columnDisplaySize = 2147483647;
            String columnLabel = str[i-1];
            String columnName = str[i-1];
            int columnType = 12;

            String columnTypeName = "string";
            int precision = 2147483647;
            int scale = 0;
//                String schemaName = resultSetMetaData.getSchemaName(i);
            String schemaName = "";
//                String tableName = resultSetMetaData.getTableName(i);
            String tableName = "";
            boolean autoIncrement = false;
            boolean caseSensitve = false;
            boolean currency = false;
//                boolean definitelyWritable = resultSetMetaData.isDefinitelyWritable(i);
            boolean definitelyWritable = true;
            int nullable = 1;
            boolean readOnly = true;
//                boolean searchable = resultSetMetaData.isSearchable(i);
            boolean searchable = true;
//                boolean signed = resultSetMetaData.isSigned(i);
            boolean signed = true;
//                boolean writable = resultSetMetaData.isWritable(i);
            boolean writable = true;

            SupersqlResultSetMetaDataPart supersqlResultSetMetaDataPart = new SupersqlResultSetMetaDataPart(
                    catalogName,
                    columnClassName,
                    columnDisplaySize,
                    columnLabel,
                    columnName,
                    columnType,
                    columnTypeName,
                    precision,
                    scale,
                    schemaName,
                    tableName,
                    autoIncrement,
                    caseSensitve,
                    currency,
                    definitelyWritable,
                    nullable,
                    readOnly,
                    searchable,
                    signed,
                    writable);
            partlist.add(supersqlResultSetMetaDataPart);
        }

        return new SupersqlResultSet(1, rows, new SupersqlResultSetMetaData(partlist));
    }


    public static SupersqlResultSet convertResultSet(ResultSet driverResultSet){

        List<SupersqlRow> rows = new ArrayList<SupersqlRow>();
        ResultSetMetaData resultSetMetaData = null;
        List<SupersqlResultSetMetaDataPart> partlist = new ArrayList<SupersqlResultSetMetaDataPart>();
        try {
            resultSetMetaData = driverResultSet.getMetaData();

            //for data
            while(driverResultSet.next()){

                List<SupersqlValue> values = new ArrayList<SupersqlValue>();
                int fieldCount = resultSetMetaData.getColumnCount();

                for (int i = 1; i < fieldCount+1; i++) {

                    int columnType = resultSetMetaData.getColumnType(i);
                    RawVal rawVal = null;
                    switch (columnType){

                        case 4:
                            rawVal = integer_val(driverResultSet.getInt(i));
                            break;
                        case 5:
                            rawVal = smallint_val(driverResultSet.getShort(i));
                            break;
                        case -5:
                            rawVal = bigint_val(driverResultSet.getLong(i));
                            break;
                        case 6:
                            rawVal = RawVal.double_val(driverResultSet.getDouble(i));
                            break;
                        case 8:
                            rawVal = RawVal.double_val(driverResultSet.getDouble(i));
                            break;
                        case 12:
                            rawVal = string_val(driverResultSet.getString(i));
                            break;
                        case 1:
                            rawVal = string_val(driverResultSet.getString(i));
                            break;
                        case -16:
                            rawVal  = string_val(driverResultSet.getString(i));
                            break;
                        case 16:
                            rawVal = bool_val(driverResultSet.getBoolean(i));
                            break;
                        default:
                            System.err.println("not supported field type");
                    }
                    values.add(new SupersqlValue(false,rawVal));
                }
                rows.add(new SupersqlRow(values));
            }

            //for meta
            int fieldCount = resultSetMetaData.getColumnCount();
            for (int i = 1; i < fieldCount+1; i++) {

//                String catalogName = resultSetMetaData.getCatalogName(i);
                String catalogName = "";
                String columnClassName = resultSetMetaData.getColumnClassName(i);
                int columnDisplaySize = resultSetMetaData.getColumnDisplaySize(i);
                String columnLabel = resultSetMetaData.getColumnLabel(i);
                String columnName = resultSetMetaData.getColumnName(i);
                int columnType = resultSetMetaData.getColumnType(i) == 1? 12:resultSetMetaData.getColumnType(i);

                String columnTypeName = resultSetMetaData.getColumnTypeName(i);
                int precision = resultSetMetaData.getPrecision(i);
                int scale = resultSetMetaData.getScale(i);
//                String schemaName = resultSetMetaData.getSchemaName(i);
                String schemaName = "";
//                String tableName = resultSetMetaData.getTableName(i);
                String tableName = "";
                boolean autoIncrement = resultSetMetaData.isAutoIncrement(i);
                boolean caseSensitve = resultSetMetaData.isCaseSensitive(i);
                boolean currency = resultSetMetaData.isCurrency(i);
//                boolean definitelyWritable = resultSetMetaData.isDefinitelyWritable(i);
                boolean definitelyWritable = true;
                int nullable = resultSetMetaData.isNullable(i);
                boolean readOnly = resultSetMetaData.isReadOnly(i);
//                boolean searchable = resultSetMetaData.isSearchable(i);
                boolean searchable = true;
//                boolean signed = resultSetMetaData.isSigned(i);
                boolean signed = true;
//                boolean writable = resultSetMetaData.isWritable(i);
                boolean writable = true;

                SupersqlResultSetMetaDataPart supersqlResultSetMetaDataPart = new SupersqlResultSetMetaDataPart(
                        catalogName,
                        columnClassName,
                        columnDisplaySize,
                        columnLabel,
                        columnName,
                        columnType,
                        columnTypeName,
                        precision,
                        scale,
                        schemaName,
                        tableName,
                        autoIncrement,
                        caseSensitve,
                        currency,
                        definitelyWritable,
                        nullable,
                        readOnly,
                        searchable,
                        signed,
                        writable);
                partlist.add(supersqlResultSetMetaDataPart);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return new SupersqlResultSet(1, rows,new SupersqlResultSetMetaData(partlist));
    }


}
