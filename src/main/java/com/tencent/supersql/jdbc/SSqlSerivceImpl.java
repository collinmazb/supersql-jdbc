package com.tencent.supersql.jdbc;

/**
 * Created by waixingren on 2/27/17.
 */

import com.tencent.supersql.gen.*;
import org.apache.thrift.TException;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.tencent.supersql.gen.RawVal.*;

public  class SSqlSerivceImpl implements SupersqlConnectionService.Iface{



    final Logger logger = LoggerFactory.getLogger(SSqlSerivceImpl.class);
    private Map<String, Connection> allLinks = new HashMap<String, Connection>();
    private Connection currentLink;
    private Statement currentStatement;

    @Override
    public int createLink(String driverurl, String linkName, String username, String password) throws TException {

        try {
            Connection con = DriverManager.getConnection(driverurl,username,password);
            allLinks.put(linkName, con);
            if(con != null){

                logger.info("link to presto created");
            }
            int r  = con == null ? -1 : 0;
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String useLink(String linkName) throws TException {

        currentLink = allLinks.get(linkName);
        return linkName;
    }

    @Override
    public List<String> showLinks() throws TException {

        List<String> links = new ArrayList<String>();
        for(String linkName : allLinks.keySet()){

            links.add(linkName);
        }
        return links;
    }

    @Override
    public SupersqlConnection createConnection(String url, Map<String, String> properties) throws TException {
        return null;
    }

    @Override
    public SupersqlStatement createStatement(SupersqlConnection connection) throws TException {

        try {
            currentStatement = currentLink.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SupersqlStatement supersqlStatement = new SupersqlStatement(1234, "select * from nation", 2345);
        return  supersqlStatement;
    }

    @Override
    public SupersqlStaticMetaData connection_getstaticmetadata(SupersqlConnection connection) throws TException {
        return null;
    }

    @Override
    public boolean connection_isvalid(SupersqlConnection connection, int timeout) throws TException {
        return false;
    }

    @Override
    public void connection_setAutoCommit(SupersqlConnection connection, boolean autoCommit) throws SupersqlException, TException {

    }

    @Override
    public boolean connection_getAutoCommit(SupersqlConnection connection) throws SupersqlException, TException {
        return false;
    }

    @Override
    public void connection_setTransactionIsolation(SupersqlConnection connection, int level) throws SupersqlException, TException {

    }

    @Override
    public int connection_getTransactionIsolation(SupersqlConnection connection) throws SupersqlException, TException {
        return 0;
    }

    @Override
    public void connection_setReadOnly(SupersqlConnection connection, boolean readOnly) throws SupersqlException, TException {

    }

    @Override
    public boolean connection_getReadOnly(SupersqlConnection connection) throws SupersqlException, TException {
        return false;
    }

    @Override
    public void connection_setCatalog(SupersqlConnection connection, String catalog) throws SupersqlException, TException {

    }

    @Override
    public String connection_getCatalog(SupersqlConnection connection) throws SupersqlException, TException {
        return null;
    }

    @Override
    public void connection_setSchema(SupersqlConnection connection, String schema) throws SupersqlException, TException {

    }

    @Override
    public String connection_getSchema(SupersqlConnection connection) throws SupersqlException, TException {
        return null;
    }

    @Override
    public String connection_getCatalogSeparator(SupersqlConnection connection) throws TException {
        return null;
    }

    @Override
    public String connection_getCatalogTerm(SupersqlConnection connection) throws TException {
        return null;
    }

    @Override
    public String connection_getSchemaTerm(SupersqlConnection connection) throws TException {
        return null;
    }

    @Override
    public SupersqlResultSet connection_getCatalogs(SupersqlConnection connection) throws TException {
        return null;
    }

    @Override
    public SupersqlResultSet connection_getSchemas(SupersqlConnection connection, String catalog, String schemaPattern) throws SupersqlException, TException {
        return null;
    }

    @Override
    public SupersqlResultSet connection_getTables(SupersqlConnection connection, String catalog, String schemaPattern, String tableNamePattern, List<String> types) throws TException {
        return null;
    }

    @Override
    public SupersqlResultSet connection_getColumns(SupersqlConnection connection, String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern) throws TException {
        return null;
    }

    @Override
    public String connection_getSQLKeywords(SupersqlConnection connection) throws TException {
        return null;
    }

    @Override
    public SupersqlResultSet connection_getTableTypes(SupersqlConnection connection) throws TException {
        return null;
    }

    @Override
    public SupersqlResultSet connection_getTypeInfo(SupersqlConnection connection) throws SupersqlException, TException {
        return null;
    }

    @Override
    public void closeConnection(SupersqlConnection connection) throws SupersqlException, TException {

    }

    @Override
    public void statement_close(SupersqlStatement statement) throws SupersqlException, TException {

    }

    @Override
    public boolean statement_execute(SupersqlStatement statement, String sql) throws SupersqlException, TException {
        return false;
    }

    @Override
    public SupersqlResultSet statement_executeQuery(SupersqlStatement statement, String sql) throws SupersqlException, TException {

        ResultSet resultSet = null;
        try {
            resultSet = currentStatement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return convertResultSet(resultSet);
    }

    private static SupersqlResultSet convertResultSet(ResultSet driverResultSet){
//          public SupersqlRow(
//                java.util.List<SupersqlValue> values)
//        {
//            this();
//            this.values = values;
//        }

//          public SupersqlValue(
//        boolean isnull,
//        RawVal val)
//        {
//            this();
//            this.isnull = isnull;
//            setIsnullIsSet(true);
//            this.val = val;
//        }

        //  public SupersqlResultSet(
//        int id,
//        java.util.List<SupersqlRow> rows,
//        SupersqlResultSetMetaData metadata)
//        {
//            this();
//            this.id = id;
//            setIdIsSet(true);
//            this.rows = rows;
//            this.metadata = metadata;
//        }

        List<SupersqlRow> rows = new ArrayList<SupersqlRow>();
        ResultSetMetaData resultSetMetaData = null;
        List<SupersqlResultSetMetaDataPart> partlist = new ArrayList<SupersqlResultSetMetaDataPart>();
        try {
            resultSetMetaData = driverResultSet.getMetaData();

            //for data
            while(driverResultSet.next()){

                List<SupersqlValue> values = new ArrayList<SupersqlValue>();
                int fieldCount = resultSetMetaData.getColumnCount();

                for (int i = 1; i < fieldCount; i++) {

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
                        default:
                            System.err.println("not supported field type");
                    }
                    values.add(new SupersqlValue(true,rawVal));
                }
                rows.add(new SupersqlRow(values));
            }

            //for meta
            int fieldCount = resultSetMetaData.getColumnCount();
            for (int i = 1; i < fieldCount; i++) {

                String catalogName = resultSetMetaData.getCatalogName(i);
                String columnClassName = resultSetMetaData.getColumnClassName(i);
                int columnDisplaySize = resultSetMetaData.getColumnDisplaySize(i);
                String columnLabel = resultSetMetaData.getColumnLabel(i);
                String columnName = resultSetMetaData.getColumnName(i);
                int columnType = resultSetMetaData.getColumnType(i);
                String columnTypeName = resultSetMetaData.getColumnTypeName(i);
                int precision = resultSetMetaData.getPrecision(i);
                int scale = resultSetMetaData.getScale(i);
                String schemaName = resultSetMetaData.getSchemaName(i);
                String tableName = resultSetMetaData.getTableName(i);
                boolean autoIncrement = resultSetMetaData.isAutoIncrement(i);
                boolean caseSensitve = resultSetMetaData.isCaseSensitive(i);
                boolean currency = resultSetMetaData.isCurrency(i);
                boolean definitelyWritable = resultSetMetaData.isDefinitelyWritable(i);
                int nullable = resultSetMetaData.isNullable(i);
                boolean readOnly = resultSetMetaData.isReadOnly(i);
                boolean searchable = resultSetMetaData.isSearchable(i);
                boolean signed = resultSetMetaData.isSigned(i);
                boolean writable = resultSetMetaData.isWritable(i);

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

    @Override
    public SupersqlResultSet statement_getResultSet(SupersqlStatement statement) throws SupersqlException, TException {
        return null;
    }

    @Override
    public int statement_getUpdateCount(SupersqlStatement statement) throws TException {
        return 0;
    }

    @Override
    public int statement_getResultSetType(SupersqlStatement statement) throws TException {
        return 0;
    }

    @Override
    public void statement_cancel(SupersqlStatement statement) throws SupersqlException, TException {

    }

    @Override
    public statement_getWarnings_return statement_getWarnings(SupersqlStatement statement) throws SupersqlException, TException {
        return null;
    }

    @Override
    public void statement_clearWarnings(SupersqlStatement statement) throws SupersqlException, TException {

    }

    @Override
    public int statement_getMaxRows(SupersqlStatement statement) throws SupersqlException, TException {
        return 0;
    }

    @Override
    public void statement_setMaxRows(SupersqlStatement statement, int max) throws SupersqlException, TException {

    }

    @Override
    public int statement_getQueryTimeout(SupersqlStatement statement) throws SupersqlException, TException {
        return 0;
    }

    @Override
    public void statement_setQueryTimeout(SupersqlStatement statement, int seconds) throws SupersqlException, TException {

    }
}
