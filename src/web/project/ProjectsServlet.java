package web.project;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Employee;
import entity.Project;
import service.EmployeeService;
import service.ProjectService;


@WebServlet("/projects.do")
public class ProjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int employeeId = (Integer)session.getAttribute("employeeId");
		if(employeeId == 0){
			System.out.println("employee±»Çå¿Õ");
		}else{
			List<Project> projectList = ProjectService.findProjects(employeeId);
			request.setAttribute("projectList",projectList);
			request.getRequestDispatcher("WEB-INF/views/projects/index.jsp").forward(request, response);
		}
	}

}
