<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${! empty productlist}">
		<c:forEach var="product" items="${productlist}" >
			${product.p_name }
			${product.p_unitPrice }
			${product.p_category }			
			<br>
		</c:forEach>
	</c:if>

</body>
</html>