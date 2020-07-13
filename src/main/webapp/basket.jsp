<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.food.biz.supplier.SupplierFoodVO"%>
<%
	List<SupplierFoodVO> basketList = (List) request.getAttribute("basketList");
	String member_email = (String) session.getAttribute("member_email");
	String member_name = (String) session.getAttribute("member_name");
	Integer member_grade_code = (Integer) session.getAttribute("member_grade_code");
	Integer admin = (Integer) session.getAttribute("admin");
	int total = 0;
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
			<th>상품이미지</th>
			<th>상품명</th>
			<th>상품가격</th>
			<th>상품수량</th>
		</tr>
		<%
			for (SupplierFoodVO basket : basketList) {
		%>
		<tr>
			<td><%=basket.getSupplier_food_image()%></td>
			<td><%=basket.getSupplier_food_name()%></td>
			<td><%=basket.getSupplier_food_price()%></td>
			<td><form action="basketIncrease.do" method="post">
					<input type="hidden" name="member_email" value="<%=member_email%>"><input
						type="hidden" name="supplier_food_code"
						value="<%=basket.getSupplier_food_code()%>"><input
						class="btn btn-success" type="submit" value="업">
				</form><%=basket.getBasket_detail_amount()%>
				<form action="basketDecrease.do" method="post">
					<input type="hidden" name="member_email" value="<%=member_email%>"><input
						type="hidden" name="supplier_food_code"
						value="<%=basket.getSupplier_food_code()%>"><input
						class="btn btn-success" type="submit" value="다운">
				</form></td>
			<td><button class="btn btn-success"
					onclick="location.href='deleteBasket.do?basket_detail_code=<%=basket.getBasket_detail_code()%>&member_email=<%=member_email%>'">삭제</button></td>
		</tr>
		<%
			total += basket.getSupplier_food_price() * basket.getBasket_detail_amount();
			}
		%>
		<tr>
			<td></td>
			<td>합계 : <%=total%></td>
			<td>배송비 : 2500</td>
			<td>총가격 : <%=total + 2500%></td>
		</tr>
	</table>

	<form action="basketOrderPage.do" method="post">
		<input type="hidden" name="member_email" value="<%=member_email%>">
		<input class="btn btn-success" type="submit" value="구매">
	</form>
</body>
</html>