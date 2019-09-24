package cn.itcast.service;

import cn.itcast.entity.Admin;
import cn.itcast.exception.UserExistsException;

/**
 * ҵ���߼���ӿ����
 * @author Jie.Yuan
 *
 */
public interface IAdminService {

	/**
	 * ע��
	 */
	void register(Admin admin) throws UserExistsException;
	
	/**
	 * ��½
	 */
	Admin login(Admin admin);
}
