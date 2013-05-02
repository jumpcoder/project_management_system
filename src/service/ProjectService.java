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
		//��project�����½�һ��project
		int projectId = new ProjectDao().addProject(name, describle);
		//��manager��project�Ĺ�ϵ��ӵ�employeeproject����
		EmployeeProjectDao epDao = new EmployeeProjectDao();
		int managerId = EmployeeService.mapToEmployeeId(manager);
		epDao.addEmployeeProject(projectId,managerId, "������");
		
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
			epDao.addEmployeeProject(projectId,employeeId, "Ա��");
		}
	}

}
