import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;

public class Onyx extends Pokemon{
	public Onyx(int l){
		super(l);
		setMaxHealth(27 + ((l - 1) * 8));
		setHealth(27 + (( l - 1) * 8));
		setAttack(3 + (( l - 1) * 2));
		setDefense(10 + (( l - 1) * 4));
		setXP(0);
	
	}
	//////////////////PERFORM MOVES//////////////////////////////
	public Movetype performMove1(Pokemon p1) {	return ShieldandSword(p1);	}
	public Movetype performMove2(Pokemon p1) {	return DiamondStorm(p1);}
	public Movetype performMove3(Pokemon p1) {	return RazorRock(p1);}
	public Movetype performMove4(Pokemon p1) {	return Harden(p1);	}
	//////////////////////GETTER FUNCTIONS/////////////////////
	public String getType() { return "Rock";}
	public String getName() { return "Onyx";}
	public String getMove1() { return "Shield and Sword";}
	public String getMove2() { return "Diamond Storm";}
	public String getMove3() { return "Razor Rock";}
	public String getMove4() { return "Harden";}
	public ImageIcon getIcon() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		URL imgURL = getClass().getResource("/resource/Onyx.png");
		Image img = toolkit.getImage(imgURL);
		img = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img);
		return icon;
	}
	///////////////////MOVES//////////////////////////
	public Movetype ShieldandSword(Pokemon p){
		int myAttack = getAttack(), myDefense = getDefense(), var;
		var = myAttack;
		myAttack = myDefense;
		myDefense = var;
		setAttack(myAttack);
		setDefense(myDefense);
		System.out.printf("%s's attacks and defense switched!", getName());
		return new Movetype(Movetype.MoveType.StatusChange,Movetype.MoveType.StatusChange, myAttack, myDefense );
	}
	
	public Movetype DiamondStorm(Pokemon p){
		double damage = (getAttack() + 10)/p.getDefense();
		double EnemyHealth = p.getHealth() - damage;
		p.setHealth(EnemyHealth);
		return new Movetype(Movetype.MoveType.Damage, damage);
	}
	public Movetype RazorRock(Pokemon p){
		double damage = (getAttack() / p.getDefense());
		double EnemyHealth = getHealth();
		Random rnd = new Random();
		if (rnd.nextInt(10) < 3){
			damage = getAttack() * 2;
			EnemyHealth = EnemyHealth - damage;
			p.setHealth(EnemyHealth);
			System.out.printf("Critical Hit!\n");
			return new Movetype(Movetype.MoveType.Damage, damage);
		}
		else {
		EnemyHealth = EnemyHealth - damage;
		p.setHealth(EnemyHealth);
		return new Movetype(Movetype.MoveType.Damage, damage);
		}
	}
	public Movetype Harden(Pokemon p){
		int defUP = getDefense() * 3;
		setDefense(defUP);
		System.out.printf("%s's defense sharply rose!\n", getName());
		return new Movetype(Movetype.MoveType.StatusChange, defUP);
	}
////////////OTHER FUNCTIONS///////////////
	public void resetStats(){
		setAttack(3 + ((getLVL() - 1) * 2));
		setDefense(10 + ((getLVL() - 1) * 4));
	}
	public void levelUP(){
		level++;
		attack = attack + 2;
		defense = defense + 4;
		health = health + 8;
	}
}
