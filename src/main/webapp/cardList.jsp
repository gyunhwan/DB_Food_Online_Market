<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%@page import="com.food.biz.member.CardListVO" %>
    <%
    List<CardListVO> cardList = (List) request.getAttribute("cardList");
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
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="customers" class="custom">
		<tr>
			<th>카드번호</th>
			<th>유효기간</th>
			<th>카드종류</th>
			<th></th>
		</tr>
		<%for(CardListVO card : cardList){ %>
		<tr>
			<td><%=card.getCard_number() %></td>
			<td><%=card.getCard_date() %></td>
			<td><%=card.getCard_kind() %></td>
			<td><form action="deleteCard.do" method="post"><input type="hidden" name="card_code" value="<%=card.getCard_code()%>"><input type="hidden" name="member_email" value="<%=member_email%>"><input class="btn btn-success" type="submit" value="삭제"></form></td>
		</tr>
		<%} %>
	</table>
	<button class="btn btn-success" onclick="location.href='cardInsert.jsp'">카드 등록</button>
</body>
</html>