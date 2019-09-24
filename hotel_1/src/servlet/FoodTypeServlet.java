package servlet;

import java.io.IOException;
import java.util.List;

import javax.enterprise.inject.New;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.iap.Response;

import entity.FoodType;
import service.IFoodTypeService;
import service.impl.FoodTypeService;

/**
 * Servlet implementation class FoodTypeServlet
 */
@WebServlet("/FoodTypeServlet")
public class FoodTypeServlet extends HttpServlet {
	private IFoodTypeService foodTypeService=new FoodTypeService();
	String uri;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		if("addFoodType".equals(method)){
			addFoodType(request, response);
		}
		else if("list".equals(method)){
			list(request, response);
		}
		else if("viewUpdate".equals(method)){
			viewUpdate(request, response);
		}
		else if("update".equals(method)){
			update(request, response);
		}
		else if("delete".equals(method)){
			delete(request, response);
		}
		
	}

	protected void addFoodType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String foodTypeName = request.getParameter("foodTypeName");
			FoodType ft = new FoodType();
			ft.setTypeName(foodTypeName);
			foodTypeService.save(ft);
			uri="/FoodTypeServlet?method=list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			uri="/error/error.jsp";
		}
		request.getRequestDispatcher(uri).forward(request, response);
		
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<FoodType> list = foodTypeService.getAll();
			request.setAttribute("listFoodType", list);
			uri="/sys/type/foodtype_list.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			uri="/error/error.jsp";
		}
		request.getRequestDispatcher(uri).forward(request, response);
		
	}
	protected void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// 1. 获取请求id
			String id = request.getParameter("id");
			// 2. 根据id查询对象
			FoodType ft = foodTypeService.findById(Integer.parseInt(id));
			// 3. 保存
			request.setAttribute("foodType", ft);
			// 4. 跳转
			uri = "/sys/type/foodtype_update.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		request.getRequestDispatcher(uri).forward(request, response);
		
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id=request.getParameter("id");
			System.out.println(id);
			foodTypeService.delete(Integer.parseInt(id));
			uri="/FoodTypeServlet?method=list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			uri="/error/error.jsp";
		}
		request.getRequestDispatcher(uri).forward(request, response);
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//1. 获取请求数据封装
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("foodTypeName");
			FoodType foodType = new FoodType();
			foodType.setId(id);
			foodType.setTypeName(name);
			
			//2. 调用Service更新
			foodTypeService.update(foodType);
			//3. 跳转
			//list(request,response);
			uri = "/FoodTypeServlet?method=list";
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		request.getRequestDispatcher(uri).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
