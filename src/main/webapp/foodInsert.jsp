<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String url = (String) request.getAttribute("url");
	String supplier_business_number = (String) session.getAttribute("supplier_business_number");
	String supplier_name = (String) session.getAttribute("supplier_name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>Insert title here</title>
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
	<table id="customers" class="custom">
		<form action="upload.do" method="post" enctype="multipart/form-data">
			<tr>
				<th>사진
				</td>
				<td><input type="file" name="file1"></td>
				<td><input type="submit" value="사진등록" class="btn btn-success"></td>
			</tr>
		</form>
		<form action="insertSupplierFood.do" method="post">
			<tr>
				<th>식자재명</th>
				<td colspan="2"><input type="text" name="supplier_food_name"></td>
			</tr>
			<tr>
				<th>식자재 설명</th>
				<td colspan="2"><input type="text" name="supplier_food_comment"></td>
			</tr>
			<tr>
				<th>식자재 재고</th>
				<td colspan="2"><input type="text" name="supplier_food_stock"></td>
			</tr>
			<tr>
				<th>식자재 가격</th>
				<td colspan="2"><input type="text" name="supplier_food_price"></td>
			</tr>
			<tr>
				<th>식자재 단위</th>
				<td colspan="2"><input type="text" name="supplier_food_unit"></td>
			</tr>
			<tr>
				<th>식자재 사진</th>
				<td colspan="2"><input type="hidden" name="supplier_food_image"
					value="<%=url%>"><%=url%></td>
			</tr>
			<tr>
				<td colspan="3" style="text-align: center"><input type="hidden"
					name="supplier_business_number"
					value="<%=supplier_business_number%>"> <input type="hidden"
					name="supplier_food_yesno" value="승인대기중"> <input
					class="btn btn-success" type="submit" value="등록"></td>
			</tr>
		</form>
	</table>

</body>
</html>