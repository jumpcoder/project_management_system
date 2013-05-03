package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entity.Goal;

public class GoalDao extends Dao<Goal>{

	@Override
	protected Goal mapToObject() throws SQLException, DaoException {
		ResultSet rs = this.getResultSet();
		Goal goal = new Goal();
		goal.setId(rs.getInt("id"));
		goal.setName(rs.getString("name"));
		goal.setDescrible(rs.getString("describle"));
		goal.setCreateTime(rs.getString("create_time"));
		return goal;
	}

	public List<Goal> findGoalsByProjectId(int projectId) {
		String sql = "select id, name, describle, create_time from goal where project_id = ?";
		try {
			this.setSql(sql, projectId);
			List<Goal> goalList = this.query();
			return goalList;
		} catch (DaoException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void addGoal(String name, String describle, int employeeId, int projectId) {
		String sql = "insert into goal(name, describle, employee_id, project_id) values(?,?,?,?)";
		try {
			this.setSql(sql, name, describle, employeeId, projectId);
			this.update();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
