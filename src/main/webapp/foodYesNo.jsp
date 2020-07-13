<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%@page import="com.food.biz.supplier.SupplierFoodVO" %>
    <%
    List<SupplierFoodVO> foodList = (List) request.getAttribute("foodList");
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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="customers" class="custom">
		<tr>
			<th>사업자번호</th>
			<th>식자재명</th>
			<th>식자재가격</th>
			<th>식자재단위</th>
		</tr>
		<%for(SupplierFoodVO food : foodList){ %>
		<tr>
			<td><%=food.getSupplier_business_number() %></td>
			<td><a href="foodYesNoDetail.do?supplier_food_code=<%=food.getSupplier_food_code()%>"><%=food.getSupplier_food_name() %></a></td>
			<td><%=food.getSupplier_food_price() %></td>
			<td><%=food.getSupplier_food_unit() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>