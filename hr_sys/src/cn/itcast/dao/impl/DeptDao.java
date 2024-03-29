package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import cn.itcast.dao.IDeptDao;
import cn.itcast.entity.Dept;

public class DeptDao implements IDeptDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	public List<Dept> getAll() {
		return  sessionFactory.getCurrentSession().createQuery("from Dept").list();
	}

	public Dept findById(int id) {
		return (Dept) sessionFactory.getCurrentSession().get(Dept.class,id);
	}

}
