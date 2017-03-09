package com.tencent.supersql.thrift;

import org.apache.commons.collections.map.HashedMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by waixingren on 3/7/17.
 */
public class SSMetaData {


    private static Map<String, List<DriverInfo>> db2DriverInfoMap = new HashedMap();

    public static Map<String, List<DriverInfo>> getDb2DriverInfoMap() {
        return db2DriverInfoMap;
    }

    static public class DriverInfo{

        private String driverName;
        private String driverDB;
        private String driverTableName;

        public DriverInfo(String driverName, String driverDB, String driverTableName) {
            this.driverName = driverName;
            this.driverDB = driverDB;
            this.driverTableName = driverTableName;
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

    }

    public static String getDriverName(String database, String tableName){

        List<DriverInfo> driverInfos = db2DriverInfoMap.get(database);
        String driverName = null;
        for(DriverInfo driverInfo : driverInfos){

            String driverTableName = driverInfo.getDriverTableName();
            String driverDatabase = driverInfo.getDriverDB();
            if(driverTableName.equalsIgnoreCase(tableName) && driverDatabase.equalsIgnoreCase(database)){

                driverName =  driverInfo.getDriverName();
                return driverName;
            }
        }
        return null;
    }

    public static void initSSMetaData(){

        String superSqlDefault = "default";
        List<DriverInfo> driverInfos = new ArrayList<>();
        driverInfos.add(new DriverInfo("presto", "default", "tb11"));
        driverInfos.add(new DriverInfo("presto", "default", "tb12"));

        db2DriverInfoMap.put(superSqlDefault, driverInfos);

//        updateSSMetaData("sparksql", superSqlDefault, "nation");
        updateSSMetaData("sparksql", superSqlDefault, "region");
        updateSSMetaData("hive", superSqlDefault, "orders");
        updateSSMetaData("hive", superSqlDefault, "lineitems");

    }

    public static void updateSSMetaData(String driverName, String database, String tableName){

        List<DriverInfo> driverInfos = db2DriverInfoMap.get(database);
        if(driverInfos == null){

            driverInfos = new ArrayList<>();
        }
        driverInfos.add(new DriverInfo(driverName,database,tableName));
        db2DriverInfoMap.put(database, driverInfos);
    }
}
