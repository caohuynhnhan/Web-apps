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
public class Users {
	private String username;
	private String password;
	private int permission;
	public Users(String usrname, String pass, int per){
		this.setPassword(pass);
		this.setPermission(per);
		this.setUsername(usrname);
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
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the permission
	 */
	public int getPermission() {
		return permission;
	}
	/**
	 * @param permission the permission to set
	 */
	public void setPermission(int permission) {
		this.permission = permission;
	}
	
	public static ArrayList<Users> getAllUser() throws Exception {
		ConnectDB conn = new ConnectDB();
		ArrayList<Users> lst = new ArrayList<>();
		String sql = "select * from users";
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				String userName=rs.getString("username");
				String password = rs.getString("password");
				int permission = rs.getInt("permission");
				Users usr = new Users(userName, password, permission);
				lst.add(usr);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.closeConnet();
		return lst;
	}
	
	
	
	public static Users getUserByUsername(String usrName) throws Exception {
		ConnectDB conn = new ConnectDB();
		Users usr = null;
		String sql = "select * from users where username=?";
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			pst.setString(1, usrName);
			ResultSet rs = pst.executeQuery();
			
				String userName=rs.getString("username");
				String password = rs.getString("password");
				int permission = rs.getInt("permission");
				usr = new Users(userName, password, permission);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.closeConnet();
		return usr;
	}
	
	
	
	
	public  boolean updateUser(Users newUser) throws Exception{
		
		String sql = "update users set username=?, password=?, permission=? where username=?";
		ConnectDB conn = new ConnectDB();
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			pst.setString(1, newUser.getUsername());
			pst.setString(2, newUser.getPassword());
			pst.setInt(3, newUser.getPermission());
			pst.setString(4, this.getUsername());
			
			
			return pst.executeUpdate()>0;	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.closeConnet();
		return false;
		
	}
	
	
		public  boolean insertUser() throws Exception{
		
		String sql = "insert into users values(?,?,?)";
		ConnectDB conn = new ConnectDB();
		try {
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			pst.setString(1, this.getUsername());
			pst.setString(2, this.getPassword());
			pst.setInt(3, this.getPermission());			
			if(pst.executeUpdate()>0)
				return defaultValues.increaseDefaultValue("currentuser");
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.closeConnet();
		return false;
		
	}
		
		
		
		
		
		public  boolean deleteUser(String usr) throws Exception{
			
			String sql = "delete from users where username=?";
			ConnectDB conn = new ConnectDB();
			try {
				PreparedStatement pst = conn.openConnect().prepareStatement(sql);
				pst.setString(1, usr);				
				return pst.executeUpdate()>0;	
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn.closeConnet();
			return false;
			
		}
}
