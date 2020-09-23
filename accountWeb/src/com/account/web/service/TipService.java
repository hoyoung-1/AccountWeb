package com.account.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.account.web.entity.Tip;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class TipService {
	
	private final String URL ="jdbc:oracle:thin:@localhost:1521:hy";
	private final String ID ="account";
	private final String PW = "account";
	
	// list를 출력
	public List<Tip> getList(int page){
		List<Tip> list = new ArrayList<Tip>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(URL,ID,PW);
			
			String sql = "select * " + 
					"from( " + 
					"select rownum num, a.* " + 
					"from ( " + 
					"    select * " + 
					"    from tip " + 
					"    order by regdate desc " + 
					"    ) a " + 
					") " + 
					"where num BETWEEN ? and ?";
			
			int start = 1 + (page-1)*10;
			int end = page * 10;

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int tipId = rs.getInt("tip_no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				
				Tip tip = new Tip(tipId, title, content, writer, regdate);
				list.add(tip);
			}

			
			rs.close();
			ps.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("driver 에러");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sql 에러 : getList()");
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
					
			ps.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
		
	}
	
	public int count() {
		int cnt =0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection(URL,ID,PW);
			
			String sql = "SELECT COUNT(*) cnt FROM tip";
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return cnt;
		
	}

}
