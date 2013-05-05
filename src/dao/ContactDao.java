package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entity.Contact;

public class ContactDao extends Dao<Contact>{
	protected Contact mapToObject() throws SQLException, DaoException{
		Contact contact = new Contact();
		ResultSet rs = getResultSet();
		contact.setId(rs.getInt("id"));
		contact.setName(rs.getString("name"));
		contact.setCompanyName(rs.getString("company_name"));
		contact.setMoblie(rs.getString("moblie"));
		contact.setPhone(rs.getString("phone"));
		contact.setEmail(rs.getString("email"));
		contact.setAddress(rs.getString("address"));
		contact.setWebsite(rs.getString("website"));
		contact.setMicroBlogging(rs.getString("micro_blogging"));
		contact.setContent(rs.getString("content"));
		contact.setCreateTime(rs.getString("create_time"));
		return contact;
	}
	
	public List<Contact> findEmployeeByProjectId(int projectId){
		String sql = "select id, name, company_name, moblie, phone, email, address, website, micro_blogging, content, create_time " + 
				"from contact where project_id = ?";
		try {
			this.setSql(sql, projectId);
			List<Contact> contactList =  this.query();
			return contactList;
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
}
