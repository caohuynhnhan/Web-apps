<%@page import="Object.Products"%>
<%@page import="Model.ConnectDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Object.Categorys" %>
<%@page import="Object.ProductDetails" %>
<%@page import="Object.Colors" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include flush="true" page="/Header"/>
<!doctype html>
<html  class="no-js" lang="vi">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/foundation.css" />
<link rel="stylesheet" type="text/css" href="css/foundation.min.css" /> 
<link rel="stylesheet" type="text/css" href="css/foundation-flex.css" /> 
<link rel="stylesheet" type="text/css" href="css/foundation-rtl.css" /> 
<title></title>
</head>
<body>
<%
	String id = (String)request.getAttribute("id"); 
	Products pro = new Products().getProductByID(id);
%>
<form action="ProductManager" method="post">
<input type="hidden" name="action" value="confirmedit">
<input type="hidden" name="oldid" value="<%=pro.getProductID()%>">

<table>
	<tr>
		<th colspan="4">Thêm sản phẩm</th>
	</tr>
	<tr>
		<td>Mã sản phẩm (9 kí tự):</td>
		<td align="left"><input type="text" name="id" placeholder="9 kí tự (Tự động sinh nếu bỏ trống)" value="<%=pro.getProductID()%>"></td>
		
		<td>Danh mục:</td>
		<td align="left">
			<select name="cat">
				
				<option value="<%=pro.getCategory()%>"><%=new Categorys().getCategoryByID(pro.getCategory()).getCategoryName()+" (Cũ)"%></option>
				<% ArrayList<Categorys> lst = new Categorys().getAllCategory(); %>
				<%for(Categorys cat:lst){ %>
				<option value="<%=cat.getCategoryID()%>"><%=cat.getCategoryName() %></option>
				<%} %>
			</select>
		</td>
	</tr>
	<tr>
		<td>Tên sản phẩm:</td>
		<td align="left"><input type="text" name="name" placeholder="Ví dụ: Iphone 6S 64GB" value="<%=pro.getProductName()%>"></td>
		<td>Chi tiết:</td>
		<td align="left">
			<select name="detail">
				<option value="<%=pro.getProductDetail()%>"><%=new ProductDetails().getProductDetailByID(pro.getProductDetail()).getProductName()+" (cũ)" %></option>
				<% ArrayList<ProductDetails> lstd = new ProductDetails().getAllProductDetail(); %>
				<%for(ProductDetails prodl:lstd){ %>
				<option value="<%=prodl.getDetailID()%>"><%=prodl.getProductName() %></option>
				<%} %>
			</select>
		</td>
	</tr>
	<tr>
		<td>Bộ nhớ:</td>
		<td align="left"><input type="text" name="storage" placeholder="Ví dụ: 64GB/2GB" value="<%=pro.getStorage()%>"></td>
		<td>Bảo hành:</td>
		<td align="left"><input type="number" value=12 name="war" value="<%=pro.getWarranty()%>"></td>
	</tr>
	<tr>
		<td>Màu sắc:</td>
		<td align="left">
			<select name="color">
				<option value="<%=pro.getColor() %>"><%=pro.getColor() +" (cũ)"%></option>
			<%
				ArrayList<Colors> lstc = new Colors().getAllColor();
				for(Colors c:lstc){
			%>
				<option value="<%=c.getValue() %>"><%=c.getValue() %></option>
			<%} %>
			</select>
		</td>
		<td>Giá:</td>
		<td align="left"><input min="0" max="1000000" required type="number" name="price" placeholder="Đơn vị nghìn đồng" value="<%=pro.getPrice()%>"></td>
	</tr>
	<tr align="center">
		<td colspan="4">
			<input class="medium success button" type="submit" value="Lưu thay đổi">
			<input class="medium alert button" type="reset" value="Xóa hết">
		</td>
	</tr>
</table>
</form>
</body>
</html>