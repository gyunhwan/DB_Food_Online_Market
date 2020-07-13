<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="com.food.biz.supplier.SupplierVO" %>
    <%
    SupplierVO supplierInfo = (SupplierVO) request.getAttribute("supplierInfo");
    String supplier_business_number = (String) session.getAttribute("supplier_business_number");
	String supplier_name = (String) session.getAttribute("supplier_name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>
<nav>
  <ul>
  <li><a href="supplierPersonalFoodList.do?supplier_business_number=<%=supplier_business_number%>">메인</a></li>
   <li><a href="logout.do">로그아웃</a></li>
   <li><a href="foodInsert.jsp">식자재 등록</a></li>
   <li><a href="supplierInfoUpdatePage.do?supplier_business_number=<%=supplier_business_number%>">공급자 정보 수정</a></li>
   <li><a href="supplierCalPage.do?supplier_business_number=<%=supplier_business_number%>">정산</a></li>
  </ul>
</nav>
<form action="supplierInfoUpdate.do" method="post">
<table id="customers" class="custom">
	<tr>
		<th>사업자 번호</th>
		<td><input type="hidden" name="supplier_business_number" value="<%=supplierInfo.getSupplier_business_number() %>"><%=supplierInfo.getSupplier_business_number() %></td>
	</tr>
	<tr>
		<th>공급자 비밀번호</th>
		<td><input type="text" name="supplier_pw" value="<%=supplierInfo.getSupplier_pw()%>"></td>
	</tr>
	<tr>
		<th>공급자 이름</th>
		<td><input type="text" name="supplier_name" value="<%=supplierInfo.getSupplier_name()%>"></td>
	</tr>
	<tr>
		<th>공급자 전화번호</th>
		<td><input type="text" name="supplier_tel" value="<%=supplierInfo.getSupplier_tel()%>"></td>
	</tr>
</table>
<input type="submit" class="btn btn-success" value="수정">
</form>
</body>
</html>