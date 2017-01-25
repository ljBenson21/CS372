import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;

public class Blastoise extends Pokemon {
	public Blastoise(int l){
		super(l);
		setMaxHealth(23 + ((l - 1 ) * 10));
		setHealth(23 + (( l - 1) * 10));
		setAttack(9 + (( l - 1) * 2));
		setDefense(8 + (( l - 1) * 2));
		setXP(0);
		
	}
	////////////////////////////PERFORM MOVES///////////////////
	public Movetype performMove1(Pokemon p1) { return HydroPump(p1);}
	public Movetype performMove2(Pokemon p1) { return AquaJet(p1);}
	public Movetype performMove3(Pokemon p1) { return Mud_Slap(p1);}
	public Movetype performMove4(Pokemon p1) { return Shell_Shock(p1);}
	///////////////////////GETTER FUNCTIONS//////////////////////
	public String getType() { return "Water";}
	public String getName() { return "Blastoise";}
	public String getMove1() { return "Hydro Pump";}
	public String getMove2() { return "Aqua Jet";}
	public String getMove3() { return "Mud-Slap";}
	public String getMove4() { return "Shell-Shock";}
	public ImageIcon getIcon() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		URL imgURL = getClass().getResource("/resource/Blastoise.png");
		Image img = toolkit.getImage(imgURL);
		img = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img);
		return icon;
	}
	/////////////////////MOVES//////////////////////////
	public Movetype HydroPump(Pokemon p){
		int atkUP = getAttack() + getLVL();
		setAttack(atkUP);
		double damage = p.getHealth() - (getAttack() / p.getDefense());
		if (p.getType().equals("Fire")){
			damage = p.getHealth() - ((getAttack() * 2) / p.getDefense());
			p.setHealth(damage);
			System.out.printf("It's super effective!\n");
			return new Movetype(Movetype.MoveType.Damage, damage);
		}
		else if(p.getType().equals("Grass")){
			damage = p.getHealth() - ((getAttack() / 2) / p.getDefense());
			p.setHealth(damage);
			System.out.printf("It's not very effective...\n");
			return new Movetype(Movetype.MoveType.Damage, damage);
		}
		p.setHealth(damage);
		return new Movetype(Movetype.MoveType.Damage, damage);
	}
	
	public Movetype AquaJet(Pokemon p){
		int criticalChance = 3;
		double damage = getAttack();
		double EnemyHealth = p.getHealth() - (damage / p.getDefense());
		Random rnd = new Random();
		if (rnd.nextInt(10) <= criticalChance){
			damage = getAttack() * 2;
			EnemyHealth = p.getHealth() - (damage / p.getDefense());
			p.setHealth(EnemyHealth);
			System.out.printf("Critical Hit!\n");
			return new Movetype(Movetype.MoveType.Damage, damage);
		}
		p.setHealth(EnemyHealth);
		return new Movetype(Movetype.MoveType.Damage, damage);
	}
	
	public Movetype Mud_Slap(Pokemon p){
		double damage = getAttack();
		if (p.getType().equals("Electric")){
			int dampen = p.getAttack() - 5;
			p.setAttack(dampen);
			System.out.printf("Opponent Attack was lowered!\n");
		}
		else if(p.getType().equals("Rock")){
			System.out.printf("No Damage\n");
			return null;
		}
		double EnemyHealth = p.getHealth() - (damage / p.getDefense());
		p.setHealth(EnemyHealth);
		return new Movetype(Movetype.MoveType.Damage, damage);
	}
	
	public Movetype Shell_Shock(Pokemon p){
		
		Random rnd = new Random();
		int random = rnd.nextInt((15)+1);
		if (random <= 5){
			double heal = getHealth() + getAttack();
			setHealth(getHealth() + heal);
			System.out.printf("Blastoise was healed for %.2f points\n", heal);
			return new Movetype(Movetype.MoveType.Heal, heal);
		}
		else if (random > 5 && random <= 10){
			int increaseDef = getDefense() + getAttack();
			setDefense(increaseDef);
			System.out.printf("Increased Defense!\n");
			return new Movetype(Movetype.MoveType.StatusChange, increaseDef);
		}
		else if (random > 10) {
			double damage = getAttack();
			double EnemyHealth = p.getHealth() - (damage / p.getDefense());
			p.setHealth(EnemyHealth);
			return new Movetype(Movetype.MoveType.Damage, damage);
		}
		return null;
		
	
		}	////////////OTHER FUNCTIONS///////////////
		public void resetStats(){
			setAttack(9 + ((getLVL() - 1) * 2));
			setDefense(8 + ((getLVL() - 1) * 2));
		}
		public void levelUP(){
			level++;
			attack = attack + 2;
			defense = defense + 2;
			maxHealth = maxHealth + 10;
		}
}
