package cn.itcast.service;

import java.util.List;

import cn.itcast.entity.Employee;

/**
 * 2. Ա��ҵ���߼���
 * @author Jie.Yuan
 *
 */
public interface IEmployeeService {

	/**
	 * ��ѯ���е�Ա��
	 * @return
	 */
	List<Employee> getAll();
}
