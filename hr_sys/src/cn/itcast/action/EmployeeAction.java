package cn.itcast.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import cn.itcast.entity.Dept;
import cn.itcast.entity.Employee;
import cn.itcast.service.IDeptService;
import cn.itcast.service.IEmployeeService;

public class EmployeeAction implements ModelDriven<Employee>,RequestAware{
	private Employee employee=new Employee();
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Employee getEmployee() {
		return employee;
	}
	
	private int deptId;
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getDeptId() {
		return deptId;
	}
	
	private IDeptService deptService;
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	
	
	private IEmployeeService employeeService;
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	
	public String list()  {
		List<Employee> listEmp = employeeService.getAll();
		request.put("listEmp",listEmp);
		return "list";
	}
	
	
	public String viewAdd(){
		List<Dept> listDept = deptService.getAll();
		request.put("listDept", listDept);
		return "add";
	}
	
	public String save(){
		Dept dept = deptService.findById(deptId);
		employee.setDept(dept);
		employeeService.save(employee);
		return "listAction";
	
	}
	
	public String viewUpdate(){
		int id = employee.getId();
		Employee emp = employeeService.findById(id);
		List<Dept> listDept = deptService.getAll();
		ValueStack vs=ActionContext.getContext().getValueStack();
		vs.pop();
		vs.push(emp);
		request.put("listDept", listDept);
		
		return "edit";
	}
	
	public String update(){
		Dept dept = deptService.findById(deptId);
		employee.setDept(dept);
		employeeService.update(employee);
		return "listAction";
	}
	
	public String move(){
		int empId = employee.getId();
		// µ÷ÓÃserviceÉ¾³ý
		employeeService.delete(empId);
		return "listAction";
	}

	private Map<String, Object> request;
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}


}
