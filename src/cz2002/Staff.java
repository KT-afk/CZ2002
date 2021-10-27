import Person.Gender;

public class Staff extends Person{
	public static Integer StaffIDcounter=0;
	private Integer id;
	private String jobTitle;
	public Staff(String name, Gender gender, String jobTitle) {
		super(name,gender);
		id = StaffIDcounter++;
		this.jobTitle = jobTitle;
	}
	
}
