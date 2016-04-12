<%@page import="Model.ConnectDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Object.Categorys"%>
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
<title>Add Product</title>
</head>

<body>
<form id="form1" name="form1" method="POST" action="CategorysManager">
<input type="hidden" name="action" value="add"/>
  <table border="1" align="center"> 
    
      <tr>
        <th colspan="3" align="center">Thêm danh mục  sản phẩm</th>
      </tr>
      <tr>
        <!-- <td>Mã danh mục </td> --> 
        <td>Tên danh mục</td>
        <td>Loại</td>
        <td>Mô tả</td>        
      </tr>
      <tr>
      	<!-- <td><input required type="text" name="catid" placeholder="Tối đa 9 kí tự" width="100%"/></td> -->
        
        <td><input required type="text" name="catname" width=100%/></td>
        <td>
        	<select name="type">
        		<option value=1>Điện thoại</option>
        		<option value=2>Máy tính bảng</option>
        		<option value=3>Phụ kiện</option>
        		<option value=4>Bài viết</option>
        	</select>
        </td>
        <td><input type="text" name="catdes" width=100%/></td>        
      </tr>
      
      <tr>
        <td colspan="4" align="center">
        	
        	<input class="medium success button" name="submit" type="submit" id="submit" formmethod="POST" value="Xác nhận thêm">
        	<input class="medium alert button" type="reset" name="reset" id="reset" value="Làm lại"> 
        </td>
      </tr>
    
  </table>
</form>
<br>
<br>
<h3 align="center">Quản lí danh mục</h3>
<table border="1" align="center">
	<tr>
		<th>Mã danh mục</th>
		<th>Tên danh mục</th>
		<th>Loại</th>
		<th>Mô tả</th>
		<th>Hành động</th>
	</tr>
<% ArrayList<Categorys> lst = new Categorys().getAllCategory(); %>
<%for(Categorys cat:lst){ %>
<% int d = cat.getType();
	String dvalue = "";
switch(d){
case 1:
	dvalue = "Điện thoại";
	break;
case 2:
	dvalue = "Máy tính bảng";
	break;
case 3:
	dvalue = "Phụ kiện";
	break;
case 4:
	dvalue = "Bài viết";
	break;
}
%>

<% String editURL = "EditCategoryUI?catid="+cat.getCategoryID(); %>
<% String deleteURL = "CategorysManager?action=delete&deleteID="+cat.getCategoryID(); %>
	<tr>
		<td align="center"><%=cat.getCategoryID() %></td>
		<td align="center"><%=cat.getCategoryName() %></td>
		<td align="center"><%=dvalue %></td>
		<td align="center"><%= cat.getDescription() %></td>
		<td align="center">
			<div class="button-group" align="center">
				<a class="alert button" onclick="Delete();" href="<%=deleteURL%>">Xóa</a>&emsp;<a class="success button" href="<%=editURL%>">Sửa</a>
			</div>
			
		</td>
	</tr>
		
	

<%} %>
</table>


</body>
</html>
