

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;



public class Charizard extends Pokemon {
	public Charizard(int l){
		super(l);
		setMaxHealth(20 + ((l - 1) * 10));
		setHealth(20 + ((l-1) * 10));	
		setAttack(15 + ((l-1) * 3));
		setDefense(5 + ((l-1) * 1));
		setXP(0);
		
	}
	////////////////PERFORM MOVE FUNCTIONS/////////////
	public Movetype performMove1(Pokemon p1) { return FireBlast(p1);}///////////////////////
	public Movetype performMove2(Pokemon p1) { return Fly(p1);}
	public Movetype performMove3(Pokemon p1) { return SunnyDay(p1);}
	public Movetype performMove4(Pokemon p1) { return Heatwave(p1);}
	
	///////////////////GETTER FUNCTIONS////////////////
	public String getName() {return "Charizard";}
	public String getType() {return "Fire";}
	
	public ImageIcon getIcon() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		URL imgURL = getClass().getResource("/resource/Charizard.png");
		Image img = toolkit.getImage(imgURL);
		img = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img);
		return icon;
		}
	
	public String getMove1() {return "FireBlast";}
	public String getMove2() {return "Fly";}
	public String getMove3() {return "Sunny Day";}
	public String getMove4() {return "HeatWave";}
	
	/////////////////MOVES/////////////////////
	public Movetype FireBlast(Pokemon p1){
		double damage = getAttack();
		double EnemyHealth = p1.getHealth() - (damage / p1.getDefense());
		int burn = 5; // random chance to burn
		Random rnd = new Random();
		if (rnd.nextInt(10) == 2){
			System.out.printf("%s was burned!\n", p1.getName());
			p1.setHealth(EnemyHealth - burn);
		}
		p1.setHealth(EnemyHealth);
		return new Movetype(Movetype.MoveType.Damage, EnemyHealth);
	}
	public Movetype Fly(Pokemon p1){
		double damage = getAttack();
		double EnemyHealth = p1.getHealth() - (damage / p1.getDefense());
		Random rnd = new Random();
		for (int i =0; i < 5; i++){
			if (rnd.nextInt(10) < 7){
				{
					p1.setHealth(EnemyHealth);
					return new Movetype(Movetype.MoveType.Damage, EnemyHealth);
				}
			}
		}
		System.out.printf("Attack Missed!\n");
		return null;
	}
	public Movetype SunnyDay(Pokemon p1) {
		int damIncrease = getAttack() + 5;
		int EnemyDecrease = p1.getAttack() - 3;
		int EnemyIncrease = p1.getAttack() + 5;
		setAttack(damIncrease);	
		if (p1.getType().equals("Water")) {
			p1.setAttack(EnemyDecrease);
			System.out.printf("%s attack was lowered!\n", p1.getName());
			return new Movetype(Movetype.MoveType.StatusChange, EnemyDecrease);
		}
		else if (p1.getType().equals("Fire")){
			p1.setAttack(EnemyIncrease);
			System.out.printf("%s attack was increased!\n", p1.getName());
			return new Movetype(Movetype.MoveType.StatusChange, EnemyIncrease);
		}
		return null;
	}
	
	public Movetype Heatwave(Pokemon p1) {
		double damage = p1.getHealth();
		double EnemyHealth = p1.getHealth();
		Random rnd = new Random();
		int num = rnd.nextInt(100);
		if (num < 10){
			EnemyHealth = EnemyHealth - damage;
			p1.setHealth(EnemyHealth);
			System.out.printf("%s was overcomed by heat!\n", p1.getName());
			return new Movetype(Movetype.MoveType.Damage, EnemyHealth);
		}
		else if(num >= 10){
			setHealth(getHealth() - getAttack());
			System.out.printf("%s hurt itself!\n", getName());
			return new Movetype(Movetype.MoveType.Damage, health);
		}
		return null;
	}
	
	public void resetStats(){
		setAttack(15 + ((getLVL() - 1) * 3));
		setDefense(5 + ((getLVL()-1) * 1));
	}
	
	public void levelUP(){
		level++;
		attack = attack + 3;
		defense = defense + 1;
		health = health + 10;
	}
}
