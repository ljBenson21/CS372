/**
*This class models a typical person in Lazy Town
*@author LJ Benson
*@version 1.00, 06 January 2017
*/
public class Person {
	String name;
	int age;
	String phoneNum;
	/**
	*This function returns the name age and phone number of the specified person
	*@return the name, age and phone number of unique person
	*/
	
	public String toString(){
		return String.format("%s is a %d years old and their phone number is %s\n",
		name, age, phoneNum);
	}
}
