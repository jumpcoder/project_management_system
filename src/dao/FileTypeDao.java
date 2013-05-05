package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entity.FileType;

public class FileTypeDao extends Dao<FileType>{

	@Override
	protected FileType mapToObject() throws SQLException, DaoException {
		FileType fileType = new FileType();
		ResultSet rs = getResultSet();
		fileType.setId(rs.getInt("id"));
		fileType.setName(rs.getString("name"));
		fileType.setCreateTime(rs.getString("create_time"));
		fileType.setEmployeeId(rs.getInt("employee_id"));
		return fileType;
	}
	
	public List<FileType> findFileTypeByProjectId(int projectId){
		String sql = "select id, name, create_time, employee_id from file_type where project_id = ?";
		
		try {
			this.setSql(sql, projectId);
			return this.query();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
