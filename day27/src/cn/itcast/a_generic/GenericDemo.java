package cn.itcast.a_generic;

import org.junit.Test;

/**
 * ���ͷ���/������
 * @author Jie.Yuan
 *
 */
public class GenericDemo<T> {

	// ���巺�ͷ���
	public <K> T save(T t,K k) {
		return null;
	}
	
	public void update(T t) {

	}
	
	// ���Է���
	@Test
	public void testMethod() throws Exception {
		
		// �����ࣺ  �ڴ���������������ʱ��ȷ������
		GenericDemo<String> demo = new GenericDemo<String>();
		demo.save("test", 1);
	}
}
