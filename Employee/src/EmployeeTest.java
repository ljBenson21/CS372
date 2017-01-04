
public class EmployeeTest {

	public static void main(String[] args) {
		EmployeeClass student1 = new EmployeeClass("LJ", "Benson", 500.00);
		EmployeeClass student2 = new EmployeeClass("Jessica", "Biel", 2500.00);
		double Stud1yearSal = student1.getMonthSal() * 12;
		double Stud2yearSal = student2.getMonthSal() * 12;
		
		System.out.printf("%s %s has a yearly salary of %f.\n",student1.getFirstname(), student1.getLastName(),Stud1yearSal);
		System.out.printf("%s %s has a yearly salary of %f.\n",student2.getFirstname(), student2.getLastName(),Stud2yearSal);

		double SalRaise1 = student1.getMonthSal() * 1.1;
		double SalRaise2 = student2.getMonthSal() * 1.1;
		
		System.out.printf("%s after the raise, now has a monthly income of %f and a yearly salary of "
				+ "%f.", student1.getFirstname(), SalRaise1, (SalRaise1 * 12));
		System.out.printf("%s after the raise, now has a monthly income of %f and a yearly salary of "
				+ "%f.", student2.getFirstname(), SalRaise2, (SalRaise2 * 12));
	}

}
