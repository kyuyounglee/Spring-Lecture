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

	<div class="form-group">
    	<label for="exampleFormControlInput1">카테고리</label>    	
    	<form:input class="form-control" path="p_category"/>
  	</div>
  	
  	<div class="form-group">
    	<label for="exampleFormControlInput1">제조사</label>    	
    	<form:input class="form-control" path="p_manufacturer"/>
  	</div>
  	
  	<div class="form-group">
    	<label for="exampleFormControlInput1">상품상태</label>    	
    	<form:input class="form-control" path="p_condition"/>
  	</div>	
  	<div class="form-group">
    	<label for="exampleFormControlInput1">이미지파일명</label>    	
    	<form:input class="form-control" path="p_fileName"/>
  	</div>	
	
	</form:form>
</body>
</html>