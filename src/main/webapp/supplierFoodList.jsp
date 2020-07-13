<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%@page import="com.food.biz.supplier.SupplierFoodVO" %>
    <%
    List<SupplierFoodVO> foodList = (List) request.getAttribute("foodList");
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
<table id="customers" class="custom" >
	<tr>
		<th>식자재사진</th>
		<th>식자재명</th>
		<th>식자재가격</th>
		<th>식자재승인여부</th>
	</tr>
	<%for(SupplierFoodVO food : foodList){ %>
	<tr>
		<td><img
					src="http://localhost:8080\biz\img\<%=food.getSupplier_food_image()%>"
					style="width: 300px; height: 300px"
					/></td>
		<td><%=food.getSupplier_food_name() %></td>
		<td><%=food.getSupplier_food_price() %></td>
		<td><%if(food.getSupplier_food_yesno().equals("승인대기중")){ %>
		승인대기중
		<%}else if(food.getSupplier_food_yesno().equals("승인")){ %>
		승인
		<%}else if(food.getSupplier_food_yesno().equals("거절")){ %>
		거절
		<%} %>
		</td>
	</tr>
	<%} %>
</table>
</body>
</html>