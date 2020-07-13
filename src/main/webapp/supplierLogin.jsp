<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<body>
	<form action="supplierLogin.do" method="post">
		<table id="customers" class="custom">
			<tr>
				<th>supplier_business_number</th>
				<td><input type="text" name="supplier_business_number"></td>
			</tr>
			<tr>
				<th>supplier_pw</th>
				<td><input type="text" name="supplier_pw"></td>
			</tr>
			<tr>
				<td><input type="submit" class="btn btn-success" value="로그인"></td>
				<td><input type="button" class="btn btn-success" value="회원가입" onclick="location.href='supplierJoin.jsp'"></td>
			</tr>
		</table>
	</form>
</body>
</html>