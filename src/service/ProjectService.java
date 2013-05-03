package service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.EmployeeProjectDao;
import dao.ProjectDao;
import entity.Employee;
import entity.Project;

public class ProjectService {
	
	public static List<Project> findProjects(int employeeId) {
		List<Project> projectList = new EmployeeProjectDao().findProjectsByEmployeeId(employeeId);
		return projectList;
		
	}
	
	public static void createProject(String name, String describle, String manager,
			String members) {
		//在project表中新建一个project
		int projectId = new ProjectDao().addProject(name, describle);
		//将manager和project的关系添加到employeeproject表中
		EmployeeProjectDao epDao = new EmployeeProjectDao();
		int managerId = EmployeeService.mapToEmployeeId(manager);
		epDao.addEmployeeProject(managerId,projectId, "负责人");
		
		Pattern pattern = Pattern.compile("\\s*\\w+[\\s,;\t]?");
		Matcher matcher = pattern.matcher(members);
		
		List<String> usernameList = new ArrayList<String>();
		while(matcher.find()){
			String username = matcher.group();
			username = username.trim();
			int length = username.length();
			if(' ' == username.charAt(length - 1) || 
				',' == username.charAt(length - 1) ||
				';' == username.charAt(length - 1) || 
				'\t' == username.charAt(length - 1)){
				username = username.substring(0,length - 1);
			}
			usernameList.add(username);
		}
		List<Integer> employeeIdList = EmployeeService.mapToEmployeeId(usernameList);
		for(int employeeId:employeeIdList){
			epDao.addEmployeeProject(employeeId,projectId, "员工");
		}
	}

}
