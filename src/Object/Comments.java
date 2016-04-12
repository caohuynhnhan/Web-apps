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
public class Comments {
	private String commentID;
	private String memberID;
	private String productID;
	private String message;
	public Comments(String commID, String memID, String proID, String mes){
		this.setCommentID(commID);
		this.setMemberID(memID);
		this.setProductID(proID);
		this.setMessage(mes);
	}
	/**
	 * @return the commentID
	 */
	public String getCommentID() {
		return commentID;
	}
	/**
	 * @param commentID the commentID to set
	 */
	public void setCommentID(String commentID) {
		this.commentID = commentID;
	}
	/**
	 * @return the memberID
	 */
	public String getMemberID() {
		return memberID;
	}
	/**
	 * @param memberID the memberID to set
	 */
	public void setMemberID(String memberID) {
		this.memberID = memberID;
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
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public static ArrayList<Comments> getAllComment() throws Exception{
		 ArrayList<Comments> lst = new ArrayList<Comments>();
		 String strSQL = "select * from comments";
		 ConnectDB conn = new ConnectDB();
		 try 
		 {
			 ResultSet rs = conn.getStatement().executeQuery(strSQL);
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
		 conn.closeConnet();
		 return lst;
	}

	public boolean insertComment() throws Exception{
		 String sql = "insert into comments values(?,?,?,?)";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement pst = conn.openConnect().prepareStatement(sql);
		 pst.setString(1, this.getCommentID());
		 pst.setString(2, this.getMemberID());
		 pst.setString(3, this.getProductID());
		 pst.setString(4, this.getMessage());	 
		 
		 if(pst.executeUpdate()>0)
			return defaultValues.increaseDefaultValue("currentcomment");	
		    return false;

	}

	public boolean deleteComment() throws SQLException, Exception{
		 String sql = "delete from comments where commentid=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement pst = conn.openConnect().prepareStatement(sql);
		 pst.setString(1, this.getCommentID());
		 return pst.executeUpdate()>0;
		 
	}





	public static Comments getCommentByID(String commentId)throws Exception{
		 String sql = "select * from comments where commentid=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement pst = conn.openConnect().prepareStatement(sql);
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
		 conn.closeConnet();
		 return cmt;
	}
	public boolean updateComment(Comments cmt) throws SQLException, Exception{
		 String sql = "update comments set commentid=?, memberid=?, productid=?, message=? where commentid=?";
		 ConnectDB conn = new ConnectDB();
		 PreparedStatement pst = conn.openConnect().prepareStatement(sql);
		 pst.setString(1, cmt.getCommentID());
		 pst.setString(2, cmt.getMemberID());
		 pst.setString(3, cmt.getProductID());
		 pst.setString(4, cmt.getMessage());
		 pst.setString(5, this.getCommentID());
		 
		 
		 return pst.executeUpdate()>0;
	}

}
