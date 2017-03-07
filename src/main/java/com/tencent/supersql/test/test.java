package com.tencent.supersql.test;

import com.tencent.supersql.jdbc.ParseUtil;

/**
 * Created by waixingren on 3/7/17.
 */
public class test {

    public static void main(String[] args) {

//        String sql = "creat table db1.user(id int, name string)";
        String sql = "select * from db1.nation where nationkey>100";
        String str[] = ParseUtil.getDbAndTable(sql);

    }
}
