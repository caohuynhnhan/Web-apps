	package Object;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import Model.ConnectDB;

public class Categorys {
	 private String categoryId;
	 private String categoryName;		 
	 private String description;
	 private int type;
	 
	 public Categorys(String cID, String cName,int Type, String cDescription ) {
		 this.setCategoryID(cID);
		 this.setCategoryName(cName);
		 this.setDescription(cDescription);
		 this.setType(Type);
	 }
	 
	 public Categorys() {
	 }
	 
	 public String getCategoryID() {
		 return categoryId;
	 }
	 
	 public void setCategoryID(String newid) {
		 this.categoryId = newid;
	 }
	 
	 public String getCategoryName() {
		 return categoryName;
	 }
	 
	 public void setCategoryName(String newname) {
		 this.categoryName = newname;
	 }

	 
	 
	 public boolean insertCategory() throws Exception
	 {
		 ConnectDB conn = new ConnectDB();
	 	 String sql = "insert into categorys values(?,?,?,?)";
	 	 PreparedStatement pst = conn.openConnect().prepareStatement(sql);
	 	 pst.setString(1, this.getCategoryID());
	 	 pst.setString(2, this.getCategoryName());	
	 	 pst.setInt(3, this.getType());	
	 	 pst.setString(4, this.getDescription());
	 	 
	     if(pst.executeUpdate()>0)
			return defaultValues.increaseDefaultValue("currentcategory");	
	     return false;
	 	 
	 }	 
	 
	 public static ArrayList<Categorys> getAllCategory() throws Exception{
		 ArrayList<Categorys> lst = new ArrayList<Categorys>();
		 String strSQL = "select * from categorys";
		 ConnectDB conn = new ConnectDB();
		 try 
		 {
			 ResultSet rs = conn.getStatement().executeQuery(strSQL);
			 while(rs.next()){
				 String cID = rs.getString("categoryID");
				 String cName = rs.getString("categoryName");
				 String cDescription = rs.getString("description");
				 int cType = rs.getInt("type");
				 Categorys cat = new Categorys(cID, cName, cType, cDescription);
				 lst.add(cat);
			 }
		 } catch (Exception e) 
		 {
			 throw new Exception(e.getMessage() +" Error at : " + strSQL);
		 }
		 conn.closeConnet();
		 return lst;
	}
	 
	
	 
	public boolean deleteCategory() throws SQLException, Exception{
		 String sql = "delete from categorys where categoryID=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement pst = conn.openConnect().prepareStatement(sql);
		 pst.setString(1, this.getCategoryID());
		return pst.executeUpdate()>0;
		 
	}
	public static void deleteCategoryByID(String id) throws SQLException, Exception{
		 String sql = "delete from categorys where categoryID=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement pst = conn.openConnect().prepareStatement(sql);
		 pst.setString(1, id);
		 pst.executeUpdate();
		 
	}
	 
	 
	 

	 
	public static Categorys getCategoryByID(String catID)throws Exception{
		 String sql = "select * from categorys where categoryID=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement pst = conn.openConnect().prepareStatement(sql);
		 pst.setString(1, catID);
		 ResultSet rs = pst.executeQuery();
		 Categorys cat = null;
		 if(rs.next()){
			 String catid = rs.getString("categoryID");
			 String catname = rs.getString("categoryName");	
			 String catdes = rs.getString("description");
			 int cattyp = rs.getInt("type");
			 cat = new Categorys(catid, catname, cattyp, catdes);
		 }
		 return cat;
	}
	public boolean updateCategory(Categorys cat) throws SQLException, Exception{
		 String sql = "update categorys set categoryid=?, categoryName=?, type=?, description=? where categoryid=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement pst = conn.openConnect().prepareStatement(sql);
		 pst.setString(1, cat.getCategoryID());
		 pst.setString(2, cat.getCategoryName());
		 pst.setInt(3, cat.getType());
		 pst.setString(4, cat.getDescription());
		 pst.setString(5, this.getCategoryID());
		 return pst.executeUpdate()>0;
	}
	 /*
	 @Override
	 
	 public int hashCode() {
		 final int prime = 31;
		 int result = 1;
		 result = prime * result + ((masp == null) ? 0 : masp.hashCode());
		 return result;
	 }
	 @Override
	 public boolean equals(Object obj) {
		 if (this == obj)
			 return true;
		 if (obj == null)
			 return false;
		 if (getClass() != obj.getClass())
			 return false;
		 
		 SanPham other = (SanPham) obj;
		 if (masp == null) {
			 if (other.masp != null)
				 return false;
		 } 
		 else 
			 if (!masp.equals(other.masp))
				 return false;
		 return true;
	 }*/

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	 
	}