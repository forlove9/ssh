package cn.itcast.dao;

import cn.itcast.entity.Admin;

public interface IAdminDao {
	 
		void save(Admin admin);

		/**
		 * 根据管理员信息查询
		 * @param admin  管理员对象
		 * @return	返回查询后的结果
		 */
		Admin findByAdmin(Admin admin);

}
