package action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{
	public String execute() throws Exception {
		System.out.println("���ʵ���action�����ڴ�������");
		System.out.println("����service");
		return "success";
	}
}