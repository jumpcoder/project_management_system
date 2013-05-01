package service;

import java.util.List;

import dao.EmployeeDao;
import dao.ProjectDao;
import entity.Employee;
import entity.Project;

public class EmployeeService {
	public static Employee login(String username, String password) {
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = employeeDao.findUserByUsername(username);
		if(employee == null){
			return null;
		}
		if(!employee.getPassword().equals(password)){
			return null;
		}
		return employee;
	}
	public static Employee addProjects(Employee employee) {
		ProjectDao projectDao = new ProjectDao();
		List<Project> projectList = projectDao.findProjectsByEmployeeId(employee.getId());
		employee.setProjects(projectList);
		return employee;
		
	}
}
