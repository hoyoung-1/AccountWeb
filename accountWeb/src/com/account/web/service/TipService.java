package com.account.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.account.web.entity.Tip;

public class TipService {
	
	private final String URL ="jdbc:oracle:thin:@localhost:1521:hy";
	private final String ID ="account";
	private final String PW = "account";
	
	// list를 출력
	public List<Tip> getList(){
		List<Tip> list = new ArrayList<Tip>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(URL,ID,PW);
			
			String sql = "select * from tip";

			Statement st = con.createStatement();
	
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
			
			}

			
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("driver 에러");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sql 에러");
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean insert(int userNo,String title,String content,String writer) {
		
		boolean flag = false;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection(URL,ID,PW);
			
			String sql = "insert into tip(user_no,tip_no,title,content,writer)" + 
					"values (?,seq_tip.nextval,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			ps.setString(2, title);
			ps.setString(3, content);
			ps.setString(4, writer);
			
			int result = ps.executeUpdate();
			
			if(result > 0) {
				flag = true;
			}
					
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
		
	}
}
