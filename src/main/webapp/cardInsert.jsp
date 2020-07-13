<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%
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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insertCard.do" method="post">
	<table class="custom" id="customers">
		<tr>
			<th>카드번호</th>
			<td><input type="text" name="card_number"></td>
		</tr>
		<tr>
			<th>유효기간</th>
			<td><input type="text" name="card_date"></td>
		</tr>
		<tr>
			<th>카드종류</th>
			<td><input type="text" name="card_kind"></td>
		</tr>
	</table>
	<input type="hidden" name="member_email" value="<%=member_email%>">
	<input class="btn btn-success" type="submit" value="카드등록">
	</form>
</body>
</html>