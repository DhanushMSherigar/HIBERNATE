package com.nav.servlet8;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.jdbc.driver.OracleDriver;

public class GetResult extends HttpServlet
{
	String url="jdbc:oracle:thin:@//localhost:1521/XE";
	String un="system";
	String pwd="system";
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	
	String a=null;
	String b=null;
	int c=0;
	int d=0;
	int f=0;
	float g=0.0f;
	
	public void init()
	{
		try
		{
			DriverManager.registerDriver(new OracleDriver());
			con=DriverManager.getConnection(url, un, pwd);
		} 
		catch (SQLException e)
		{
						e.printStackTrace();
		}
	}

	public void service(HttpServletRequest x, HttpServletResponse y)
	{
		
		try
		{
			String temp=x.getParameter("USN");
			
				pstmt=con.prepareStatement("Select * from JULY_BATCH where USN=?");
				pstmt.setString(1, temp);
				res=pstmt.executeQuery();
			
				while(res.next()==true)
				{
					a=res.getString(1);
					b=res.getString(2);
					c=res.getInt(3);
					d=res.getInt(4);
					f=res.getInt(5);
					g=res.getFloat(6);
				
					PrintWriter pw=y.getWriter();
					pw.println(a);
					pw.println(b);
					pw.println(c);
					pw.println(d);
					pw.println(f);
					pw.println(g);
					
				}
				Integer c1=new Integer(c);
				Integer d1=new Integer(d);
				Integer f1=new Integer(f);
				
				String c2=c1.toString();
				String d2=d1.toString();
				String f2=f1.toString();
				
				Cookie ck1=new Cookie("MARKS1",c2);
				Cookie ck2=new Cookie("MARKS2",d2);
				Cookie ck3=new Cookie("MARKS3",f2);
				
				ck1.setMaxAge(3*60);
				ck2.setMaxAge(3*60);
				ck3.setMaxAge(3*60);
				
				y.addCookie(ck1);
				y.addCookie(ck2);
				y.addCookie(ck3);
				
				HttpSession hs=x.getSession(true);
				hs.setAttribute("MARKS1", c);
				hs.setAttribute("MARKS2", d);
				hs.setAttribute("MARKS3", f);
				x.getServletContext().getRequestDispatcher("/PrintPercentage").include(x, y);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void destroy()
	{
		try
		{
			res.close();
			pstmt.close();
			con.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}


}
