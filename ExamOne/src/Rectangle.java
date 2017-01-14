
public class Rectangle {
	double Area;
	double Perimeter;
	String kind;
	int ID;
	String Color;
	int side1, side2;
	public double convertArea(){
		Area = side1 * side2;
		return Area;
	}
	public double convertPerimeter() {
		Perimeter = (side1 * 2) + (side2 * 2);
		return Perimeter;
	}
	public String toString(){
		String newID = Integer.toString(ID);
		String toString = kind + newID;
		
		return toString;
	}
	public String getKind(){ return kind;}
	public String getDetailString() { 
		String newID = Integer.toString(ID);
		String newArea = Double.toString(Area);
		String newPmeter = Double.toString(Perimeter);
		String allStuff = kind + newID + Color + newArea + newPmeter;
		return allStuff;
	}
	public int getID() { return ID;}
}
