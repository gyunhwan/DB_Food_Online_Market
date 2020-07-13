<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String member_email = (String) session.getAttribute("member_email");
	String member_name = (String) session.getAttribute("member_name");
	Integer member_grade_code = (Integer) session.getAttribute("member_grade_code");
	Integer admin = (Integer) session.getAttribute("admin");
%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://fonts.googleapis.com/css?family=Permanent+Marker&display=swap"
	rel="stylesheet">
<style>
nav {
	margin-left: auto;
	margin-right: auto;
}

ul {
	list-style-type: none;
	margin-left: auto;
	margin-right: auto;
	overflow: hidden;
	color: green;
	background-color: white;
	text-align: center;
	border-top-style: solid;
}

li {
	display: inline-block;
}

li a {
	display: block;
	color: green;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: x-large;
	font-weight: bold;
	font-family: 'Permanent Marker', cursive;
}

/* Change the link color to #111 (black) on hover */
li :hover {
	border-top-style: solid;
	color: #FFE08C;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav>
		<ul style="">
			<li><a href="http://localhost:8080/biz/recipeList.do">홈</a></li>
			<%
				if (member_email == null) {
			%>
			<li><a href="supplierLogin.jsp">공급자로그인</a></li>
			<li><a href="memberLogin.jsp">회원로그인</a></li>
			<%
				} else {
			%>
			<li><a href="logout.do">로그아웃</a></li>
			<%
				}
			%>
			<li><a href="supplierFoodList.do">식자재 검색화면</a></li>
			<%
				if (admin != null && admin == 0) {
			%>
			<li><a href="basketList.do?member_email=<%=member_email%>">장바구니</a></li>
			<li><a href="getOrderList.do?member_email=<%=member_email%>">마이페이지</a></li>
			<%
				} else if (admin != null && admin == 1) {
			%>
			<li><a href="test.do">레시피등록</a></li>
			<li><a href="foodIn.jsp">식자재등록</a></li>
			<li><a href="orderList.do">주문확인</a></li>
			<li><a href="foodYesNo.do">식자재 신청목록</a></li>
			<%
				}
			%>
		</ul>
	</nav>



</body>
</html>