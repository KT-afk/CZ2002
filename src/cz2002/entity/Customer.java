package cz2002.entity;

public class Customer extends Person {
	public static Integer CustIDcounter=0;
	private Integer id;
	private boolean membership;
	public Customer(String name, Gender gender, boolean membership) {
		super(name,gender);
		id = CustIDcounter++;
		this.membership = membership;
	}
	public Integer getID(){
		return id;
	}
	public boolean getMembership(){
		return membership;
	}
	
}
