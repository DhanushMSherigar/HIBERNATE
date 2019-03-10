<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.ServletException" %>
<%@ page import="oracle.jdbc.driver.OracleDriver" %>

<html>
<head>
</head>
<body>

<%!
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

%>

<%!
public void jspInit()
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

%>

<%!
public void jspDestroy()
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
%>

<%
try
{
	String temp=request.getParameter("USN");
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
		
		PrintWriter pw=response.getWriter();
		pw.println(a);
		pw.println(b);
		pw.println(c);
		pw.println(d);
		pw.println(f);
		pw.println(g);
		
		}
}
catch (Exception e)
{
	e.printStackTrace();
}
%>
</body>
</html>