package cn.itcast.dao;

import cn.itcast.entity.Admin;

public interface IAdminDao {
	 
		void save(Admin admin);

		/**
		 * ���ݹ���Ա��Ϣ��ѯ
		 * @param admin  ����Ա����
		 * @return	���ز�ѯ��Ľ��
		 */
		Admin findByAdmin(Admin admin);

}
