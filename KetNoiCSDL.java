package ThiCuoiKi;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




public class KetNoiCSDL {
	private String dbclass = "com.mysql.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/qlpb";
	private String USERNAME = "root";
	private String PASSWORD = "";
	private Connection conn;
	private Statement state;
	public KetNoiCSDL() {
		try {
			Class.forName(dbclass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			this.state = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean isValidUser(String username, String password) {
		String sql = "SELECT `username`, `password` FROM `nhanvien` WHERE username='"+username+"' and password ='"+password+"'";
		ResultSet rs = null;
		try {
			rs = state.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs.next()) {
				//String username1 = rs.getString("username");
				//String password1 = rs.getString("password");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void addUser(String username, String password, String fullname, int idpb) {
		String sql = "INSERT INTO `nhanvien` (`id`, `username`, `password`, `fullname`, `idpb`)"
				+ " VALUES (NULL, '"+username+"', '"+password+"', '"+fullname+"', '"+idpb+"')";
		try {
			state.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editUser(String username, String fullname, int idpb) {
		String sql = "UPDATE `nhanvien` SET `fullname` = '"+fullname+"', `idpb` = '"+idpb+"' WHERE `nhanvien`.`username` = '"+username.trim()+"'";
		try {
			state.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteUser(String username) {
		String sql = "DELETE FROM `nhanvien` WHERE username='"+username.trim()+"'";
		try {
			state.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void displayListUser() {
		String sql = "SELECT * FROM nhanvien";
		ResultSet rs = null;
		try {
			rs = state.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("Id") + rs.getString("username") 
				+ rs.getString("password") + rs.getString("fullname") + rs.getInt("idpb"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String displayUserByUsername(String username) {
		String sql = "SELECT * FROM `nhanvien` WHERE username='"+username.trim()+"'";
		ResultSet rs = null;
		try {
			rs = state.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs.next()) {
				return rs.getInt("Id") + rs.getString("username") 
				+ rs.getString("password") + rs.getString("fullname") + rs.getInt("idpb");
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(new KetNoiCSDL().isValidUser("admin", "123456")); 
//		new KetNoiCSDL().displayListUser();
//		new KetNoiCSDL().displayUserByUsername("phongphamfc");
//		new KetNoiCSDL().addUser("dieppham", "123456", "Pham Dinh Diep", 2);
//		new KetNoiCSDL().editUser("dieppham", "Ai biet", 3);
//		new KetNoiCSDL().deleteUser("dieppham");
//		new KetNoiCSDL().displayListUser();
	}
	
}

