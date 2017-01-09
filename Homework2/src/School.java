/**
*This class models a School in Lazy Town
*@author LJ Benson
*@version 1.00, 06 January 2017
*/

import java.util.ArrayList; 

public class School extends Building {
	ArrayList<Person> CurrPeople = new ArrayList<Person>(); // Array of current people in school
	
	/** 
	*This function adds people to array of current people in school
	*@param Person specified to add
	*/
	public void addPeople(Person p){
		CurrPeople.add(p);
	}
	
	/**
	*Prints the people in the school who are kids/students
	*/
	public void printStudents() {
		for (Person p: CurrPeople){
			if(p instanceof Child)
				System.out.printf("%s is a student in the school.\n", p.name);
		}
	}
	/**
	*Prints the people in the school who are teachers/profs
	*/
	public void printTeach() {
		for (Person p: CurrPeople) {
			if (p instanceof Teacher)
				System.out.printf("%s is the teacher in the school.\n", p.name);
		}
	}
	/**
	*School constructor based off of building 
	*@param name of the school
	*@param location of the school
	*/
	public School(String n, String addy)
	{
		this.Buildname = n;
		this.addy = addy;
	}
}
