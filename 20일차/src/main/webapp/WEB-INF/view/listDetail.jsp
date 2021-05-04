<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table table-striped margin-left: auto margin-right: auto" alies = "center">
		<tbody>
			<tr>
				<td class="text-center">${product.p_id }</td>
			</tr>
			<tr>
				<td class="text-center">${product.p_name }</td>
			</tr>
			<tr>
				<td class="text-center">${product.p_unitPrice }</td>
			</tr>
			<tr>
				<td class="text-center">${product.p_description }</td>
			</tr>
			<tr>
				<td class="text-center">${product.p_category }</td>
			</tr>
			<tr>
				<td class="text-center">${product.p_manufacturer }</td>
			</tr>
			<tr>
				<td class="text-center">${product.p_condition }</td>
			</tr>
			<tr>
				<td class="text-center">${product.p_fileName }</td>
			</tr>
		</tbody>
	</table>
	<%-- <c:if test="${! empty product }">
		<div class="container">
			<div class="row">
				<div class="col">
					<p>${product.p_id }</p>
				</div>
			</div>
			<div class="row col">
				<p>${product.p_name }</p>
			</div>
			<div class="row col">
				<p>${product.p_unitPrice }</p>
			</div>
			<div class="row">
				<p>${product.p_description }</p>
			</div>
			<div class="row">
				<p>${product.p_category }</p>
			</div>
			<div class="row">
				<p>${product.p_manufacturer }</p>
			</div>
			<div class="row">
				<p>${product.p_condition }</p>
			</div>
			<div class="row">
				<p>${product.p_fileName }</p>
			</div>
		</div>
	</c:if> --%>


</body>
</html>