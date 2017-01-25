

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton { 
	Pokemon pokemon;
	String name;
	public MyButton(Pokemon p1, String n){
		super(n);
		pokemon = p1;
	}
	public MyButton(Pokemon p, ImageIcon i) {
		super(i);
		pokemon = p;
	}
	public Pokemon getPokemon() {return pokemon;}
}
