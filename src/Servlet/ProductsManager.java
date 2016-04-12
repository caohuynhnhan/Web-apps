package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Object.Products;
import Object.defaultValues;

/**
 * Servlet implementation class ProductsManager
 */
@WebServlet("/ProductsManager")
public class ProductsManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		
		switch (action) {
		case "add":
			Products pro = null;
			try {
				String dtl = defaultValues.getDefaultValue("products");
				String cur = defaultValues.getDefaultValue("currentproduct");
				String id = dtl+cur;			
				String name = request.getParameter("name");
				String cat = request.getParameter("cat");
				String detail = request.getParameter("detail");
				String color = request.getParameter("color");
				int war = Integer.valueOf(request.getParameter("war"));				
				int price = Integer.valueOf(request.getParameter("price"));				
				String storage = request.getParameter("storage");
				
				pro = new Products(id, name, cat, detail, price, color, war, storage);
				if(pro.insertProduct()){
					response.setHeader("Refresh", "3; url=Products");
					out.println("<!doctype html>");
					out.println("<HTML>");
					out.println("<head>");
					out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");		 
					out.println("<meta charset=\"utf-8\">");
					out.println("</head>");
				    out.println("<BODY align=\"center\">");
				    out.println("Đã thêm thành công đối tượng có ID: "+id+"<br>");
				    out.println("Sẽ tự động chuyển trang trong vòng 3 giây nữa<BR>");
				    out.println("<a href=\"Products\">Nhấn vào đây nếu trình duyệt không tự động chuyển trang</a>");
				    out.println("</BODY>");
				    out.println("</HTML>");
			    }else {
			    	response.setHeader("Refresh", "3; url=Products");
					out.println("<!doctype html>");
					out.println("<HTML>");
					out.println("<head>");
					out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");		 
					out.println("<meta charset=\"utf-8\">");
					out.println("</head>");
				    out.println("<BODY align=\"center\">");				    
				    out.println("Đã xảy ra lỗi khi thêm đối tượng có ID: "+id+"<br>");
				    out.println("Sẽ tự động chuyển trang trong vòng 3 giây nữa<BR>");
				    out.println("<a href=\"Products\">Nhấn vào đây nếu trình duyệt không tự động chuyển trang</a>");
				    out.println("</BODY>");
				    out.println("</HTML>");
			    }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case "delete":
			String idd = request.getParameter("id");			
			try {
				Products prod = null;
				new Products();
				prod = Products.getProductByID(idd);
				
				prod.deleteProduct();
				
				
				response.setHeader("Refresh", "3; url=Products");
				out.println("<!doctype html>");
				out.println("<HTML>");
				out.println("<head>");
				out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");		 
				out.println("<meta charset=\"utf-8\">");
				out.println("</head>");
			    out.println("<BODY align=\"center\">");
			    out.println("Đã xóa thành công đối tượng có ID: "+idd+"<br>");
			    out.println("Sẽ tự động chuyển trang trong vòng 3 giây nữa<BR>");
			    out.println("<a href=\"Products\">Nhấn vào đây nếu trình duyệt không tự động chuyển trang</a>");
			    out.println("</BODY>");
			    out.println("</HTML>");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			break;
		case "edit":
			String ide = request.getParameter("id");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductEdit");	
			request.setAttribute("id", ide);
			dispatcher.forward(request, response);
			break;
		case "confirmedit":
			String oldid = request.getParameter("oldid");
			String idec = request.getParameter("id");			
			String nameec = request.getParameter("name");
			String catec = request.getParameter("cat");
			String detailec = request.getParameter("detail");
			String colorec = request.getParameter("color");
			int warec = Integer.valueOf(request.getParameter("war"));
			int priceec = Integer.valueOf(request.getParameter("price"));
			String storageec = request.getParameter("storage");
			Products newpro = new Products(idec, nameec, catec, detailec, priceec, colorec, warec, storageec);
			try {
				new Products();
				pro = Products.getProductByID(oldid);
				if(pro.updateProduct(newpro)){
					//response.setHeader("Refresh", "3; url=Products");
					out.println(detailec);
					out.println("<br>");
					out.println("<!doctype html>");
					out.println("<HTML>");
					out.println("<head>");
					out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");		 
					out.println("<meta charset=\"utf-8\">");
					out.println("</head>");
				    out.println("<BODY align=\"center\">");
				    out.println("Đã cập nhật thành công đối tượng có ID: "+oldid+"<br>");
				    out.println("Sẽ tự động chuyển trang trong vòng 3 giây nữa<BR>");
				    out.println("<a href=\"Products\">Nhấn vào đây nếu trình duyệt không tự động chuyển trang</a>");
				    out.println("</BODY>");
				    out.println("</HTML>");
				}else {
					out.println(detailec);
					out.println("<br>");
					//response.setHeader("Refresh", "3; url=Products");
					out.println("<!doctype html>");
					out.println("<HTML>");
					out.println("<head>");
					out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");		 
					out.println("<meta charset=\"utf-8\">");
					out.println("</head>");
				    out.println("<BODY align=\"center\">");
				    out.println("Cập nhật không thành công đối tượng có ID: "+oldid+"<br>");
				    out.println("Sẽ tự động chuyển trang trong vòng 3 giây nữa<BR>");
				    out.println("<a href=\"Products\">Nhấn vào đây nếu trình duyệt không tự động chuyển trang</a>");
				    out.println("</BODY>");
				    out.println("</HTML>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		default:
			break;
		}
		
		
	}

}
