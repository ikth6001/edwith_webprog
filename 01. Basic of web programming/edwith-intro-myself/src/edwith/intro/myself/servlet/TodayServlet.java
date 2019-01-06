package edwith.intro.myself.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodayServlet
 */
public class TodayServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw= response.getWriter();
		String contents= "<!DOCTYPE html>"
					 + "<html>"
					 + "<head>"
					 + "<meta charset=\"UTF-8\">"
					 + "<title>Insert title here</title>"
					 + "</head>"
					 + "<body>"
					 + "	<a href=\"http://localhost:8080/edwith-intro-myself\">메인화면</a>"
					 + "	<br>"
					 + "	<br>"
					 + "	<br>"
					 + "	<br>"
					 + "	<h1>현재시간 : " + new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date())
					 + "</body>"
					 + "</html>";
		
		pw.write(contents);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
