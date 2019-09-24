package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.IEmployeeDao;
import cn.itcast.entity.Employee;
import cn.itcast.service.IEmployeeService;

public class EmployeeService implements IEmployeeService{
	private IEmployeeDao employeeDao;
	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public void save(Employee emp) {
		employeeDao.save(emp);
	}

	public void update(Employee emp) {
		employeeDao.update(emp);
		
	}

	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeDao.getAll();
	}

	public List<Employee> getAll(String employeeName) {
		return employeeDao.getAll(employeeName);
	}

	public void delete(int id) {
		employeeDao.delete(id);
		
	}

	public void deleteMany(int[] ids) {
		if (ids != null && ids.length >0) {
			for (int id : ids){
				delete(id);
			}
		}
		
	}

}
