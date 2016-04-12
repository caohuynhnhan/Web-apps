/**
 * 
 */
package Object;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



import Model.ConnectDB;

/**
 * @author Anonymous
 *
 */
public class Images {
	private String imageID;
	private String imageName;
	private InputStream imageValue;
	private String product;
	 
	public Images(String imgID, String imgName, InputStream imgValue, String proID){
		this.setImageID(imgID);
		this.setImageValue(imgValue);
		this.setProduct(proID);
		this.setImageName(imgName);
		
	}
	/**
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}
	/**
	 * @return the imageValue
	 */
	public InputStream getImageValue() {
		return imageValue;
	}
	/**
	 * @param imageValue the imageValue to set
	 */
	public void setImageValue(InputStream imageValue) {
		this.imageValue = imageValue;
	}
	/**
	 * @return the imageID
	 */
	public String getImageID() {
		return imageID;
	}
	/**
	 * @param imageID the imageID to set
	 */
	public void setImageID(String imageID) {
		this.imageID = imageID;
	}
	
	
	public static ArrayList<Images> getAllImage()throws Exception{
		ArrayList<Images> lst = new ArrayList<>();
		ConnectDB conn = new ConnectDB();
		String sql = "select * from images";
		PreparedStatement pst;
		try {
			pst = conn.openConnect().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				String imageID = rs.getString("imageid");
				InputStream imageValue = rs.getBlob("imagevalue").getBinaryStream();				
				String productid = rs.getString("product");
				String imageName = rs.getString("imagename");
				Images img = new Images(imageID, imageName, imageValue, productid);
				lst.add(img);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		conn.closeConnet();
		return lst;
	}
	
	public static ArrayList<twoElement> getAllIdAndProduct()throws Exception{
		ArrayList<twoElement> lst = new ArrayList<>();
		ConnectDB conn = new ConnectDB();
		String sql = "select imageid, product from images";
		PreparedStatement pst;
		try {
			pst = conn.openConnect().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				String imageID = rs.getString("imageid");
				String productid = rs.getString("product");
				twoElement e = new twoElement(imageID, productid);
				lst.add(e);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		conn.closeConnet();
		return lst;
	}
	public static Images getImageByID(String imgID) throws Exception {
		String sql = "select * from images where imageid=?";
		ConnectDB conn = new ConnectDB();
		Images img = null;
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			pst.setString(1, imgID);
			ResultSet rs = pst.executeQuery();
			String imageID = rs.getString("imageid");
			String imageName = rs.getString("imagename");
			InputStream imageValue = rs.getBlob("imagevalue").getBinaryStream();
			String productid = rs.getString("product");
			img = new Images(imageID, imageName, imageValue, productid);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		conn.closeConnet();
		return img;
		
	}
	
	public boolean deleteImage() throws Exception{
		ConnectDB conn = new ConnectDB();
		String sql = "delete from images where imageid=?";
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			pst.setString(1, this.getImageID());
			return pst.executeUpdate()>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean updateImage(Images img) throws Exception{
		ConnectDB conn = new ConnectDB();
		String sql = "update images set imageid=?, imagename=?, imagevalue=?, product=? where imageid=?";
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			pst.setString(1, img.getImageID());
			pst.setBlob(3, img.getImageValue());
			pst.setString(4, img.getProduct());
			pst.setString(2, img.getImageName());
			pst.setString(5, this.getImageID());
			return pst.executeUpdate()>0;
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean insertImage() throws Exception{
		ConnectDB conn = new ConnectDB();
		String sql = "insert into images values(?,?,?,?)";
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);			
			pst.setString(1, this.getImageID());
			pst.setBlob(3, this.getImageValue());
			pst.setString(4, this.getProduct());			
			pst.setString(2, this.getImageName());			
			if(pst.executeUpdate()>0)
				return defaultValues.increaseDefaultValue("currentimage");	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	/**
	 * @return the imageName
	 */
	public String getImageName() {
		return imageName;
	}
	/**
	 * @param imageName the imageName to set
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
}
