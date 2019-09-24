package cn.itcast.f_log4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;


public class App {
	
	Log log = LogFactory.getLog(App.class);
	
	@Test
	public void save() {
		try {
			log.info("���棺 ��ʼ���뱣�淽��");

			int i = 1/0;
			
			log.info("���棺 ִ�б���������ɹ�");
		} catch (Exception e) {
			
			log.error("ִ��App��Save()���������쳣��");  // �쳣
			
			e.printStackTrace();
		}
	}
	
	/*
	 * ˼���� ��־������������ã�
	 * 	 ----> ������־��������ݡ�
	 */
	@Test
	public void testLog() throws Exception {
		// �����ͬ�������ʾ
		log.debug("������Ϣ");
		log.info("��Ϣ��ʾ");
		log.warn("����");
		log.error("�쳣");
		
	}
}
