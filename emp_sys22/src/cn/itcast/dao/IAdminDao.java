package cn.itcast.dao;

import cn.itcast.entity.Admin;

/**
 * 2. ����Ա���ݷ��ʲ�ӿ����
 * @author Jie.Yuan
 *
 */
public interface IAdminDao {

	/**
	 * �����û��������ѯ
	 * @param admin
	 * @return
	 */
	Admin findByNameAndPwd(Admin admin);
}
