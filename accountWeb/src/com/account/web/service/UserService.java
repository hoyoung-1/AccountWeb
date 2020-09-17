package com.account.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.account.web.entity.Users;

public class UserService {
	
	private final String URL ="jdbc:oracle:thin:@localhost:1521:hy";
	private final String ID ="account";
	private final String PW = "account";
	
	// 회원가입
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
			}
			
			ps.close();
			con.close();
		
			return result;
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("driver 에러");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sql 문제 발생");
			e.printStackTrace();
		}
		
		return result;
	} // End userAdd
	
	
	// 로그인
	public Users login(String id, String pw) {
		Users user = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(URL,ID,PW);
			
			String sql = "select * from users where id = ? and pw = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, pw);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int userNo = rs.getInt("user_no");
				String getId = rs.getString("id");
				String getPw = rs.getString("pw");
				String name = rs.getString("name");
				Date regdate = rs.getDate("regdate");
				
				user = new Users(userNo, getId, getPw, name, regdate);
				
				System.out.println(user);
			}
			
			rs.close();
			ps.close();
			con.close();
	
			
		} catch (ClassNotFoundException e) {
			System.out.println("driver 에러");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sql 문제 발생");
			e.printStackTrace();
		}
		
		return user;
		
	}
}
