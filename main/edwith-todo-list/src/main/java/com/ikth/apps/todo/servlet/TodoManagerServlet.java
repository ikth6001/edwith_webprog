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

	private final String SERVLET_REQ_URI_PREFIX= "/edwith-todo-list/todo";
	private final String SERVLET_REQ_SELECT_ALL= "/all";
	
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
			List<TodoDto> tasks= null;
			if(uri.equals(SERVLET_REQ_URI_PREFIX + SERVLET_REQ_SELECT_ALL)) {
				tasks= todoDao.selectAll();
			} else {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "It is not correct request uri");
				return;
			}
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
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		final String uri= request.getRequestURI();
		logger.debug("requested uri [{}]", uri);
		
		String id= null;
		if(uri.startsWith(SERVLET_REQ_URI_PREFIX)) {
			id= uri.substring(SERVLET_REQ_URI_PREFIX.length() + 1);
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "It is not correct request uri");
			return;
		}
		logger.debug("task id to update status [{}]", id);
		
		try {
			TodoDto task= todoDao.selectOne(id);
			
			if(task == null) {
				logger.error("there are no task apecified by id [{}]", id);
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "there are no task apecified by id");
				return;
			}
			
			String type= task.getType();
			if("TODO".equals(type)) {
				type= "DOING";
			} else if("DOING".equals(type)) {
				type= "DONE";
			} else {
				return;
			}
			
			todoDao.updateTaskType(id, type);
			
			/**
			 * 동일 페이지로의 redirect는 안되는 듯 하다..
			 */
//			response.sendRedirect("/edwith-todo-list/index.html");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	}
}