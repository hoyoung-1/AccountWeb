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

import com.account.web.entity.Notice;

public class NoticeService {

	private final String URL ="jdbc:oracle:thin:@localhost:1521:hy";
	private final String ID ="account";
	private final String PW = "account";
	
	public List<Notice> getList(int page){
		
		List<Notice> list = new ArrayList<Notice>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(URL,ID,PW);
			
			String sql = "select * from (" + 
					"select rownum num,n.*" + 
					"from (select * from notice order by notice_no desc) n" + 
					")" + 
					"where num between ? and ?";
			
			
			/// 1, 11, 21, 31 > 등차수열  an = 1 + (page-1)*10
			/// 10, 20, 30, 40 > page * 10
			
			int start = 1 + (page-1)*10;
			int end = page * 10;
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int noticeNo = rs.getInt("notice_no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				Notice notice = new Notice(noticeNo, title, content, writer, regdate);
				
				list.add(notice);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("driver 에러");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sql 에러");
			e.printStackTrace();
		}
		return list;
	}
	
	public int listCount () {
		
		int count = 0;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(URL,ID,PW);
			
			String sql = "select count(*)from notice";
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
		
			
		

		} catch (ClassNotFoundException e) {
			System.out.println("driver 에러");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sql 에러");
			e.printStackTrace();
		}
		return count;
	}
	
	
}
