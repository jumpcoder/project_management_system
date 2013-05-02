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
		return project;
	}

	public int addProject(String name, String describle) {
		try {
			String sql = "select max(id) as id '' as name '' as describle '' as create_time from project";
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


}
