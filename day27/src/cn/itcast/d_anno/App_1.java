package cn.itcast.d_anno;

import java.util.List;

import org.junit.Test;

/**
 * ���õ�ע��
 * @author Jie.Yuan
 *
 */
public class App_1 {

	// ��д����ķ���
	@Override
	public String toString() {
		return super.toString();
	}
	
	// ���Ʊ���������
	@SuppressWarnings(value = {"unused","unchecked"})
	private void save() {
		List list = null;
	}
	
	// ��Ƿ����Լ���ʱ
	@Deprecated
	private void save1() {
	}
	
	
	@Test
	public void testMain() throws Exception {
	}
}
