package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Admin;
import service.IAdminService;
import service.impl.AdminService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private IAdminService adminService=new AdminService();
	private String url;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPwd(pwd);
		
		try {
			Admin loginInfo = adminService.findByNameAndPwd(admin);
			if(loginInfo==null){
				url="/login.jsp";
			}else{
				request.getSession().setAttribute("loginInfo", loginInfo);
				url="/IndexServlet";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			url="/error/error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
