<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%--    
    when we need to use any jstl tag we use the preffix   uri is the location where the jstl is located
    
    
    <%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
    <c:out value="hello world"/>
     --%>
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

  
  
   ${name}  <br> <!-- same as below     . this will get the values from the servlet and print it 
                                            it is full code  -->> 
                                            \
                                            
 <%--  <% 
     String name= request.getAttribute("name").toString(); // this give an object and we are converting 
                                              // into the string for the output
   %>
   <%=name  %>  --%>
   
</body>
</html>
</html>

