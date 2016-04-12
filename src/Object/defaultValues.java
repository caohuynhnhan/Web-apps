package Object;

import java.sql.PreparedStatement;
import java.sql.ResultSet;



import Model.ConnectDB;

public class defaultValues {
	private String key;
	private String value;
	public defaultValues(){
		// TODO Auto-generated constructor stub
	}
	public defaultValues(String id, String value) {
		this.setKey(id);
		this.setValue(value);
	}
	public static boolean increaseDefaultValue(String Key) {
				
		String sql = "update defaultvalues set defaultvalue=? where id=?";
		ConnectDB conn = new ConnectDB();
		try {
			int dv = Integer.valueOf(defaultValues.getDefaultValue(Key));
			dv+=1;
			PreparedStatement pst = conn.openConnect().prepareStatement(sql);
			pst.setString(1, String.valueOf(dv));
			pst.setString(2, Key);
			return pst.executeUpdate()>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
				
	}
	public static String getDefaultValue(String Key) throws Exception {
		String sql = "select defaultvalue from defaultvalues where id=?";
		ConnectDB conn = new ConnectDB();
		PreparedStatement pst;
		try {
			pst = conn.openConnect().prepareStatement(sql);
			pst.setString(1, Key);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getString("defaultvalue");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Không rõ";
	}
	public String getKey() {
		return key;
	}
	public void setKey(String id) {
		this.key = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
