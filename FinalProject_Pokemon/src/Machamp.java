import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;

//////////////////THINGS TO CHANGE////////////////////////
// * CREATE FUNCTION DAMAGE() TO DAMAGE ENEMY POKEMON
public class Machamp extends Pokemon{
	public Machamp(int l){
		super(l);
		setMaxHealth(15 + ((l-1) * 8));
		setHealth(15 + (( l - 1 ) * 8));
		setAttack(20 + (( l - 1) * 5));
		setDefense(5 + (( l - 1) * 1));
		setXP(0);
	}
///////////////////////PERFORM MOVES/////////////////////////
public Movetype performMove1(Pokemon p1) { return DrainPunch(p1);	}

public Movetype performMove2(Pokemon p1) {return ConcreteShuriken(p1); 	}

public Movetype performMove3(Pokemon p1) {return BulkUP(p1);	}

public Movetype performMove4(Pokemon p1) {return CloseCombat(p1);	}
/////////////////////GETTER FUNCTIONS//////////////////////
	public String getType() { return "Fighting";}
	public String getName() { return "Machoke";}
	public String getMove1() { return "Drain Punch";}
	public String getMove2() { return "Concrete Shuriken";}
	public String getMove3() { return "Bulk Up";}
	public String getMove4() { return "Close Combat";}
	public ImageIcon getIcon() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		URL imgURL = getClass().getResource("/resource/Machamp.png");
		Image img = toolkit.getImage(imgURL);
		img = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img);
		return icon;
	}
	///////////////////////MOVES///////////////////////
public Movetype DrainPunch(Pokemon p) {
	double damage = getAttack() / p.getDefense();
	double EnemyHealth = p.getHealth() - damage;
	double heal = damage / 2;
	double YourHealth = getHealth() + heal;
	setHealth(YourHealth);
	p.setHealth(EnemyHealth);
	System.out.printf("%s punched %s and gained %.2f health\n",getName(), p.getName(), heal);
	return new Movetype(Movetype.MoveType.Damage, Movetype.MoveType.Heal, damage, heal);
}

public Movetype ConcreteShuriken(Pokemon p){
	double damage = getAttack() / p.getDefense();
	double EnemyHealth = p.getHealth();
	int num = 3;
	Random rnd = new Random();
	int criticalChance = rnd.nextInt((3) + 1);
	if (p.getName().equals("Rock")){
		System.out.printf("Nothing happened\n");
		return null;
	}
	else if (criticalChance == num){
		damage = (getAttack() * 2) / p.getDefense();
		p.setHealth(EnemyHealth  - damage);
		System.out.printf("Critical Hit!\n");
		return new Movetype(Movetype.MoveType.Damage, damage);
	}
	else{
	p.setHealth(EnemyHealth - damage);
	return new Movetype(Movetype.MoveType.Damage, damage);
	}
}

public Movetype BulkUP(Pokemon p){
	int atkUP = getAttack() * 2, defUP = getDefense() * 2;
	setAttack(atkUP); 
	setDefense(defUP);
	System.out.printf("%s's attack and defense sharply rose\n", getName());
	return new Movetype(Movetype.MoveType.StatusChange,Movetype.MoveType.StatusChange,atkUP, defUP );
}

public Movetype CloseCombat(Pokemon p){
	if (p.getType().equals("Flying") || p.getType().equals("Rock")) {
		double damage = (getAttack() + 15) / p.getDefense();
		double EnemyHealth = p.getHealth() - damage;
		p.setHealth(EnemyHealth);
		System.out.printf("It's super effective!\n");
		return new Movetype(Movetype.MoveType.Damage, damage);
	}
	else{
		double damage = (getAttack() + 10) / p.getDefense() ;
		double EnemyHealth = p.getHealth() - damage;
		p.setHealth(EnemyHealth);
		return new Movetype(Movetype.MoveType.Damage, damage);
	}
}
////////////OTHER FUNCTIONS///////////////
	public void resetStats(){
		setAttack(20 + ((getLVL() - 1) * 5));
		setDefense(5 + ((getLVL() - 1) * 1));
	}
	public void levelUP(){
		level++;
		attack = attack + 5;
		defense = defense + 1;
		maxHealth = maxHealth + 8;
	}
	
}
