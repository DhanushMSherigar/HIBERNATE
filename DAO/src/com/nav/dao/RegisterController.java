package com.nav.dao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nav.dao.Model;
public class RegisterController extends HttpServlet
{
	public void service(HttpServletRequest x, HttpServletResponse y)
	{
			try
			{
				String name=x.getParameter("NAME");
				String city=x.getParameter("CITY");
				String pwd=x.getParameter("PWD");
				Model m=new Model();
				m.setName(name);
				m.setCity(city);
				m.setPwd(pwd);
				
				boolean b=m.register();
				if(b==true)
				{
					y.sendRedirect("/DAO/RegisterSuccess.jsp");				
				}
				else
				{
					y.sendRedirect("/DAO/RegisterFailure.jsp");
				}
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
	}


}
