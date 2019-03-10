package com.nav.servlets;

import java.io.IOException;
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
			y.sendRedirect("/Servlet1/Hello.html");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	//http://localhost:9090/Servlet1/Launch
	
}
