package com.nav.servlet6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Validation extends HttpServlet
{
	public void service(HttpServletRequest x, HttpServletResponse y)
	{
		String temp=x.getParameter("USN");
	
		if(temp.length()!=10)
		{
			try 
			{
				y.sendRedirect("/Servlet6/Error.html");
			}
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			else
			{
				try
				{
					x.getServletContext().getRequestDispatcher("/GetResult").forward(x, y);
				}
				catch (ServletException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
 
		
}
