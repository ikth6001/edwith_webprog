package com.ikth.apps.reservation.typehandle;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.ikth.apps.reservation.dto.ProductImage.TypeEnum;

public class CustomEnumTypeHandler extends BaseTypeHandler<TypeEnum>
{

	@Override
	public void setParameter(PreparedStatement ps, int i, TypeEnum parameter, JdbcType jdbcType) throws SQLException 
	{
		ps.setString(i, parameter.getValue());
	}

	@Override
	public TypeEnum getResult(ResultSet rs, String columnName) throws SQLException 
	{
		String value= rs.getString(columnName);
		return TypeEnum.fromValue(value);
	}

	@Override
	public TypeEnum getResult(ResultSet rs, int columnIndex) throws SQLException 
	{
		String value= rs.getString(columnIndex);
		return TypeEnum.fromValue(value);
	}

	@Override
	public TypeEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
		String value= cs.getString(columnIndex);
		return TypeEnum.fromValue(value);
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, TypeEnum parameter, JdbcType jdbcType)
			throws SQLException 
	{
		ps.setString(i, parameter.getValue());
	}

	@Override
	public TypeEnum getNullableResult(ResultSet rs, String columnName) throws SQLException 
	{
		return TypeEnum.fromValue(rs.getString(columnName));
	}

	@Override
	public TypeEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException 
	{
		return TypeEnum.fromValue(rs.getString(columnIndex));
	}

	@Override
	public TypeEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException 
	{
		return TypeEnum.fromValue(cs.getString(columnIndex));
	}

}
