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
	
	private Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
		Class.forName(DRIVER_CLASS_NAME).newInstance();
		return DriverManager.getConnection(DATABASE_URL, USER_ID, USER_PW);
	}

	public List<TodoDto> selectAll() throws Exception
	{
		Connection conn= getConnection();
		
		try(PreparedStatement pstmt= conn.prepareStatement(SELECT_ALL);
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
}
