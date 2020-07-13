<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.food.biz.supplier.SupplierFoodVO"%>
<%@page import="com.food.biz.member.AddressListVO"%>
<%@page import="com.food.biz.member.CardListVO"%>
<%
	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String today = formatter.format(new java.util.Date());
	java.text.SimpleDateFormat formatter2 = new java.text.SimpleDateFormat("MM");
	String today2 = formatter2.format(new java.util.Date());

	List<CardListVO> cardList = (List) request.getAttribute("cardList");
	List<AddressListVO> addressList = (List) request.getAttribute("addressList");
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
	<form action="singleInsertOrder.do" method="post">
		<table class="custom" id="customers">
			<tr>
				<th></th>
				<th>상품명</th>
				<th>수량</th>
				<th>가격</th>
			</tr>
			<tr>
				<td><img
					src="http://localhost:8080\biz\img\<%=supplierFood.getSupplier_food_image()%>"
					style="width: 50px; height: 50px"></td>
				<td><%=supplierFood.getSupplier_food_name()%></td>
				<td>1</td>
				<td><%=supplierFood.getSupplier_food_price()%></td>
			</tr>
			<tr>
				<td>합계 : <%=supplierFood.getSupplier_food_price()%></td>
				<td>배송비 : 2500</td>
				<td colspan=2>총가격 : <%=supplierFood.getSupplier_food_price() + 2500%></td>
			</tr>
		</table>
		<table id="customers" class="custom">
			<tr>
				<th></th>
				<th>우편번호</th>
				<th>주소</th>
				<th>상세주소</th>
			</tr>

			<%
				for (AddressListVO address : addressList) {
			%>
			<tr>
				<td><input type="radio" name="address_code"
					value="<%=address.getAddress_code()%>"></td>
				<td><%=address.getPost_number()%></td>
				<td><%=address.getAddress()%></td>
				<td><%=address.getAddress_detail()%></td>
			</tr>
			<%
				}
			%>
			<tr>
				<td><input type="radio" name="address_code" value="0"></td>
				<td><input type="text" name="post" placeholder="우편번호"></td>
				<td><input type="text" name="order_address" placeholder="주소"></td>
				<td><input type="text" name="order_address_detail"
					placeholder="주소상세"></td>
			</tr>
		</table>
		<table id="customers" class="custom">
			<tr>
				<td></td>
				<th>카드번호</th>
				<th>유효기간</th>
				<th>카드종류</th>
			</tr>
			<%
				for (CardListVO card : cardList) {
			%>
			<tr>
				<td><input type="radio" name="card_code"
					value="<%=card.getCard_code()%>"></td>
				<td><%=card.getCard_number()%></td>
				<td><%=card.getCard_date()%></td>
				<td><%=card.getCard_kind()%></td>
			</tr>
			<%
				}
			%>
			<tr>
				<td><input type="radio" name="card_code" value="0"></td>
				<td><input type="text" name="card_number" placeholder="카드번호"></td>
				<td><input type="text" name="card_date" placeholder="유효기간"></td>
				<td><input type="text" name="card_kind" placeholder="카드종류"></td>
			</tr>
		</table>
		<div class="container">
			<div class="row">
				<div class="col">
					<input type="hidden" name="member_email" value="<%=member_email%>">
					<input  type="hidden" name="order_date" value="<%=today%>">
					<input  type="hidden" name="sell_month" value="<%=today2%>">
					<input  type="hidden" name="order_total"
						value="<%=supplierFood.getSupplier_food_price()%>"> <input
						type="hidden" name="order_state" value="준비중"> <input
						type="hidden" name="order_detail_price"
						value="<%=supplierFood.getSupplier_food_price()%>"> <input
						type="hidden" name="order_detail_amount" value="1"> <input
						type="hidden" name="supplier_food_code"
						value="<%=supplierFood.getSupplier_food_code()%>"> <input class="btn btn-success"
						type="submit" value="구매하기"> 
				</div>
				<div class="col">
					<input type="button" class="btn btn-success"
						value="취소하기">
				</div>
			</div>
		</div>
	</form>
</body>
</html>