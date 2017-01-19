import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;
class Countdown implements Runnable {
	
	
     
    private JLabel _label;
	Boolean startStop = true;
////////////////Dice Images///////////////////////////
Toolkit toolkit1 = Toolkit.getDefaultToolkit();
URL img1 = getClass().getResource("/resource/one.jpg");
Image one = toolkit1.getImage(img1);


Toolkit toolkit2 = Toolkit.getDefaultToolkit();
URL img2 = getClass().getResource("/resource/two.jpg");
Image two = toolkit2.getImage(img2);


Toolkit toolkit3 = Toolkit.getDefaultToolkit();
URL img3 = getClass().getResource("/resource/three.jpg");
Image three = toolkit3.getImage(img3);


Toolkit toolkit4 = Toolkit.getDefaultToolkit();
URL img4 = getClass().getResource("/resource/four.jpg");
Image four = toolkit4.getImage(img4);


Toolkit toolkit5 = Toolkit.getDefaultToolkit();
URL img5 = getClass().getResource("/resource/five.jpg");
Image five = toolkit5.getImage(img5);


Toolkit toolkit6 = Toolkit.getDefaultToolkit();
URL img6 = getClass().getResource("/resource/six.jpg");
Image six = toolkit6.getImage(img6);

	
		
	
    public Countdown(JLabel label) {
        _label = label;
    }

    
    
    public void run() {
    	int x = 0;// integer from one to 5
    	 
    	
    	one = one.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		two = two.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		three = three.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		four = four.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		five = five.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		six = six.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	
	
	ImageIcon icon1 = new ImageIcon(one), icon2 = new ImageIcon(two), icon3 = new ImageIcon(three),
			icon4 = new ImageIcon(four), icon5 = new ImageIcon(five), icon6 = new ImageIcon(six);

	
	ImageIcon[] i = { icon1, icon2, icon3, icon4, icon5, icon6 };

     

    	
        while(Homework4Test.startStop == true) {
        	
            _label.setIcon(i[x]);
            try {
                Thread.sleep(50);
            }
            catch (InterruptedException ex) {;}
            x = (x + 1) % 6;
            
        }
        
        
        
    }
}

public class Homework4Test extends JFrame implements ActionListener{
	public static Boolean startStop;
	public static void main(String [] args){
		Homework4Test test = new Homework4Test();
	}
	 JButton button = new JButton("Stop");
	 
	public Homework4Test() {
		
		setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        button.addActionListener(this);
       this.add(button);

        
               
        Countdown[] cs = new Countdown[5];
        startStop = true;
        for (int i=0; i<5; i++) {
            JLabel l = new JLabel();
            cs[i] = new Countdown(l);
            this.add(l);
        }

        this.setVisible(true);

        for (int i=0; i<5; i++) {
            Thread t = new Thread(cs[i]);
            t.start();
            try {
                Thread.sleep(100);
                
            }
            catch (InterruptedException ex) {;}
        }
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		startStop = false;
	}
}
