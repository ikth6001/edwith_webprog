package com.ikth.apps.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ikth.apps.todo.dto.TodoDto;

public class TodoDao 
{
	private final String DRIVER_CLASS_NAME= "com.mysql.cj.jdbc.Driver";
	private final String DATABASE_URL= "jdbc:mysql://localhost/todo?characterEncoding=UTF-8&serverTimezone=UTC";
	private final String USER_ID= "todoMgr";
	private final String USER_PW= "todoMgr";
	
	private final String SELECT_ALL= 
			"SELECT ID, TITLE, NAME, SEQUENCE, TYPE, REGDATE"
			+ " FROM TODO"
			+ " ORDER BY REGDATE DESC";
	
	private final String SELECT_ONE=
			"SELECT ID, TITLE, NAME, SEQUENCE, TYPE, REGDATE"
			+ " FROM TODO"
			+ " WHERE ID = ?";
	
	private final String UPDATE_STATUS=
			"UPDATE TODO"
			+ " SET TYPE = ?"
			+ " WHERE ID = ?";
	
	private final String INSERT_TASK=
			"INSERT INTO TODO"
			+ " (TITLE, NAME, SEQUENCE)"
			+ " VALUES(?, ?, 1)";
	
	private Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
		Class.forName(DRIVER_CLASS_NAME).newInstance();
		return DriverManager.getConnection(DATABASE_URL, USER_ID, USER_PW);
	}
	
	public int updateTaskType(String id, String type) throws Exception
	{
		try(Connection conn= getConnection();
				PreparedStatement pstmt= conn.prepareStatement(UPDATE_STATUS))
		{
			pstmt.setString(1, type);
			pstmt.setString(2, id);
			
			return pstmt.executeUpdate();
		}
	}
	
	public TodoDto selectOne(String id) throws Exception
	{
		ResultSet rs= null;
		
		try(Connection conn= getConnection();
				PreparedStatement pstmt= conn.prepareStatement(SELECT_ONE))
		{
			pstmt.setString(1, id);
			rs= pstmt.executeQuery();
			
			while(rs.next())
			{
				TodoDto task= new TodoDto();
				task.setId(rs.getInt("ID"));
				task.setTitle(rs.getString("TITLE"));
				task.setName(rs.getString("NAME"));
				task.setSequence(rs.getInt("SEQUENCE"));
				task.setType(rs.getString("TYPE"));
				task.setRegDate(rs.getString("REGDATE"));
				
				return task;
			}
			
			return null;
		}
		finally 
		{
			if(rs != null) try { rs.close(); } catch(Exception e) { }
		}
	}

	public List<TodoDto> selectAll() throws Exception
	{
		try(Connection conn= getConnection();
				PreparedStatement pstmt= conn.prepareStatement(SELECT_ALL);
				ResultSet rs= pstmt.executeQuery())
		{
			List<TodoDto> tasks= new ArrayList<>();
			
			while(rs.next())
			{
				TodoDto task= new TodoDto();
				task.setId(rs.getInt("ID"));
				task.setTitle(rs.getString("TITLE"));
				task.setName(rs.getString("NAME"));
				task.setSequence(rs.getInt("SEQUENCE"));
				task.setType(rs.getString("TYPE"));
				task.setRegDate(rs.getString("REGDATE"));
				
				tasks.add(task);
			}
			
			return tasks;
		}
	}
	
	public int insertTask(String name, String title) throws Exception
	{
		try(Connection conn= getConnection();
				PreparedStatement pstmt= conn.prepareStatement(INSERT_TASK))
		{
			pstmt.setString(1, title);
			pstmt.setString(2, name);
			
			return pstmt.executeUpdate();
		}
	}
}
