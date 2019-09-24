package cn.itcast.service.impl;

import cn.itcast.dao.IAdminDao;
import cn.itcast.dao.impl.AdminDao;
import cn.itcast.entity.Admin;
import cn.itcast.exception.UserExistsException;
import cn.itcast.service.IAdminService;

/**
 * 3. ҵ���߼���ʵ��
 * @author Jie.Yuan
 *
 */
public class AdminService implements IAdminService {

	// ���õ�dao
	private IAdminDao adminDao = new AdminDao();
	
	@Override
	public Admin login(Admin admin) {
		try {
			return adminDao.findByNameAndPwd(admin);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void register(Admin admin) throws UserExistsException  {
		
		try {
			// 1. �ȸ����û�����ѯ�û��Ƿ����
			boolean flag = adminDao.userExists(admin.getUserName());
			
			// 2. ����û����ڣ�������ע��
			if (flag){
				// ������ע��, ����������ʾ
				throw new UserExistsException("�û����Ѿ����ڣ�ע��ʧ�ܣ�");
			}
			
			// 3. �û������ڣ��ſ���ע��
			adminDao.save(admin);
		
		} catch (UserExistsException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
