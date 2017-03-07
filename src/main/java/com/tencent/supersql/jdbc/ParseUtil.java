package com.tencent.supersql.jdbc;

/**
 * Created by waixingren on 3/7/17.
 */
public class ParseUtil {

    public static String[] getDbAndTable(String sql){

        if(sql.startsWith("create")){

            String s = sql;
            String postcreatetable = s.substring(s.indexOf(" table ")+7, s.length()).trim();
            String tableName = postcreatetable.substring(0,postcreatetable.indexOf("("));
            String str[] = tableName.split("\\.");
            return str;
        }else if(sql.startsWith("select")){

            String s = "select * from db1.nation where nationkey>10";
            String postfrom = s.substring(s.indexOf("from") + 4, s.length()).trim();
            String dbtable = postfrom.substring(0, postfrom.indexOf(" "));
            String str[] = dbtable.split("\\.");
            return str;
        }else{

            return null;
        }

    }
}
