<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.food.biz.supplier.SupplierFoodVO"%>
<%@page import="com.food.biz.food.FoodVO"%>
<%
	List<FoodVO> foodList = (List) request.getAttribute("foodList");
	SupplierFoodVO food = (SupplierFoodVO) request.getAttribute("food");
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
	<form action="foodYes.do" method="post">
		<table id="customers" class="custom">
			<tr>
				<th>식자재 사진</th>
				<td><img
					src="http://localhost:8080\biz\img\<%=food.getSupplier_food_image()%>"
					style="width: 300px; height: 300px" /></td>
			</tr>
			<tr>
				<th>식자재명</th>
				<td><%=food.getSupplier_food_name()%></td>
			</tr>
			<tr>
				<th>식자재 설명</th>
				<td><%=food.getSupplier_food_comment()%></td>
			</tr>
		<tr>
			<th>식자재 재고</th>
			<td><%=food.getSupplier_food_stock()%></td>
		</tr>
		<tr>
			<th>식자재 가격</th>
			<td><%=food.getSupplier_food_price()%></td>
		</tr>
		<tr>
			<th>식자재 단위</th>
			<td><%=food.getSupplier_food_unit()%></td>
		</tr>
		<tr>
            <th>식자재 재료</th>
            <td>
            <select style="width:100%" class="recipe_food"
					name="food_code">
               <%
               	for (FoodVO vo : foodList) {
               %>
                  <option value=<%=vo.getFood_code()%>>재표명:<%=vo.getFood_name()%>  단위:<%=vo.getFood_unit()%></option>
               <%
               	}
               %>
            </select>
            </td>
         </tr>
	</table>
	<input type="hidden" name="supplier_food_code"
			value="<%=food.getSupplier_food_code()%>">
	<input class="btn btn-success" type="submit" value="승인">
	</form>
<button class="btn btn-success"
		onclick="location.href='foodNo.do?supplier_food_code=<%=food.getSupplier_food_code()%>'">거절</button>
</body>
</html>