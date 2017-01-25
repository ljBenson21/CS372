import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;


public class Pidgeot extends Pokemon {//when I have time, change one of moves to mirror move
	public Pidgeot(int l){
		super(l);
		setMaxHealth(13 + ((l-1) * 7));
		setHealth(13 + (( l -1 ) * 7));
		setAttack(16 + (( l - 1) * 4));
		setDefense(11 + (( l -1) * 3));
		setXP(0);

	}
	/////////////////////PERFORM MOVES///////////////////////
	public Movetype performMove1(Pokemon p1) { return AerialAce(p1);	}

	public Movetype performMove2(Pokemon p1) {return Hurricane(p1); 	}

	public Movetype performMove3(Pokemon p1) {return SteelWing(p1);	}

	public Movetype performMove4(Pokemon p1) {return FeatherDance(p1);	}
	////////////////GETTER FUNCTIONS////////////////
	public String getType() { return "Flying";}
	public String getName() { return "Pidgeot";}
	public String getMove1() { return "Aerial Ace";}
	public String getMove2() { return "Hurricane";}
	public String getMove3() { return "Steel Wing";}
	public String getMove4() { return "Feather Dance";}
	public ImageIcon getIcon() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		URL imgURL = getClass().getResource("/resource/Pidgeot.png");
		Image img = toolkit.getImage(imgURL);
		img = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img);
		return icon;
	}
	///////////////////////////MOVES/////////////////////
	public Movetype AerialAce(Pokemon p){
		double damage = (getAttack() / p.getDefense());
		int atkUP = getAttack() + 5;
		double EnemyHealth = p.getHealth();
		p.setHealth(EnemyHealth - damage);
		setAttack(atkUP);
		return new Movetype(Movetype.MoveType.Damage, Movetype.MoveType.StatusChange,damage,atkUP);
	}
	public Movetype Hurricane(Pokemon p){
		double damage = (getAttack() + 10) / p.getDefense();
		double EnemyHealth = p.getHealth();
		if (p.getType().equals("Fire")){
			damage = (getAttack() * 1.5)/p.getDefense();
			p.setHealth(EnemyHealth - damage);
			System.out.printf("It's super effective!\n");
			return new Movetype(Movetype.MoveType.Damage, damage);
		}
		else if (p.getType().equals("Flying")){
			System.out.printf("Nothing happened...\n");
			return null;
		}
		else {
			p.setHealth(EnemyHealth - damage);
			return new Movetype(Movetype.MoveType.Damage, damage);
		}
	}
	public Movetype SteelWing(Pokemon p){
		Random rnd = new Random();
		double EnemyHealth = p.getHealth();
		double damage = getAttack() / p.getDefense();
		if (rnd.nextInt(10) <= 6){
			damage = (getAttack() * 1.75) / p.getDefense();
			p.setHealth(EnemyHealth - damage);
			System.out.printf("Critical Hit\n");
			return new Movetype(Movetype.MoveType.Damage, damage);
		}
		else {
		p.setHealth(EnemyHealth - damage);
		return new Movetype(Movetype.MoveType.Damage, damage);
		}
	}
	
	public Movetype FeatherDance(Pokemon p){
		int atkUP = getAttack() + 7;
		setAttack(atkUP);
		System.out.printf("%s attack sharply rose!\n", getName());
		return new Movetype(Movetype.MoveType.StatusChange, atkUP);
	}
	
////////////OTHER FUNCTIONS///////////////
	public void resetStats(){
		setAttack(16 + ((getLVL() - 1) * 4));
		setDefense(11 + ((getLVL() - 1) * 3));
	}
	public void levelUP(){
		level++;
		attack = attack + 4;
		defense = defense + 3;
		health = health + 7;
	}
	
}
/*public Movetype MirrorMove(Pokemon p){
Random rnd = new Random();
double value = p.getAttack();
double EnemyHealth = p.getHealth();
Movetype newMove;
if (rnd.nextInt(4)+ 1 == 1){
	newMove = p.performMove1(p);
	value = newMove.getValue1();
}
}*/
