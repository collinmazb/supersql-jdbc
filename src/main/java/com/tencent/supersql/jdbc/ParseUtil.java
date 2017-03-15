package com.tencent.supersql.jdbc;

import com.tencent.supersql.thrift.SSMetaData;

/**
 * Created by waixingren on 3/7/17.
 */
public class ParseUtil {

    public static String[] getDbAndTable(String sql1){


        String sql2 = sql1.toLowerCase();
        if(sql2.toLowerCase().startsWith("create")){

            String s = sql2;
            String postcreatetable = s.substring(s.indexOf(" table ")+7, s.length()).trim();
            String tableName = postcreatetable.substring(0,postcreatetable.indexOf("("));
            String str[] = tableName.split("\\.");
            return str;
        }else if(sql2.toLowerCase().startsWith("select")){

            String s = sql2;
            String postfrom = s.substring(s.indexOf("from") + 4, s.length()).trim();
            String dbtable = postfrom;
            String str[] = dbtable.split("\\.");
            return str;
        }else if(sql2.startsWith("desc") || sql2.startsWith("describe")){

            String postdesc = sql2.substring(sql2.indexOf(" "), sql2.length()).trim();
            String str[] = postdesc.split("\\.");
            return str;
        }else if(sql2.startsWith("show partitions")){

            String postPartitions = sql2.substring(sql2.indexOf("show partitions")+15, sql2.length()).trim();
            int spaceIdx = postPartitions.indexOf(" ");
            String dbtbStr = null;
            if(spaceIdx == -1){

                dbtbStr = postPartitions;
            }else{

                dbtbStr = postPartitions.substring(postPartitions.indexOf(" "));
            }
            String dbtb[] = dbtbStr.split("\\.");
            return dbtb;
        }
        return null;

    }

    public  static String getDriverName(String sql){

        int driverIdx = sql.indexOf(" driver ");
        String driverName = sql.substring(driverIdx + 8, sql.length()).trim();
        if(SSMetaData.supportedDrivers.contains(driverName)){

            return driverName;
        }
        return null;
    }
}
