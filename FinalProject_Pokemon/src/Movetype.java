
public class Movetype {
	public enum MoveType { Damage, Heal, StatusChange }
	double value1, value2;
	
	MoveType type1, type2;
	
	public Movetype(MoveType m, double v){
		type1 = m;
		value1 = v;
	}
	public Movetype(MoveType m, MoveType x, double v, double y ){
		type1 = m; type2 = x;
		value1 = v; value2 = y;
	}
	public MoveType getMoveType1() { return type1;}
	public MoveType getMoveType2() {return type2;}
	public double getValue1() {return value1;} 
	public double getValue2() {return value2;}
}
