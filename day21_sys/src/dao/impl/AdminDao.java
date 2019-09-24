package dao.impl;



import org.apache.commons.dbutils.handlers.BeanHandler;

import dao.IAdminDao;
import entity.Admin;
import utils.JdbcUtils;

public class AdminDao implements IAdminDao {

	@Override
	public Admin findByNameAndPwd(Admin admin) {
		try {
			String sql="select * from admin where username=? and pwd=?";
			return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<Admin>(Admin.class),
					admin.getUsername(),
					admin.getPwd());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
