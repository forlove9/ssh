package cn.itcast.a_generic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * ���ͻ����÷�
 * @author Jie.Yuan
 *
 */
public class App {

	// ����ʱ���쳣 
	@Test
	public void testGeneric() throws Exception {
		// ���ϵ�����
		List list = new ArrayList();
		list.add("China");
		list.add(1);
		
		// ���ϵ�ʹ��
		String str = (String) list.get(1);
		
	}
	
	// ʹ�÷���
	@Test
	public void testGeneric2() throws Exception {
		// �������ͼ��ϵ�ʱ��ָ��Ԫ�ص�����
		List<String> list = new ArrayList<String>();
		list.add("China");
//		list.add(1);// ����ʱ�ڱ���
		
		String str = list.get(1); 
	}
	
	/*
	 * ���Ͳ���ʵ�� 
	 
	public void save(List<Person> p){
	}
	public void save(List<Dept> d){    // ���� �����淽�������һ��
	}
	*/
	
	// ����д��
	@Test
	public void testGeneric3() throws Exception {
		// �������ͼ��ϣ������������ͱ���һ��
		List<Object> list = new ArrayList<Object>();
		List<String> list1 = new ArrayList<String>();
		List list2 = new ArrayList<String>();
		List<Integer> list3 = new ArrayList();
		
		// ����
		//List<Object> list4 = new ArrayList<String>();
		// ���� �������ͱ�������������,����Ϊ��������
		// List<int> list5 = new ArrayList<int>();
	}
	
}












