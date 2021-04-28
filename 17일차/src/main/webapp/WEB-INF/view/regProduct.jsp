<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
</head>
<body>
	<form:form modelAttribute="product">
		<p>
			<label>
				이름:<br>
				<form:input path="p_name"/>
				<form:errors path="p_name"/>
			</label>
		</p>
		<p>
			<label>
				가격:<br>
				<form:input path="p_unitPrice"/>
				<form:errors path="p_unitPrice"/>
			</label>
		</p>		
		<p>
			<label>
				상품설명:<br>
				<form:textarea path="p_description" rows="3"/>
				<form:errors path="p_description"/>
			</label>
		</p>		
		<p>
			<label>
				카테고리:<br>
				<form:input path="p_category"/>
				<form:errors path="p_category"/>
			</label>
		</p>
		<p>
			<label>
				제조사:<br>
				<form:input path="p_manufacturer"/>
				<form:errors path="p_manufacturer"/>
			</label>
		</p>				
		<p>
			<label>
				제품상태:<br>
				<form:input path="p_condition"/>
				<form:errors path="p_condition"/>
			</label>
		</p>	
		<input type="submit" value="등록"  />	
	</form:form>
</body>
</html>