
public class Triangle implements Shape {
	double Area;
	double Perimeter;
	String kind;
	int ID;
	String Color;
	int height;
	int side1, side2, side3;
	
	public double convertArea(){
		Area = (side1 * height) / 2;
		return Area;
	}
	public double convertPmeter(){
		Perimeter = side1 + side2 + side3;
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
