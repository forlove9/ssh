package cn.itcast.d_tx;

import org.junit.Test;

public class App {

	@Test
	public void testname() throws Exception {
		
		// ת��
		AccountDao accountDao = new AccountDao();
		accountDao.trans();
	}
}
