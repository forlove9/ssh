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
public class App_extends {
	
	
	/**
	 * list����ֻ�ܴ��� Double/Float/Integer������
	 * �޶�Ԫ�ط�Χ��Ԫ�ص�����Ҫ�̳���Number��  (����)
	 * @param list
	 */
	public void save(List<? extends Number> list) {
	}

	@Test
	public void testGeneric() throws Exception {
		List<Double> list_1 = new ArrayList<Double>();
		List<Float> list_2 = new ArrayList<Float>();
		List<Integer> list_3 = new ArrayList<Integer>();
		
		List<String> list_4 = new ArrayList<String>();
		
		// ����
		save(list_1);
		save(list_2);
		save(list_3);
		//save(list_4);
	}
}












