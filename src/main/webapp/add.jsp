<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%   // any thing writeed betwrrn  <%  will be treaed as java code
        int i = Integer.parseInt(request.getParameter("num1"));
	    int j = Integer.parseInt(request.getParameter("num2"));
	    int k = i+j;
	    out.println(k);
	    %>

</body>
</html>