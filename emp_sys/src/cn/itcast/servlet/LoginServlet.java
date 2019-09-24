package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.entity.Admin;
import cn.itcast.service.IAdminService;
import cn.itcast.service.impl.AdminService;

/**
 * �����½����
 * @author Jie.Yuan
 *
 */
public class LoginServlet extends HttpServlet {
	// Serviceʵ��
	private IAdminService adminService = new AdminService();
	// ��ת��Դ
	private String uri;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		//1. ��ȡ����
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		// ��װ
		Admin admin = new Admin();
		admin.setUserName(userName);
		admin.setPwd(pwd);
		
		try {
			//2. ����service����ҵ��
			Admin loginInfo = adminService.findByNameAndPwd(admin);
			// �ж�:
			if (loginInfo == null){
				// ��½ʧ��
				uri = "/login.jsp";
			} else {
				// ��½�ɹ�
				// �ȣ��������ݵ�session
				request.getSession().setAttribute("loginInfo", loginInfo);
				// �٣���ת����ҳ��ʾservlet(/index)
				uri = "/index";
			}
		} catch (Exception e) {
			// ����
			e.printStackTrace();
			// ����
			uri = "/error/error.jsp";
		}
		
		//3. ��ת
		request.getRequestDispatcher(uri).forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
