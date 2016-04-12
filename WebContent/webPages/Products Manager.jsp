<%@page import="Object.ProductDetails"%>
<%@page import="Object.Colors"%>
<%@page import="Object.Categorys"%>
<%@page import="Model.ConnectDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Object.Products"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include flush="true" page="/Header"/>
<!doctype html>
<html  class="no-js" lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/foundation.css" />
<link rel="stylesheet" type="text/css" href="css/foundation.min.css" /> 
<link rel="stylesheet" type="text/css" href="css/foundation-flex.css" /> 
<link rel="stylesheet" type="text/css" href="css/foundation-rtl.css" /> 
<script language="javascript">
	function Delete()
	{
		var agree = confirm("Bạn có chắc muốn xóa?");
		if (agree)
			return true ;
		else
			return false ;
	}
</script>
<title>Product</title>
</head>

<body>
<form action="ProductManager" method="post" >
<input type="hidden" name="action" value="add">
<table>
	<tr>
		<th colspan="4">Thêm sản phẩm</th>
	</tr>
	<tr>
		<td>Tên sản phẩm:</td>
		<td align="left"><input required type="text" name="name" placeholder="Ví dụ: Iphone 6S 64GB"></td>
		
		<td>Danh mục:</td>
		<td align="left">
			<select name="cat">
				<% ArrayList<Categorys> lst = new Categorys().getAllCategory(); %>
				<%for(Categorys cat:lst){ %>
					<option value="<%=cat.getCategoryID()%>"><%=cat.getCategoryName() %></option>
				<%} %>
			</select>
		</td>
	</tr>
	<tr>
		
		
		<td>Chi tiết:</td>
		<td align="left">
			<select name="detail">
				<% ArrayList<ProductDetails> lstd = new ProductDetails().getAllProductDetail(); %>
				<%for(ProductDetails prodl:lstd){ %>
					<option value="<%=prodl.getDetailID()%>"><%=prodl.getProductName() %></option>
				<%} %>
			</select>
		</td>
		<td>Màu sắc:</td>
		<td align="left">
			<select name="color">
			<%
				ArrayList<Colors> lstc = new Colors().getAllColor();
				for(Colors c:lstc){
			%>
				<option value="<%=c.getValue() %>"><%=c.getValue() %></option>
			<%} %>
			</select>
		</td>
	</tr>
	<tr>
		<td>Bộ nhớ:</td>
		<td align="left"><input type="text" name="storage" placeholder="Ví dụ: 64GB/2GB"></td>
		<td>Bảo hành:</td>
		<td align="left"><input type="number" value=12 name="war"></td>
	</tr>
	<tr>
		
		<td>Giá:</td>
		<td align="left"><input required type="number" name="price" placeholder="Đơn vị nghìn đồng"></td>
	</tr>
	<tr align="center">
		<td colspan="4">
			<input class="medium success button" type="submit" value="Xác nhận thêm">
			<input class="medium alert button" type="reset" value="Xóa hết">
		</td>
	</tr>
</table>
</form>

<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->

<table>
	<tr><th colspan="9"><h3>Danh sách sản phẩm</h3></th></tr>
	<tr>
		<th>Mã sản phẩm</th>
		<th>Tên sản phẩm</th>
		<th>Danh mục</th>
		<th>Chi tiết</th>
		<th>Bộ nhớ</th>
		<th>Màu sắc</th>
		<th>Bảo hành</th>		
		<th>Giá</th>
		<th>Ảnh sản phẩm</th>
		<th>Tùy chọn</th>
	</tr>
<% ArrayList<Products> lst2 = new Products().getAllProduct(); %>
<%for(Products pro:lst2){ %>
	<tr align="center">
		
		<td><%=pro.getProductID() %></td>
		<td><%=pro.getProductName() %></td>
		<td><%=pro.getCategory() %></td>
		<td><%=pro.getProductDetail() %></td>
		<td><%=pro.getStorage() %></td>
		<td><%=pro.getColor() %></td>
		<td><%=pro.getWarranty() +" tháng"%></td>
		<td><%=pro.getPrice()+"000 VND" %></td>
		<td><a>link</a></td>
		<td>
			<form action="ProductManager" method="post">
				<input type="hidden" name="action" value="delete">
				<input type="hidden" name="id" value="<%=pro.getProductID()%>">
				<input class="small success button" type="submit" value="Xóa"> 
			</form>
			<form action="ProductManager" method="post">
			<input type="hidden" name="action" value="edit">
			<input type="hidden" name="id" value="<%=pro.getProductID()%>">
				<input class="small alert button" type="submit" value="Chỉnh sửa"> 
			</form>
		</td>		
	</tr>
	
		
	
<%} %>
</table>
</body>