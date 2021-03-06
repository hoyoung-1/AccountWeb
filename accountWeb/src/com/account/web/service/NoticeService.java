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

			
			rs.close();
			ps.close();
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
	
	// 공지사항의 총 갯수
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
		return count;
	}
	
	
	// 세부 내용을 가져오는 메소드
	public Notice detail(int noticeNo) {
		Notice notice = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(URL,ID,PW);
			
			String sql = "SELECT * FROM notice where notice_no=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, noticeNo);

			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int getNoticeNo = rs.getInt("notice_no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				notice = new Notice(getNoticeNo, title, content, writer, regdate);
			}

			rs.close();
			ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("driver 에러");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sql 에러");
			e.printStackTrace();
		}

		return notice;
	}

	public boolean insert(String title, String content) {
		
		boolean flag = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(URL,ID,PW);
			
			String sql = "INSERT INTO notice(notice_no,title,content,writer)"
					+ " VALUES (seq_notice.nextval,?,?,'관리자')";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			
			int flag_ = ps.executeUpdate();
			
			if(flag_ > 0) {
				flag = true;
			}
			
			ps.close();
			con.close();
			

		} catch (ClassNotFoundException e) {
			System.out.println("driver 에러");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sql 에러");
			e.printStackTrace();
		}
	
		return flag;
	}

	public boolean delete(int noticeNo) {
		
		boolean flag = false;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(URL,ID,PW);
			
			String sql = "delete from notice where notice_no=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, noticeNo);
			
			int flag_ = ps.executeUpdate();
			
			if(flag_ > 0) {
				flag = true;
			}
			
			ps.close();
			con.close();
			

		} catch (ClassNotFoundException e) {
			System.out.println("driver 에러");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sql 에러");
			e.printStackTrace();
		}
		
		return flag;
	}

	public Notice getPrev(int noticeNo) { // 이전 게시물
		Notice notice = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(URL,ID,PW);
			
			String sql = "SELECT n.*, rownum " + 
					"FROM (" + 
					"    select * " + 
					"    from notice " + 
					"    order by regdate desc" + 
					") n " + 
					"where notice_no < ? and rownum =1";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, noticeNo);

			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int getNoticeNo = rs.getInt("notice_no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				notice = new Notice(getNoticeNo, title, content, writer, regdate);
			}

			rs.close();
			ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("driver 에러");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sql 에러");
			e.printStackTrace();
		}
		
		
		
		return notice;
	}

	public Notice getNext(int noticeNo) {
		
		
		Notice notice = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(URL,ID,PW);
			
			String sql = "select rownum, n.* from notice n" + 
					"	where regdate > (" + 
					"    select regdate" + 
					"    from notice" + 
					"    where notice_no = ?" + 
					") and rownum = 1";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, noticeNo);

			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int getNoticeNo = rs.getInt("notice_no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				notice = new Notice(getNoticeNo, title, content, writer, regdate);
			}

			rs.close();
			ps.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("driver 에러");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sql 에러");
			e.printStackTrace();
		}
		
		
		
		return notice;
	}
	
	
}
