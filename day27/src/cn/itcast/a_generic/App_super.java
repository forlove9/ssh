package cn.itcast.a_generic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * ����, �漰��һЩ�ؼ���
 * 
 * Ctrl + shift + R   �鿴��ǰ��Ŀ����
 * Ctrl + shift + T   �鿴Դ��jar���е���
 * @author Jie.Yuan
 *
 */
public class App_super {
	
	
	/**
	 * super�޶�Ԫ�ط�Χ��������String����   �����ޡ�
	 * @param list
	 */
	public void save(List<? super String> list) {
	}

	@Test
	public void testGeneric() throws Exception {
		// �������淽�������봫��String�ĸ���
		List<Object> list1 = new ArrayList<Object>();
		List<String> list2 = new ArrayList<String>();
		
		List<Integer> list3 = new ArrayList<Integer>();
		//save(list3);
	}
}












