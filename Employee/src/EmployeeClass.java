
public class EmployeeClass {

	String firstName;
	String lastName;
	double MonthSal;
	
	EmployeeClass(String FN, String LN, double MS) 
	{
		this.firstName = FN;
		this.lastName = LN;
		this.MonthSal = MS;
	}
	
	public String getFirstname() { return firstName;}
	public String getLastName() {return lastName;}
	public double getMonthSal() {return MonthSal;}
	
	public void setFirstname(String FN) { this.firstName = FN;}
	public void setLastName(String LN) { this.lastName = LN;}
	public void setMonthSal(double MS) {this.MonthSal = MS;} 
	
}
