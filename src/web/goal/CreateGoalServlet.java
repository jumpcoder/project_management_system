package web.goal;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Employee;

import service.GoalService;


@WebServlet("/create_goal.do")
public class CreateGoalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/views/projects/project/goal/create_goal.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String describle = request.getParameter("describle");
		int employeeId = (Integer)request.getSession().getAttribute("employeeId");
		int projectId = (Integer)request.getSession().getAttribute("projectId");
		GoalService.createGoal(name, describle, employeeId, projectId);
		response.sendRedirect("goal.do");
	}

}
