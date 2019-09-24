package cn.itcast.test.dao.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.test.dao.TestDao;
import cn.itcast.test.entity.Person;

public class TestDaoImpl extends HibernateDaoSupport implements TestDao {
	/**
	 * 因为hibernateDaoSupport类中的setSessionFactory方法是final定义的
	 * 所以子类不能重写此方法，也就不能通过注解的方式注入sessionFactory。只能在配置文件
	 * 中配置testDao*/
	@Override
	public void save(Person person) {
		getHibernateTemplate().save(person);
	}

	@Override
	public Person findPerson(Serializable id) {
		return getHibernateTemplate().get(Person.class, id);
	}

}
