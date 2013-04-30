package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import entity.Employee;

public class EmployeeDao extends Dao<Employee>{
	protected Employee mapToObject() throws SQLException, DaoException{
		Employee employee = new Employee();
		ResultSet rs = getResultSet();

		employee.setId(rs.getInt("id"));
		employee.setUsername(rs.getString("username"));
		employee.setPassword(rs.getString("password"));

		return employee;
	}
	
	public Employee findUserByUsername(String username) {
		String sql = "select id, username, password from user where id = ?";
		
		try {
			this.setSql(sql, username);
			List<Employee> employeeList = this.query();
			if(employeeList.size() == 0){
				return null;
			}else if(employeeList.size() == 1){
				return employeeList.get(0);
			}
		} catch (DaoException e) {			
			e.printStackTrace();
		}
		return null;
	}
}
