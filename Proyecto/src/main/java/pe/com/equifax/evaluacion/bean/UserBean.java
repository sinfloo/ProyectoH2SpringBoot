package pe.com.equifax.evaluacion.bean;

import java.util.Calendar;


public class UserBean {
	private int id;
	private String name;
	private int age;
	private String email;
	private String phone;
	private int year;

	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	public UserBean(int id, String name, int age, String email, String phone) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;		
		this.year =  Calendar.getInstance().get(Calendar.YEAR)-age;
	}
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = yaerNac();
	}

	public int yaerNac() {		
		this.year=Calendar.getInstance().get(Calendar.YEAR)-this.age;
		return this.year;
	}
	

}
