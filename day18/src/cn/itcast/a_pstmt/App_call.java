package cn.itcast.a_pstmt;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.utils.JdbcUtil;

public class App_call {
	
	// ȫ�ֲ���
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private CallableStatement cstmt;  // �洢����
	private ResultSet rs;
	

	// �����е��ô洢����
	@Test
	public void testCall() throws Exception {
		
		try {
			//1 . ��������
			con = JdbcUtil.getConnection();
			//2.  ����ִ�д洢���̵�stmt����
			CallableStatement cstmt = con.prepareCall("CALL proc_login");
			//3.  ִ�У��洢���̣�
			rs = cstmt.executeQuery();
			
			// �������������
			if (rs.next()) {
				String name = rs.getString("userName");
				String pwd = rs.getString("pwd");
				// ����
				System.out.println(name + pwd);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




















