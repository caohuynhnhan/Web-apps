package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Object.Carts;
import Object.Categorys;
import Object.Comments;
import Object.Customers;

public class ConnectDB {
 
Connection connect = null;
Statement stmt = null;
ResultSet rs = null;
 
/**
 * Kiemk tra Driver ket noi co so du lieu
 */
 protected void hasDriver() throws Exception{
	 try 
	 {
		 Class.forName("com.mysql.jdbc.Driver");
	 } 
	 catch (ClassNotFoundException ex) {
		 
		 throw new Exception ("Invalid Driver!!Please check this drver....");
		 
	 }
 }
 
/**
 * Ket noi co so du lieu
 * 1 - Kiem tra ket noi
 * 2 - Neu chua ket noi thi tao ket noi
 * 3 - Tra ve ket qua la ket noi
 * @return Connection
 */
 public Connection openConnect() throws Exception{
	 if(connect == null)
	 {
		 hasDriver();
		 String url = "jdbc:mysql://localhost/apt-shop";
	 
	 try 
	 {
		 this.connect = DriverManager.getConnection(url,"caohuynhnhan","937289032");
		 System.out.println("Connect success");
	 } catch (SQLException e) 
	 {
		 throw new Exception(e.getMessage() + "Connect failed to database .... ");
	 	}
	 }
	 return connect;
 }
 /**
 * Make a Statement to execute the SQL statement
 * @return Statement
 */
 public Statement getStatement() throws SQLException, Exception{
	 if(stmt == null)
	 {
		 stmt = openConnect().createStatement();
	 }
	 return stmt;
 }

 /**
 * A method to close the connection.
 * @throws SQLException
 */
 public void closeConnet() throws SQLException
 {
	 if(rs != null && !rs.isClosed())
		 rs.close();
	 if(stmt != null)
		 stmt.close();
	 if(connect != null)
		 connect.close();
 }
 
