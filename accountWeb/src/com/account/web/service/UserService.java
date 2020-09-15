package com.account.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {
	
	private final String URL ="jdbc:oracle:thin:@localhost:1521:hy";
	private final String ID ="account";
	private final String PW = "account";
	
	public boolean userAdd(String id, String pw,String name) {
		
		boolean result = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(URL,ID,PW);
			
			String sql = "INSERT INTO users(user_no,id,pw,name) VALUES (seq_user.nextval,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, name);
			
			int result_ = ps.executeUpdate();
			
			if(result_==1) {
				result = true;
			}else {
				result = false;
			}
		
			return result;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	
		
	}
}
