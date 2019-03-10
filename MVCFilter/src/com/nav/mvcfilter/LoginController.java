package com.nav.mvcfilter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nav.mvcfilter.LoginModel;
public class LoginController extends HttpServlet 
{
	public void service(HttpServletRequest x, HttpServletResponse y)
	{
			try
			{
				String name=x.getParameter("NAME");
				String pwd=x.getParameter("PWD");
				LoginModel lm=new LoginModel();
				lm.setName(name);
				lm.setPwd(pwd);
				
				boolean b=lm.verify();
				if(b==true)
				{
					HttpSession hs=x.getSession(true);
					hs.setAttribute("NAME", lm.getName());
					y.sendRedirect("/MVCFilter/Loginsuccess.jsp");				
				}
				else
				{
					y.sendRedirect("/MVCFilter/LoginFailure.html");
				}
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

}
