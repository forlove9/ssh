package cn.itcast.d_tx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import cn.itcast.utils.JdbcUtil;

public class AccountDao {

	// ȫ�ֲ���
	private Connection con;
	private PreparedStatement pstmt;

	// 1. ת�ˣ�û��ʹ������
	public void trans1() {

		String sql_zs = "UPDATE account SET money=money-1000 WHERE accountName='����';";
		String sql_ls = "UPDATE account SET money=money+1000 WHERE accountName='����';";

		try {
			con = JdbcUtil.getConnection(); // Ĭ�Ͽ�������ʿ����
			con.setAutoCommit(true);

			/*** ��һ��ִ��SQL ***/
			pstmt = con.prepareStatement(sql_zs);
			pstmt.executeUpdate();

			/*** �ڶ���ִ��SQL ***/
			pstmt = con.prepareStatement(sql_ls);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(con, pstmt, null);
		}

	}

	// 2. ת�ˣ�ʹ������
	public void trans2() {

		String sql_zs = "UPDATE account SET money=money-1000 WHERE accountName='����';";
		String sql_ls = "UPDATE1 account SET money=money+1000 WHERE accountName='����';";

		try {
			con = JdbcUtil.getConnection(); // Ĭ�Ͽ�������ʿ����
			// һ����������Ϊ�ֶ��ύ
			con.setAutoCommit(false);

			/*** ��һ��ִ��SQL ***/
			pstmt = con.prepareStatement(sql_zs);
			pstmt.executeUpdate();

			/*** �ڶ���ִ��SQL ***/
			pstmt = con.prepareStatement(sql_ls);
			pstmt.executeUpdate();

		} catch (Exception e) {
			try {
				// ���� �����쳣����Ҫ�ع�����
				con.rollback();
			} catch (SQLException e1) {
			}
			e.printStackTrace();
		} finally {
			try {
				// �������еĲ���ִ�гɹ�, �ύ����
				con.commit();
				JdbcUtil.closeAll(con, pstmt, null);
			} catch (SQLException e) {
			}
		}

	}

	// 3. ת�ˣ�ʹ������ �ع���ָ���Ĵ����
	public void trans() {
		// ��������
		Savepoint sp = null;
		
		// ��һ��ת��
		String sql_zs1 = "UPDATE account SET money=money-1000 WHERE accountName='����';";
		String sql_ls1 = "UPDATE account SET money=money+1000 WHERE accountName='����';";
		
		// �ڶ���ת��
		String sql_zs2 = "UPDATE account SET money=money-500 WHERE accountName='����';";
		String sql_ls2 = "UPDATE1 account SET money=money+500 WHERE accountName='����';";

		try {
			con = JdbcUtil.getConnection(); // Ĭ�Ͽ�������ʿ����
			con.setAutoCommit(false);       // ���������ֶ��ύ

			/*** ��һ��ת�� ***/
			pstmt = con.prepareStatement(sql_zs1);
			pstmt.executeUpdate();
			pstmt = con.prepareStatement(sql_ls1);
			pstmt.executeUpdate();
			
			// �ع������λ�ã�
			sp = con.setSavepoint(); 
			
			
			/*** �ڶ���ת�� ***/
			pstmt = con.prepareStatement(sql_zs2);
			pstmt.executeUpdate();
			pstmt = con.prepareStatement(sql_ls2);
			pstmt.executeUpdate();
			

		} catch (Exception e) {
			try {
				// �ع� (�ع���ָ���Ĵ����)
				con.rollback(sp);
			} catch (SQLException e1) {
			}
			e.printStackTrace();
		} finally {
			try {
				// �ύ
				con.commit();
			} catch (SQLException e) {
			}
			JdbcUtil.closeAll(con, pstmt, null);
		}

	}
}
