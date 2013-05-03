package service;

import java.util.List;

import dao.GoalDao;
import entity.Goal;

public class GoalService {
	public static List<Goal> findGoals(int projectId){
		return new GoalDao().findGoalsByProjectId(projectId);
	}

	public static void createGoal(String name, String describle, int employeeId, int projectId) {
		new GoalDao().addGoal(name,describle, employeeId,projectId);
		
	}
}
