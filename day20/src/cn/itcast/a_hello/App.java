package cn.itcast.a_hello;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.itcast.utils.JdbcUtil;

public class App {

	// 1. ʹ��DbUtils�������
	@Test
	public void testUpdate() throws Exception {
		String sql = "delete from admin where id=10;";
		//1.1 ����
		Connection con = JdbcUtil.getConnection();
		//1.2 �������Ĺ�����
		QueryRunner qr = new QueryRunner();
		//1.3 ����
		qr.update(con, sql);
		
		con.close();
	}
	
	// 2. ʹ��DbUtils�����ѯ
	@Test
	public void testQuery() throws Exception {
		String sql = "select * from admin";
		//1.1 ����
		Connection con = JdbcUtil.getConnection();
		//1.2 �������Ĺ�����
		QueryRunner qr = new QueryRunner();
		//1.3 ��ѯ
		List<Admin> list = qr.query(con, sql, new BeanListHandler<Admin>(Admin.class));
		
		System.out.println(list);
		
		con.close();
	}
}












