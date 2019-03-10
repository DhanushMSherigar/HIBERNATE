package com.nav.mvc1;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class Model
{
	private String url="jdbc:oracle:thin:@//localhost:1521/XE";
	private String un="system";
	private String pwd="system";
	
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet res=null;
	
	private String name=null;
	private String usn=null;
	private int marks1=0;
	private int marks2=0;
	private int marks3=0;
	private float avg=0.0f;
	
	
	public String getUrl() {
		return url;
	}
	public String getUn() {
		return un;
	}
	public String getPwd() {
		return pwd;
	}
	public Connection getCon() {
		return con;
	}
	public PreparedStatement getPstmt() {
		return pstmt;
	}
	public ResultSet getRes() {
		return res;
	}
	public String getName() {
		return name;
	}
	public String getUsn() {
		return usn;
	}
	public int getMarks1() {
		return marks1;
	}
	public int getMarks2() {
		return marks2;
	}
	public int getMarks3() {
		return marks3;
	}
	public float getAvg() {
		return avg;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public void setUn(String un)
	{
		this.un = un;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}
	public void setRes(ResultSet res) {
		this.res = res;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}
	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}
	public void setMarks3(int marks3) {
		this.marks3 = marks3;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
	public Model()
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
	boolean getResult()
	{
		try 
		{
			pstmt=con.prepareStatement("Select * from JULY_BATCH where USN=?");
			pstmt.setString(1, usn);
			res=pstmt.executeQuery();
			
			while(res.next()==true)
			{
				name=res.getString(1);
				usn=res.getString(2);
				marks1=res.getInt(3);
				marks2=res.getInt(4);
				marks3=res.getInt(5);
				avg=res.getFloat(6);
					return true;				
			}
			
		}
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	}
