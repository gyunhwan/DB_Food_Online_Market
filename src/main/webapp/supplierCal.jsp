<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.food.biz.supplier.CalVO"%>
<%
	List<CalVO> calList = (List) request.getAttribute("calList");
	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String today3 = formatter.format(new java.util.Date());
	java.text.SimpleDateFormat formatter2 = new java.text.SimpleDateFormat("dd");
	String today2 = formatter2.format(new java.util.Date());
	String lastDate2 = (String) request.getAttribute("lastDate");
	int frequency = (Integer) request.getAttribute("frequency");
	int today = (Integer.parseInt(today2));
	int lastDate = (Integer.parseInt(lastDate2));
	String supplier_business_number = (String) session.getAttribute("supplier_business_number");
	String supplier_name = (String) session.getAttribute("supplier_name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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


	<table id="customers" class="custom">

		<%
			if ((today - lastDate) >= frequency) {
		%><tr>
			<td><form action="supplierCal.do" method="post">
					<input type="hidden" name="supplier_business_number"
						value="<%=supplier_business_number%>"> <input
						type="hidden" name="cal_date" value="<%=today3%>"> <input
						type="hidden" name="lastDate" value="<%=lastDate%>"> <input
						type="submit" value="정산">
				</form></td>
		</tr>
		<%
			}
		%>

		<tr>
			<th>정산날짜</th>
			<th>정산가격</th>
		</tr>
		<%
			for (CalVO cal : calList) {
		%>
		<tr>
			<td><%=cal.getCal_date()%></td>
			<td><%=cal.getCal_price()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>