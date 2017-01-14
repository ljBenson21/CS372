
public class Square {
	double Area;
	double Perimeter;
	String kind;
	int ID;
	String Color;
	int side;
	public double convertArea(){
		Area = side * side;
		return Area;
	}
	public double convertPerimeter(){
		Perimeter = side * 4;
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
