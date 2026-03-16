<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1> hlw you are in the display.jsp file</h1>
   <% 
       String name= request.getAttribute("name").toString(); // this give an object and we are converting 
                                              // into the string for the output
   %>
   <%=name  %>
   
   ${name}   // same as below 
 <%--  <% 
     String name= request.getAttribute("name").toString(); // this give an object and we are converting 
                                              // into the string for the output
   %>
   <%=name  %>  --%>
   
</body>
</html>