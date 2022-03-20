package com.shubao.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateTypeHandler extends BaseTypeHandler<Date> {

    /**
     * 将Java类型转换成数据库需要的类型
     * @param ps
     * @param i
     * @param parameter
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        long time = parameter.getTime();
        ps.setLong(i, time);
    }

    /**
     * 将数据中类型转换为Java类型
     * @param rs 查询出的结果集
     * @param columnName 要转换的字段名称
     * @return
     * @throws SQLException
     */
    @Override
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        //获得结果集中的数据，将需要转换的数据(long)转换成Date类型，返回
        long aLong = rs.getLong(columnName);
        Date date = new Date(aLong);
        return date;
    }

    /**
     * 将数据库中的类型，转换成Java类型
     * @param rs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        //获得结果集中的数据，将需要转换的数据(long)转换成Date类型，返回
        long aLong = rs.getLong(columnIndex);
        Date date = new Date(aLong);
        return date;
    }

    /**
     * 将数据库中的类型，转换成Java类型
     * @param cs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        long aLong = cs.getLong(columnIndex);
        Date date = new Date(aLong);
        return date;
    }
}
