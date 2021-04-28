<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<link rel= "stylesheet"  href="./resources/css/bootstrap.min.css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품 목록</h1>
			<h5 class="display-5" align="right">
				<a href='<c:url value="/regProduct" />'>상품 등록</a>
			</h5>
		</div>
	</div>
	<c:if test="${! empty productlist}">	
		<div class = "container">
			<div class = "row" align="center">
				<c:forEach var="product" items="${productlist}" >
					<div class = "col-md-4">
						<h3>${product.p_name }</h3>
						<p>${product.p_unitPrice }</p>
						<p>${product.p_category }</p>
						<p>
							<a href='<c:url value="/productDetail?id=${product.p_id }" />'>상세 정보</a>
						</p>							
					</div>
				</c:forEach>
			</div>			
		</div>
	</c:if>
	
	
	
	<%-- <c:if test="${! empty productlist}">
		<c:forEach var="product" items="${productlist}" >
			${product.p_name }
			${product.p_unitPrice }
			${product.p_category }			
			<br>
		</c:forEach>
	</c:if> --%>

</body>
</html>