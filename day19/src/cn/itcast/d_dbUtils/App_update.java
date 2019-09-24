package cn.itcast.d_dbUtils;

import java.sql.Connection;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import cn.itcast.utils.JdbcUtil;

public class App_update {

	private Connection conn;

	// 1. ����
	@Test
	public void testUpdate() throws Exception {
		String sql = "delete from admin where id=?";
		// ���Ӷ���
		conn = JdbcUtil.getConnection();

		// ����DbUtils���Ĺ��������
		QueryRunner qr = new QueryRunner();
		qr.update(conn, sql, 26);

		// �ر�
		DbUtils.close(conn);
	}

	// 2. ������
	@Test
	public void testBatch() throws Exception {
		String sql = "insert into admin (userName, pwd) values(?,?)";
		conn = JdbcUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		// ����ɾ��
		qr.batch(conn, sql, new Object[][]{ {"jack1","888"},{"jack2","999"}  });
		
		// �ر�
		conn.close();
	}
}
