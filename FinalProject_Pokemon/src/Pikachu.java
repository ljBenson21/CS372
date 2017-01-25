import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;

public class Pikachu extends Pokemon{
	public Pikachu(int l){
		super(l);
		setMaxHealth(20 + (( l-1) * 9));
		setHealth(20 + (( l - 1) * 9));
		setAttack(10 + (( l - 1) * 3));
		setDefense(10 + (( l - 1) * 2));
		setXP(0);

	}
	/////////////////PERFORM MOVES////////////////////
	public Movetype performMove1(Pokemon p1) { return Discharge(p1);	}
	public Movetype performMove2(Pokemon p1) {return Electaportation(p1); 	}
	public Movetype performMove3(Pokemon p1) {return ThunderBolt(p1);	}
	public Movetype performMove4(Pokemon p1) {return VoltTackle(p1);	}
	////////////////GETTER FUNCTIONS///////////////////////////////
	public String getType() { return "Electric";}
	public String getName() { return "Pikachu";}
	public String getMove1() { return "Discharge";}
	public String getMove2() { return "Electaportation";}
	public String getMove3() { return "Thunderbolt";}
	public String getMove4() { return "Volt Tackle";}
	public ImageIcon getIcon() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		URL imgURL = getClass().getResource("/resource/Pikachu.png");
		Image img = toolkit.getImage(imgURL);
		img = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img);
		return icon;
	}
	///////////////////MOVES/////////////////////
	public Movetype Discharge(Pokemon p){
		double EnemyHealth = p.getHealth();
		double damage = getAttack() / p.getDefense();
		if (p.getType().equals("Water")){
			damage = (getAttack() * 3) / p.getDefense();
			p.setHealth(EnemyHealth - damage);
			System.out.printf("It's super effective!\n");
			return new Movetype(Movetype.MoveType.Damage, damage);
		}
		else if (p.getType().equals("Rock")){
			System.out.printf("Nothing happened...\n");
			return null;
		}
		else{ 
			p.setHealth(EnemyHealth - damage);
			return new Movetype(Movetype.MoveType.Damage, damage);
		}
	}
	public Movetype Electaportation(Pokemon p){
		double EnemyHealth = p.getHealth();
		double damage;
		Random rnd = new Random();
		if (p.getType().equals("Rock")){
			System.out.printf("Nothing happened...\n");
			return null;
		}
		else if (rnd.nextInt(10)+ 1 <= 3){
			damage = (getAttack() * 3)/ p.getDefense();
			p.setHealth(EnemyHealth - damage);
			System.out.printf("Attack Hit!\n");
			return new Movetype(Movetype.MoveType.Damage, damage);
		}
		else {
			System.out.printf("Attack Missed!\n");
			return null;
		}
	}
	public Movetype ThunderBolt(Pokemon p){
		double EnemyHealth = p.getHealth();
		double damage = (getAttack() + 10) / p.getDefense();
		if (p.getType().equals("Rock")){
			damage = ((getAttack() + 10) / 2) / p.getDefense();
			p.setHealth(EnemyHealth - damage);
			System.out.printf("It's not very effective...\n");
			return new Movetype(Movetype.MoveType.Damage, damage);
		}
		else if (p.getType().equals("Water")){
			damage = ((getAttack() + 10) * 2) / p.getDefense();
			p.setHealth(EnemyHealth - damage);
			System.out.printf("Its super effective!");
			return new Movetype(Movetype.MoveType.Damage, damage);
		}
		else {
			p.setHealth(EnemyHealth - damage);
			return new Movetype(Movetype.MoveType.Damage, damage);
		}
	}
	public Movetype VoltTackle(Pokemon p){
		double EnemyHealth = p.getHealth();
		double damage = getAttack() / p.getDefense();
		Random rnd = new Random();
		p.setHealth(EnemyHealth - damage);
		if (rnd.nextInt(10) + 1 <= 5){
			setAttack(getAttack() + 5);
			System.out.printf("%s's attack rose slightly.\n", getName());
			return new Movetype(Movetype.MoveType.Damage, Movetype.MoveType.StatusChange, damage, getAttack());
		}
		else 
			return new Movetype(Movetype.MoveType.Damage, damage);
	}
////////////OTHER FUNCTIONS///////////////
	public void resetStats(){
		setAttack(10 + ((getLVL() - 1) * 3));
		setDefense(10 + ((getLVL() - 1) * 2));
	}
	public void levelUP(){
		level++;
		attack = attack + 3;
		defense = defense + 2;
		health = health + 9;
	}
}
