<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.food.biz.order.OrderVO"%>
<%
	List<OrderVO> returnList = (List) request.getAttribute("returnList");
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
			<td></td>
			<th>식자재명</th>
			<th>수량</th>
			<th>주문자</th>
			<th>주문날짜</th>
			<th>주소</th>
		</tr>
		<%
			for (int i = 0; i < returnList.size(); i++) {
		%>
		<tr>
			<td><%=returnList.get(i).getOrder_code()%></td>
			<td><%=returnList.get(i).getSupplier_food_name()%></td>
			<td><%=returnList.get(i).getOrder_detail_amount()%></td>
			<td><%=returnList.get(i).getMember_email()%></td>
			<td><%=returnList.get(i).getOrder_date()%></td>
			<td><%=returnList.get(i).getOrder_address() + " " + returnList.get(i).getOrder_address_detail()%></td>
			<%
				if (i == 0) {
			%>
			<td>
				<%
					if (returnList.get(i).getOrder_state().equals("환불 신청")) {
				%>
				<form action="changeOrderState3.do" method="post">
					<input type="hidden" name="order_code"
						value="<%=returnList.get(i).getOrder_code()%>"> <input
						type="hidden" name="order_state" value="환불 신청 승인"> <input
						type="submit" value="승인">
				</form>
			</td>

			<td>
				<form action="changeOrderState3.do" method="post">
					<input type="hidden" name="order_code"
						value="<%=returnList.get(i).getOrder_code()%>"> <input
						type="hidden" name="order_state" value="배송 완료"> <input
						type="submit" value="거절">
				</form> <%
 	} else if (returnList.get(i).getOrder_state().equals("환불 신청 승인")) {
 %>
			
			<td>
				<form action="changeOrderState3.do" method="post">
					<input type="hidden" name="order_code"
						value="<%=returnList.get(i).getOrder_code()%>"> <input
						type="hidden" name="order_state" value="환불 완료"> <input class="btn btn-success"
						type="submit" value="환불 완료">
				</form>
			</td>
			<%
				}
			%>
			<%
				} else {
			%>
			<td>
				<%
					if (returnList.get(i).getOrder_code() != returnList.get(i - 1).getOrder_code()) {
				%>
				<%
					if (returnList.get(i).getOrder_state().equals("환불 신청")) {
				%>
				<form action="changeOrderState3.do" method="post" >
					<input type="hidden" name="order_code"
						value="<%=returnList.get(i).getOrder_code()%>"> <input
						type="hidden" name="order_state" value="환불 신청 승인"> <input class="btn btn-success"
						type="submit" value="승인">
				</form>
			</td>

			<td>
				<form action="changeOrderState3.do" method="post">
					<input type="hidden" name="order_code"
						value="<%=returnList.get(i).getOrder_code()%>"> <input
						type="hidden" name="order_state" value="배송 완료"> <input class="btn btn-success"
						type="submit" value="거절">
				</form> <%
 	} else if (returnList.get(i).getOrder_state().equals("환불 신청 승인")) {
 %>
			
			<td>
				<form action="changeOrderState3.do" method="post">
					<input type="hidden" name="order_code"
						value="<%=returnList.get(i).getOrder_code()%>"> <input
						type="hidden" name="order_state" value="환불 완료"> <input class="btn btn-success"
						type="submit" value="환불 완료">
				</form>
			</td>
			<%} %>
			<%} %>
			<%} %>
		</tr>
		<%} %>
	</table>
</body>
</html>