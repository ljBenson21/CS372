import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;

public class Alakazam extends Pokemon{
	public Alakazam(int l){
		super(l);
		setMaxHealth(20 + ((l - 1) * 9));
		setHealth(20 + ((l - 1) * 9));
		setAttack(9 + ((l - 1)* 2));
		setDefense(12 + (( l - 1) * 3));
		setXP(0);
		
	}
///////////////////////PERFORM MOVES/////////////////////////
	public Movetype performMove1(Pokemon p1) { return PsyBeam(p1);	}

	public Movetype performMove2(Pokemon p1) {return Concentrate(p1); 	}

	public Movetype performMove3(Pokemon p1) {return Confusion(p1);	}

	public Movetype performMove4(Pokemon p1) {return LightScreen(p1);	}
	
	
//////////////////////GETTER FUNCTIONS//////////////////
	public String getName() {return "Alakazam";	}

	public String getMove1() {return "PsyBeam";	}

	public String getMove2() {return "Concentrate";	}

	public String getMove3() {return "Confusion";	}

	public String getMove4() {return "Light Screen";	}

	public String getType() {return "Psychic";	}

	public ImageIcon getIcon() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		URL imgURL = getClass().getResource("/resource/Alakazam.png");
		Image img = toolkit.getImage(imgURL);
		img = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img);
		return icon;
		}
	/////////////////////MOVES//////////////////////
	public Movetype PsyBeam(Pokemon p){
		double damage = (getAttack() + getLVL()) / p.getDefense();
		double EnemyHealth = p.getHealth() - damage;
		p.setHealth(EnemyHealth);
		return new Movetype(Movetype.MoveType.Damage, EnemyHealth);
	}
	
	public Movetype Concentrate(Pokemon p){
		int atkUP = getAttack() + getDefense();
		setAttack(atkUP);
		System.out.printf("Alakazam's attack rose!\n");
		return new Movetype(Movetype.MoveType.StatusChange, atkUP);
	}
	
	public Movetype Confusion(Pokemon p){
		double damage = (getAttack() - getDefense()) / p.getDefense();
		double EnemyHealth = p.getHealth() - damage;
		Random rnd = new Random();
		int opponentAtk = p.getAttack(), opponentDef = p.getDefense(), var;
		if (rnd.nextInt(10) <= 5){
			var = opponentAtk;
			opponentAtk = opponentDef;
			opponentDef = var;
			p.setAttack(opponentAtk);
			p.setDefense(opponentDef);
			System.out.printf("%s was confused! (ATK and DEF switch)\n", p.getName());
			return new Movetype(Movetype.MoveType.StatusChange,Movetype.MoveType.StatusChange, opponentAtk, opponentDef);
		}
		p.setHealth(EnemyHealth);
		return new Movetype(Movetype.MoveType.Damage, EnemyHealth);
	}
	
	public Movetype LightScreen(Pokemon p){
		int dblDef = getDefense() * 2;
		setDefense(dblDef);
		System.out.printf("Alakazam's defense rose!\n");
		return new Movetype(Movetype.MoveType.StatusChange, dblDef);
	}
	//////////////OTHER FUNCTIONS/////////////////////
	public void resetStats(){
		setAttack(9 + ((getLVL()-1) * 2));
		setDefense(12 + ((getLVL()-1) * 3));
	}
	
	public void levelUP(){
		level++;
		attack = attack + 2;
		defense = defense + 3;
		maxHealth = maxHealth + 9;
	}
	
	
	
	
	
}
