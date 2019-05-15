package com.ikth.apps.reservation.typehandle;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.util.Date;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class CustomOffSetDateHandler extends BaseTypeHandler<OffsetDateTime>
{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, OffsetDateTime parameter, JdbcType jdbcType) throws SQLException 
	{
		ps.setTimestamp(i, new Timestamp(parameter.get(ChronoField.DAY_OF_YEAR)));
	}

	@Override
	public OffsetDateTime getNullableResult(ResultSet rs, String columnName) throws SQLException 
	{
		Timestamp timestamp= rs.getTimestamp(columnName);
		long time= timestamp.getTime();
		return new Date(time).toInstant().atOffset(ZoneOffset.UTC);
	}

	@Override
	public OffsetDateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException 
	{
		Timestamp timestamp= rs.getTimestamp(columnIndex);
		long time= timestamp.getTime();
		return new Date(time).toInstant().atOffset(ZoneOffset.UTC);
	}

	@Override
	public OffsetDateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException 
	{
		Timestamp timestamp= cs.getTimestamp(columnIndex);
		long time= timestamp.getTime();
		return new Date(time).toInstant().atOffset(ZoneOffset.UTC);
	}

}
