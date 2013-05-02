package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDao;
import entity.Employee;
import service.ProjectService;


@WebServlet("/create_project.do")
public class CreateProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> employeeList = new EmployeeDao().findAllEmployee();
		request.setAttribute("employeeList", employeeList);
		request.getRequestDispatcher("WEB-INF/views/projects/create_project.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String describle = request.getParameter("describle");
		String manager = request.getParameter("manager");
		String members = request.getParameter("members");
		if(name == null || describle == null || manager == null || members == null){
			response.sendRedirect("create_project.do");
		}else if("".equals(name) || "".equals(describle) || "".equals(manager) || "".equals(members)){
			response.sendRedirect("create_project.do");
		}else{
			ProjectService.createProject(name, describle, manager, members);
			response.sendRedirect("projects.do");
		}
	}

}
