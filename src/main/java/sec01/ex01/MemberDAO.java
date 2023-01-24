package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;


	public MemberDAO() {
		try
		{
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List listMembers() {
		List list = new ArrayList();
		try {
			con = dataFactory.getConnection();
			String query = "SELECT * FROM SHOPPING_USER ORDER BY USER_DATE DESC";
			System.out.println("preparedStatement : " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("USER_ID");
				String pwd = rs.getString("USER_PWD");
				String name = rs.getString("USER_NAME");
				String phone = rs.getString("USER_PHONE");
				Date date = rs.getDate("USER_DATE");
				
				MemberBean vo = new MemberBean();
				vo.setUser_id(id);
				vo.setUser_pwd(pwd);
				vo.setUser_name(name);
				vo.setUser_phone(phone);
				vo.setUser_date(date);
				list.add(vo);
			}
			
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void addMember(MemberBean memberBean) {
		
		try {
			Connection con = dataFactory.getConnection();
			
			String id = memberBean.getUser_id();
			String pwd = memberBean.getUser_pwd();
			String name = memberBean.getUser_name();
			String phone = memberBean.getUser_phone();
			
			String query = "INSERT INTO SHOPPING_USER";
			query += "(USER_ID, USER_PWD, USER_NAME, USER_PHONE)";
			query += "VALUES (?,?,?,?)";
			System.out.println("preparedStatement : " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			pstmt.executeUpdate();
			pstmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
