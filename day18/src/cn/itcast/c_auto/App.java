package cn.itcast.c_auto;

import org.junit.Test;

public class App {

	// ����Ա��
	@Test
	public void testSave() throws Exception {
		// ģ������
		Dept d = new Dept();
		d.setDeptName("Ӧ�ÿ�����");
		Employee emp = new Employee();
		emp.setEmpName("���");
		emp.setDept(d);   // ����
		
		// ����dao����
		EmpDao empDao = new EmpDao();
		empDao.save(emp);
		
	}
}
