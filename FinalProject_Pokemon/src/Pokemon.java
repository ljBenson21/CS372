import javax.swing.ImageIcon;

public abstract class Pokemon {
	double maxHealth;
	double health;
	int attack;
	int defense;
	int XP;
	int level;
	
	
	public Pokemon(int l){ level = l;}
	
	/////////////GETTER FUNCTIONS//////////////////////
	public double getMaxHealth() {return maxHealth;}
	public double getHealth() { return health;}
	public int getAttack() { return attack;}
	public int getDefense() {return defense;}
	public int getXP() {return XP;}
	public int getLVL() {return level;}
	public abstract String getName();
	public abstract String getMove1();
	public abstract String getMove2();
	public abstract String getMove3();
	public abstract String getMove4();
	public abstract String getType();
	public abstract ImageIcon getIcon();
	
	////////////SETTER FUNCTIONS////////////////////////
	public void setMaxHealth(double MH) {maxHealth = MH;}
	public void setHealth(double H) { health = H;}
	public void setAttack(int A) { attack = A;}
	public void setDefense(int D) {defense = D;}
	public void setXP(int X) { XP = X;}
	
	
	/////////////////PERFORM MOVES//////////////////
	public abstract Movetype performMove1(Pokemon p1);
	public abstract Movetype performMove2(Pokemon p1);
	public abstract Movetype performMove3(Pokemon p1);
	public abstract Movetype performMove4(Pokemon p1);
	
	
	public abstract void resetStats();
	public abstract void levelUP();
	public double FullHeal(){
		double heal = health;
		return heal;
	}
	public Boolean faint() { // put in main
		if ( health <= 0){
			return true;
		}
		else 
			return false;
	}
	
	
	
	
}

