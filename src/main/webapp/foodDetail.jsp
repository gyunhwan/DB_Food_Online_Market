<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.food.biz.supplier.SupplierFoodVO"%>
<%
	SupplierFoodVO supplierFood = (SupplierFoodVO) request.getAttribute("supplierFood");
	String member_email = (String) session.getAttribute("member_email");
	String member_name = (String) session.getAttribute("member_name");
	Integer member_grade_code = (Integer) session.getAttribute("member_grade_code");
	Integer admin = (Integer) session.getAttribute("admin");
%>
<!DOCTYPE html>
<html>
<head>
<style>
#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}

.custom {
	margin: 50px 0 0 0;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="customers" class="custom">
		<tr>
			<td rowspan="4"><img
				src="http://localhost:8080\biz\img\<%=supplierFood.getSupplier_food_image()%>"
				width="50" height="50"
				onclick="location.href='supplierFoodDetail.do?supplier_food_=<%=supplierFood.getSupplier_food_code()%>'">
			</td>
			<th>식자재명</th>
			<td><%=supplierFood.getSupplier_food_name()%></td>
		</tr>
		<tr>
			<th>식자재가격</th>
			<td><%=supplierFood.getSupplier_food_price()%></td>
		</tr>
		<tr>
			<th>식자재설명</th>
			<td><%=supplierFood.getSupplier_food_comment()%></td>
		</tr>
		<tr>
			<th>식자재단위</th>
			<td><%=supplierFood.getSupplier_food_unit()%></td>
		</tr>

	</table>
	<%
		if (member_email != null) {
	%>
	<div class="container">
		<div class="row">
			<div class="col">
				<form action="insertBasket.do" method="post" style="text-align:center">
					<input type="hidden" name="member_email" value="<%=member_email%>">
					<input type="hidden" name="supplier_food_code"
						value="<%=supplierFood.getSupplier_food_code()%>"> <input
						class="btn btn-success" type="submit" value="장바구니">
				</form>
			</div>
			<div class="col">
				<form action="singleOrderPage.do" method="post" style="text-align:center">
					<input type="hidden" name="member_email" value="<%=member_email%>">
					<input type="hidden" name="supplier_food_code"
						value="<%=supplierFood.getSupplier_food_code()%>"> <input
						class="btn btn-success" type="submit" value="구매">
				</form>
			</div>
		</div>
	</div>


	<%
		}
	%>
</body>
</html>