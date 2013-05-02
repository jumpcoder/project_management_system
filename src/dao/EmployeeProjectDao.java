package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entity.Project;

public class EmployeeProjectDao extends Dao{
	protected Project mapToObject() throws SQLException, DaoException{
		Project project = new Project();
		ResultSet rs = this.getResultSet();
		project.setId(rs.getInt("id"));
		project.setName(rs.getString("name"));
		project.setDescrible(rs.getString("describle"));
		project.setCreateTime(rs.getString("create_time"));
		project.setPost(rs.getString("post"));
		return project;
	}
	public List<Project> findProjectsByEmployeeId(int employeeId) {
		String sql = "";
		sql = "SELECT id, post, NAME, describle, create_time " +
			"FROM (" +
				"SELECT employee_id, project_id as id, post, NAME, describle, create_time " +
				"FROM employee_project " + 
				"INNER JOIN project " +
				"ON employee_project.project_id = project.id " +
			") AS temp " +
			"WHERE employee_id = ?";
		
		try {
			this.setSql(sql, employeeId);
			List<Project> projectList = this.query();
			return projectList;
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void addEmployeeProject(int employeeId, int projectId, String post) {
		String sql = "";
		sql = "insert into employee_project(employee_id, project_id, post) values(?,?,?)";
		try{
			this.setSql(sql, employeeId, projectId, post);
			this.update();
		}catch(DaoException e){
			e.printStackTrace();
		}
	}
}
