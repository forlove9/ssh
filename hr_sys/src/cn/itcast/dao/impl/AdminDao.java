package cn.itcast.dao.impl;

import org.hibernate.SessionFactory;

import cn.itcast.dao.IAdminDao;
import cn.itcast.entity.Admin;

public class AdminDao implements IAdminDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void save(Admin admin) {
		sessionFactory.getCurrentSession().save(admin);
		
	}

	public Admin findByAdmin(Admin admin) {
		return (Admin) sessionFactory.getCurrentSession()
				.createQuery("form Admin where adminName=? and pwd=?")
				.setParameter(0,admin.getAdminName())
				.setParameter(1,admin.getPwd())
				.uniqueResult();

	}

}
