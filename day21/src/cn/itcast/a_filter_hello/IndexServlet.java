package cn.itcast.a_filter_hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet:
 * 	 �����û�http request
 * @author Jie.Yuan
 *
 */
public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// ����POST�ύ������ı���
		request.setCharacterEncoding("UTF-8");
		// ������Ӧ��ı���
		response.setCharacterEncoding("UTF-8");
		// ����ҳ���ʱ��ʱ��ı����ʽ�� ������Ӧ��ı���
		response.setContentType("text/html;charset=UTF-8");
		
		
		// GET�ύ����
		String str = request.getParameter("");
		str = new String(str.getBytes("ISO8859-1"),"UTF-8");
		
		
		response.sendRedirect(request.getContextPath() + "/servletTest");
//		request.getRequestDispatcher("/servletTest").forward(request, response);
	}

}
