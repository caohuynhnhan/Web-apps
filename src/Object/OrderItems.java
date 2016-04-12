/**
 * 
 */
package Object;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import Model.ConnectDB;

/**
 * @author Anonymous
 *
 */
public class OrderItems {
	private String orderItemID;
	private String orderID;
	private String productID;
	private int quantity;
	
	public OrderItems(String oderItemID, String orderID, String productID, int quantity){
		this.setOrderID(orderID);
		this.setOrderItemID(oderItemID);
		this.setProductID(productID);
		this.setQuantity(quantity);

	}
	/**
	 * @return the orderItemID
	 */
	public String getOrderItemID() {
		return orderItemID;
	}
	/**
	 * @param orderItemID the orderItemID to set
	 */
	public void setOrderItemID(String orderItemID) {
		this.orderItemID = orderItemID;
	}
	/**
	 * @return the orderID
	 */
	public String getOrderID() {
		return orderID;
	}
	/**
	 * @param orderID the orderID to set
	 */
	public void setOrderID(String orderID) {
		this.orderID = orderID;
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


	
	public static ArrayList<OrderItems> getAllOrderItem() throws Exception {
		String sql = "select * from orderitems";
		ArrayList<OrderItems> lst = new ArrayList<>();
		ConnectDB conn = new ConnectDB();
		PreparedStatement pst;
		try {
			pst = conn.openConnect().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String orderItemID = rs.getString("orderitemid");
				String orderId = rs.getString("orderid");
				String productID = rs.getString("productid");
				int quantity = rs.getInt("quantity");
				OrderItems odi = new OrderItems(orderItemID, orderId, productID, quantity);
				lst.add(odi);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return lst;
		
	}
	
	public static OrderItems getOrderItemByID() throws Exception{
		String sql = "select * from orderitems where orderitemid=?";
		ConnectDB conn = new ConnectDB();
		OrderItems odi = null;
		PreparedStatement pst;
		try {
			pst = conn.openConnect().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			String orderitemID = rs.getString("orderitemid");
			String orderID = rs.getString("orderid");	
			String productID = rs.getString("productid");
			int quantity = rs.getInt("quantity");
			odi = new OrderItems(orderitemID, orderID, productID, quantity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return odi;
		
	}
	
	public boolean insertOrderItem() throws Exception{
		String sql = "insert into orderitems values(?,?,?,?)";
		ConnectDB conn = new ConnectDB();
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			pst.setString(1, this.getOrderItemID());
			pst.setString(2, this.getOrderID());
			pst.setString(3, this.getProductID());
			pst.setInt(4, this.getQuantity());
			if(pst.executeUpdate()>0)
				return defaultValues.increaseDefaultValue("currentorderitem");	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean updateOrderItem(OrderItems odi) throws Exception{
		
		String sql = "update orderitems set orderitemid=?, orderid=?, productid=?, quantity=? where orderitemid=?";
		ConnectDB conn = new ConnectDB();
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			pst.setString(1, odi.getOrderItemID());
			pst.setString(2, odi.getOrderID());
			pst.setString(3, odi.getProductID());
			pst.setInt(4, odi.getQuantity());
			pst.setString(5, this.getOrderItemID());
			
			return pst.executeUpdate()>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteOrderItem() throws Exception{
		
		String sql = "delete from orderitems where orderitemid=?";
		ConnectDB conn = new ConnectDB();
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			
			pst.setString(1, this.getOrderItemID());
			
			return pst.executeUpdate()>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
