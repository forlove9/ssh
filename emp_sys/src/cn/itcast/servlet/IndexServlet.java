package cn.itcast.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.entity.Admin;
import cn.itcast.entity.Employee;
import cn.itcast.service.IAdminService;
import cn.itcast.service.IEmployeeService;
import cn.itcast.service.impl.AdminService;
import cn.itcast.service.impl.EmployeeService;

public class IndexServlet extends HttpServlet {

	// Serviceʵ��
	private IEmployeeService employeeService = new EmployeeService();
	// ��ת��Դ
	private String uri;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			// ����service��ѯ����
			List<Employee> list = employeeService.getAll();
			request.setAttribute("listEmp", list);
			// ������ҳjsp
			uri = "/list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		// ת��
		request.getRequestDispatcher(uri).forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
