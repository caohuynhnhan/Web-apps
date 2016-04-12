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
public class Customers {
	private String customerID;
	private String customerName;
	private boolean gender;
	private String numberphone;
	private String email;
	private String address;
	private String shippingaddress;
	private String username;
	public Customers(String cusID, String cusName, boolean gen, String numb, String email, String add, String shippingadd, String usr ){
		this.setAddress(add);
		this.setCustomerID(cusID);
		this.setCustomerName(cusName);
		this.setEmail(email);
		this.setShippingaddress(shippingadd);
		this.setNumberphone(numb);
		this.setGender(gen);
		this.setUsername(usr);
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
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the gender
	 */
	public boolean getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	/**
	 * @return the numberphone
	 */
	public String getNumberphone() {
		return numberphone;
	}
	/**
	 * @param numberphone the numberphone to set
	 */
	public void setNumberphone(String numberphone) {
		this.numberphone = numberphone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the shippingaddress
	 */
	public String getShippingaddress() {
		return shippingaddress;
	}
	/**
	 * @param shippingaddress the shippingaddress to set
	 */
	public void setShippingaddress(String shippingaddress) {
		this.shippingaddress = shippingaddress;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public static ArrayList<Customers> getAllCustomer() throws Exception{
		ArrayList<Customers> lst = new ArrayList<Customers>();
		String sql = "select * from customers";
		ConnectDB conn = new ConnectDB();
		PreparedStatement pst = conn.openConnect().prepareStatement(sql);
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
		conn.closeConnet();
		return lst;
		
	}

	public boolean insertCustomer() throws SQLException, Exception{
		String sql = "insert in to customers values(?,?,?,?,?,?,?,?)";
		ConnectDB conn = new ConnectDB();
		PreparedStatement pst = conn.openConnect().prepareStatement(sql);	
		pst.setString(1, this.getCustomerID());
		pst.setString(2, this.getCustomerName());
		pst.setBoolean(3, this.getGender());
		pst.setString(4, this.getNumberphone());
		pst.setString(5, this.getEmail());
		pst.setString(6, this.getAddress());
		pst.setString(7, this.getShippingaddress());
		pst.setString(8, this.getUsername());
		if(pst.executeUpdate()>0)
			return defaultValues.increaseDefaultValue("currentcustomer");	
		    return false;
		
	}
	public boolean updateCustomer(Customers newCus) throws Exception {
		ConnectDB conn = new ConnectDB();
		String sql = "update customers set customerid=?, customername=?, gender=?, numberphone=?, email=?, address=?, shippingaddress=?, username=? where customerid=?";
		
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			pst.setString(1, newCus.getCustomerID());
			pst.setString(2, newCus.getCustomerName());
			pst.setBoolean(3, newCus.getGender());
			pst.setString(4, newCus.getNumberphone());
			pst.setString(5, newCus.getEmail());
			pst.setString(6, newCus.getAddress());
			pst.setString(7, newCus.getShippingaddress());
			pst.setString(8, newCus.getUsername());
			pst.setString(9, this.getCustomerID());			
			pst.setString(1, this.getCustomerID());
			return pst.executeUpdate()>0;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

	public boolean deleteCustomer() throws Exception{
		String sql = "delete from customers where customerid=?";
		PreparedStatement pst;	
		ConnectDB conn = new ConnectDB();
		pst = conn.openConnect().prepareStatement(sql);	
		pst.setString(1, this.getCustomerID());
		return pst.executeUpdate()>0;
	}

	public static Customers getCustomerByID(String customerID) throws SQLException, Exception{
		String sql = "select * from customers where customerid=?";
		ConnectDB conn = new ConnectDB();
		PreparedStatement pst = conn.openConnect().prepareStatement(sql);
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
		conn.closeConnet();
		return cus;
		
	}	
}
