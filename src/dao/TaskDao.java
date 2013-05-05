package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entity.Task;

public class TaskDao extends Dao<Task>{
	@Override
	protected Task mapToObject() throws SQLException, DaoException {
		ResultSet rs = this.getResultSet();
		Task task = new Task();
		task.setId(rs.getInt("id"));
		task.setName(rs.getString("name"));
		task.setDescrible(rs.getString("describle"));
		task.setState(rs.getString("state"));
		task.setState(rs.getString("level"));
		task.setBeginTime(rs.getString("begin_time"));
		task.setEndTime(rs.getString("end_time"));
		task.setCreateTime(rs.getString("create_time"));
		task.setPercentage(rs.getInt("percentage"));
		task.setEmployeeId(rs.getInt("employee_id"));
		task.setEmployeeName(rs.getString("employee_name"));
		return task;
	}
	
	public List<Task> findTaskByGoalId(int goalId){
		String sql = "select task.id, name, describle, state, level, begin_time, end_time, create_time, percentage, employee_id, employee.username AS employee_name "+
				"from task " +
				"inner join employee " +
				"on employee_id = employee.id AND goal_id = ?";
		try {
			this.setSql(sql, goalId);
			return this.query();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void addTask(String name, String describle, String state, String level, String beginTime, String endTime, int employeeId, int goalId){
		String sql = "insert into task(name, describle, state, level, begin_time, end_time, employee_id, goal_id) values(?,?,?,?,?,?,?,?)";
		try {
			this.setSql(sql, name, describle, state, level, beginTime, endTime, employeeId, goalId);
			this.update();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
}
