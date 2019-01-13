package com.ikth.apps.todo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.ikth.apps.todo.dao.TodoDao;
import com.ikth.apps.todo.dto.TodoDto;

/**
 * Servlet implementation class TodoManagerServlet
 */
public class TodoManagerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private Logger logger= LoggerFactory.getLogger(TodoManagerServlet.class);

	private Gson gson= new Gson();
	private TodoDao todoDao= new TodoDao();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		final String uri= request.getRequestURI();
		logger.debug("requested uri [{}]", uri);
		
		try {
			List<TodoDto> tasks= todoDao.selectAll();
			logger.debug("select all tasks count [{}]", tasks.size());
			
//			response.setContentType("application/json");
			response.setContentType("text/json");
			response.setCharacterEncoding("utf-8");
			final String bodyMsg= gson.toJson(tasks);
			
			PrintWriter pw= response.getWriter();
			pw.print(bodyMsg);
			pw.flush();
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	}
}