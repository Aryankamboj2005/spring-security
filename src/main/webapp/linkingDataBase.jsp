<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Data</title>
</head>
<body>

<%
String url ="jdbc:mysql://localhost:3306/demo";
String UserName= "root";
String password = "Aryan2005@";
String query ="Select * from students where id=1"; // writing query

Class.forName("com.mysql.cj.jdbc.Driver"); // SQL driver 
Connection con= DriverManager.getConnection(url,UserName,password);
Statement st = con.createStatement();   // creating a starement 
ResultSet rs = st.executeQuery(query);   // processiugn query

if(rs.next()){
%>

ID: <%= rs.getString(1) %><br>
Name: <%= rs.getString(2) %><br>
Age: <%= rs.getString(3) %><br>
City: <%= rs.getString(4) %><br>

<%
}
%>

</body>
</html>