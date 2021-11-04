package cz2002.entity;

import cz2002.entity.Person;

public class Staff extends Person {
	public static Integer StaffIDcounter=0;
	private Integer id;
	private String jobTitle;
	public Staff(String name, Gender gender, String jobTitle) {
		super(name,gender);
		id = StaffIDcounter++;
		this.jobTitle = jobTitle;
	}
	public Integer getID(){
		return id;
	}
	public String getJobTitle(){
		return jobTitle;
	}
	
}
