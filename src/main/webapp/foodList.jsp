<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.food.biz.supplier.SupplierFoodVO"%>
<%
	List<SupplierFoodVO> supplierFoodList = (List) request.getAttribute("supplierFoodList");
	String member_email = (String) session.getAttribute("member_email");
	String member_name = (String) session.getAttribute("member_name");
	Integer member_grade_code = (Integer) session.getAttribute("member_grade_code");
	Integer admin = (Integer) session.getAttribute("admin");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.card {
	float: left;
	margin: 15px 15px 15px 15px;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
	width: 30%;
}

.card:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

.container {
	padding: 2px 16px;
}
</style>
</head>
<body>
	<div>
		<div class="row">
			<div class="col"></div>
			<div class="col">
				<form action="recipeSearch.do" method="post">
					<input type="text" class="input-group-text"
						style="width: 60%; float: left" class="input-group-text"
						name="supplier_food_name"> <input class="btn btn-success"
						type="submit" value="검색">
				</form>
			</div>
			<div class="col"></div>
		</div>
		<div class=row>
			<%
				for (SupplierFoodVO supplierFood : supplierFoodList) {
			%>
			<div class="card">
				<img
					src="http://localhost:8080\biz\img\<%=supplierFood.getSupplier_food_image()%>"
					style="width: 100%; height: 50px"
					onclick="location.href='supplierFoodDetail.do?supplier_food_code=<%=supplierFood.getSupplier_food_code()%>'">
				<div class="container">
					<p style="text-align: center"><%=supplierFood.getSupplier_food_name()%></p>
					<p style="text-align: center"><%=supplierFood.getSupplier_food_price()%>
				</div>
			</div>

			<%
				}
			%>
		</div>
	</div>
</body>
</html>