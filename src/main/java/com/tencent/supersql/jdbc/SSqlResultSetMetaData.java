package com.tencent.supersql.jdbc;

import com.tencent.supersql.gen.SupersqlResultSetMetaData;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by waixingren on 2/28/17.
 */
public class SSqlResultSetMetaData implements ResultSetMetaData {

    private SupersqlResultSetMetaData metadata;

    public SSqlResultSetMetaData(SupersqlResultSetMetaData supersqlResultSetMetaData){

        this.metadata = supersqlResultSetMetaData;
    }


    public int findColumn(String columnLabel) {
        // Check columnLabel
        for (int i=0; i < this.metadata.parts.size(); i++)
        {
            if (columnLabel.equals(this.metadata.parts.get(i).columnLabel)) {
                return i+1;
            }
        }
        // Check columnName
        for (int i=0; i < this.metadata.parts.size(); i++)
        {
            if (columnLabel.equals(this.metadata.parts.get(i).columnName)) {
                return i+1;
            }
        }
        return -1;
    }

    @Override
    public int getColumnCount() throws SQLException {
        return this.metadata.parts.size();
    }

    @Override
    public boolean isAutoIncrement(int column) throws SQLException {
        return this.metadata.parts.get(column - 1).autoIncrement;
    }

    @Override
    public boolean isCaseSensitive(int column) throws SQLException {
        return this.metadata.parts.get(column - 1).caseSensitive;
    }

    @Override
    public boolean isSearchable(int column) throws SQLException {
        return this.metadata.parts.get(column - 1).searchable;
    }

    @Override
    public boolean isCurrency(int column) throws SQLException {
        return this.metadata.parts.get(column - 1).currency;
    }

    @Override
    public int isNullable(int column) throws SQLException {
        return this.metadata.parts.get(column - 1).nullable;
    }

    @Override
    public boolean isSigned(int column) throws SQLException {

        return this.metadata.parts.get(column - 1).signed;
    }

    @Override
    public int getColumnDisplaySize(int column) throws SQLException {
        return this.metadata.parts.get(column - 1).columnDisplaySize;
    }

    @Override
    public String getColumnLabel(int column) throws SQLException {

        return this.metadata.parts.get(column - 1).columnLabel;
    }

    @Override
    public String getColumnName(int column) throws SQLException {
        return this.metadata.parts.get(column - 1).columnName;
    }

    @Override
    public String getSchemaName(int column) throws SQLException {
        return this.metadata.parts.get(column - 1).schemaName;
    }

    @Override
    public int getPrecision(int column) throws SQLException {

        return this.metadata.parts.get(column - 1).precision;
    }

    @Override
    public int getScale(int column) throws SQLException {

        return this.metadata.parts.get(column - 1).scale;
    }

    @Override
    public String getTableName(int column) throws SQLException {
        return this.metadata.parts.get(column - 1).tableName;
    }

    @Override
    public String getCatalogName(int column) throws SQLException {

        return this.metadata.parts.get(column - 1).catalogName;
    }

    @Override
    public int getColumnType(int column) throws SQLException {
        return this.metadata.parts.get(column - 1).columnType;
    }

    @Override
    public String getColumnTypeName(int column) throws SQLException {
        return this.metadata.parts.get(column - 1).columnTypeName;
    }

    @Override
    public boolean isReadOnly(int column) throws SQLException {
        return this.metadata.parts.get(column - 1).readOnly;
    }

    @Override
    public boolean isWritable(int column) throws SQLException {
        return this.metadata.parts.get(column - 1).writable;
    }

    @Override
    public boolean isDefinitelyWritable(int column) throws SQLException {
        return this.metadata.parts.get(column - 1).definitelyWritable;
    }

    @Override
    public String getColumnClassName(int column) throws SQLException {

        return this.metadata.parts.get(column - 1).columnClassName;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
