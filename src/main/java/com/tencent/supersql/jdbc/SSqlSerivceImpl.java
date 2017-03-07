package com.tencent.supersql.jdbc;

/**
 * Created by waixingren on 2/27/17.
 */

import com.tencent.supersql.gen.*;
import org.apache.hadoop.ha.HAServiceProtocolHelper;
import org.apache.thrift.TException;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import java.util.concurrent.atomic.AtomicInteger;

import static com.tencent.supersql.gen.RawVal.*;

public  class SSqlSerivceImpl implements SupersqlConnectionService.Iface{


    Logger logger  =  Logger.getLogger(SSqlSerivceImpl.class);
    private Map<String, Connection> allLinks = new HashMap<String, Connection>();
    private Connection currentLink;
    private Map<Integer, ConnectionInfo> id2Links = new HashMap<>();
    private String currentLinkName;
    private Statement currentStatement;
    private AtomicInteger id = new AtomicInteger(0);

    static class SupersqlOptionKey{

        public static String MODEL;
        public static String REALTIME;
        public static String TRANSACTION;

        public static String DRIVER_NAME;
        public static String DATABASE;
    }

    static class SupersqlOptionValue{

        public static String hive;
        public static String presto;
        public static String sparksql;

    }

    class ConnectionInfo {

        public Connection getCon() {
            return con;
        }

        public void setCon(Connection con) {
            this.con = con;
        }

        public Statement getStatement() {
            return statement;
        }

        public void setStatement(Statement statement) {
            this.statement = statement;
        }

        Connection con;
        Statement statement;

        public ConnectionInfo(Connection con){

            this.con = con;
        }

        public void createStatement(){

            try {
                statement = con.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public int createLink(int id, String driverurl, String linkName, String username, String password) throws TException {

        try {
            Connection con = DriverManager.getConnection(driverurl,username,password);
            String str[] = driverurl.split(":");

            if(con != null){

                logger.info("Link to " + str[1] + " created");
            }else{

                logger.error("Can not create link to " + str[1]);
            }
            id2Links.put(new Integer(id), new ConnectionInfo(con));
            int r  = con == null ? -1 : 0;
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String useLink(int id, String linkName) throws TException {

//        currentLink = id2Links.get(id);
//        currentLinkName = linkName;
//        logger.info("Current link is: " + linkName);
//        return linkName;
        return null;
    }

    @Override
    public List<String> showLinks(int id) throws TException {

        List<String> links = new ArrayList<String>();
        for(String linkName : allLinks.keySet()){

            links.add(linkName);
        }
        return links;
    }

    @Override
    public int getId() throws TException {

        return this.id.incrementAndGet();
    }

    @Override
    public SupersqlConnection createConnection(String url, Map<String, String> properties) throws TException {

        int conId = this.id.incrementAndGet();
        return new SupersqlConnection(conId);
    }

    @Override
    public SupersqlStatement createStatement(SupersqlConnection connection) throws TException {

        ConnectionInfo connectionInfo = id2Links.get(connection.getId());
        connectionInfo.createStatement();
//        logger.info("Current link " + currentLinkName + " created a statement");

        return new SupersqlStatement(connection.getId(), null, 0);
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
    public boolean statement_executeupdate(SupersqlStatement statement, String sql) throws SupersqlException, TException {

        Statement driverStatement = id2Links.get(statement.getId()).getStatement();
        if(driverStatement == null){


        }
        String driverSql = parseSql(sql);
        try {
            driverStatement.executeUpdate(driverSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    private String parseSql(String sql){

        String optionsStr = sql.substring(sql.indexOf("ssoptions")+10, sql.length());
        optionsStr = optionsStr.substring(0,optionsStr.length()-1);
        System.out.println(optionsStr);
        String options[] = optionsStr.split(",");
        Map<String,String> optionsMap = new HashMap<>();
        for (int i = 0; i < options.length; i++) {

            String option[] = options[i].trim().split(" ");
            optionsMap.put(option[0].trim(), option[1].trim());
        }
        Map<String, String> ssOptions = new HashMap<>();
        if(optionsMap.get(SupersqlOptionKey.MODEL).equalsIgnoreCase("")
                && optionsMap.get(SupersqlOptionKey.REALTIME).equalsIgnoreCase("true")) {

            ssOptions.put(SupersqlOptionKey.DRIVER_NAME, SupersqlOptionValue.hive);
            ssOptions.put(SupersqlOptionKey.DATABASE, "default");
        }

        return null;
    }

    @Override
    public SupersqlResultSet statement_executeQuery(SupersqlStatement statement, String sql) throws SupersqlException, TException {

        ResultSet resultSet = null;
        try {
            Statement driverStatement = id2Links.get(statement.getId()).getStatement();
            resultSet = driverStatement.executeQuery(sql);
            if(resultSet != null){

                logger.info("Current link " + currentLinkName + " got resultset");
            }
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
