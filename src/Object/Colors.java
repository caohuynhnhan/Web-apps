package Object;

import java.sql.ResultSet;
import java.util.ArrayList;



import Model.ConnectDB;

public class Colors {
	private String value;
	private int id;
	public Colors() {
		
	}
	public  Colors(int id, String value) {
		this.setValue(value);
		this.setId(id);
	}
	public static ArrayList<Colors> getAllColor() throws Exception{
		ArrayList<Colors> lst = new ArrayList<>();
		ConnectDB conn = new ConnectDB();
		String sql = "select * from colors";
		Colors c = null;
		try {
			ResultSet rs = conn.getStatement().executeQuery(sql);
			while(rs.next())
			{
				int id = rs.getInt("id");
				String col = rs.getString("value");
				c = new Colors(id, col);
				lst.add(c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.closeConnet();
		return lst;
		
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
