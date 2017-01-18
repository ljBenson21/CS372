/**
*This class models a small child in Lazy Town
*@author LJ Benson
*@version 1.00, 06 January 2017
*/
public class Child extends Person {
	String favCandy;
	
	/**
	*This function returns the favorite candy of the specified child
	*@returns favorite candy
	*/
	public String getFavCandy() { return favCandy;}
	
	/**
	*Constructor of the Child 
	*@param favorite candy of the child
	*@param name of the person
	*@param age of the person
	*@param phone number 
	*/
	public Child(String c, String n, int a, String p)
	{
		this.favCandy = c;
		this.name = n;
		this.age = a;
		this.phoneNum = p;
	}
}
