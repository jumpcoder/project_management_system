package service;

import dao.EmployeeDao;
import entity.Employee;

public class EmployeeService {
	private EmployeeDao employeeDao = new EmployeeDao();
	public Employee login(String username, String password) {
		Employee employee = employeeDao.findUserByUsername(username);
		if(employee == null){
			return null;
		}
		if(!employee.getPassword().equals(password)){
			return null;
		}
		return employee;
	}
}
