import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;

public class Venasaur extends Pokemon{
	public Venasaur(int l){
		super(l);
		setMaxHealth(20 + (( l - 1) * 10));
		setHealth(20 + (( l - 1) * 10));
		setAttack(5 + (( l - 1) * 1));
		setDefense(15 + (( l - 1) * 3));
		setXP(0);

	}
	/////////////////////PERFORM MOVES//////////////////////////
	public Movetype performMove1(Pokemon p1) { return RazorLeaf(p1);	}
	public Movetype performMove2(Pokemon p1) {return GigaDrain(p1); 	}
	public Movetype performMove3(Pokemon p1) {return ToxicSlam(p1);	}
	public Movetype performMove4(Pokemon p1) {return Relaxation(p1);	}
	//////////////////GETTER FUNCTIONS/////////////////////////////
	public String getType() { return "Grass";}
	public String getName() { return "Venasaur";}
	public String getMove1() { return "Razor Leaf";}
	public String getMove2() { return "Giga Drain";}
	public String getMove3() { return "Toxic Slam";}
	public String getMove4() { return "Relaxation";}
	public ImageIcon getIcon() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		URL imgURL = getClass().getResource("/resource/Venasaur.png");
		Image img = toolkit.getImage(imgURL);
		img = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img);
		return icon;
	}
	/////////////////////////MOVES/////////////////////
	public Movetype RazorLeaf(Pokemon p){
		double EnemyHealth = p.getHealth();
		double damage = getAttack() / p.getDefense();
		if (p.getType().equals("Fire")){
			damage = (getAttack() / 2) / p.getDefense();
			p.setHealth(EnemyHealth - damage);
			System.out.printf("It's not very effective...\n");
			return new Movetype(Movetype.MoveType.Damage, damage);
		}
		else if ( p.getType().equals("Water")){
			damage = (getAttack() * 2) / p.getDefense();
			p.setHealth(EnemyHealth - damage);
			System.out.printf("It's super effective!\n");
			return new Movetype(Movetype.MoveType.Damage, damage);
		}
		else {
			p.setHealth(EnemyHealth - damage);
			return new Movetype(Movetype.MoveType.Damage, damage);
		}
	}
	public Movetype GigaDrain(Pokemon p){
		double EnemyHealth = p.getHealth();
		double damage = (getAttack() + 10) / p.getDefense();
		double YourHealth = damage / 1.5;
		setHealth(getHealth() + YourHealth);
		p.setHealth(EnemyHealth - damage);
		System.out.printf("%s drained %s and gained %.2f health!\n", getName(), p.getName(), YourHealth);
		return new Movetype(Movetype.MoveType.Damage, Movetype.MoveType.Heal, damage, YourHealth);
	}
	public Movetype ToxicSlam(Pokemon p){
		double EnemyHealth = p.getHealth();
		double damage = getAttack() / p.getDefense();
		Random rnd = new Random();
		if (rnd.nextInt(10)+ 1 <=6){
			int poisoned = 15;
			damage = damage + poisoned;
			p.setHealth(EnemyHealth - damage);
			System.out.printf("%s was poisoned!\n", p.getName());
			return new Movetype(Movetype.MoveType.Damage, damage);
		}
		else {
			p.setHealth(EnemyHealth - damage);
			return new Movetype(Movetype.MoveType.Damage, damage);
		}
		
	}
	public Movetype Relaxation(Pokemon p){
		setHealth(getHealth() + 20);
		setAttack(getAttack() + 3);
		setDefense(getDefense() + 3);
		return new Movetype(Movetype.MoveType.StatusChange, Movetype.MoveType.Heal, (getAttack() + 3), (getHealth() + 20) );
	}
////////////OTHER FUNCTIONS///////////////
	public void resetStats(){
		setAttack(5 + ((getLVL() - 1) * 1));
		setDefense(15 + ((getLVL() - 1) * 3));
	}
	public void levelUP(){
		level++;
		attack = attack + 1;
		defense = defense + 3;
		health = health + 10;
	}
}
