<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--    it is used to import the packages    -->
<%@ page import= "java.util.Date,java.util.*" %>    

<!--     this is the decleration section -->
<%! 
   int z = 1; 
  %>
<!--        the below tag is knowns as the scriplet -->
    <%   // any thing writeed betwrrn  <%  will be treaed as java code
        int i = Integer.parseInt(request.getParameter("num1"));
	    int j = Integer.parseInt(request.getParameter("num2"));
	    int k = i+j;
	    out.println(k);
	    out.println(z);
	    %>

</body>
</html>