import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class myButton extends JButton {
	Person p;
	public myButton(Person purse, ImageIcon icon){
		super(purse.name, icon);
		p = purse;
	}
	public myButton(String s, ImageIcon i){
		super(s,i);
	}
	public myButton(String s){
		super(s);
	}
	public myButton(String s, ImageIcon i, int x, int y, int w, int h){
		super(s, i);
		this.setBounds(x, y, w, h);
	}
	
	public Person getPerson() {return p;}

}
