<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <%  pageContext.setAttribute("name","Aryan");  %><!--  is have the local scope --> 
      <%  pageContext.setAttribute("name2","Aryan kamboj" ,PageContext.SESSION_SCOPE);  %>
                          <!--  HAVE SCOPE IN THE DIFFERENT SESSIONS -->
</body>
</html>