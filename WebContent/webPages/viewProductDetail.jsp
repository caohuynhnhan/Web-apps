<%@page import="Object.ProductDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html  class="no-js" lang="vi">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/foundation.css" />
<link rel="stylesheet" type="text/css" href="css/foundation.min.css" /> 
<link rel="stylesheet" type="text/css" href="css/foundation-flex.css" /> 
<link rel="stylesheet" type="text/css" href="css/foundation-rtl.css" /> 
</head>
<body>

<%  
	String id = (String)request.getParameter("id");
	ProductDetails prodl = new ProductDetails().getProductDetailByID(id);	
%>
<table border="1">
	<tr>
		<td>Tên máy</td>
		<td colspan="2"><%=prodl.getProductName() %></td>
	</tr>
	<tr>		
		<td>Mạng</td>
		<td>Loại mạng</td>
		<td><%=prodl.getNetwork() %></td>
	</tr>
	<tr>
		<td>Ngày ra mắt</td>
		<td colspan="2"><%=prodl.getLaunchDate() %></td>
		
	</tr>
	<tr>
		<td rowspan="3">Thân máy</td>
		<td>Kích thước</td>
		<td><%=prodl.getDimenison() %></td>		
	</tr>
	<tr>		
		<td>Trọng lượng</td>		 
		<td><%=prodl.getWeight()+" gram" %></td>		
	</tr>
	<tr>		
		<td>SIM</td>
		<td><%=prodl.getSimCard() %></td>		
	</tr>


	<tr>
		<td rowspan="4">Màn hình</td>
		<td>Loại màn hình</td>
		<td><%=prodl.getDisplayType() %></td>		
	</tr>
	<tr>		
		<td>Kích thước</td>
		<td><%=prodl.getDisplaySize() %></td>		
	</tr>
	<tr>		
		<td>Độ phân giải</td>
		<td><%=prodl.getDisplayResolution() %></td>		
	</tr>	
	<tr>		
		<td>Cảm ứng</td>
		<td><%=prodl.getTouchScreen() %></td>		
	</tr>
	<tr>
		<td rowspan="3">Nền tảng</td>
		<td>Hệ điều hành</td>
		<td><%=prodl.getOs() %></td>		
	</tr>
	<tr>		
		<td>Chipset/CPU</td>
		<td><%=prodl.getChipset() %></td>		
	</tr>
	<tr>		
		<td>GPU</td>
		<td><%=prodl.getGpu() %></td>		
	</tr>	
	<tr>
		<td rowspan="2">Bộ nhớ</td>
		<td>Bộ nhớ trong</td>
		<td><%=prodl.getInternalMemory() %></td>		
	</tr>
	<tr>		
		<td>Thẻ nhớ ngoài</td>
		<td><%=prodl.getExternalSD() %></td>		
	</tr>
	<tr>
		<td rowspan="4">Camera</td>
		<td>Camera chính</td>
		<td><%=prodl.getPrimaryCamera() %></td>		
	</tr>
	<tr>		
		<td>Tính năng</td>
		<td><%=prodl.getCameraFeatures() %></td>		
	</tr>
	<tr>		
		<td>Quay phim</td>
		<td><%=prodl.getVideo() %></td>		
	</tr>
	<tr>		
		<td>Camera phụ</td>
		<td><%=prodl.getSecondaryCamera() %></td>		
	</tr>
	<tr>
		<td rowspan="3">Âm thanh</td>
		<td>Hỗ trợ</td>
		<td><%=prodl.getSoundType() %></td>		
	</tr>
	<tr>		
		<td>Loa ngoài</td>
		<td><%=prodl.getSpeaker() %></td>		
	</tr>
	<tr>		
		<td>Cổng 3.5mm</td>
		<td><%=prodl.getJack35()==1?"Có":"Không" %></td>		
	</tr>
	
	<tr>
		<td rowspan="5">Kết nối</td>
		<td>Wifi</td>
		<td><%=prodl.getWifi() %></td>		
	</tr>
	<tr>		
		<td>Bluetooth</td>
		<td><%=prodl.getBluetooth() %></td>		
	</tr>
	<tr>		
		<td>Định vị</td>
		<td><%=prodl.getGps() %></td>		
	</tr>
	<tr>		
		<td>USB</td>
		<td><%=prodl.getUsb() %></td>		
	</tr>
	<tr>		
		<td>Khác</td>
		<td><%=prodl.getOtherconnection() %></td>		
	</tr>

	<tr>
		<td rowspan="2">Đặc điểm</td>
		<td>Cảm biến</td>
		<td><%=prodl.getSensor() %></td>		
	</tr>
	<tr>		
		<td>Giải trí</td>
		<td><%=prodl.getMultimeia() %></td>		
	</tr>
	<tr>
		<td rowspan="2">Pin</td>
		<td>Dung lượng</td>
		<td><%=prodl.getBattery() %></td>		
	</tr>
	<tr>		
		<td>Thời gian chờ</td>
		<td><%=prodl.getStandby() %></td>		
	</tr>
	<tr>
		<td>Bộ sản phẩm</td>
		<td>Phụ kiện</td>
		<td><%=prodl.getAccessories() %></td>		
	</tr>

	<tr>
		<td>Thông tin khác</td>
		<td colspan="2"><%=prodl.getOtherDescription() %></td>
			
	</tr>
	

</table>
</body>
</html>