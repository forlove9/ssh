package cn.itcast.entity;

/**
 * 1. ʵ������� (��Ϊ����DbUtils���������Ҫ�����ݿ����ֶ�һ��)
 * @author Jie.Yuan
 *
 */
public class Employee {

	private int empId;			// Ա��id
	private String empName;		// Ա������
	private int dept_id;		// ����id
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int deptId) {
		dept_id = deptId;
	}
	
	
}