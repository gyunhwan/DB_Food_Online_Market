<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%@page import="com.food.biz.member.MemberVO" %>
    <%
    MemberVO memberInfo = (MemberVO) request.getAttribute("memberInfo");
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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="memberInfoUpdate.do" method="post">
<table class="custom" id="customers">
	<tr>
		<th>회원 이메일</th>
		<td><%=memberInfo.getMember_email() %><input type="hidden" name="member_email" value="<%=memberInfo.getMember_email()%>"></td>
	</tr>
	<tr>
		<th>회원 비밀번호</th>
		<td><input type="text" name="member_pw" value="<%=memberInfo.getMember_pw()%>"></td>
	</tr>
	<tr>
		<th>회원 이름</th>
		<td><input type="text" name="member_name" value="<%=memberInfo.getMember_name()%>"></td>
	</tr>
	<tr>
		<th>회원 전화번호</th>
		<td><input type="text" name="member_tel" value="<%=memberInfo.getMember_tel()%>"></td>
	</tr>
	<tr>
	<th>등급</th>
	<td>
	<%if(memberInfo.getMember_grade_code()==0){ %>
		고마운분
	<%} %>
	<%if(memberInfo.getMember_grade_code()==1){ %>
		귀한분
	<%} %>
	<%if(memberInfo.getMember_grade_code()==2){ %>
		더귀한분
	<%} %>
	<%if(memberInfo.getMember_grade_code()==3){ %>
		천생연분
	<%} %>
	</td>
	</tr>
</table>
<input class="btn btn-success" type="submit" value="수정">
</form>
</body>
</html>