<%@page import="Object.ProductDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/foundation.css" />
<link rel="stylesheet" type="text/css" href="css/foundation.min.css" /> 
<link rel="stylesheet" type="text/css" href="css/foundation-flex.css" /> 
<link rel="stylesheet" type="text/css" href="css/foundation-rtl.css" /> 

<title>Add Product</title>

</head>
<body>


	<form action="ProductDetailsManager" method="post">
	<input type="hidden" name="action" value="confirmadd">
		<table border="1">
			<tr align="center">
				<td colspan="3"><h3>Cấu hình chi tiết</h3></td>
			</tr>
			<tr align="center">				
				<td>Tên máy</td>				
				<td colspan="2"><input name="productName" value="" type="text" placeholder="Apple iPhone 6s plus"></td>
			</tr>
			<tr align="center">
				
				<td>Mạng</td>
				<td>Loại mạng</td>
				<td><input name="network" value="2G/3G/4G" type="text" placeholder="2G/3G/4G"></td>
			</tr>
			<tr align="center">
				<td>Ngày ra mắt</td>
				<td colspan="2"><input type="month" name="launchdate" value="2016-08"></td>
				
			</tr>
			<tr align="center">
				<td rowspan="3">Thân máy</td>
				<td>Kích thước</td>
				<td><input name="dimenison" value="120x85x7.5mm" type="text" placeholder="Chiều dài x chiều rộng x chiều sâu"></td>		
			</tr>
			<tr align="center">		
				<td>Trọng lượng (gram)</td>		 
				<td><input name="weight" value=0 type="number"></td>		
			</tr>
			<tr align="center">		
				<td>SIM</td>
				<td><input name="simcard" value="" type="text" placeholder="2xNano Sim"></td>		
			</tr>
		
		
			<tr align="center">
				<td rowspan="4">Màn hình</td>
				<td>Loại màn hình</td>
				<td><input name="displaytype" value="" type="text" placeholder="IPS LCD true HD, kính cường lực Gorilla glass 3"></td>		
			</tr>
			<tr align="center">		
				<td>Kích thước</td>
				<td><input name="displaysize" value="" type="text" placeholder="5.5 inches"></td>		
			</tr>
			<tr align="center">		
				<td>Độ phân giải</td>
				<td><input name="displayresolution" value="" type="text" placeholder="2K, 2556x1440 pixel"></td>		
			</tr>	
			<tr align="center">		
				<td>Cảm ứng</td>
				<td><input name="touchscreen" value="" type="text" placeholder="Có, cảm ứng điện dung đa điểm"></td>		
			</tr>
			<tr align="center">
				<td rowspan="3">Nền tảng</td>
				<td>Hệ điều hành</td>
				<td><input name="os" value="" type="text" placeholder="Android 5.0 Lolipop, update to 6.0 Marshmallow"></td>		
			</tr>
			<tr align="center">		
				<td>Chipset/CPU</td>
				<td><input name="chipset" value="" type="text" placeholder="Snapdragon S810"></td>		
			</tr>
			<tr align="center">		
				<td>GPU</td>
				<td><input name="gpu" value="" type="text" placeholder="Adreno 350"></td>		
			</tr>	
			<tr align="center">
				<td rowspan="2">Bộ nhớ</td>
				<td>Bộ nhớ trong</td>
				<td><input name="internalmemory" value="" type="text" placeholder="64GB lưu trữ, 4GB RAM"></td>		
			</tr>
			<tr align="center">		
				<td>Thẻ nhớ ngoài</td>
				<td><input name="externalsd" value="" type="text" placeholder="Có, hỗ trợ tối đa 128GB"></td>		
			</tr>
			<tr align="center">
				<td rowspan="4">Camera</td>
				<td>Camera chính</td>
				<td><input name="primarycamera" value="" type="text" placeholder="24 Megapixel"></td>		
			</tr>
			<tr align="center">		
				<td>Tính năng</td>
				<td><input name="camerafeature" value="" type="text" placeholder="Auto focus, laser focus, geo-tagging, face-detecting"></td>		
			</tr>
			<tr align="center">		
				<td>Quay phim</td>
				<td><input name="video" value="" type="text" placeholder="hỗ trợ quay phim 4K 60fps"></td>		
			</tr>
			<tr align="center">		
				<td>Camera phụ</td>
				<td><input name="secondarycamera" value="" type="text" placeholder="5 Megapixel, f2.0"></td>		
			</tr>
			<tr align="center">
				<td rowspan="3">Âm thanh</td>
				<td>Hỗ trợ</td>
				<td><input name="soundtype" value="" type="text" placeholder="wav, mp3, acc"></td>		
			</tr>
			<tr align="center">		
				<td>Loa ngoài</td>
				<td><input name="speaker" value="" type="text" placeholder="Có, công nghệ Dolby Audio"></td>		
			</tr>
			<tr align="center">		
				<td>Cổng 3.5mm</td>
				<td>
					<select name="jack35">
						<option value=1>Có</option>
						<option value=0>Không có</option>
					</select>
				</td>		
			</tr>
			
			<tr align="center">
				<td rowspan="5">Kết nối</td>
				<td>Wifi</td>
				<td><input name="wifi" value="" type="text" placeholder="Có, hỗ trợ chuẩn a/b/g/n/ac"></td>		
			</tr>
			<tr align="center">		
				<td>Bluetooth</td>
				<td><input name="bluetooth" value="" type="text" placeholder="Có, BT 4.0"></td>		
			</tr>
			<tr align="center">		
				<td>Định vị</td>
				<td><input name="gps" value="" type="text" placeholder="Có, GPS, Glonass"></td>		
			</tr>
			<tr align="center">		
				<td>USB</td>
				<td><input name="usb" value="" type="text" placeholder="USB 2.0, OTG support"></td>		
			</tr>
			<tr align="center">		
				<td>Khác</td>
				<td><input name="otherconnection" value="" type="text" placeholder="NFC, Radio with RDS, IR sensor"></td>		
			</tr>
		
			<tr align="center">
				<td rowspan="2">Đặc điểm</td>
				<td>Cảm biến</td>
				<td><input name="sensor" value="" type="text" placeholder="Tiệm cận, ánh sáng, la bàn số, con quay hồi chuyển"></td>		
			</tr>
			<tr align="center">		
				<td>Giải trí</td>
				<td><input name="mutimedia" value="" type="text" placeholder="Video đa định dạng, Email, Lịch, Ghi chú..." ></td>		
			</tr>
			<tr align="center">
				<td rowspan="2">Pin</td>
				<td>Dung lượng</td>
				<td><input name="battery" value="" type="text" placeholder="4000 mAh"></td>		
			</tr>
			<tr align="center">		
				<td>Thời gian chờ</td>
				<td><input name="standby" value="" type="text" placeholder="200h 2G, 182h 3G"></td>		
			</tr>
			<tr align="center">
				<td>Bộ sản phẩm</td>
				<td>Phụ kiện</td>
				<td><input name="accessories" value="" type="text" placeholder="Sạc, cáp, tai nghe, sách hướng dẫn, dock sạc"></td>		
			</tr>	
			<tr align="center">
				<td>Thông tin khác</td>
				<td colspan="2"><input name="otherdescription" value="" type="text" placeholder="Free 50GB Google Drive in 2 years"></td>				
			</tr>
				
			<tr align="center">
				<td colspan="3">
					<input type="submit" class="medium success button" value="Xác nhận">
					<input type="reset" class="medium alert button" value="Xóa hết">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>