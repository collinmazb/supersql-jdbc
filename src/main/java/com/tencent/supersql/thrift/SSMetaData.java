package com.tencent.supersql.thrift;

import org.apache.commons.collections.map.HashedMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by waixingren on 3/7/17.
 */
public class SSMetaData {


    static class DriverInfo{

        private String driverName;
        private String driverDB;
        private String driverTableName;

        public DriverInfo(String driverName, String driverDB, String driverTableName) {
            this.driverName = driverName;
            this.driverDB = driverDB;
            this.driverTableName = driverTableName;
        }
    }

    private static Map<String, List<DriverInfo>> driverInfoMap = new HashedMap();
    public static void initSSMetaData(){

        String superSqlDefault = "Default";
        List<DriverInfo> driverInfos = new ArrayList<>();
        driverInfoMap.put(superSqlDefault, driverInfos);
    }

    public static void updateSSMetaData(String driverName, String database, String tableName){

        List<DriverInfo> driverInfos = driverInfoMap.get(driverName);
        driverInfos.add(new DriverInfo(driverName,database,tableName));
    }
}
