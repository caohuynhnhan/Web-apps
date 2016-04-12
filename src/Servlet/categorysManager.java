package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Object.Categorys;
import Object.defaultValues;

/**
 * Servlet implementation class categorysManager
 */
//@WebServlet("/CategorysManager")
public class categorysManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public categorysManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String d="delete";
		
		if(request.getParameter("action").equals(d)){
			
			String catID = request.getParameter("deleteID");
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			try {
				Categorys.deleteCategoryByID(catID);
				
				
				response.setHeader("Refresh", "3; url=CategorysManagerUI");
				out.println("<!doctype html>");
				out.println("<HTML>");
				out.println("<head>");
				out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");				 
				out.println("<meta charset=\"utf-8\">");
				out.println("</head>");
			    out.println("<BODY align=\"center\">");
			    out.println("Đã xóa đối tượng có ID: "+catID+"<br>");
			    out.println("Sẽ tự động chuyển trang trong vòng 3 giây nữa<BR>");
			    out.println("<a href=\"CategorysManagerUI\">Nhấn vào đây nếu trình duyệt không tự động chuyển trang</a>");
			    out.println("</BODY>");
			    out.println("</HTML>");
			    
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				response.setHeader("Refresh", "5; url=CategorysManagerUI");
			}
					
			
			
			
		       
		       
			//response.sendRedirect("CategorysManager");
			
			
			//response.sendRedirect("CategorysManagerUI");
			return;
		}else response.getWriter().append("Đã cập nhật đối tượng");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("catname");
		String desc = request.getParameter("catdes");
		int type = Integer.valueOf(request.getParameter("type"));
		String id="";
		try {
			String a = defaultValues.getDefaultValue("categorys");
			String b = defaultValues.getDefaultValue("currentcategory");
			id=a+b;
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
			
		String action = "";
		try {
			action = request.getParameter("action");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(action.equals("edit")){
			Categorys cat;
			try {
				id = request.getParameter("catid");
				cat = Categorys.getCategoryByID(id);
				Categorys newcat = new Categorys(id, name, type, desc);
				cat.updateCategory(newcat);
				//response.setHeader("Refresh", "3; url=CategorysManagerUI");
				out.println("<!doctype html>");
				out.println("<HTML>");
				out.println("<head>");
				out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");				 
				 
				out.println("<meta charset=\"utf-8\">");
				out.println("</head>");
			    out.println("<BODY align=\"center\">");
			    out.println("Đã thay đổi thành công đối tượng có ID: "+id+"<br>");
			    out.println("Sẽ tự động chuyển trang trong vòng 3 giây nữa<BR>");
			    out.println("<a href=\"CategorysManagerUI\">Nhấn vào đây nếu trình duyệt không tự động chuyển trang</a>");
			    out.println("</BODY>");
			    out.println("</HTML>");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
		}
		if(action.equals("add")){
			Categorys cat = new Categorys(id, name, type, desc);
			try {
				cat.insertCategory();
				
				response.setHeader("Refresh", "3; url=CategorysManagerUI");
				out.println("<!doctype html>");
				out.println("<HTML>");
				out.println("<head>");
				out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");				 
				 
				out.println("<meta charset=\"utf-8\">");
				out.println("</head>");
			    out.println("<BODY align=\"center\">");
			    out.println("Đã thêm thành công đối tượng có ID: "+id+"<br>");
			    out.println("Sẽ tự động chuyển trang trong vòng 3 giây nữa<BR>");
			    out.println("<a href=\"CategorysManagerUI\">Nhấn vào đây nếu trình duyệt không tự động chuyển trang</a>");
			    out.println("</BODY>");
			    out.println("</HTML>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.getWriter().append("Thao tác không thành công!!!");
				response.sendRedirect("CategorysManagerUI");
			}
		}
		
		
		
	}

}
