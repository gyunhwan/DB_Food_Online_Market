<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
<div class=container>
<div class=row style="text-align:center;width:1000px">
	<h1 stlye="width:100%">로그인</h1>
	</div>
	<div class="row">
	<form action="memberLogin.do" method="post">
		<table stlye="width:100%" id="customers" class="custom">
			<tr>
				<td>member_email</td>
				<td><input type="text" name="member_email"></td>
			</tr>
			<tr>
				<td>member_pw</td>
				<td><input type="text" name="member_pw"></td>
			</tr>
			<tr>
				<td><input class="btn btn-success" type="submit" value="로그인"></td>
				<td><input class="btn btn-success" type="button" onclick="location.href='memberJoin.jsp'" value="회원가입"></td>
			</tr>
		</table>
		
	</form>
	</div>
	</div>>
</body>
</html>