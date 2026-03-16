<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--    it is used to import the packages    -->
<%@ page import= "java.util.Date,java.util.*" %>    <!--  also called the directive -->

<!--     this is the decleration section -->
<%! 
   int z = 1; 
  %>
<!--        the below tag is knowns as the scriplet -->
    <%   // any thing writeed betwrrn  <%  will be treaed as java code
        int i = Integer.parseInt(request.getParameter("num1"));
	    int j = Integer.parseInt(request.getParameter("num2"));
	    int k = i+j;
	    out.println(k+"</br>");
	    %>
	    <!--  expression tag used for printing any thing in the java  -->
	    <!--  expression  -->
	    <%= z %>  <!--  print statement  -->
	    <%= 9/0 %>

</body>
</html>