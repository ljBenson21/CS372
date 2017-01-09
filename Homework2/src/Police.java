/**
*This class models a police officer in Lazy Town
*@author LJ Benson
*@version 1.00, 06 January 2017
*/
public class Police extends Person implements Employee{
	
	private double moneyHeld = 0;
	private static long EmpID = 0000000;
	policeRole Role;
	
	/**
	*Constructor of police officer
	*@param Role of the officer
	*@param Name of the officer
	*@param age of the officer
	*@param phone number of the officer
	*/
	Police(policeRole r, String n, int a, String p)
	{
		this.Role = r;
		this.name = n;
		this.age = a;
		this.phoneNum = p;
	}
	
	/**
	*Return the officer's ID number
	*@return ID number 
	*/
	public long EmpID(){
		EmpID++;
		return EmpID;
	}
	/**
	*sets the ID number of the officer+
	*@param the ID number
	*/
	public void setID(long i){
		this.EmpID = i;
	}
	/**
	*gets the amount of money that the officer holds in his/hers account
	*@return amount of money in savings account*/
	public double getSavings() {return moneyHeld;}
	/**
	*gets the ID number of officer
	*@return ID number
	*/
	public long getID() {return EmpID;}
	/**
	*enum type for the different roles an officer could have
	*@type of officer in Lazy Town
	*/
	public enum policeRole {
		Patrol, Sargent, Captain, Chief
	}
	/**
	*gets role of the officer
	*@return role
	*/
	public policeRole getRole(){
		return Role;
	}
	/**
	*the pay function that pays specific officers working in Lazy Town
	*@returns total money that is in specific person's bank account
	*/
	public double Pay(){
		if (this.Role == policeRole.Patrol){ //monthly pay for patrol officers
			double pay = 700;
			moneyHeld += pay;
			return moneyHeld;
		}
		else if (this.Role == policeRole.Sargent){ // monthly pay for sargents
			double pay = 800;
			moneyHeld += pay;
			return moneyHeld;
		}
		else if (this.Role == policeRole.Captain){ // monthly pay for Captains
			double pay = 950;
			moneyHeld += pay;
			return moneyHeld;
		}
		else if (this.Role == policeRole.Chief){ //monthly pay for Chief
			double pay = 1100;
			moneyHeld += pay;
			return moneyHeld;
		}
		return 0;
	}
	/**
	*pays a person the specific amount registered in the parameters
	*@param extra money given to the person not having to do with monthly payments
	*@returns total money in savings
	*/
	public double Pay(int p)
	{
		moneyHeld += p;
		return moneyHeld;
	}
	
	
}
