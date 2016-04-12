/**
 * 
 */
package Object;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.ConnectDB;

/**
 * @author Anonymous
 *
 */
public class Carts {
	private String cartID;
	private String customerID;
	private String productID;
	private int quantity;
	
	public Carts(String cartid, String customerid, String productid, int quantity){
		this.setCartID(cartid);
		this.setCustomerID(customerid);
		this.setProductID(productid);
		this.setQuantity(quantity);
	}
	/**
	 * @return the cartID
	 */
	public String getCartID() {
		return cartID;
	}
	/**
	 * @param cartID the cartID to set
	 */
	public void setCartID(String cartID) {
		this.cartID = cartID;
	}
	/**
	 * @return the customerID
	 */
	public String getCustomerID() {
		return customerID;
	}
	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	/**
	 * @return the productID
	 */
	public String getProductID() {
		return productID;
	}
	/**
	 * @param productID the productID to set
	 */
	public void setProductID(String productID) {
		this.productID = productID;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	public static ArrayList<Carts> getAllCart() throws Exception{
		 ArrayList<Carts> lst = new ArrayList<Carts>();
		 ConnectDB conn = new ConnectDB();
		 String strSQL = "select * from carts";
		 try 
		 {
			 ResultSet rs = conn.getStatement().executeQuery(strSQL);
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
		 conn.closeConnet();
		 return lst;
	}
	 
	public boolean insertCategory() throws Exception{
		 String sql = "insert into carts values(?,?,?,?)";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement pst = conn.openConnect().prepareStatement(sql);
		 pst.setString(1, this.getCartID());
		 pst.setString(2, this.getCustomerID());
		 pst.setString(3, this.getProductID());
		 pst.setInt(4, this.getQuantity());	 		 
		 if(pst.executeUpdate()>0)
				return defaultValues.increaseDefaultValue("currentcategory");
		 return false;
	 
	}
	 
	public boolean deleteCarts() throws SQLException, Exception{
		 String sql = "delete from carts where cartid=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement pst = conn.openConnect().prepareStatement(sql);
		 pst.setString(1, this.getCartID());
		 return pst.executeUpdate()>0;
		 
	}
	 
	 
	 

	 
	public static Carts getCartByID(String cartID)throws Exception{
		 String sql = "select * from categorys where cartid=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement pst = conn.openConnect().prepareStatement(sql);
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
		 conn.closeConnet();
		 return cart;
	}
	public boolean updateCart(Carts cart) throws SQLException, Exception{
		 String sql = "update carts set cartID=?, customerid=?, productid=?, quantity=? where cartid=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement pst = conn.openConnect().prepareStatement(sql);
		 pst.setString(1, cart.getCartID());
		 pst.setString(2, cart.getCustomerID());
		 pst.setString(3, cart.getProductID());
		 pst.setInt(4, cart.getQuantity());
		 pst.setString(5, this.getCartID());
		 
		 return pst.executeUpdate()>0;
	}

}
