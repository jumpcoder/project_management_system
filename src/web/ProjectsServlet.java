package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Employee;

import service.EmployeeService;


@WebServlet("/projects.do")
public class ProjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Employee employee = (Employee)session.getAttribute("employee");
		if(employee == null){
			System.out.println("employee±»Çå¿Õ");
		}else{
			EmployeeService.addProjects(employee);
			session.setAttribute("employee",employee);
			request.getRequestDispatcher("WEB-INF/views/projects/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
