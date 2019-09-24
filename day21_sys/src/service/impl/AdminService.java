package service.impl;

import dao.IAdminDao;
import dao.impl.AdminDao;
import entity.Admin;
import service.IAdminService;

public class AdminService implements IAdminService{
	private IAdminDao admindao=new AdminDao();
	@Override
	public Admin findByNameAndPwd(Admin admin) {
		// TODO Auto-generated method stub
		try {
			return admindao.findByNameAndPwd(admin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
