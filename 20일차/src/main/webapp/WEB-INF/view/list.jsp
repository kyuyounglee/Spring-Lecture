<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<%-- <c:if test="${! empty productList }">
	<c:forEach items="${productList }" var = "product">		
		<p>${product.p_id }</p>
		<p>${product.p_name }</p>
		<p>${product.p_unitPrice }</p>
	</c:forEach>
</c:if> --%>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">아이디</th>
      <th scope="col">이 름</th>
      <th scope="col">가 격</th>
      <th scope="col">상품설명</th>
      <th scope="col">카테고리</th>
      <th scope="col">제조사</th>
      <th scope="col">상품상태</th>
      <th scope="col">첨부파일</th>
    </tr>
  </thead>  
  <tbody> 
  
<c:if test="${! empty productList }">
	<c:forEach items="${productList }" var = "product" varStatus="status">
	     
	    <tr>
	      <th scope="row">${status.count }</th>
	      <td>
	      	<a href=' <c:url value = "/list/${product.p_id }" /> ' >${product.p_id }</a>	      
	      </td>
	      <td>${product.p_name }</td>
	      <td>${product.p_unitPrice }</td>
	      <td>${product.p_description }</td>
	      <td>${product.p_category }</td>
	      <td>${product.p_manufacturer }</td>
	      <td>${product.p_condition }</td>
	      <td>${product.p_fileName }</td>
	    </tr>
	    
    </c:forEach>
</c:if>
        
  </tbody>  
</table>
</body>
</html>