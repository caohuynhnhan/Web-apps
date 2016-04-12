package Object;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.ConnectDB;

public class Products {
private String productID;
private String productName;
private String category;
private String productDetail;
private int price;
private String color;
private int warranty;
private String storage;

public Products(){
	
}
public Products(String proID, String proName, String cat, String proDetail, int price, String color, int warranty, String Storage){
	this.setCategory(cat);
	this.setColor(color);
	this.setPrice(price);
	this.setProductDetail(proDetail);
	this.setProductID(proID);
	this.setProductName(proName);
	this.setWarranty(warranty);
	this.setStorage(Storage);
	
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
 * @return the productName
 */
public String getProductName() {
	return productName;
}
/**
 * @param productName the productName to set
 */
public void setProductName(String productName) {
	this.productName = productName;
}
/**
 * @return the category
 */
public String getCategory() {
	return category;
}
/**
 * @param category the category to set
 */
public void setCategory(String category) {
	this.category = category;
}
/**
 * @return the productDetail
 */
public String getProductDetail() {
	return productDetail;
}
/**
 * @param productDetail the productDetail to set
 */
public void setProductDetail(String productDetail) {
	this.productDetail = productDetail;
}
/**
 * @return the price
 */
public int getPrice() {
	return price;
}
/**
 * @param price the price to set
 */
public void setPrice(int price) {
	this.price = price;
}
/**
 * @return the color
 */
public String getColor() {
	return color;
}
/**
 * @param color the color to set
 */
public void setColor(String color) {
	this.color = color;
}

public static ArrayList<Products> getAllProduct() throws Exception{
	ArrayList<Products> lst = new ArrayList<>();
	String sql = "select * from products";
	ConnectDB conn = new ConnectDB();
	try {
		PreparedStatement pst = conn.openConnect().prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			String productID = rs.getString("productid");
			String productName = rs.getString("productname");
			String category = rs.getString("category");
			String productDetail = rs.getString("productdetail");
			int price = rs.getInt("price");
			String color = rs.getString("color");
			int warranty = rs.getInt("warranty");
			String Storage = rs.getString("storage");
			Products pro = new Products(productID, productName, category, productDetail, price, color, warranty, Storage);
			lst.add(pro);		
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	conn.closeConnet();
	return lst;
	
}



public static Products getProductByID(String prodID) throws Exception{
	
	String sql = "select * from products where productid=?";
	ConnectDB conn = new ConnectDB();
	Products pro = null;
	try {
		PreparedStatement pst = conn.openConnect().prepareStatement(sql);
		pst.setString(1, prodID);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
			String productID = rs.getString("productid");
			String productName = rs.getString("productname");
			String category = rs.getString("category");
			String productDetail = rs.getString("productdetail");
			int price = rs.getInt("price");
			String color = rs.getString("color");
			int warranty = rs.getInt("warranty");
			String Storage = rs.getString("storage");
			pro = new Products(productID, productName, category, productDetail, price, color, warranty, Storage);
			
			return pro;	
		}
				
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	conn.closeConnet();
	return pro;
	
}


public  boolean insertProduct() throws Exception{
	
	String sql = "insert into products values(?,?,?,?,?,?,?,?)";
	ConnectDB conn = new ConnectDB();
	try {
		PreparedStatement pst = conn.openConnect().prepareStatement(sql);
		pst.setString(1, this.getProductID());
		pst.setString(2, this.getProductName());
		pst.setString(3, this.getCategory());
		pst.setString(4, this.getProductDetail());
		pst.setInt(5, this.getPrice());
		pst.setString(6, this.getColor());
		pst.setInt(7, this.getWarranty());
		pst.setString(8, this.getStorage());
		if (pst.executeUpdate()>0) {
			return defaultValues.increaseDefaultValue("currentproduct");		
		}
			
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	conn.closeConnet();
	return false;
	
}


public  boolean deleteProduct() throws Exception{
	
	String sql = "delete from products where productid=?";
	ConnectDB conn = new ConnectDB();
	try {
		PreparedStatement pst = conn.openConnect().prepareStatement(sql);
		pst.setString(1, this.getProductID());		
		return pst.executeUpdate()>0;	
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	conn.closeConnet();
	return false;
	
}


public  boolean updateProduct(Products newProduct) throws Exception{
	
	String sql = "update products set productid=?, productname=?, category=?, productdetail=?, price=?, color=?, warranty=?, storage=? where productid=?";
	ConnectDB conn = new ConnectDB();
	try {
		PreparedStatement pst = conn.openConnect().prepareStatement(sql);
		pst.setString(1, newProduct.getProductID());
		pst.setString(2, newProduct.getProductName());
		pst.setString(3, newProduct.getCategory());
		pst.setString(4, newProduct.getProductDetail());
		pst.setInt(5, newProduct.getPrice());
		pst.setString(6, newProduct.getColor());
		pst.setInt(7, newProduct.getWarranty());
		pst.setString(8, newProduct.getStorage());
		pst.setString(9, this.getProductID());
		
		return pst.executeUpdate()>0;	
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	conn.closeConnet();
	return false;
	
}


/**
 * @return the warranty
 */
public int getWarranty() {
	return warranty;
}
/**
 * @param warranty the warranty to set
 */
public void setWarranty(int warranty) {
	this.warranty = warranty;
}
public String getStorage() {
	return storage;
}
public void setStorage(String storage) {
	this.storage = storage;
}
}
