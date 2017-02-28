package com.tencent.supersql.jdbc;

import java.sql.Connection;

/**
 * Created by waixingren on 2/23/17.
 */
public class LinkInfo {

    LinkInfo(){

    }

    private String linkName;
    private Connection con;
    private String dirverUrl;

    public LinkInfo(String linkName, String driverJdbcUrl, Connection link) {

        this.linkName = linkName;
        this.dirverUrl = driverJdbcUrl;
        this.con = link;
    }

    public String getLinkName() {
        return linkName;
    }

    public Connection getCon() {
        return con;
    }

    public String getDirverUrl() {
        return dirverUrl;
    }

}
