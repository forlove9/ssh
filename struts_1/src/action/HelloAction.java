package action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		System.out.println("µ÷ÓÃaction");
		return "success";
	}
}
