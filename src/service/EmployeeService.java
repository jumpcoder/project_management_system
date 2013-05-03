package service;

import java.util.ArrayList;
import java.util.List;


import dao.EmployeeDao;
import dao.EmployeeProjectDao;
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

	
	public static int mapToEmployeeId(String username){
		List<Employee> employeeList = new EmployeeDao().findAllEmployee();
		for(Employee employee:employeeList){
			if(username.equals(employee.getUsername())){
				return employee.getId();
			}
		}
		return -1;
	}
	
	public static List<Integer> mapToEmployeeId(List<String> usernameList){
		List<Employee> employeeList = new EmployeeDao().findAllEmployee();
		int index = 0,length = employeeList.size();
		String[] keys = new String[length];
		int[] values = new int[length];
		for(Employee employee:employeeList){
			keys[index] = employee.getUsername();
			values[index]= employee.getId();
			index++;
		}
		List<Integer> idList = new ArrayList<Integer>();
		
		for(String username:usernameList){
			for(index = 0; index < length; index++){
				if(username.equals(keys[index])){
					idList.add(values[index]);
				}
			}
		}
		
		return idList;
	}
}
