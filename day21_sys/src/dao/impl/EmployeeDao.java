package dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.IEmployee;
import entity.Employee;
import utils.JdbcUtils;

public class EmployeeDao implements IEmployee {

	@Override
	public List<Employee> getAll() {
		try {
			String sql="select * from employee ";
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<Employee>(Employee.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
