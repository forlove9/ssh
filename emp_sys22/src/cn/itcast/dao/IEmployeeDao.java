package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.Employee;

/**
 * 2. Ա�����ݷ��ʲ�ӿ����
 * @author Jie.Yuan
 *
 */
public interface IEmployeeDao {

	/**
	 * ��ѯ���е�Ա��
	 * @return
	 */
	List<Employee> getAll();
}
