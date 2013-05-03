package web.goal;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Goal;

import service.GoalService;

@WebServlet("/goal.do")
public class GoalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int projectId = (Integer)request.getSession().getAttribute("projectId");
		List<Goal> goalList = GoalService.findGoals(projectId);
		request.setAttribute("goalList", goalList);
		request.getRequestDispatcher("WEB-INF/views/projects/project/goal/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
