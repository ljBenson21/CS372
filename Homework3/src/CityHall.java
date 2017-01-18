/**
*This class is the model of City Hall
*@author LJ Benson
*@version 1.00, 06 January 2017
*/

import java.util.ArrayList;

public class CityHall extends Building {
	ArrayList<Person> CurrEmployees = new ArrayList<Person>(); // Array of current people in City Hall
	
	/** 
	*This function adds people to array of current people in City Hall
	*Adds people to CurrEmployees
	*@param Person specified to add*
	*/
	public void addPeople(Person p){
		CurrEmployees.add(p);
	}
	/**
	*Prints the people in City hall that are officers 
	*prints out officer from CurrEmployees
	*/
	public void printOfficers() {
		for (Person p: CurrEmployees){
			if (p instanceof Police){
				System.out.printf("%s is the %s in the City Hall.\n",p.name, ((Police)p).getRole());
			}
		}
	}
	/**
	*City Hall constructor based off of building 
	*@param name of the Hall
	*@param location of the City Hall
	*/
	public CityHall(String n, String a)
	{
		this.Buildname = n;
		this.addy = a;
	}
}
