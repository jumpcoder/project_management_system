package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entity.Project;



public class ProjectDao extends Dao<Project>{
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
	public int addProject(String name, String describle) {
		try {
			String sql = "select max(id) as id from project";
			this.setSql(sql);
			List<Project> projectList = this.query();
			int projectId = projectList.get(0).getId();
			projectId++;
			sql = "insert into project(id,name,describle) values(?,?,?)";
			this.setSql(sql, projectId, name, describle);
			this.update();
			return projectId;
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public void addEmployeeProject(int projectId, String manager) {
		// TODO Auto-generated method stub
		
	}

}
