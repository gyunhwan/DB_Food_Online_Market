<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.food.biz.member.AddressListVO"%>
<%
	List<AddressListVO> addressList = (List) request.getAttribute("addressList");
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
			<th>우편번호</th>
			<th>주소</th>
			<th colspan="2">상세주소</th>
		</tr>
		<%
			for (AddressListVO address : addressList) {
		%>
		<tr>
			<td><%=address.getPost_number()%></td>
			<td><%=address.getAddress()%></td>
			<td><%=address.getAddress_detail()%></td>
			<td><form action="deleteAddress.do" method="post">
					<input type="hidden" name="address_code"
						value="<%=address.getAddress_code()%>"><input
						type="hidden" name="member_email" value="<%=member_email%>"><input class="btn btn-success"
						type="submit" value="삭제">
				</form></td>
		</tr>
		<%
			}
		%>
	</table>
	<button class="btn btn-success" onclick="location.href='addressInsert.jsp'">배송지 등록</button>
</body>
</html>