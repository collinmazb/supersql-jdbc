package com.tencent.supersql.jdbc;

/**
 * Created by waixingren on 2/27/17.
 */

import com.facebook.presto.jdbc.PrestoConnection;
import com.facebook.presto.jdbc.PrestoStatement;
import com.tencent.supersql.gen.*;
import com.tencent.supersql.thrift.ConnectionPool;
import com.tencent.supersql.thrift.SSMetaData;
import org.apache.thrift.TException;

import java.sql.*;
import java.util.*;

import org.apache.log4j.Logger;

import javax.swing.plaf.nimbus.State;
import java.util.concurrent.atomic.AtomicInteger;

public  class SSqlSerivceImpl implements SupersqlConnectionService.Iface{


    Logger logger  =  Logger.getLogger(SSqlSerivceImpl.class);
    private Map<String, Connection> allLinks = new HashMap<String, Connection>();
    private Connection currentLink;
    private Map<Integer, String> conid2Db = new HashMap<>();
    private Map<Integer, ConnectionInfo> id2Links = new HashMap<>();
    private String currentLinkName;
    private Statement currentStatement;
    private AtomicInteger id = new AtomicInteger(0);

    static class SupersqlOptionKey{

        public static String model;
        public static String realtime;
        public static String transaction;

        public static String DRIVER_NAME = "drivername";
        public static String DATABASE;
    }

    static class SupersqlOptionValue{

        public static String hive = "hive";
        public static String presto  = "presto";
        public static String sparksql = "sparksql";

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

    class ParsedDriverSql{

        public String getDriverName() {
            return driverName;
        }

        public String getParsedDriverSql() {
            return parsedDriverSql;
        }

        private String driverName;
        private String parsedDriverSql;

