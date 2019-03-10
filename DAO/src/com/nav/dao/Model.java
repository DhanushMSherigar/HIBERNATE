package com.nav.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class Model
{
		
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet res=null;
	
	private String name=null;
	private String city=null;
    private String pwd=null;
    
	
	public void setCon(Connection con)
	{
		this.con = con;
	}
	public void setPstmt(PreparedStatement pstmt) 
	{
		this.pstmt = pstmt;
	}
	public void setRes(ResultSet res) 
	{
		this.res = res;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public void setPwd(String pw)
	{
		this.pwd = pw;
	}
	
	public Connection getCon()
	{
		return con;
	}
	public PreparedStatement getPstmt()
	{
		return pstmt;
	}
	public ResultSet getRes() 
	
	{
		return res;
	}
	public String getName()
	{
		return name;
	}
	public String getCity() 
	{
		return city;
	}
	public String getPwd()
	{
		return pwd;
	}
	
	public Model()
	{
		try
		{
			DAOModel d=new DAOModel();
			con=d.getConnection();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
		boolean verify()
		{
			try 
			{
					pstmt=con.prepareStatement("Select * from JULYSTUDENT where NAME=? and PWD=? ");
					pstmt.setString(1, name);
					pstmt.setString(2, pwd);
					res=pstmt.executeQuery();
				
					while(res.next()==true)
					{
						name=res.getString(1);
						return true;
					}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return false;
		}
		
		boolean register()
		{
			try 
			{
					pstmt=con.prepareStatement("Insert into JULYSTUDENT values (?,?,?)");
					pstmt.setString(1, name);
					pstmt.setString(2, city);
					pstmt.setString(3, pwd);
					int r=pstmt.executeUpdate();
				
					if(r==1)
					{
						return true;
					}
					
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return false;
		}



}
