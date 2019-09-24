package cn.itcast.d_dbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.junit.Test;

import cn.itcast.c_jdbc.Admin;
import cn.itcast.utils.JdbcUtil;

public class App_query {

	private Connection conn;

	// һ����ѯ�� �Զ���������װ����
	@Test
	public void testQuery() throws Exception {
		String sql = "select * from admin where id=?";
		// ��ȡ����
		conn = JdbcUtil.getConnection();
		// ����DbUtils���Ĺ��������
		QueryRunner qr = new QueryRunner();
		// ��ѯ
		Admin admin = qr.query(conn, sql, new ResultSetHandler<Admin>() {

			// ��η�װһ��Admin����
			public Admin handle(ResultSet rs) throws SQLException {
				if (rs.next()) {
					Admin admin = new Admin();
					admin.setId(rs.getInt("id"));
					admin.setUserName(rs.getString("userName"));
					admin.setPwd(rs.getString("pwd"));
					return admin;
				}
				return null;
			}

		}, 0);

		// ����
		System.out.println(admin);
		// �ر�
		conn.close();

	}
	
	// ������ѯ�� ʹ������ṩ�Ľ���������װ����
	
	// 1��BeanHandler: ��ѯ���ص�������
	@Test
	public void testQueryOne() throws Exception {
		String sql = "select * from admin where id=?";
		// ��ȡ����
		conn = JdbcUtil.getConnection();
		// ����DbUtils���Ĺ��������
		QueryRunner qr = new QueryRunner();
		// ��ѯ���ص�������
		Admin admin =  qr.query(conn, sql, new BeanHandler<Admin>(Admin.class), 29);
		
		System.out.println(admin);
		conn.close();
	}
	
	// 2��BeanListHandler: ��ѯ����list���ϣ�����Ԫ����ָ���Ķ���
	@Test
	public void testQueryMany() throws Exception {
		String sql = "select * from admin";
		conn = JdbcUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		// ��ѯȫ������
		List<Admin> list = qr.query(conn, sql, new BeanListHandler<Admin>(Admin.class));
		
		System.out.println(list);
		conn.close();
	}
	@Test
//	3) ArrayHandler, ��ѯ���ؽ����¼�ĵ�һ�У���װ�Զ�������, �����أ�Object[]
//	4) ArrayListHandler, �Ѳ�ѯ��ÿһ�ж���װΪ�������飬����ӵ�list������
//	5) ScalarHandler ��ѯ���ؽ����¼�ĵ�һ�еĵ�һ��  (�ھۺϺ���ͳ�Ƶ�ʱ����)
//	6) MapHandler  ��ѯ���ؽ���ĵ�һ����¼��װΪmap
	public void testArray() throws Exception {
		String sql = "select * from admin";
		conn = JdbcUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		// ��ѯ
		//Object[] obj = qr.query(conn, sql, new ArrayHandler());
		//List<Object[]> list = qr.query(conn, sql, new ArrayListHandler());
		//Long num = qr.query(conn, sql, new ScalarHandler<Long>());
		Map<String, Object> map = qr.query(conn,sql, new MapHandler());
		
		conn.close();
	}
	
	
	
}
