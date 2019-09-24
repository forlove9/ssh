package cn.itcast.b_metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

import cn.itcast.utils.JdbcUtil;

public class App {

	//1. ���ݿ�Ԫ����
	@Test
	public void testDB() throws Exception {
		
		// ��ȡ����
		Connection conn = JdbcUtil.getConnection();
		// ��ȡ���ݿ�Ԫ����
		DatabaseMetaData metaData = conn.getMetaData();// alt + shift + L  ���ٻ�ȡ��������ֵ
		
		System.out.println(metaData.getUserName());
		System.out.println(metaData.getURL());
		System.out.println(metaData.getDatabaseProductName());
	}
	
	//2. ����Ԫ����
	@Test
	public void testParams() throws Exception {
		// ��ȡ����
		Connection conn = JdbcUtil.getConnection();
		// SQL
		String sql = "select * from dept where deptid=? and deptName=?";
		// Object[] values = {"tom","888"};
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// ����Ԫ����
		ParameterMetaData p_metaDate = pstmt.getParameterMetaData();
		// ��ȡ�����ĸ���
		int count = p_metaDate.getParameterCount();
		
		
		// ����
		System.out.println(count);
	}
	
	// 3. �����Ԫ����
	@Test
	public void testRs() throws Exception {
		String sql = "select * from dept ";
		
		// ��ȡ����
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		// �õ������Ԫ����(Ŀ�꣺ͨ�������Ԫ���ݣ��õ��е�����)
		ResultSetMetaData rs_metaData = rs.getMetaData();
		
		// ����ÿһ�н��
		while (rs.next()) {
			// 1. ��ȡ�еĸ���
			int count = rs_metaData.getColumnCount();
			// 2. ��������ȡÿһ�е��е�����
			for (int i=0; i<count; i++) {
				// �õ��е�����
				String columnName = rs_metaData.getColumnName(i + 1);
				// ��ȡÿһ�е�ÿһ�е�ֵ
				Object columnValue = rs.getObject(columnName);
				// ����
				System.out.print(columnName + "=" + columnValue + ",");
			}
			System.out.println();
		}
		
	}
	
	
	
}








