package com.nav.dao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet
{
	public void service(HttpServletRequest x, HttpServletResponse y)
	{
			try
			{
				String name=x.getParameter("NAME");
				String pwd=x.getParameter("PWD");
				Model m=new Model();
				m.setName(name);
				m.setPwd(pwd);
				
				boolean b=m.verify();
				if(b==true)
				{
					HttpSession hs=x.getSession(true);
					hs.setAttribute("NAME", m.getName());
					y.sendRedirect("/DAO/Loginsuccess.jsp");				
				}
				else
				{
					y.sendRedirect("/DAO/LoginFailure.html");
				}
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}


}
