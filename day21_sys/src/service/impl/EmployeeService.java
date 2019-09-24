package service.impl;

import java.util.List;

import dao.IEmployee;
import dao.impl.EmployeeDao;
import entity.Employee;
import service.IEmployeeService;

public class EmployeeService implements IEmployeeService {
	private IEmployee employeeDao=new EmployeeDao();
	@Override
	public List<Employee> getAll() {
		try {
			return employeeDao.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
}
