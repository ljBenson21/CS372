
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import java.awt.*;

public class PokemonTest extends JComponent{
	JFrame frame = new JFrame("Pokemon");

	public static void main(String [] args){
		PokemonTest test = new PokemonTest();
		
	}
	
	public PokemonTest(){
		frame.setSize(500,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setVisible(true);
		
		JLabel welcome = new JLabel("Welcome to Pokemon!");
		JButton button = new JButton("START");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JButton button2 = new JButton("continue");
				Trainer User = new Trainer();
				String name = JOptionPane.showInputDialog(null, "What is your trainer's name?");
				User.setName(name);
				JLabel label = new JLabel(String.format("<html>Welcome %s! The objective of this game<br>"
						+ "is to get both you and your pokemon to defeat a single gym leader. In<br>"
						+ "order to do this, you must train your pokemon and become the best trainer<br>"
						+ "in the area. You may have a maximum 4 pokemon throughout the game and<br>"
						+ "may not change or remove pokemon... So choose wisely, and GOOD LUCK!</html>", name));
				frame.getContentPane().add(label);
				frame.revalidate();
				button2.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						JFrame f = new JFrame("Choose Starter Pokemon");
						f.setLayout(new BorderLayout());
						f.setSize(200,200);
						
						JLabel label = new JLabel("Choose Wisely: ");
						f.add(label, BorderLayout.NORTH);
						JButton choose = new JButton("Choose");
						JPanel pokePanel = new JPanel();
						final ButtonGroup pokemon = new ButtonGroup();
						JRadioButton r1;
						pokePanel.add(r1 = new JRadioButton("Charizard"));
						r1.setActionCommand("Charizard");
						pokemon.add(r1);
						pokePanel.add(r1 = new JRadioButton("Blastoise"));
						r1.setActionCommand("Blastoise");
						pokemon.add(r1);
						pokePanel.add(r1 = new JRadioButton("Venasaur"));
						r1.setActionCommand("Venasaur");
						pokemon.add(r1);
						pokePanel.add(r1 = new JRadioButton("Onyx"));
						r1.setActionCommand("Onyx");
						pokemon.add(r1);
						pokePanel.add(r1 = new JRadioButton("Pidgeot"));
						r1.setActionCommand("Pidgeot");
						pokemon.add(r1);
						pokePanel.add(r1 = new JRadioButton("Pikachu"));
						r1.setActionCommand("Pikachu");
						pokemon.add(r1);
						pokePanel.add(r1 = new JRadioButton("Machamp"));
						r1.setActionCommand("Machamp");
						pokemon.add(r1);
						pokePanel.add(r1 = new JRadioButton("Alakazam"));
						r1.setActionCommand("Alakazam");
						pokemon.add(r1);

						choose.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								String p = pokemon.getSelection().getActionCommand();
									if (p.equals("Alakazam"))
										User.addTeamMembers(new Alakazam(1));
									else if(p.equals("Blastoise"))
										User.addTeamMembers(new Blastoise(1));
									else if(p.equals("Charizard"))
										User.addTeamMembers(new Charizard(1));
									else if(p.equals("Machamp"))
										User.addTeamMembers(new Machamp(1));
									else if(p.equals("Onyx"))
										User.addTeamMembers(new Onyx(1));
									else if(p.equals("Pidgeot"))
										User.addTeamMembers(new Pidgeot(1));
									else if(p.equals("Pikachu"))
										User.addTeamMembers(new Pikachu(1));
									else if(p.equals("Venasaur"))
										User.addTeamMembers(new Venasaur(1));
								f.dispose();
								MainMenu main = new MainMenu(User);
								frame.dispose();
							}
						});
						f.add(pokePanel, BorderLayout.CENTER);
						f.add(choose, BorderLayout.SOUTH);
						f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						f.setVisible(true);
						frame.getContentPane().removeAll();
						frame.repaint();
					}
				});
				frame.add(button2);
				frame.revalidate();
			}
		});
		welcome.setForeground(Color.BLACK);
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setFont(new Font("Stencil", Font.PLAIN, 20));

		frame.getContentPane().add(welcome);
		frame.getContentPane().add(button);
	}

	
	public void faint(JFrame f){
		JOptionPane.showMessageDialog(f,"Your pokemon has fainted!");
	}

	
}
