package cn.itcast.d_debug;

import org.junit.Test;

/**
 * 1. Ϊʲô�õ��ԣ�
 * 	������������> �������   �������кܿ죬������������ܳ������⣬ϣ��������ָ��λ��ֹͣ������
 *  ������������> �Ա��ڹ۲����ֵ�ı仯
 * 
 * 2. ���öϵ㣺  ���öϵ��ÿһ���ط������򶼻�ֹͣ����!
 *    Ҫѡ��debugģʽ���г���
 * 3. ����
 * 	   F5  step into  ��������  �����뷽����
 *     F6  step over  ��������
 *     F7  step return ��������
 *     F8  resume     �����������г��򣬻���������һ���ϵ�
 *
 * 4. web��Ŀ����
 *  ----> �����ύ��servlet�ĵ�һ�У����öϵ㣬���ԣ�
 */
public class App {
	int r;

	@Test
	public void testApp() throws Exception {
		Cal cal = new Cal();
		int sum = cal.sum(1,13,2);
		System.out.println("��:" + sum);
	}
	
	
	public static void main(String[] args) {
		
	}
}
