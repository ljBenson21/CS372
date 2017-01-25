

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.util.Random;

public class MainMenu {
	JFrame frame = new JFrame("Main Menu"), l = new JFrame("User Pokemon");
	int days = 0;
	public MainMenu(Trainer User){
		frame.setSize(750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
			JPanel NorthPanel = new JPanel();
			NorthPanel.setBackground(Color.GRAY);
			JButton peekPokemon = new JButton("Examine Pokemon"), healPokemon = new JButton("Heal Team"),
					hunt = new JButton("Find Pokemon"), train = new JButton("Find Trainer"), boss = new JButton("Fight Gym Leader");
			train.setForeground(Color.WHITE);
			boss.setBackground(Color.RED);
			train.setBackground(Color.BLUE);
			hunt.setBackground(Color.ORANGE);
			healPokemon.setBackground(Color.PINK);
			peekPokemon.setBackground(Color.GREEN);
			NorthPanel.add(peekPokemon);
			NorthPanel.add(healPokemon);
			NorthPanel.add(hunt);
			NorthPanel.add(train);
			NorthPanel.add(boss);
			
			peekPokemon.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					l.getContentPane().setLayout(new BorderLayout());
					l.setSize(300, 300);
					
					JButton done = new JButton("Done");
					done.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e){
							l.dispose();
						}
					});
					
					for (int i = 0; i < User.Team.size(); i++){
						MyButton btn = new MyButton(User.getPokemon(i),User.Team.get(i).getIcon());
						btn.addActionListener(new ActionListener(){
							@Override
							public void actionPerformed(ActionEvent e){
								MyButton b = (MyButton)e.getSource();
								Pokemon c = b.getPokemon();
								JOptionPane.showMessageDialog(l, String.format("Health: %.1f\nAttack: %d\nDefense: %d\n"
										+ "Type: %s\nMove 1: %s\nMove2: %s\nMove 3: %s\nMove 4: %s\n",
										c.getHealth(), c.getAttack(), c.getDefense(), c.getType(),c.getMove1(),
										c.getMove2(),c.getMove3(), c.getMove4()));
							}
						});
						l.getContentPane().add(btn, BorderLayout.CENTER);
					}
					l.getContentPane().add(done, BorderLayout.SOUTH);
					
					l.setVisible(true);
				}
			});
			
			healPokemon.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					days++;
					for (int i = 0; i < User.Team.size(); i++){
						if (User.fullHeals == 0){
							break;
						}
						else{
							User.fullHeals--;
							User.Team.get(i).health = User.Team.get(i).FullHeal();
							System.out.printf("You have %d Full Heals.", User.fullHeals);
						}//Potential fix
					}
			}
		});
			
			hunt.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					Random rnd = new Random();
					int num = rnd.nextInt(100);
					if (num < 25){
						days++;
						frame.getContentPane().add(new JLabel("There were no Pokemon to be found."), BorderLayout.CENTER);
					}
					else {
						days++;
						WildFight fight = new WildFight(User);
					}
				}
			});
			
			if (User.defeatedTeam()==true){
				frame.add(new JLabel("All Pokemon have fainted.\n"), BorderLayout.CENTER);
				if (User.fullHeals <= 0)
					frame.add(new JLabel("GAME OVER"), BorderLayout.SOUTH);
				frame.getContentPane().revalidate();
			}
			
			
			frame.getContentPane().add(NorthPanel);
			
		
	}
}

