package Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Model.ConnectDB;
import Object.Images;
import Object.defaultValues;






/**
 * Servlet implementation class FilesUpload
 */
//url="FileUpload"
public class FilesUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilesUpload() {
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
		InputStream ips = null;
		Part filePart = request.getPart("file");
		
		if(filePart!=null){
			ips = filePart.getInputStream();
			String id;
			try {
				
				id = defaultValues.getDefaultValue("images")+defaultValues.getDefaultValue("currentimage");
				String imgName = request.getParameter("imgname");
				String productId = request.getParameter("productid");			
				if(ips!=null){
					
					Images img = new Images(id, imgName, ips, productId);
					if (img.insertImage()) {
						response.setHeader("Refresh", "3; url=UploadImage");					
						out.println("<!doctype html>");
						out.println("<HTML>");
						out.println("<head>");
						out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"); 
						out.println("<meta charset=\"utf-8\">");
						out.println("</head>");
					    out.println("<BODY align=\"center\">");
					    out.println("Đã thêm thành công đối tượng có ID: "+id+"<br>");
					    out.println("Sẽ tự động chuyển trang trong vòng 3 giây nữa<BR>");				    
					    out.println("<a href=\"UploadImage\">Nhấn vào đây nếu trình duyệt không tự động chuyển trang</a>");
					    out.println("</BODY>");
					    out.println("</HTML>");	
						
					}else{
						response.setHeader("Refresh", "3; url=UploadImage");
						out.println("<!doctype html>");
						out.println("<HTML>");
						out.println("<head>");
						out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"); 
						out.println("<meta charset=\"utf-8\">");
						out.println("</head>");
					    out.println("<BODY align=\"center\">");
					    out.println("Thêm đối tượng không thành công, vui lòng thử lại"+"<br>");
					    out.println("Sẽ tự động chuyển trang trong vòng 3 giây nữa<BR>");				    
					    out.println("<a href=\"UploadImage\">Nhấn vào đây nếu trình duyệt không tự động chuyển trang</a>");
					    out.println("</BODY>");
					    out.println("</HTML>");						
					}
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
				
			
		}
		
	}

}
