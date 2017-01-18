import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;

public class Window extends JComponent {
	ArrayList<String> PeopleinSchool = new ArrayList();
	ArrayList<String> PeopleinCityHall = new ArrayList();
	
	JFrame frame;

	int x = 0, y = 0;

	public Window(ArrayList<Person> people, ArrayList<Building> build){
		
		initialize((people), (build));
		
		frame.setVisible(true);
	}
	
void initialize(ArrayList<Person> people, ArrayList<Building> build){
	frame = new JFrame();
	frame.setLayout(new BorderLayout());
	frame.setBounds(100, 100, 750, 500);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	
	//Create Child icon
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	URL imgURL = getClass().getResource("/resource/ChildImage.jpg");
	Image ChildIMG = toolkit.getImage(imgURL);
	ChildIMG = ChildIMG.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	ImageIcon icon = new ImageIcon(ChildIMG);
	
	//create police icon
	Toolkit toolkit1 = Toolkit.getDefaultToolkit();
	URL imgURL1 = getClass().getResource("/resource/policeIMG.jpg");
	Image PoliceIMG = toolkit1.getImage(imgURL1);
	PoliceIMG = PoliceIMG.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	ImageIcon icon1 = new ImageIcon(PoliceIMG);
	
	//create teacher icon
	Toolkit toolkit2 = Toolkit.getDefaultToolkit();
	URL imgURL2 = getClass().getResource("/resource/teacher.jpg");
	Image teacherIMG = toolkit2.getImage(imgURL2);
	teacherIMG = teacherIMG.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	ImageIcon icon2 = new ImageIcon(teacherIMG);
	
	//create city hall icon
	Toolkit toolkit4 = Toolkit.getDefaultToolkit();
	URL imgURL4 = getClass().getResource("/resource/chimg.jpg");
	Image CHIMG = toolkit4.getImage(imgURL4);
	CHIMG = CHIMG.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon icon4 = new ImageIcon(CHIMG);
	
	//create school icon
	Toolkit toolkit3 = Toolkit.getDefaultToolkit();
	URL imgURL3 = getClass().getResource("/resource/SchoolIMG.jpg");
	Image SchoolIMG = toolkit3.getImage(imgURL3);
	SchoolIMG = SchoolIMG.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	ImageIcon icon3 = new ImageIcon(SchoolIMG);

    JPanel panel = new JPanel(), panel2 = new JPanel(), panel3 = new JPanel();
	JButton btn = new myButton("School", icon3);
	JButton btn2 = new myButton("City Hall", icon4);
	JButton btn3 = new myButton("Add people to City Hall");
	JButton btn4 = new myButton("Add people to School");
	JButton btn5 = new myButton("Delete people from School");
	JButton btn6 = new myButton("Delete people from City Hall");
	
	JLabel label = new JLabel();
	JButton learn = new JButton("Show me details");
	learn.setBackground(Color.CYAN);
	
	label.add(learn);
	for (int i = 0; i < people.size(); i++)
	{
		if(people.get(i) instanceof Child){
			myButton btn7 = new myButton(people.get(i), icon);
			btn7.setBackground(Color.MAGENTA);
			panel.add(btn7);
			btn7.addMouseMotionListener(new MouseAdapter(){
				@Override //makes the button move on mouse click
				public void mouseDragged(MouseEvent e){
					myButton b = (myButton)e.getSource();
					Person c = b.getPerson();
					x = e.getX() + b.getX();
					y = e.getY() + b.getY();
					b.setBounds(x, y, 150, 75);
					////////////MOVE CHILD TO "SHOW ME DETAILS"///////////
					if (b.getX() < label.getX()&& b.getY() > label.getY() ){
						if (c instanceof Child){
							String dlg = String.format("%s is %d years old, loves %s and has a phone "
									+ "with number %s.", c.name, c.age, ((Child) c).favCandy, c.phoneNum );
							JOptionPane.showMessageDialog(frame, dlg);
						}
					}
					
				}
			});
		}
		else if(people.get(i) instanceof Police){
			JButton btn7 = new myButton(people.get(i), icon1);
			btn7.setBackground(Color.LIGHT_GRAY);

			panel.add(btn7);
			btn7.addMouseMotionListener(new MouseAdapter(){
				@Override //MAKES THE BUTTON MOVE ON MOUSE CLICK!
				public void mouseDragged(MouseEvent e){
					myButton b = (myButton)e.getSource();
					Person c = b.getPerson();
					x = e.getX() + b.getX();
					y = e.getY() + b.getY();
					b.setBounds(x, y, 150, 75);
					////////////MOVE POLICE TO "SHOW ME DETAILS"///////////
					if (b.getX() < label.getX()&& b.getY() > label.getY() ){
						if (c instanceof Police){
							String dlg = String.format("%s is %d years old and the %s of the police department"
									+ ". %s's phone number is %s", c.name, c.age, ((Police)c).getRole(), c.name, c.phoneNum);
							JOptionPane.showMessageDialog(frame, dlg);
						}
					}
				}
			});
			
		}
		else if (people.get(i) instanceof Teacher){
			JButton btn7 = new myButton(people.get(i), icon2);
			btn7.setBackground(Color.GREEN);
			panel.add(btn7);
			btn7.addMouseMotionListener(new MouseAdapter(){
				@Override //ERRRRMAHGERRRRRD MAKES THE IMAGE MOVE AGAIN ON MOUSE CLICK!
				public void mouseDragged(MouseEvent e){
					myButton b = (myButton)e.getSource();
					Person c = b.getPerson();
					x = e.getX() + b.getX();
					y = e.getY() + b.getY();
					b.setBounds(x, y, 150, 75);
					////////////MOVE TEACHER TO "SHOW ME DETAILS"///////////
					if (b.getX() < label.getX()&& b.getY() > label.getY() ){
						if (c instanceof Teacher){
							String dlg = String.format("%s is %d years old and is the only teacher"
									+ "in the city. She is certified to teach %s and \nteaches children in "
									+ "%d grade. %s's phone number is %s", c.name, c.age, ((Teacher)c).getCertification(),((Teacher)c).getGradelvl()
									, c.name, c.phoneNum);
							JOptionPane.showMessageDialog(frame, dlg);
						}
					}
				}
			});
		}
			
		


	}

	
	//////////////////SCHOOL BUTTON/////////////////////////
	btn.setBackground(Color.YELLOW);
	panel2.add(btn);
	btn.addActionListener(new ActionListener() {
		@Override 
		public void actionPerformed(ActionEvent e){
			String details = "";
			for (int i = 0; i < PeopleinSchool.size(); i++){
				details += PeopleinSchool.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, details, "Printing Results\n", JOptionPane.INFORMATION_MESSAGE );
		}
	});
	///////////////CITY HALL BUTTON///////////////////////////////////////////////////////////////////////////////////////////////////
	btn2.setBackground(Color.ORANGE);
	panel2.add(btn2);
	btn2.addActionListener(new ActionListener() {
		@Override 
		public void actionPerformed(ActionEvent e){
			String details = "";
			for (int i = 0; i < PeopleinCityHall.size(); i++){
				details += PeopleinCityHall.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, details, "Printing Results\n", JOptionPane.INFORMATION_MESSAGE );
		}
	});
	
	
	///////////////ADD PEOPLE TO SCHOOL//////////////////////////////
	btn4.setBackground(Color.WHITE);
	panel3.add(btn4);
	btn4.addActionListener(new ActionListener() {
		@Override 
		public void actionPerformed(ActionEvent e){
			String name = JOptionPane.showInputDialog(null, "Which person do you want to add to the school?");
			for (int i = 0; i < people.size(); i++){
				String s = people.get(i).name;
				if (s.equals(name))
					PeopleinSchool.add(name);
				else{
					
				}
			}
		}
	});
	///////////////ADD PEOPLE TO CITY HALL//////////////////////////
	btn3.setBackground(Color.WHITE);
	panel3.add(btn3);
	btn3.addActionListener(new ActionListener() {
		@Override 
		public void actionPerformed(ActionEvent e){
			String name = JOptionPane.showInputDialog(null, "Which person do you want to add to the City Hall?");
			for (int i = 0; i < people.size(); i++){
				String s = people.get(i).name;
				if (s.equals(name))
					PeopleinCityHall.add(name);
				else{
					
				}
			}
		}
	});
	//////////////DELETE PEOPLE FROM SCHOOL/////////////////////////////
	btn5.setBackground(Color.WHITE);
	panel3.add(btn5);
	btn5.addActionListener(new ActionListener() {
		@Override 
		public void actionPerformed(ActionEvent e){
			String name = JOptionPane.showInputDialog(null, "Which person do you want to delete from School?");
			PeopleinSchool.remove(name);
		}
	});
	//////////////DELETE PEOPLE FROM CITY HALL////////////////////////
	btn6.setBackground(Color.WHITE);
	panel3.add(btn6);
	btn6.addActionListener(new ActionListener() {
		@Override 
		public void actionPerformed(ActionEvent e){
			String name = JOptionPane.showInputDialog(null, "Which person do you want to delete from City Hall?");
			PeopleinCityHall.remove(name);
		}
	});
	////////////////////BUTTON THAT RESETS THE FRAME/////////////////////
	JPanel panel4 = new JPanel();
	JButton repaint = new JButton("Reset");
	repaint.setBackground(Color.PINK);
	panel4.add(repaint);
	repaint.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			frame.getContentPane().invalidate();
			frame.getContentPane().validate();
			frame.getContentPane().repaint();
			
		}
	});
	
	
	
	frame.add(learn, BorderLayout.WEST);
	frame.add(repaint, BorderLayout.EAST);
	frame.add(panel, BorderLayout.CENTER);
	frame.add(panel2, BorderLayout.SOUTH);
	frame.add(panel3, BorderLayout.NORTH);
	
	
	
	
}


}
