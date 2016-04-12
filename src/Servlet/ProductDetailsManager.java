package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import Object.ProductDetails;
import Object.defaultValues;


public class ProductDetailsManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailsManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Set writer 
		RequestDispatcher dispatcher = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();		
		String action = request.getParameter("action");
		String id = request.getParameter("id");		
		switch (action) {
		case "confirmedit":
			try {
				
				String network = request.getParameter("network");
				String launchdate = request.getParameter("launchdate");
				String dimenison = request.getParameter("dimenison");
				float weight = Float.valueOf(request.getParameter("weight"));
				String simcard = request.getParameter("simcard");
				String displaytype = request.getParameter("displaytype");
				String displaysize = request.getParameter("displaysize");
				String displayresolution = request.getParameter("displayresolution");
				String touchscreen = request.getParameter("touchscreen");
				String os = request.getParameter("os");
				String chipset = request.getParameter("chipset");
				String gpu = request.getParameter("gpu");
				String internalmemory = request.getParameter("internalmemory");
				String externalsd = request.getParameter("externalsd");
				String primarycamera = request.getParameter("primarycamera");
				String camerafeature = request.getParameter("camerafeature");
				String video = request.getParameter("video");
				String secondarycamera = request.getParameter("secondarycamera");
				String soundtype = request.getParameter("soundtype");
				String speaker = request.getParameter("speaker");
				int jack35 = Integer.valueOf(request.getParameter("jack35"));
				String wifi = request.getParameter("wifi");
				String bluetooth = request.getParameter("bluetooth");
				String gps = request.getParameter("gps");
				String usb = request.getParameter("usb");
				String otherconnection = request.getParameter("otherconnection");
				String sensor = request.getParameter("sensor");
				String mutimedia = request.getParameter("mutimedia");
				String battery = request.getParameter("battery");
				String standby = request.getParameter("standby");
				String accessories = request.getParameter("accessories");
				String otherdescription = request.getParameter("otherdescription");
				String productName = request.getParameter("productName");
				ProductDetails prodl3 = ProductDetails.getProductDetailByID(id);
				ProductDetails prodl2 = new ProductDetails(id, network, launchdate, dimenison, weight, simcard, displaytype, displaysize, displayresolution, touchscreen, os, chipset, gpu, externalsd, internalmemory, primarycamera, camerafeature, video, secondarycamera, soundtype, speaker, wifi, bluetooth, gps, usb, sensor, mutimedia, battery, standby, otherdescription, productName, jack35, accessories, otherconnection);	
				if(prodl3.updateProductDetail(prodl2)){					
					response.setHeader("Refresh", "3; url=ProductDetailUI");					
					out.println("<!doctype html>");
					out.println("<HTML>");
					out.println("<head>");
					out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"); 
					out.println("<meta charset=\"utf-8\">");
					out.println("</head>");
				    out.println("<BODY align=\"center\">");
				    out.println("Đã cập nhật thành công đối tượng có ID: "+id+"<br>");
				    out.println("Sẽ tự động chuyển trang trong vòng 3 giây nữa<BR>");				    
				    out.println("<a href=\"ProductDetailUI\">Nhấn vào đây nếu trình duyệt không tự động chuyển trang</a>");
				    out.println("</BODY>");
				    out.println("</HTML>");				
				}else{
					response.setHeader("Refresh", "3; url=AddDetail");
					//out.print(prodl2.getDetailID());
					//out.print(prodl3.getDetailID());
					out.println("<!doctype html>");
					out.println("<HTML>");
					out.println("<head>");
					out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"); 
					out.println("<meta charset=\"utf-8\">");
					out.println("</head>");
				    out.println("<BODY align=\"center\">");
				    out.println("Cập nhật đối tượng không thành công, vui lòng thử lại"+"<br>");
				    out.println("Sẽ tự động chuyển trang trong vòng 3 giây nữa<BR>");				    
				    out.println("<a href=\"ProductDetailUI\">Nhấn vào đây nếu trình duyệt không tự động chuyển trang</a>");
				    out.println("</BODY>");
				    out.println("</HTML>");	
				}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			break;
		case "edit":
			ProductDetails p = null;
			try {
				p = ProductDetails.getProductDetailByID(request.getParameter("id"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.setAttribute("prodl", p);
			dispatcher = getServletContext().getRequestDispatcher("/EditDetail");			
			dispatcher.forward(request, response);
			break;
		case "delete":		
			ProductDetails prodl = new ProductDetails();
			prodl.setDetailID(id);
			try {
				prodl.deleteProductDetail();
				response.setHeader("Refresh", "3; url=ProductDetailUI");
				out.println("<!doctype html>");
				out.println("<HTML>");
				out.println("<head>");
				out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");				 
				 
				out.println("<meta charset=\"utf-8\">");
				out.println("</head>");
			    out.println("<BODY align=\"center\">");
			    out.println("Đã xóa đối tượng có ID: "+id+"<br>");
			    out.println("Sẽ tự động chuyển trang trong vòng 3 giây nữa<BR>");
			    out.println("<a href=\"ProductDetailUI\">Nhấn vào đây nếu trình duyệt không tự động chuyển trang</a>");
			    out.println("</BODY>");
			    out.println("</HTML>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "view":	
			
			dispatcher = getServletContext().getRequestDispatcher("/ViewDetailUI");	
			request.setAttribute("id", id);
			dispatcher.forward(request, response);
			break;	
		case "add":
			dispatcher = getServletContext().getRequestDispatcher("/AddDetail");
			dispatcher.forward(request, response);
			break;
		case "confirmadd":		
			try {
				new defaultValues();
				String dtl = defaultValues.getDefaultValue("productdetails");
				String cur = defaultValues.getDefaultValue("currentproductdetail");
				String detailid = dtl+cur;
				String network = request.getParameter("network");
				String launchdate = request.getParameter("launchdate");
				String dimenison = request.getParameter("dimenison");
				float weight = Float.valueOf(request.getParameter("weight"));
				String simcard = request.getParameter("simcard");
				String displaytype = request.getParameter("displaytype");
				String displaysize = request.getParameter("displaysize");
				String displayresolution = request.getParameter("displayresolution");
				String touchscreen = request.getParameter("touchscreen");
				String os = request.getParameter("os");
				String chipset = request.getParameter("chipset");
				String gpu = request.getParameter("gpu");
				String internalmemory = request.getParameter("internalmemory");
				String externalsd = request.getParameter("externalsd");
				String primarycamera = request.getParameter("primarycamera");
				String camerafeature = request.getParameter("camerafeature");
				String video = request.getParameter("video");
				String secondarycamera = request.getParameter("secondarycamera");
				String soundtype = request.getParameter("soundtype");
				String speaker = request.getParameter("speaker");
				int jack35 = Integer.valueOf(request.getParameter("jack35"));
				String wifi = request.getParameter("wifi");
				String bluetooth = request.getParameter("bluetooth");
				String gps = request.getParameter("gps");
				String usb = request.getParameter("usb");
				String otherconnection = request.getParameter("otherconnection");
				String sensor = request.getParameter("sensor");
				String mutimedia = request.getParameter("mutimedia");
				String battery = request.getParameter("battery");
				String standby = request.getParameter("standby");
				String accessories = request.getParameter("accessories");
				String otherdescription = request.getParameter("otherdescription");
				String productName = request.getParameter("productName");
				ProductDetails prodl2 = new ProductDetails(detailid, network, launchdate, dimenison, weight, simcard, displaytype, displaysize, displayresolution, touchscreen, os, chipset, gpu, externalsd, internalmemory, primarycamera, camerafeature, video, secondarycamera, soundtype, speaker, wifi, bluetooth, gps, usb, sensor, mutimedia, battery, standby, otherdescription, productName, jack35, accessories, otherconnection);	
				if(prodl2.insertProductDetail()){					
					response.setHeader("Refresh", "3; url=ProductDetailUI");					
					out.println("<!doctype html>");
					out.println("<HTML>");
					out.println("<head>");
					out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"); 
					out.println("<meta charset=\"utf-8\">");
					out.println("</head>");
				    out.println("<BODY align=\"center\">");
				    out.println("Đã thêm thành công đối tượng có ID: "+detailid+"<br>");
				    out.println("Sẽ tự động chuyển trang trong vòng 3 giây nữa<BR>");				    
				    out.println("<a href=\"ProductDetailUI\">Nhấn vào đây nếu trình duyệt không tự động chuyển trang</a>");
				    out.println("</BODY>");
				    out.println("</HTML>");				
				}else{
					response.setHeader("Refresh", "3; url=AddDetail");
					out.println("<!doctype html>");
					out.println("<HTML>");
					out.println("<head>");
					out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"); 
					out.println("<meta charset=\"utf-8\">");
					out.println("</head>");
				    out.println("<BODY align=\"center\">");
				    out.println("Thêm đối tượng không, vui lòng thử lại"+"<br>");
				    out.println("Sẽ tự động chuyển trang trong vòng 3 giây nữa<BR>");				    
				    out.println("<a href=\"AddDetail\">Nhấn vào đây nếu trình duyệt không tự động chuyển trang</a>");
				    out.println("</BODY>");
				    out.println("</HTML>");	
				}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				
			
			
		
			break;
		default:
			break;
		}
	}

}
