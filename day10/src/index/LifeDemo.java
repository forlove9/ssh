package index;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LifeDemo extends HttpServlet {
	public LifeDemo() {
		System.out.println("1.����severlet����");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("2.��ʼ��severlet����");
	}
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("3.service����������");
	}
	private void destory() {
		// TODO Auto-generated method stub
		System.out.println("4.����servlet����");
	}
}
