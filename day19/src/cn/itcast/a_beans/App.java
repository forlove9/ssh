package cn.itcast.a_beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

public class App {

	//1. ��javabean�Ļ�������
	@Test
	public void test1() throws Exception {
		
		// a. ��������
		Admin admin = new Admin();
//		admin.setUserName("Jack");
//		admin.setPwd("999");
		
		// b. BeanUtils���ʵ�ֶ������ԵĿ���
		BeanUtils.copyProperty(admin, "userName", "jack");
		BeanUtils.setProperty(admin, "age", 18);
		
		// �ܽ�1�� ���ڻ����������ͣ����Զ���������ת��!
		
		
		// c. ����Ŀ���
		Admin newAdmin = new Admin();
		BeanUtils.copyProperties(newAdmin, admin);
		
		// d. map���ݣ�������������
		Admin adminMap = new Admin();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userName", "Jerry");
		map.put("age", 29);
		// ע�⣺map�е�keyҪ��javabean����������һ��
		BeanUtils.populate(adminMap, map);
		
		// ����
		System.out.println(adminMap.getUserName());
		System.out.println(adminMap.getAge());
	}
	
	
	//2. �Զ�����������ת����
	@Test
	public void test2() throws Exception {
		// ģ�������
		String name = "jack";
		String age = "20";
		String birth = "   ";
		
		// ����
		Admin admin = new Admin();
		
		// ע����������ת������1�� �Զ���ķ�ʽ
		ConvertUtils.register(new Converter() {
			// ת�����ڲ�ʵ�ַ�������Ҫ��д
			@Override
			public Object convert(Class type, Object value) {
				
				// �ж�
				if (type != Date.class) {
					return null;
				}
				if (value == null || "".equals(value.toString().trim())) {
					return null;
				}
				
				
				try {
					// �ַ���ת��Ϊ����
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					return sdf.parse(value.toString());
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
		},Date.class);
		
		
		
		// �ѱ��ύ�����ݣ���װ��������
		BeanUtils.copyProperty(admin, "userName", name);
		BeanUtils.copyProperty(admin, "age", age);
		BeanUtils.copyProperty(admin, "birth", birth);
		
		//------ ����------
		System.out.println(admin);
	}
	
	//2. ʹ���ṩ����������ת����������
	@Test
	public void test3() throws Exception {
		// ģ�������
		String name = "userName";
		String age = "20";
		String birth = null;
		
		// ����
		Admin admin = new Admin();
		
		// ע����������ת������2�� ʹ������ṩ��ת����������
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
				
		// �ѱ��ύ�����ݣ���װ��������
		BeanUtils.copyProperty(admin, "userName", name);
		BeanUtils.copyProperty(admin, "age", age);
		BeanUtils.copyProperty(admin, "birth", birth);
		
		//------ ����------
		System.out.println(admin);
	}
}







