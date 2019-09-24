package cn.itcast.c_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;


// ���似��
public class App {

	// 1. ��������
	@Test
	public void testInfo() throws Exception {
		// ��ȫ��
		String className = "cn.itcast.c_reflect.Admin";
		// �õ����ֽ���
		Class<?> clazz = Class.forName(className);
		
		// ��������1: Ĭ�Ϲ��캯����д
		//Admin admin = (Admin) clazz.newInstance();
		
		// ��������2�� ͨ����������������������
		Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
		Admin admin = (Admin) constructor.newInstance("Jack");
		
	}
	@Test
	//2. ��ȡ�������ơ�ֵ
	public void testField() throws Exception {
		
		// ��ȫ��
		String className = "cn.itcast.c_reflect.Admin";
		// �õ����ֽ���
		Class<?> clazz = Class.forName(className);
		// ����
		Admin admin =  (Admin) clazz.newInstance();
		
		// ��ȡ���е���������
		Field[]  fs =  clazz.getDeclaredFields();
		// ���������ÿһ���������ơ�ֵ
		for (Field f : fs) { 
			// ����ǿ�Ʒ���
			f.setAccessible(true);
			// ����
			String name = f.getName();
			// ֵ
			Object value = f.get(admin);
			
			System.out.println(name + value);
		}
	}
	
	@Test
	//3. �����ȡ����
	public void testMethod() throws Exception {
		
		// ��ȫ��
		String className = "cn.itcast.c_reflect.Admin";
		// �õ����ֽ���
		Class<?> clazz = Class.forName(className);
		// ����
		Admin admin =  (Admin) clazz.newInstance();
		
		// ��ȡ��������    public int getId() {
		Method m = clazz.getDeclaredMethod("getId");
		// ���÷���
		Object r_value = m.invoke(admin);
		
		System.out.println(r_value);
	}
	
	
}









