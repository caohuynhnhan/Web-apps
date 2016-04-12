<%@page import="Object.Products"%>
<%@page import="Model.ConnectDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Object.ProductDetails"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<title>Quản lí Chi tiết Sản phẩm</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/foundation.css" />
<link rel="stylesheet" type="text/css" href="css/foundation.min.css" /> 
<link rel="stylesheet" type="text/css" href="css/foundation-flex.css" /> 
<link rel="stylesheet" type="text/css" href="css/foundation-rtl.css" /> 
</head>

<body align="center">
	
	
<br>

	<h3>Danh sách Chi tiết sản phẩm</h3>
	<div align="right"> 
	<form action="ProductDetailsManager" method="post">
		<input type="hidden" name="action" value="add">
		<input type="submit" class="small success button" value="Chuyển đến trang nhập cấu hình">
	</form>
	</div>	
		
	<table>		
    	<tr align="center">
        	<th>Tên sản phẩm</th>
            <th>Màn hình</th>
            <th>CPU</th>
            <th>Bộ nhớ</th>
            <th>Camera</th>
            <th>Hành động</th>
            
        </tr>
		<% ArrayList<ProductDetails> lst = new ProductDetails().getAllProductDetail(); %>
		<%for(ProductDetails prdl:lst){ %>
		<%
			
			
		%>
        <tr>
        	<td><%=prdl.getProductName() %></td>
            <td><%=prdl.getDisplaySize() + " " + prdl.getDisplayResolution() %></td>
            <td><%=prdl.getChipset() %></td>
            <td><%=prdl.getInternalMemory() %></td>
            <td><%=prdl.getPrimaryCamera() %></td>
            
            <td>
            	<a class="small success button" href="ProductDetailsManager?action=view&id=<%=prdl.getDetailID() %>">Xem chi tiết</a>
            	<a class="small warning button" href="ProductDetailsManager?action=edit&id=<%=prdl.getDetailID() %>">Chỉnh sửa</a>
            	<a class="small alert button" href="ProductDetailsManager?action=delete&id=<%=prdl.getDetailID() %>">Xóa</a>
            	
                
            </td>

        </tr>
        <%} %>
        
    </table>

</body>
</html>
