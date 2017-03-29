package com.tencent.supersql.thrift;

import com.facebook.presto.jdbc.PrestoConnection;
import org.apache.commons.collections.map.HashedMap;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by waixingren on 3/7/17.
 */
public class SSMetaData {

    //    public static List<String> supportedDrivers = Arrays.asList("sparksql", "hive", "presto","impala","phoeinx");
    public static List<String> supportedDrivers = Arrays.asList("hive");

    private static Map<String, List<DriverInfo>> db2DriverInfoMap = new HashedMap();

    public static Map<String, List<DriverInfo>> getDb2DriverInfoMap() {
        return db2DriverInfoMap;
    }

    static public class DriverInfo {

        private String driverName;
        private String driverDB;
        private String driverTableName;

        public void setDriverUrl(String driverUrl) {
            this.driverUrl = driverUrl;
        }

        private String driverUrl;

        public DriverInfo(String driverName, String driverDB, String driverTableName) {
            this.driverName = driverName;
            this.driverDB = driverDB;
            this.driverTableName = driverTableName;
        }

        public DriverInfo(String driverName, String driverDB, String driverTableName, String driverUrl) {
            this(driverName, driverDB, driverTableName);
            this.driverUrl = driverUrl;
        }

        public String getDriverName() {
            return driverName;
        }

        public String getDriverDB() {
            return driverDB;
        }

        public String getDriverTableName() {
            return driverTableName;
        }

        public String getDriverUrl() {
            return driverUrl;
        }
    }

    public static String getDriverName(String database, String tableName) {

        List<DriverInfo> driverInfos = db2DriverInfoMap.get(database);
        String driverName = null;
        for (DriverInfo driverInfo : driverInfos) {

            String driverTableName = driverInfo.getDriverTableName();
            String driverDatabase = driverInfo.getDriverDB();
            if (driverTableName.equalsIgnoreCase(tableName)) {

                if (driverDatabase.equalsIgnoreCase(database)) {

                    driverName = driverInfo.getDriverName();
                    return driverName;
                }
            }
        }
        return null;
    }

    public static void initSSMetaData() {

        for (String driver : Config.drivers.keySet()) {

            Connection con = ConnectionPool.getConnection(driver);
            String connectionUrl = ConnectionPool.getConnectionUrl(driver);
            if (con == null) {

                continue;
            }
            try {
                Statement statement = con.createStatement();
                String showDBStr = con instanceof PrestoConnection ? "show schemas" : "show databases";
                ResultSet dbresultSet = statement.executeQuery(showDBStr);
                while (dbresultSet.next()) {

                    String databaseName = dbresultSet.getString(1);
                    if (databaseName.isEmpty()) {

                        continue;
                    }
                    con.setSchema(databaseName);
                    Statement tbstatement = con.createStatement();
                    ResultSet tableResultSet = tbstatement.executeQuery("show tables");
                    tableResultSet.next();
                    if (db2DriverInfoMap.containsKey(databaseName)) {

                        List<DriverInfo> driverInfos = db2DriverInfoMap.get(databaseName);
                        fillMap(driverInfos, tableResultSet, driver, databaseName, connectionUrl);
                        db2DriverInfoMap.put(databaseName, driverInfos);
                    } else {

                        List<DriverInfo> driverInfos = new ArrayList<>();
                        fillMap(driverInfos, tableResultSet, driver, databaseName, connectionUrl);
                        db2DriverInfoMap.put(databaseName, driverInfos);
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void fillMap(List<DriverInfo> driverInfos, ResultSet tableResultSet, String driver, String databaseName, String connectionUrl) throws SQLException {

        while (tableResultSet.next()) {

            if (driverInfos == null) {

                driverInfos = new ArrayList<>();
            }
            driverInfos.add(new DriverInfo(driver, databaseName, tableResultSet.getString(1), connectionUrl));
        }
    }

    public static void updateSSMetaData(String driverName, String database, String tableName, String url) {

        List<DriverInfo> driverInfos = db2DriverInfoMap.get(database);
        if (driverInfos == null) {

            driverInfos = new ArrayList<>();
        }
        driverInfos.add(new DriverInfo(driverName, database, tableName, url));
        db2DriverInfoMap.put(database, driverInfos);
    }
}
