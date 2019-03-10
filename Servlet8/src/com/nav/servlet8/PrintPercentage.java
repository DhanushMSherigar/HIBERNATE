package com.nav.servlet8;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class PrintPercentage extends HttpServlet 
{
	
		public void service(HttpServletRequest x, HttpServletResponse y)
		{
			try
			{
			HttpSession hs=x.getSession();
			int a=(int)hs.getAttribute("MARKS1");
			int b=(int)hs.getAttribute("MARKS2");
			int c=(int)hs.getAttribute("MARKS3");
			float per=((a+b+c)/300.0f)*100;
			
				PrintWriter pw=y.getWriter();
				pw.println("Percentage is  "+per);
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

}