        public ParsedDriverSql(String driverName, String parsedDriverSql) {
            this.driverName = driverName;
            this.parsedDriverSql = parsedDriverSql;
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
    public SupersqlConnection createConnection(String database, Map<String, String> properties) throws TException {

        //TODO synchronized
        int conId = this.id.incrementAndGet();
        conid2Db.put(new Integer(conId), database);
        return new SupersqlConnection(conId);
    }

    @Override
    public SupersqlStatement createStatement(SupersqlConnection connection) throws TException {

//        ConnectionInfo connectionInfo = id2Links.get(connection.getId());
//        connectionInfo.createStatement();

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

        if(sql.startsWith("use")){

            String database = sql.split(" ")[1];
            conid2Db.put(statement.getId(), database);
        }
        return true;
    }

    @Override
    public boolean statement_executeupdate(SupersqlStatement statement, String sql) throws SupersqlException, TException {

        boolean flag = isDDL(sql);
        if(!flag) return false;

        ParsedDriverSql driverSql = parseSql(statement, sql);
        try {
            Statement driverStatement = ConnectionPool.getConnection(driverSql.getDriverName()).createStatement();
            int r = driverStatement.executeUpdate(driverSql.getParsedDriverSql());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    private boolean isDDL(String sql) {

        sql = sql.toLowerCase();
        if(sql.startsWith("create")){

            String sub = sql.trim().substring(6, sql.length()).trim();
            if(sub.startsWith("database")){

                return false;
//                throw new SupersqlException("create database not supported", "hahaha", -1);
            }else if(sub.startsWith("table") || sub.startsWith("external")){

                return true;
            }
        }else if(sql.startsWith("drop")){

            String sub = sql.trim().substring(4, sql.length()).trim();
            if(sub.startsWith("database")){


                return false;
            }else if(sub.startsWith("table")){

                return true;
            }
        }else{

            return false;
        }

        return false;
    }

//    private ParsedDriverSql parseSql(SupersqlStatement statement,String sql){
//
//        String str[] = ParseUtil.getDbAndTable(sql);
//        String database = str.length==2 ? str[0] : conid2Db.get(statement.getId());
//        String table = str.length==2 ? str[1] : str[0];
//
//        StringBuffer driversql = new StringBuffer(sql.substring(0,sql.indexOf("ssoptions")));
//        String optionsStr = sql.substring(sql.indexOf("ssoptions")+10, sql.length());
//
//        optionsStr = optionsStr.substring(0,optionsStr.length()-1);
//        System.out.println(optionsStr);
//        String options[] = optionsStr.split(",");
//        Map<String,String> optionsMap = new HashMap<>();
//        for (int i = 0; i < options.length; i++) {
//
//            String option[] = options[i].trim().split(" ");
//            optionsMap.put(option[0].trim(), option[1].trim());
//        }
//        Map<String, String> ssOptions = new HashMap<>();
//        if(optionsMap.containsKey("driver")){
//            if(optionsMap.get("driver").equalsIgnoreCase("presto")){
//
//                SSMetaData.updateSSMetaData("presto", database,table.trim(), "");
//                return new ParsedDriverSql("presto", driversql.toString());
//            }
//        }else if(optionsMap.containsKey("transaction")){
//
//            if(optionsMap.get("transaction").equalsIgnoreCase("true")) {
//
//                ssOptions.put(SupersqlOptionKey.DRIVER_NAME, SupersqlOptionValue.hive);
//                driversql.append("STORED AS ORC");
//                SSMetaData.updateSSMetaData(ssOptions.get(SupersqlOptionKey.DRIVER_NAME),database,table, "");
//                return new ParsedDriverSql(ssOptions.get(SupersqlOptionKey.DRIVER_NAME), driversql.toString());
//            }
//        }
//        return null;
//    }

    private ParsedDriverSql parseSql(SupersqlStatement supersqlStatement, String sql){

        sql = sql.toLowerCase().trim();
        String dbtb[] = ParseUtil.getDbAndTable(sql);
        String database = dbtb.length==2 ? dbtb[0] : conid2Db.get(supersqlStatement.getId());
        String table = dbtb.length==2 ? dbtb[1] : dbtb[0];

        int idx = sql.indexOf(" driver ");
        String preDriver = sql.substring(0,idx);
        if(idx != -1){

            String driverName = ParseUtil.getDriverName(sql);
            if(driverName != null){

                SSMetaData.updateSSMetaData(driverName,database,table, "");
                return new ParsedDriverSql(driverName, preDriver);
            }
        }else{

            return null;
        }
        return null;
    }


    @Override
    public SupersqlResultSet statement_executeQuery(SupersqlStatement statement, String sql) throws SupersqlException, TException {

        ResultSet resultSet = null;

        if(sql.startsWith("show")){

            String database = conid2Db.get(statement.getId());
            return processShow(database, sql);
        }else if(sql.startsWith("desc") || sql.startsWith("describe")){

            return processDesc(conid2Db,statement,sql);
        }

        try {

            String str[] = ParseUtil.getDbAndTable(sql);
            String database = str.length==2 ? str[0] : conid2Db.get(statement.getId());
            String table = str.length==2 ? str[1] : str[0];
            Connection connection = ConnectionPool.getConnection(SSMetaData.getDriverName(database, table));
            if(connection instanceof PrestoConnection){

                connection.setSchema(database);
            }
            Statement driverStatement = connection.createStatement();
            resultSet = driverStatement.executeQuery(sql);
            if(resultSet != null){

                logger.info("Current link " + currentLinkName + " got resultset");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ResultSetUtil.convertResultSet(resultSet);
    }

    private static SupersqlResultSet processShow(String database, String sql) {

        if(sql.equalsIgnoreCase("show databases")){

            Set<String> dbs = SSMetaData.getDb2DriverInfoMap().keySet();
            return ResultSetUtil.convertDB(dbs);
        }else if(sql.equalsIgnoreCase("show tables")){

            List<SSMetaData.DriverInfo> driverInfos = SSMetaData.getDb2DriverInfoMap().get(database);
            return ResultSetUtil.convertTable(driverInfos);
        }
        return null;
    }

    private static SupersqlResultSet processDesc(Map<Integer, String> conid2Db, SupersqlStatement statement, String sql){


        String dbtb[] = ParseUtil.getDbAndTable(sql);
        String database = dbtb.length==2 ? dbtb[0] : conid2Db.get(statement.getId());
        String table = dbtb.length==2 ? dbtb[1] : dbtb[0];

        Connection connection = ConnectionPool.getConnection(SSMetaData.getDriverName(database, table));
        ResultSet resultSet = null;
        try {
            Statement driverStatement = connection.createStatement();
            resultSet = driverStatement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResultSetUtil.convertResultSet(resultSet);
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
