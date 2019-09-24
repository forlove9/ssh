package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import cn.itcast.dao.IEmployeeDao;
import cn.itcast.entity.Employee;

public class EmployeeDao implements IEmployeeDao{
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void save(Employee emp) {
		sessionFactory.getCurrentSession().save(emp);
	}

	public void update(Employee emp) {
		sessionFactory.getCurrentSession().update(emp);
	}

	public void delete(int id) {
		sessionFactory
		.getCurrentSession()
		.createQuery("delete from Employee where id=?")
		.setParameter(0, id)
		.executeUpdate();
	}

	public Employee findById(int id) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAll(String employeeName) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Employee where empName like ?")
				.setString(1, "%"+employeeName+"%")
				.list();
	}

}
