package com.tencent;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;
import java.net.*;

import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * Created by waixingren on 2/21/17.
 */



public class UaeDriver implements Driver{


    static final int VERSION_MAJOR = 1;
    static final int VERSION_MINOR = 0;

    static final int JDBC_VERSION_MAJOR = 4;
    static final int JDBC_VERSION_MINOR = 1;

    static final String DRIVER_NAME = "Presto JDBC Driver";
    static final String DRIVER_VERSION = VERSION_MAJOR + "." + VERSION_MINOR;

    private static final DriverPropertyInfo[] DRIVER_PROPERTY_INFOS = {};

    private static final String JDBC_URL_START = "jdbc:";
    private static final String DRIVER_URL_START = "jdbc:presto:";

    private static final String USER_PROPERTY = "user";

    public UaeDriver(){

        //TODO
    }

    static {
        try {
            DriverManager.registerDriver(new UaeDriver());
        }
        catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {

//        if (!acceptsURL(url)) {
        if(false){
            return null;
        }
        return new UaeConnection();
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return true;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 0;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }


    private static URI parseDriverUrl(String url)
            throws SQLException
    {
        URI uri;
        try {
            uri = new URI(url.substring(JDBC_URL_START.length()));
        }
        catch (URISyntaxException e) {
            throw new SQLException("Invalid JDBC URL: " + url, e);
        }
        if (isNullOrEmpty(uri.getHost())) {
            throw new SQLException("No host specified: " + url);
        }
        if (uri.getPort() == -1) {
            throw new SQLException("No port number specified: " + url);
        }
        if ((uri.getPort() < 1) || (uri.getPort() > 65535)) {
            throw new SQLException("Invalid port number: " + url);
        }
        return uri;
    }
}
