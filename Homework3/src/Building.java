/**
*This class a building in Lazy Town
*@author LJ Benson
*@version 1.00, 06 January 2017
*/
public class Building {
	String Buildname;
	String addy;
	
	/**
	*This function returns the name and address of the building 
	*@return the name and address of the building
	*/
	public String toString(){
		return String.format("%s is located at %s.\n", Buildname, addy);
	}
}
