<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String imsi = request.getContextPath() + "/Shopping?command=main";
	// request.getContextPath()  => 프로젝트이름을 반환함 => JspModel2  
	//out.print(imsi);
	response.sendRedirect(imsi);
%>
</body>
</html>