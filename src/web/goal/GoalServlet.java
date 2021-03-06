package web.goal;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmployeeService;

import dao.GoalDao;
import dao.TaskDao;
import entity.Goal;
import entity.Task;


@WebServlet("/goal.do")
public class GoalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int goalId = Integer.parseInt(request.getParameter("id"));
		request.getSession().setAttribute("goalId", goalId);
		List<Task> taskList = new TaskDao().findTaskByGoalId(goalId);
		request.setAttribute("taskList", taskList);
		request.getRequestDispatcher("WEB-INF/views/projects/project/goals/goal/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
