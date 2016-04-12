/**
 * 
 */
package Object;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.ConnectDB;

/**
 * @author Anonymous
 *
 */
public class Orders {
	private String orderID;
	private String customerID;
	private java.sql.Date orderDate;
	private String orderItem;
	private int status;
	public Orders(String orderid, String cusID, java.sql.Date oderdate, String orderitem, int status){
		this.setCustomerID(cusID);
		this.setOrderDate(oderdate);
		this.setOrderID(orderid);
		this.setOrderItem(orderitem);
		this.setStatus(status);
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
	 * @return the orderDate
	 */
	public java.sql.Date getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(java.sql.Date orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * @return the orderItem
	 */
	public String getOrderItem() {
		return orderItem;
	}
	/**
	 * @param orderItem the orderItem to set
	 */
	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	public boolean updateOrder(Orders odr) throws Exception{
		
		String sql = "update orders set orderid=?, customerid=?, orderdate=?, orderitem=?, status=? where orderid=?";
		ConnectDB conn = new ConnectDB();
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			pst.setString(1, odr.getOrderID());
			pst.setString(2, odr.getCustomerID());
			pst.setDate(3, odr.getOrderDate());
			pst.setString(4, odr.getOrderItem());
			pst.setInt(5, odr.getStatus());
			pst.setString(6, this.getOrderID());			
			return pst.executeUpdate()>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	
	public boolean insertOrder() throws Exception{
		
		String sql = "insert orders values (?,?,?,?,?)";
		ConnectDB conn = new ConnectDB();
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			pst.setString(1, this.getOrderID());
			pst.setString(2, this.getCustomerID());
			pst.setDate(3, this.getOrderDate());
			pst.setString(4, this.getOrderItem());
			pst.setInt(5, this.getStatus());
			if(pst.executeUpdate()>0)
				return defaultValues.increaseDefaultValue("currentorder");			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}	
	
	
	public boolean deleteOrder() throws Exception{
		
		String sql = "delete from orders where orderid=?";
		ConnectDB conn = new ConnectDB();
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			pst.setString(1, this.getOrderID());						
			return pst.executeUpdate()>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}	
	
	
	public static ArrayList<Orders> getAllOrder() throws Exception{
		ArrayList<Orders> lst = new ArrayList<>();
		String sql = "select * from orders";
		ConnectDB conn = new ConnectDB();
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String orderID = rs.getString("orderid");
				String customerID = rs.getString("customerid");
				Date oderDate = rs.getDate("orderdate");
				String orderItem = rs.getString("orderitem");
				int status = rs.getInt("status");
				Orders odr = new Orders(orderID, customerID, oderDate, orderItem, status);
				lst.add(odr);
			}
						
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.closeConnet();
		return lst;
	}	
	
	
	
	
	public static Orders getOrderByID(String oderID) throws Exception{
		Orders odr = null;
		String sql = "select * from orders where orderid=?";
		ConnectDB conn = new ConnectDB();
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			pst.setString(1, oderID);
			ResultSet rs = pst.executeQuery();
			
			String orderID = rs.getString("orderid");
			String customerID = rs.getString("customerid");
			Date oderDate = rs.getDate("orderdate");
			String orderItem = rs.getString("orderitem");
			int status = rs.getInt("status");
			odr = new Orders(orderID, customerID, oderDate, orderItem, status);
			
									
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.closeConnet();
		return odr;
	}	
	
}
