package cn.itcast.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.entity.Admin;
import cn.itcast.service.IAdminService;
import cn.itcast.service.impl.AdminService;

/**
 * �û�����servlet 1. ��½ 2. �˳�
 * 
 * @author Jie.Yuan
 * 
 */
public class AdminServlet extends HttpServlet {

	// Serviceʵ��
	private IAdminService adminService = new AdminService();
	// ��ת��Դ
	private String uri;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// ����ͬ�Ĳ�������
		String method = request.getParameter("method");
		// �ж�
		if ("login".equals(method)) {
			// ��½����, ���õ�½����
			login(request, response);
		}

		else if ("out".equals(method)) {
			// �˳������������Ƴ�����
			out(request, response);
		}
	}

	// 1 ��½
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 1. ��ȡ����
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		// ��װ
		Admin admin = new Admin();
		admin.setUserName(userName);
		admin.setPwd(pwd);

		try {
			// 2. ����service����ҵ��
			Admin loginInfo = adminService.findByNameAndPwd(admin);
			// �ж�:
			if (loginInfo == null) {
				// ��½ʧ��
				uri = "/login.jsp";
			} else {
				// ��½�ɹ�
				// �ȣ��������ݵ�session
				request.getSession().setAttribute("loginInfo", loginInfo);
				//�������б� 1. �ȴ�servletContext���õ������б���;  (onLineUserList)
				//           2. ��ǰ�û����롰�����б����С���
				// ʵ��1���ȵõ�servletContext����
				ServletContext sc = getServletContext();
				// ʵ��2�� �ٻ�ȡ�����б���
				List<Admin> onlineList = (List<Admin>) sc.getAttribute("onlineList");
				// �ж�
				if (onlineList != null){
					// ʵ��3: ��ӵ�ǰ��½��
					onlineList.add(loginInfo);
					//sc.setAttribute("onlineList", onlineList);  // �������ô���,����ҪдҲ����
				}
				
				// �٣���ת����ҳ��ʾservlet(/index)
				uri = "/index";
			}
		} catch (Exception e) {
			// ����
			e.printStackTrace();
			// ����
			uri = "/error/error.jsp";
		}

		// 3. ��ת
		request.getRequestDispatcher(uri).forward(request, response);

	}

	// 2 �˳�
	private void out(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. ��ȡsession
		HttpSession session = request.getSession(false);
		//2.�жϣ� 
		if (session!=null) {
			// ��session���Ƴ��û�
			// session.removeAttribute("loginInfo");  //?
			// ����session
			session.invalidate();			
		}
		//3. ��ת(��½)
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
