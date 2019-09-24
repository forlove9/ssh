package cn.itcast.e_longtext;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.utils.JdbcUtil;

public class App_text {
	
	// ȫ�ֲ���
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	

	@Test
	// 1. ������ı���������   ( дlongtext)
	public void testSaveText() {
		String sql = "insert into test(content) values(?)";
		try {
			// ����
			con = JdbcUtil.getConnection();
			// pstmt ����
			pstmt = con.prepareStatement(sql);
			// ���ò���
			// �Ȼ�ȡ�ļ�·��
			String path = App_text.class.getResource("tips.txt").getPath();
			FileReader reader = new FileReader(new File(path));
			pstmt.setCharacterStream(1, reader);
			
			// ִ��sql
			pstmt.executeUpdate();
			
			// �ر�
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(con, pstmt, null);
		}
	}
	
	@Test
	// 2. ��ȡ���ı���������   ( ��longtext)
	public void testGetAsText() {
		String sql = "select * from  test;";
		try {
			// ����
			con = JdbcUtil.getConnection();
			// pstmt ����
			pstmt = con.prepareStatement(sql);
			// ��ȡ
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// ��ȡ���ı�����, ��ʽ1:
				//Reader r = rs.getCharacterStream("content");
				
				// ��ȡ���ı�����, ��ʽ2:
				System.out.print(rs.getString("content"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(con, pstmt, null);
		}
	}
}
