package com.nav.mvc2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class RegisterController extends HttpServlet
{
			public void service(HttpServletRequest x, HttpServletResponse y)
		{
				try
				{
					String name=x.getParameter("NAME");
					String city=x.getParameter("CITY");
					String pwd=x.getParameter("PWD");
					RegisterModel rm=new RegisterModel();
					rm.setName(name);
					rm.setCity(city);
					rm.setPwd(pwd);
					
					boolean b=rm.register();
					if(b==true)
					{
						y.sendRedirect("/MVC2/RegisterSuccess.jsp");				
					}
					else
					{
						y.sendRedirect("/MVC2/RegisterFailure.jsp");
					}
				
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
		}

}

