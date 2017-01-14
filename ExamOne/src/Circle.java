
public class Circle implements Shape {
	String kind;
	int ID;
	String Color;
	int radius;
	double Area;
	double Perimeter;
	static double pi = 3.14159;
	
	public Circle(){}
	
	public double convertArea(){
		Area = pi * (radius * radius);
		return Area;
	}
	
	public double convertPer(){
		Perimeter = 2 * pi * radius;
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
