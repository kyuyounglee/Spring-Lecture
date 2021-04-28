<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<link rel= "stylesheet"  href="./resources/css/bootstrap.min.css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="product">
	 <div class="form-group">
    	<label for="exampleFormControlInput1">제품명</label>    	
    	<form:input class="form-control" path="p_name"/>
  	</div>
  	<div class="form-group">
    	<label for="exampleFormControlInput1">가격</label>    	
    	<form:input class="form-control" path="p_unitPrice"/>
  	</div>	
	<div class="form-group">
    	<label for="exampleFormControlInput1">설명</label>
    	<form:textarea class="form-control"  path="p_description" rows="3"/>
  	</div>		
	<p>
		<form:input path="p_description"/>
	</p>
	<p>
		<form:input path="p_category"/>
	</p>
	<p>
		<form:input path="p_manufacturer"/>
	</p>
	<p>
		<form:input path="p_condition"/>
	</p>
	<p>
		<form:input path="p_fileName"/>
	</p>
	
	
	</form:form>
</body>
</html>