/**
*This class models a teacher in Lazy Town
*@author LJ Benson
*@version 1.00, 06 January 2017
*/
public class Teacher extends Person implements Employee {
	int gradeLVL;
	String ability;
	double moneyHeld =0;
	static long EmpID = 999999;	
	/**
	*Constructor of LazyTown teacher
	*@param grade that the teacher teaches
	*@param the subject the teacher teaches
	*@param name of the person
	*@param age of the person
	*@param phone number 
	*/
	public Teacher(int g, String c, String n, int a, String p)
	{
		this.gradeLVL = g;
		this.ability = c;
		this.name = n;
		this.age = a;
		this.phoneNum = p;
	}
	/**
	*gets the subject that the teacher teaches
	*@returns ability of teacher 
	*/
	public String getCertification() { return ability;}
	/**
	*gets the grade that the teacher is allowed to teach
	*@returns gradeLVL of teacher 
	*/
	public int getGradelvl() { return gradeLVL;}
	
	/**
	*gets the amount of money that the teacher holds in his/hers account
	*@return amount of money in savings account*/
	public double getSavings() {return moneyHeld;}
	
	/**
	*Return the officer's ID number
	*@return ID number 
	*/
	public long EmpID(){
		EmpID--;
		return EmpID;
		
	}
	/**
	*sets the ID number of the teacher
	*@param ID number of the teacher
	*/
	public void setID(long i){
		this.EmpID = i;
	}
	/**
	*the pay function that pays specific officers working in Lazy Town
	*@returns total money that is in specific person's bank account
	*/
	public double Pay(){
		double pay = 650;
		moneyHeld += pay;
		return moneyHeld;
	}
	/**
	*pays a person the specific amount registered in the parameters
	*@param extra money given to the person not having to do with monthly payments
	*@returns total money in savings
	*/
	public double Pay(int pay)
	{
		moneyHeld += pay;
		return moneyHeld;
	}
	
	
}
