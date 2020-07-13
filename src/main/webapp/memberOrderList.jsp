<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%@page import="com.food.biz.order.OrderVO" %>
    <%
    List<OrderVO> orderList = (List) request.getAttribute("orderList");
	String member_email = (String) session.getAttribute("member_email");
	String member_name = (String) session.getAttribute("member_name");
	Integer member_grade_code = (Integer) session.getAttribute("member_grade_code");
	Integer admin = (Integer) session.getAttribute("admin");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>Insert title here</title>
</head>
<body>
<table id="customers" class="custom">
	<tr>
			<th></th>
			<th>식자재명</th>
			<th>수량</th>
			<th>주문자</th>
			<th>주문날짜</th>
			<th>주소</th>
			<th colspan=2>주문상태</th>
		</tr>
		<%for(int i = 0 ; i<orderList.size();i++){ %>
		<tr>
			<td><img
					src="http://localhost:8080\biz\img\<%=orderList.get(i).getSupplier_food_image()%>"
					style="width: 50px; height: 50px"></td>
			<td><%=orderList.get(i).getSupplier_food_name()%></td>
			<td><%=orderList.get(i).getOrder_detail_amount() %></td>
			<td><%=orderList.get(i).getMember_email() %></td>
			<td><%=orderList.get(i).getOrder_date() %></td>
			<td><%=orderList.get(i).getOrder_address() + " " + orderList.get(i).getOrder_address_detail() %></td>
			<%if(i==0){%>
			<td>
			<%if(orderList.get(i).getOrder_state().equals("준비중")){ %>
			준비중
			</td>
			<td>
			<button onclick="location.href='deleteOrder.do?order_code=<%=orderList.get(i).getOrder_code()%>&member_email=<%=orderList.get(i).getMember_email()%>'">취소</button>
			<%} else if(orderList.get(i).getOrder_state().equals("배송중")) {%>
			배송중
			<%} else if(orderList.get(i).getOrder_state().equals("배송 완료")){ %>
			배송 완료
			</td>
			<td>
			<form action="changeOrderState2.do" method="post">
				<input type="hidden" name="order_code" value="<%=orderList.get(i).getOrder_code()%>">
				<input type="hidden" name="order_state" value="환불 신청">
				<input type="hidden" name="member_email" value="<%=orderList.get(i).getMember_email()%>">
				<input class="btn btn-success" type="submit" value="환불 신청">
			</form>
			<%} else if(orderList.get(i).getOrder_state().equals("환불 신청")){ %>
			환불 신청 대기
			<%} else if(orderList.get(i).getOrder_state().equals("환불 신청 승인")){%>
			환불 신청 승인
			<%} else if(orderList.get(i).getOrder_state().equals("환불 완료")){%>
			환불 완료
			<%} %>
			</td>
			<%}else{ %>
			<%if(orderList.get(i).getOrder_code()!=orderList.get(i-1).getOrder_code()){ %>
			<td>
			<%if(orderList.get(i).getOrder_state().equals("준비중")){ %>
			준비중
			</td>
			<td>
			<button class="btn btn-success" onclick="location.href='deleteOrder.do?order_code=<%=orderList.get(i).getOrder_code()%>&member_email=<%=orderList.get(i).getMember_email()%>'">취소</button>
			<%} else if(orderList.get(i).getOrder_state().equals("배송중")) {%>
			배송중
			<%} else if(orderList.get(i).getOrder_state().equals("배송 완료")){ %>
			배송 완료
			</td><td>
			<form action="changeOrderState2.do" method="post">
				<input type="hidden" name="order_code" value="<%=orderList.get(i).getOrder_code()%>">
				<input type="hidden" name="order_state" value="환불 신청">
				<input type="hidden" name="member_email" value="<%=orderList.get(i).getMember_email()%>">
				<input class="btn btn-success" type="submit" value="환불 신청">
			</form>
			<%} else if(orderList.get(i).getOrder_state().equals("환불 신청")){ %>
			환불 신청 대기
			<%} else if(orderList.get(i).getOrder_state().equals("환불 신청 승인")){%>
			환불 신청 승인
			<%} else if(orderList.get(i).getOrder_state().equals("환불 완료")){%>
			환불 완료
			<%} %>
			</td>
			<%} %>
			<%} %>
		</tr>
		<%} %>
		<tr>
			<td colspan=7><form action="cardList.do" method="post"  style="text-align:center"><input type="hidden" name="member_email" value="<%=member_email%>"><input class="btn btn-success" type="submit" value="카드관리"></form></td>
			
		</tr>
		<tr>
			<td colspan=8><form action="addressList.do" method="post"  style="text-align:center"><input type="hidden" name="member_email" value="<%=member_email%>"><input class="btn btn-success" type="submit" value="배송지관리"></form></td>
			
		</tr>
		<tr>
			<td colspan=8><form action="memberInfoUpdatePage.do" method="post"  style="text-align:center"><input type="hidden" name="member_email" value="<%=member_email%>"><input class="btn btn-success" type="submit" value="회원정보수정"></form></td>
			
		</tr>
	</table>
</body>
</html>