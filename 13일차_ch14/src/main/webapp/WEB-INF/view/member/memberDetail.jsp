<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>${member.id}</p>
<p>${member.email}</p>
<p>${member.name}</p>
<p><tf:formatDateTime value="${member.registerDateTime }"
				pattern="yyyy-MM-dd"	/>
</p>				
</body>
</html>