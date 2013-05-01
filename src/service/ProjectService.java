package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.EmployeeDao;
import dao.ProjectDao;

public class ProjectService {

	public static void createProject(String name, String describle, String manager,
			String members) {
		ProjectDao projectDao = new ProjectDao();
		int projectId = projectDao.addProject(name, describle);	
		projectDao.addEmployeeProject(projectId,manager);
		Pattern pattern = Pattern.compile("\\s*\\w+[\\s,;\t]?");
		Matcher matcher = pattern.matcher(members);
		
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
			projectDao.addEmployeeProject(projectId,username);
		}
		
		
	}

}
