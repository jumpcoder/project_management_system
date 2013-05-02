package service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.EmployeeProjectDao;
import dao.ProjectDao;

public class ProjectService {

	public static void createProject(String name, String describle, String manager,
			String members) {
		//在project表中新建一个project
		int projectId = new ProjectDao().addProject(name, describle);
		//将manager和project的关系添加到employeeproject表中
		EmployeeProjectDao epDao = new EmployeeProjectDao();
		int managerId = EmployeeService.mapToEmployeeId(manager);
		epDao.addEmployeeProject(projectId,managerId, "负责人");
		
		Pattern pattern = Pattern.compile("\\s*\\w+[\\s,;\t]?");
		Matcher matcher = pattern.matcher(members);
		
		List<String> usernameList = new ArrayList<String>();
		while(matcher.find()){
			String username = matcher.group();
			username = username.trim();
			int length = username.length();
			if(' ' == username.charAt(length) || 
				',' == username.charAt(length) ||
				';' == username.charAt(length) || 
				'\t' == username.charAt(length)){
				username = username.substring(0,length - 1);
			}
			usernameList.add(username);
		}
		List<Integer> employeeIdList = EmployeeService.mapToEmployeeId(usernameList);
		for(int employeeId:employeeIdList){
			epDao.addEmployeeProject(projectId,employeeId, "员工");
		}
	}

}
