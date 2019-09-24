package cn.itcast.a_pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.utils.JdbcUtil;

import java.sql.PreparedStatement;

public class App {
	
	
	// ȫ�ֲ���
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	

	// 1. û��ʹ�÷�ֹsqlע��İ���
	@Test
	public void testLogin() {
		
		// 1.0 ģ���½���û���������
		String userName = "tom";
		//String pwd = "8881";
		String pwd = " ' or 1=1 -- ";
		
		// SQL���
		String sql = "select * from admin where userName='"+userName+"'  and pwd='"+pwd+"' ";
		System.out.println(sql);
		try {
			// 1.1 ������������������
			con = JdbcUtil.getConnection();
			// 1.2 ����stmt����
			stmt = con.createStatement();
			// 1.3 ִ�в�ѯ
			rs = stmt.executeQuery(sql);
			// ҵ���ж�
			if (rs.next()) {
				System.out.println("��½�ɹ�, ��ţ�" + rs.getInt("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 1.4 �ر�
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	// 2. ʹ��PreparedStatement, ��ֹsqlע��
	@Test
	public void testLogin2() {
		
		// 1.0 ģ���½���û���������
		String userName = "tom";
		//String pwd = "8881";
		String pwd = " ' or 1=1 -- ";
		
		// SQL���
		String sql = "select * from admin where userName=?  and pwd=? ";
		try {
			// 1.1 ������������������
			con = JdbcUtil.getConnection();
			// 1.2 ����pstmt����
			pstmt = con.prepareStatement(sql);   // ��sql���Ԥ����
			// ����ռλ��ֵ
			pstmt.setString(1, userName);
			pstmt.setString(2, pwd);
			
			// 1.3 ִ��
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("��½�ɹ���" + rs.getInt("id"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 1.4 �ر�
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}










