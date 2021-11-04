package cz2002.entity;

public class Person{
	public enum Gender{
		Male,
		Female
	}
	private String name;
	private Gender gender;
	public Person(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
	}
	public void setName(String newName) {
		name = newName;
	}
	public void setGender(Gender newGender) {
		gender = newGender;
	}
	public String getName() {
		return name;
	}
	public Gender getGender() {
		return gender;
	}
	
}