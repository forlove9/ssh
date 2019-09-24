package cn.itcast.b_batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import cn.itcast.utils.JdbcUtil;

// ��װ���е������ݿ�Ĳ���
public class AdminDao {
	
	// ȫ�ֲ���
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// �����������Ա
	public void save(List<Admin> list) {
		// SQL
		String sql = "INSERT INTO admin(userName,pwd) values(?,?)";
		
		try {
			
			// ��ȡ����
			con = JdbcUtil.getConnection();
			// ����stmt 
			pstmt = con.prepareStatement(sql);   		// ��Ԥ����SQL��䡿
			
			for (int i=0; i<list.size(); i++) {
				Admin admin = list.get(i);
				// ���ò���
				pstmt.setString(1, admin.getUserName());
				pstmt.setString(2, admin.getPwd());
				
				// ���������
				pstmt.addBatch();						// ������Ҫ����SQL��
				
				// ���ԣ�ÿ5��ִ��һ��������
				if (i % 5 == 0) {
					// ����ִ�� 
					pstmt.executeBatch();
					// ���������
					pstmt.clearBatch();
				}
				
			}
			
			// ����ִ�� 
			pstmt.executeBatch();
			// ���������
			pstmt.clearBatch();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(con, pstmt, rs);
		}
	}
}

