 /**
 * Thuc Thi Insert, Delete, Update
 * @param strSQL Query
 * @return So dong bi anh huong boi cau lenh
 */
public int executeUpdate(String strSQL) throws Exception{
	 int result = 0;
	 try 
	 {
		 result = getStatement().executeUpdate(strSQL);
	 } 
	 catch (Exception ex) {
		 throw new Exception(ex.getMessage() + " Error at: " + strSQL);
	 }
	 finally{
		 this.closeConnet();
	 }
	 return result;
}
 
/*
//---------------------------------------------------------------------------------------------------------
//----------------------------------------  Querry on Categorys table
//---------------------------------------------------
//---------------------------------------------------------------------------------------------------------
public ArrayList<Categorys> getCategory() throws Exception{
	 ArrayList<Categorys> lst = new ArrayList<Categorys>();
	 String strSQL = "select * from categorys";
	 try 
	 {
		 rs = getStatement().executeQuery(strSQL);
		 while(rs.next()){
			 String cID = rs.getString("categoryID");
			 String cName = rs.getString("categoryName");
			 String cDes = rs.getString("description");
			 Categorys cat = new Categorys(cID, cName, cDes);
			 lst.add(cat);
		 }
	 } catch (Exception e) 
	 {
		 throw new Exception(e.getMessage() +" Error at : " + strSQL);
	 }
	 closeConnet();
	 return lst;
}
 
public boolean insertCategory(Categorys cat) throws Exception
{
	 String sql = "insert into categorys values(?,?,?)";
	 PreparedStatement pst = openConnect().prepareStatement(sql);
	 pst.setString(1, cat.getCategoryID());
	 pst.setString(2, cat.getCategoryName());
	 pst.setString(3, cat.getDescription());
	 
	 return pst.executeUpdate() > 0;
 
}
 
public boolean deleteCategory(String categoryID) throws SQLException, Exception{
	 String sql = "delete from categorys where categoryID=?";
	 PreparedStatement pst = openConnect().prepareStatement(sql);
	 pst.setString(1, categoryID);
	return pst.executeUpdate()>0;
	 
}
 
 
 

 
public Categorys getCategoryByID(String catID)throws Exception{
	 String sql = "select * from categorys where categoryID=?";
	 PreparedStatement pst = openConnect().prepareStatement(sql);
	 pst.setString(1, catID);
	 ResultSet rs = pst.executeQuery();
	 Categorys cat = null;
	 if(rs.next()){
		 String catid = rs.getString("categoryID");
		 String catname = rs.getString("categoryName");	
		 String descr = rs.getString("description");
		 cat = new Categorys(catid, catname, descr);
	 }
	 return cat;
}
public boolean updateCategory(String catID, Categorys cat) throws SQLException, Exception{
	 String sql = "update categorys set categoryID=?, categoryName=?, description=? where categoryID=?";
	 PreparedStatement pst = openConnect().prepareStatement(sql);
	 pst.setString(1, cat.getCategoryID());
	 pst.setString(2, cat.getCategoryName());
	 pst.setString(3, cat.getDescription());
	 pst.setString(4, catID);
	 return pst.executeUpdate()>0;
}
 
 
//---------------------------------------------------------------------------------------------------------
//----------------------------------------  Querry on carts table
//---------------------------------------------------
//---------------------------------------------------------------------------------------------------------


public ArrayList<Carts> getAllCart() throws Exception{
	 ArrayList<Carts> lst = new ArrayList<Carts>();
	 String strSQL = "select * from carts";
	 try 
	 {
		 rs = getStatement().executeQuery(strSQL);
		 while(rs.next()){
			 String cartID = rs.getString("cartid");
			 String customerID = rs.getString("customerid");
			 String productID = rs.getString("productid");
			 int quantity = rs.getInt("quantity");
			
			 Carts cart = new Carts(cartID, customerID, productID, quantity);
			 lst.add(cart);
		 }
	 } catch (Exception e) 
	 {
		 throw new Exception(e.getMessage() +" Error at : " + strSQL);
	 }
	 closeConnet();
	 return lst;
}
 
public boolean insertCategory(Carts cart) throws Exception{
	 String sql = "insert into carts values(?,?,?,?)";
	 PreparedStatement pst = openConnect().prepareStatement(sql);
	 pst.setString(1, cart.getCartID());
	 pst.setString(2, cart.getCustomerID());
	 pst.setString(3, cart.getProductID());
	 pst.setInt(4, cart.getQuantity());	 
	 
	 return pst.executeUpdate() > 0;
 
}
 
public boolean deleteCarts(String cartID) throws SQLException, Exception{
	 String sql = "delete from carts where cartid=?";
	 PreparedStatement pst = openConnect().prepareStatement(sql);
	 pst.setString(1, cartID);
	 return pst.executeUpdate()>0;
	 
}
 
 
 

 
public Carts getCartByID(String cartID)throws Exception{
	 String sql = "select * from categorys where cartid=?";
	 PreparedStatement pst = openConnect().prepareStatement(sql);
	 pst.setString(1, cartID);
	 ResultSet rs = pst.executeQuery();
	 Carts cart = null;
	 if(rs.next()){
		 String cartid = rs.getString("cartid");
		 String customerid = rs.getString("customerid");	
		 String productid = rs.getString("productid");
		 int quantity = rs.getInt("quantity");
		 
		 cart = new Carts(cartid, customerid, productid, quantity);
	 }
	 return cart;
}
public boolean updateCart(String cartID, Carts cart) throws SQLException, Exception{
	 String sql = "update carts set cartID=?, customerid=?, productid=?, quantity=? where cartid=?";
	 PreparedStatement pst = openConnect().prepareStatement(sql);
	 pst.setString(1, cart.getCartID());
	 pst.setString(2, cart.getCustomerID());
	 pst.setString(3, cart.getProductID());
	 pst.setInt(4, cart.getQuantity());
	 pst.setString(5, cartID);
	 
	 return pst.executeUpdate()>0;
}

//---------------------------------------------------------------------------------------------------------
//----------------------------------------  Querry on comments table
//---------------------------------------------------
//---------------------------------------------------------------------------------------------------------


public ArrayList<Comments> getAllComment() throws Exception{
	 ArrayList<Comments> lst = new ArrayList<Comments>();
	 String strSQL = "select * from comments";
	 try 
	 {
		 rs = getStatement().executeQuery(strSQL);
		 while(rs.next()){
			 String commentid = rs.getString("commentid");
			 String memberid = rs.getString("memberid");
			 String productID = rs.getString("productid");
			 String message = rs.getString("message");
			
			 Comments cmt = new Comments(commentid, memberid, productID, message);
			 lst.add(cmt);
		 }
	 } catch (Exception e) 
	 {
		 throw new Exception(e.getMessage() +" Error at : " + strSQL);
	 }
	 closeConnet();
	 return lst;
}

public boolean insertComment(Comments cmt) throws Exception{
	 String sql = "insert into comments values(?,?,?,?)";
	 PreparedStatement pst = openConnect().prepareStatement(sql);
	 pst.setString(1, cmt.getCommentID());
	 pst.setString(2, cmt.getMemberID());
	 pst.setString(3, cmt.getProductID());
	 pst.setString(4, cmt.getMessage());	 
	 
	 return pst.executeUpdate() > 0;

}

public boolean deleteComment(String cmtID) throws SQLException, Exception{
	 String sql = "delete from comments where commentid=?";
	 PreparedStatement pst = openConnect().prepareStatement(sql);
	 pst.setString(1, cmtID);
	 return pst.executeUpdate()>0;
	 
}





public Comments getCommentByID(String commentId)throws Exception{
	 String sql = "select * from comments where commentid=?";
	 PreparedStatement pst = openConnect().prepareStatement(sql);
	 pst.setString(1, commentId);
	 ResultSet rs = pst.executeQuery();
	 Comments cmt = null;
	 if(rs.next()){
		 String commentid = rs.getString("commentid");
		 String memberid = rs.getString("memberid");	
		 String productid = rs.getString("productid");
		 String message = rs.getString("message");
		 
		 cmt = new Comments(commentid, memberid, productid, message);
	 }
	 return cmt;
}
public boolean updateComment(String commentID, Comments cmt) throws SQLException, Exception{
	 String sql = "update comments set commentid=?, memberid=?, productid=?, message=? where commentid=?";
	 PreparedStatement pst = openConnect().prepareStatement(sql);
	 pst.setString(1, cmt.getCommentID());
	 pst.setString(2, cmt.getMemberID());
	 pst.setString(3, cmt.getProductID());
	 pst.setString(4, cmt.getMessage());
	 pst.setString(5, commentID);
	 
	 
	 return pst.executeUpdate()>0;
}


//---------------------------------------------------------------------------------------------------------
//----------------------------------------  Querry on customers table
//---------------------------------------------------
//---------------------------------------------------------------------------------------------------------
public ArrayList<Customers> getAllCustomer() throws Exception{
	ArrayList<Customers> lst = new ArrayList<Customers>();
	String sql = "select * from customers";
	PreparedStatement pst = openConnect().prepareStatement(sql);
	try {
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			String customerid = rs.getString("customerid");
			String customername = rs.getString("customername");
			boolean gender = rs.getBoolean("gender");
			String numberphone = rs.getString("numberphone");
			String email = rs.getString("email");
			String address = rs.getString("address");
			String shippingaddress = rs.getString("shippingaddress");
			String username = rs.getString("username");
			Customers cus = new Customers(customerid, customername, gender, numberphone, email, address, shippingaddress, username);
			lst.add(cus);
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		throw new Exception(e.getMessage() +" Error at : " + sql);
	}
	closeConnet();
	return lst;
	
}

public boolean insertCustomer(Customers cus) throws SQLException, Exception{
	String sql = "insert in to customers values(?,?,?,?,?,?,?,?)";
	PreparedStatement pst = openConnect().prepareStatement(sql);	
	pst.setString(1, cus.getCustomerID());
	pst.setString(2, cus.getCustomerName());
	pst.setBoolean(3, cus.getGender());
	pst.setString(4, cus.getNumberphone());
	pst.setString(5, cus.getEmail());
	pst.setString(6, cus.getAddress());
	pst.setString(7, cus.getShippingaddress());
	pst.setString(8, cus.getUsername());
	return pst.executeUpdate()>0;	
	
}

public boolean deleteCustomer(String customerID) throws Exception{
	String sql = "delete from customers where customerid=?";
	PreparedStatement pst;	
	pst = openConnect().prepareStatement(sql);	
	pst.setString(1, customerID);
	return pst.executeUpdate()>0;
}

public Customers getCustomerByID(String customerID) throws SQLException, Exception{
	String sql = "select * from customers where customerid=?";
	PreparedStatement pst = openConnect().prepareStatement(sql);
	pst.setString(1, customerID);
	ResultSet rs = pst.executeQuery();
	
	String customerid = rs.getString("customerid");
	String customername = rs.getString("customername");
	boolean gender = rs.getBoolean("gender");
	String numberphone = rs.getString("numberphone");
	String email = rs.getString("email");
	String address = rs.getString("address");
	String shippingaddress = rs.getString("shippingaddress");
	String username = rs.getString("username");
	Customers cus = new Customers(customerid, customername, gender, numberphone, email, address, shippingaddress, username);
	return cus;
	
}
*/

 public static void main(String[] args) throws Exception {
	 // Test thu cac ham
	 //new ConnectDB().UpdateProduct("sp01", new SanPham("sp01", "AAAA", "BBBB", 1000));
	 //System.out.println(new ConnectDB().getProductByID("sp01").getTensp());
 
 }
 
}