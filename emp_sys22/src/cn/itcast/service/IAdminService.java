package cn.itcast.service;

import cn.itcast.entity.Admin;

/**
 * 3. ����Աҵ���߼���
 * @author Jie.Yuan
 *
 */
public interface IAdminService {

	/**
	 * �����û��������ѯ
	 * @param admin
	 * @return
	 */
	Admin findByNameAndPwd(Admin admin);
}
