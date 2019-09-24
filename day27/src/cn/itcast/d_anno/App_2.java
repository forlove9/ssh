package cn.itcast.d_anno;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.persistence.Table;


import org.junit.Test;

/**
 * ���ԣ��Զ���ע����﷨
 * @author Jie.Yuan
 *
 */
public class App_2 {
	
	private String test;
	
	@Id
	@Author(remark = "������Ϣ������", age = 19)
	public void save() throws Exception {
		// ��ȡע����Ϣ�� name/age/remark
		
		// 1. �Ȼ�ȡ��������Method����;
		Class clazz = App_2.class;
		Method m = clazz.getMethod("save");
		
		// 2. �ٻ�ȡ�����ϵ�ע��
		Author author = m.getAnnotation(Author.class);
		// ��ȡ���ע����Ϣ
		System.out.println(author.authorName());
		System.out.println(author.age());
		System.out.println(author.remark());
	}
	
	
	
	@Test
	public void testMain() throws Exception {
		save();
	}
}
