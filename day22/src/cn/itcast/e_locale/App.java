package cn.itcast.e_locale;

import java.util.Locale;

import org.junit.Test;

public class App {

	@Test
	//1. ���ػ�����:Locale
	// ��װ���ԡ�������Ϣ�Ķ�����java.util�ṩ
	public void testLocale() throws Exception {
		// ģ���й����ԵȻ���
		//Locale locale = Locale.CHINA;
		Locale locale = Locale.getDefault();			// ��ǰϵͳĬ�ϵ����Ի���
		System.out.println(locale.getCountry());   		// CN  ���ҵļ��
		System.out.println(locale.getDisplayCountry()); // ��������
		System.out.println(locale.getLanguage());		// zh ���Լ��
		
		// ģ����������
		Locale l_us = Locale.US;
		System.out.println(l_us.getCountry());
		System.out.println(l_us.getDisplayCountry());
	}
}







