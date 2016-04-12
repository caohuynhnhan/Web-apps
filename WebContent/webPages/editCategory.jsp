<%@page import="Model.ConnectDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Object.Categorys"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/foundation.css" />
<link rel="stylesheet" type="text/css" href="css/foundation.min.css" /> 
<link rel="stylesheet" type="text/css" href="css/foundation-flex.css" /> 
<link rel="stylesheet" type="text/css" href="css/foundation-rtl.css" /> 

<title>Add Product</title>
</head>

<body>
<h1 align="center">Quản lí danh mục</h1>
<% String id = request.getParameter("catid"); %>
<% Categorys cat = new Categorys().getCategoryByID(id); %>
<form action="CategorysManager" method="post">
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="catid" value="<%=cat.getCategoryID()%>">
	<%
		int t = cat.getType();
		String tvalue ="";
		switch(t){
		case 1:
			tvalue = "Điện thoại";
			break;
		case 2:
			tvalue = "Máy tính bảng";
			break;
		case 3:
			tvalue = "Phụ kiện";
			break;
		case 4:
			tvalue = "Bài viết";
			break;
		}
	%>
	<table>
		<tr>
			<th>Các thuộc tính</th>
			<th>Mã danh mục</th>
			<th>Tên danh mục</th>
			<th>Loại</th>
			<th>Mô tả</th>
		</tr>
		
		<tr>
			<td>Giá trị cũ</td>
			<td><%= cat.getCategoryID() %></td>
			<td><%= cat.getCategoryName() %></td>
			<td><%=tvalue %>
			<td><%= cat.getDescription() %></td>
		</tr>
		<tr>
			<td>Giá trị mới</td>
			<td><input type="text" placeholder="Không thể đổi giá trị này" readonly/></td>
			<td><input type="text" placeholder="Tên danh mục mới" name="catname" value="<%= cat.getCategoryName() %>"/></td>
			<td><select name="type">
        		<option value=1>Điện thoại</option>
        		<option value=2>Máy tính bảng</option>
        		<option value=3>Phụ kiện</option>
        		<option value=4>Bài viết</option>
        		</select>
        	</td>
			<td><input type="text" placeholder="Mô tả mới" name="catdes" value="<%= cat.getDescription() %>"/></td>
		</tr>
		<tr>
			<td colspan="5" align="center">
				<input class="medium success button"  type="submit" value="Xác nhận thay đổi"/>
				<input class="medium alert button" type="reset" value="Làm lại"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>
