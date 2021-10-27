import Person.Gender;

public class Customer extends Person{
	public static int StaffIDcounter=0;
	private Integer id;
	private String jobTitle;
	public Customer(String name, Gender gender, String jobTitle) {
		super(name,gender);
		id = StaffIDcounter++;
		this.jobTitle = jobTitle;
	}
	
}