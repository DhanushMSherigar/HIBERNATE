package com.nav.servlet5;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			if(temp.length()!=10)
			{
				y.sendRedirect("/Servlet5/Error.html");
			}
			else
			{
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
			}
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
