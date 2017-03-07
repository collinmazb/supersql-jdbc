package com.tencent.supersql.jdbc;


import com.tencent.supersql.gen.SupersqlConnection;
import com.tencent.supersql.gen.SupersqlStatement;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.sql.*;
import java.util.*;
import java.util.concurrent.Executor;
import java.net.*;
import com.tencent.supersql.gen.SupersqlConnectionService;

/**
 * Created by waixingren on 2/21/17.
 */



public class SSqlConnection implements Connection{

    private Connection currentLink = null;
    private String currentLinkName = null;
    private Map<String, LinkInfo> allLinks = new HashMap<String, LinkInfo>(10);
    private SupersqlConnectionService.Client client = null;
    private Conid2CurrentLink conid2CurrentLink = null;

    class Conid2CurrentLink{

        public void setId(int id) {
            this.id = id;
        }

        public void setCurrentLink(String currentLink) {
            this.currentLink = currentLink;
        }

        public String getCurrentLink() {
            return currentLink;
        }

        public int getId() {
            return id;
        }

        private int id;
        private String currentLink;
        public Conid2CurrentLink(int id, String currentLink){

            this.id = id;
            this.currentLink = currentLink;
        }

    }

    public SSqlConnection(URI uri){

    }


    public SSqlConnection(String url){

        try {

            String databaseName = url.substring(url.lastIndexOf("/")+1, url.length());
            TTransport transport = new TSocket("localhost", 7911);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
           client = new SupersqlConnectionService.Client(protocol);
           SupersqlConnection supersqlConnection = client.createConnection(databaseName,null);
           conid2CurrentLink = new Conid2CurrentLink(supersqlConnection.getId(), null);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllLinks(){

        List<String> links = null;
        try {
            links = client.showLinks(conid2CurrentLink.getId());
        } catch (TException e) {
            e.printStackTrace();
        }
        return links;
    }

    public Connection createLink(String driverJdbcUrl, String linkName, String user, String pwd){

        try {
            client.createLink(conid2CurrentLink.getId(), driverJdbcUrl,linkName, user,pwd);
        } catch (TException e) {
            e.printStackTrace();
        }
        return null;
    }

    //overrides
    public Statement createStatement() throws SQLException {


        SupersqlStatement supersqlStatement = null;
        try {
            SupersqlConnection supersqlConnection = new SupersqlConnection(conid2CurrentLink.getId());
            supersqlStatement = client.createStatement(supersqlConnection);
            System.out.println(supersqlStatement.getId() + " " + supersqlStatement.getSql());
        } catch (TException e) {
            e.printStackTrace();
        }
        return new SSqlStatement(this.client, supersqlStatement);
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return null;
    }

    public CallableStatement prepareCall(String sql) throws SQLException {
        return null;
    }

    public String nativeSQL(String sql) throws SQLException {
        return null;
    }

    public void setAutoCommit(boolean autoCommit) throws SQLException {

    }

    public boolean getAutoCommit() throws SQLException {
        return false;
    }

    public void commit() throws SQLException {

    }

    public void rollback() throws SQLException {

    }

    public void close() throws SQLException {

    }

    public boolean isClosed() throws SQLException {
        return false;
    }

    public DatabaseMetaData getMetaData() throws SQLException {
        return null;
    }

    public void setReadOnly(boolean readOnly) throws SQLException {

    }

    public boolean isReadOnly() throws SQLException {
        return false;
    }

    public void setCatalog(String catalog) throws SQLException {

    }

    public String getCatalog() throws SQLException {
        return null;
    }

    public void setTransactionIsolation(int level) throws SQLException {

    }

    public int getTransactionIsolation() throws SQLException {
        return 0;
    }

    public SQLWarning getWarnings() throws SQLException {
        return null;
    }

    public void clearWarnings() throws SQLException {

    }

    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return null;
    }

    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return null;
    }

    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return null;
    }

    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return null;
    }

    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {

    }

    public void setHoldability(int holdability) throws SQLException {

    }

    public int getHoldability() throws SQLException {
        return 0;
    }

    public Savepoint setSavepoint() throws SQLException {
        return null;
    }

    public Savepoint setSavepoint(String name) throws SQLException {
        return null;
    }

    public void rollback(Savepoint savepoint) throws SQLException {

    }

    public void releaseSavepoint(Savepoint savepoint) throws SQLException {

    }

    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return null;
    }

    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return null;
    }

    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return null;
    }

    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return null;
    }

    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return null;
    }

    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return null;
    }

    public Clob createClob() throws SQLException {
        return null;
    }

    public Blob createBlob() throws SQLException {
        return null;
    }


    public NClob createNClob() throws SQLException {
//        return null;

        throw new SQLFeatureNotSupportedException("createNClob");
    }


    public SQLXML createSQLXML() throws SQLException {
        return null;
    }

    public boolean isValid(int timeout) throws SQLException {
        return false;
    }

    public void setClientInfo(String name, String value) throws SQLClientInfoException {

    }

    public void setClientInfo(Properties properties) throws SQLClientInfoException {

    }

    public String getClientInfo(String name) throws SQLException {
        return null;
    }

    public Properties getClientInfo() throws SQLException {
        return null;
    }

    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return null;
    }

    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return null;
    }

    public void setSchema(String schema) throws SQLException {

    }

    public String getSchema() throws SQLException {
        return null;
    }

    public void abort(Executor executor) throws SQLException {

    }

    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {

    }

    public int getNetworkTimeout() throws SQLException {
        return 0;
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    public String usingLink(String usingLinkStr) {

        String currentLinkName = null;
        try {
            currentLinkName = client.useLink(this.conid2CurrentLink.getId(),usingLinkStr);
        } catch (TException e) {
            e.printStackTrace();
        }
        return currentLinkName;
    }

    public Connection getCurrentLink() {
        return currentLink;
    }


    public String getCurrentLinkName(){

        return currentLinkName;
    }
}
