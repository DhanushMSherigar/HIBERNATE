package com.nav.servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Launch extends HttpServlet
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		try
		{
			PrintWriter pw=y.getWriter();
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>My Second Servlet</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<h1>$$$$$$$$$$$$  Hello NAVEEN  $$$$$$$$$$$$</h1>");
			pw.println("</body>");
			pw.println("</html>");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
