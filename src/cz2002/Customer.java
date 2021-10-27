
import Person.Gender;

public class Customer extends Person{
	public static Integer CustIDcounter=0;
	private Integer id;
	public Customer(String name, Gender gender) {
		super(name,gender);
		id = CustIDcounter++;
	}
	
}
