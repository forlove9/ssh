package cn.itcast.c_session;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * �����˶���󶨵�session�ϵĹ��̣���Ҫʵ��session�ض��ӿ�
 * @author Jie.Yuan
 *
 */
public class Admin implements HttpSessionBindingListener {

	private int id;
	private String name;
	
	public Admin() {
		super();
	}
	public Admin(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	// ���캯��
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// �������session
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("Admin�����Ѿ�����session");
	}
	// �����session���Ƴ�
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("Admin�����session���Ƴ���");
	}
	
}
