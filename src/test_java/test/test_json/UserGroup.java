package test_java.test.test_json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserGroup implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8641273881304769335L;

	public long id;
	
	public String name;
	
	public List<Employee> userList = new ArrayList<Employee>();

	public String dept ;
	
	public UserGroup(){
		
	}
	public UserGroup(String dept, String name, List<Employee> userList){
		this.dept = dept;
		this.name = name;
		this.userList = userList;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getUserList() {
		return userList;
	}

	public void setUserList(List<Employee> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "UserGroup [id=" + id + ", name=" + name + ", userList=" + userList + "]";
	}
	
}
