package web.goal;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmployeeService;

import dao.EmployeeDao;
import dao.TaskDao;
import entity.Employee;


@WebServlet("/create_task.do")
public class CreateTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> employeeList = new EmployeeDao().findAllEmployee();
		request.setAttribute("employeeList", employeeList);
		request.getRequestDispatcher("WEB-INF/views/projects/project/goals/goal/task/create_task.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String describle = request.getParameter("describle");
		String state = request.getParameter("state");
		String level = request.getParameter("level");
		String beginTime = request.getParameter("beginTime");
		String endTime = request.getParameter("endTime");
		int employeeId = EmployeeService.mapToEmployeeId(request.getParameter("employeeName"));
		int goalId = (Integer)request.getSession().getAttribute("goalId");
		new TaskDao().addTask(name,describle,state,level,beginTime,endTime,employeeId,goalId);

		response.sendRedirect("goal.do?id=" + goalId);
		
	}

}
