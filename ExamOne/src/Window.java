import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class Window extends JComponent{
	JFrame frame, frame2;
	ArrayList<Shape> Shapes = new ArrayList<Shape>();
	public Window() throws IOException{
		initialize();
		
		frame.setVisible(true);
	}
	
	void initialize() throws IOException{
		frame = new JFrame("Shapes and Sizes");
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/////////////////////CIRCLE////////////////////
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		URL imgURL = getClass().getResource("/resources/Circle.jpg");
		Image Circle = toolkit.getImage(imgURL);
		Circle = Circle.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(Circle);
		
		/////////////////SQUARE//////////////////////////
		Toolkit toolkit1 = Toolkit.getDefaultToolkit();
		URL imgURL1 = getClass().getResource("/resources/Circle.jpg");
		Image Square = toolkit1.getImage(imgURL1);
		Square = Square.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon icon1 = new ImageIcon(Square);
		
		////////////////RECTANGLE///////////////////////
		Toolkit toolkit2 = Toolkit.getDefaultToolkit();
		URL imgURL2 = getClass().getResource("/resources/Circle.jpg");
		Image Rectangle = toolkit2.getImage(imgURL2);
		Rectangle = Rectangle.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon icon2 = new ImageIcon(Rectangle);
		
		/////////////TRIANGLE//////////////////////////
		Toolkit toolkit3 = Toolkit.getDefaultToolkit();
		URL imgURL3 = getClass().getResource("/resources/Circle.jpg");
		Image Triangle = toolkit3.getImage(imgURL3);
		Triangle = Triangle.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon icon3 = new ImageIcon(Triangle);
		
		String FileName = "C:\\Users\\lbenson18\\Downloads\\shapes.txt";
		ReadFile file = new ReadFile(FileName);
		String[] lines = file.OpenFile();
		
		
		
		JComboBox comboBox = new JComboBox(lines);
		comboBox.setEditable(true);
		final JList list = new JList(comboBox.getModel());
		
		JButton b = new JButton("Select");
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Object[] select = list.getSelectedValues();
				System.out.println("------");
				
				for (Object o : select){
					frame2 = new JFrame("Shape Info");
					frame2.setSize(400,400);
					JLabel shapeDeets = new JLabel((String)o);
					JButton button1 = new JButton(icon);
					JButton button2 = new JButton(icon1);
					JButton button3 = new JButton(icon2);
					JButton button4 = new JButton(icon3);
					//Didnt work but do you see what I am trying to do here?///
					if (((String)o).charAt(0) == 'c')
						frame2.add(button1);
					else if(((String)o).charAt(0)== 't')
						frame2.add(button4);
					else if(((String)o).charAt(0)== 's')
						frame2.add(button2);
					else if(((String)o).charAt(0) == 'r')
						frame2.add(button3);
					/////////////////////////////////////
					frame2.add(shapeDeets);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame2.setVisible(true);
					
				}
				
			}
		});
		
		Container c = frame.getContentPane();
		c.add(new JScrollPane(list), BorderLayout.CENTER);
		c.add(b, BorderLayout.SOUTH);
		
	}

	}
