package test_java.test.test_json;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3295802431734968237L;

	public long id;
	
	public String name;
	
	public Date date;
	
	public String maid;
	
	public Employee(){
		
	}
	
	public Employee(String maid, String name, long id, Date date){
		this.maid = maid;
		this.name = name;
		this.id = id;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMaid() {
		return maid;
	}

	public void setMaid(String maid) {
		this.maid = maid;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", date=" + date + "]";
	}


}
