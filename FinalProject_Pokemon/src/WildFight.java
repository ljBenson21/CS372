import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
public class WildFight extends JComponent implements ActionListener{
	JFrame frame = new JFrame("Wild Fight");
	ArrayList<MyButton> POKEMON_TEAM = new ArrayList<MyButton>();
	int fleeTries = 3;
	MyButton pokemon;
	
	public WildFight(Trainer User)  {//figure out how to pass in attacks through Pokemon
		frame.setSize(550, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Random rnd = new Random(), randLVL = new Random(), rndMove = new Random(), rndFlee = new Random();
		JPanel west = new JPanel(), east = new JPanel(), center = new JPanel(), south = new JPanel();
		
		int level = User.getPokemon(0).getLVL();
		int levelADD = randLVL.nextInt(5);
		int rndPokemon = rnd.nextInt(8);
		int fleeChance = rndFlee.nextInt(10);
		
		Pokemon[] WildPokemon = {new Alakazam(level + levelADD), new Blastoise(level + levelADD), new Charizard(level + levelADD), 
				new Machamp(level + levelADD),new Onyx(level + levelADD), new Pidgeot(level + levelADD), new Pikachu(level + levelADD) , 
				new Venasaur(level + levelADD)}; 
		
		Pokemon wildPokemon = WildPokemon[rndPokemon];
		
		
		for (int i = 0; i < User.Team.size(); i++){
			POKEMON_TEAM.add(new MyButton(User.Team.get(i), User.Team.get(i).getIcon()));
			pokemon = POKEMON_TEAM.get(i);
			JButton done = new JButton("Flee");
			JButton choosePokemon = new JButton("Choose next Pokemon");
			choosePokemon.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					for (int i = 0; i < User.Team.size(); i++){
						
					}
				}
			});
			
			JLabel opponent = new JLabel(wildPokemon.getIcon()), fightLabel = new JLabel(String.format("A wild %s appeared!",wildPokemon.getName()));
			final int currentPoke = i;
			
			done.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					
					if (fleeChance == 2 || fleeChance == 7){
						frame.dispose();
					}
					else{
						JLabel flee = new JLabel("You could not flee!\n");
						center.add(flee);
						frame.getContentPane().revalidate();
						fleeTries--;
						if (fleeTries <=0){
							System.out.printf("You cannot attempt to flee anymore.\n");
						}
						System.out.printf("You have %d flee tries.\n", fleeTries);
						int moves = rndMove.nextInt(4) + 1;
						Pokemon p = User.getPokemon(currentPoke);
						JLabel label2;
		
						if(moves == 1){
							wildPokemon.performMove1(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove1()));
						}
						else if(moves == 2){
							wildPokemon.performMove2(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove2()));
						}
						else if(moves == 3){
							wildPokemon.performMove3(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove3()));
						}
						else if(moves == 4){
							wildPokemon.performMove4(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove4()));
						}
						else 
							label2 = new JLabel();
						center.add(label2);
						frame.getContentPane().revalidate();
					}
						
				}
			});
			
			
			
			pokemon.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					try{
					String move = JOptionPane.showInputDialog(null, String.format("What move would you like to use?\n1. %s\n2. %s:\n3. %s:\n4. %s:\n", 
							User.Team.get(currentPoke).getMove1(),User.Team.get(currentPoke).getMove2(),User.Team.get(currentPoke).getMove3(),User.Team.get(currentPoke).getMove4()));
					Pokemon p = User.Team.get(currentPoke);
					JLabel label, label2;
					int moves = rndMove.nextInt(4) + 1;
					switch(move){
					case "1": 
						p.performMove1(wildPokemon);
						label = new JLabel(String.format("%s used %s!", p.getName(), p.getMove1()));
						center.add(label);
						
						if (wildPokemon.faint() == true){
							int experienceIncrease = 10;
							int newXP = p.getXP() + experienceIncrease;
							p.setXP(newXP);
							System.out.printf("%s was defeated.\n%s gained %d experience!\n", wildPokemon.getName(), p.getName(), newXP);
							if (p.getXP() >= (10 + ((p.getLVL() - 1) * 10))){
								p.levelUP();
								JOptionPane.showMessageDialog(frame, String.format("Level: %d\n"
										+ "Attack: %d\nDefense: %d\nHealth: %.2f\n", p.getLVL(), p.getAttack(), p.getDefense(), p.getMaxHealth()));
								System.out.printf("%s leveled up!\n", p.getName());
							}
							p.resetStats();
						} 
						if(moves == 1){
							wildPokemon.performMove1(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove1()));
						}
						else if(moves == 2){
							wildPokemon.performMove2(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove2()));
						}
						else if(moves == 3){
							wildPokemon.performMove3(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove3()));
						}
						else if(moves == 4){
							wildPokemon.performMove4(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove4()));
						}
						else 
							label2 = new JLabel("Nothing Happened...?");
						
						if(p.faint() == true){
							System.out.printf("Your Pokemon has fainted.\n");
							frame.dispose();		
						}
						center.add(label2);
						frame.getContentPane().revalidate();
						System.out.printf("%f/%f\n", p.getMaxHealth(), p.health);
						System.out.printf("%f/%f\n", wildPokemon.getMaxHealth(), wildPokemon.health);
						
						
						break;
					case "2":
						p.performMove2(wildPokemon);
						label = new JLabel(String.format("%s used %s!", p.getName(), p.getMove2()));
						center.add(label);
						
						if (wildPokemon.faint() == true){
							int experienceIncrease = 10;
							int newXP = p.getXP() + experienceIncrease;
							p.setXP(newXP);
							System.out.printf("%s was defeated.\n%s gained %d experience!\n", wildPokemon.getName(), p.getName(), newXP);
							if (p.getXP() >= (10 + ((p.getLVL() - 1) * 10))){
								p.levelUP();
								JOptionPane.showMessageDialog(frame, String.format("Level: %d\n"
										+ "Attack: %d\nDefense: %d\nHealth: %.2f\n", p.getLVL(), p.getAttack(), p.getDefense(), p.getMaxHealth()));
								System.out.printf("%s leveled up!\n", p.getName());
							}
							p.resetStats();
						}
						
						if(moves == 1){
							wildPokemon.performMove1(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove1()));
						}
						else if(moves == 2){
							wildPokemon.performMove2(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove2()));
						}
						else if(moves == 3){
							wildPokemon.performMove3(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove3()));
						}
						else if(moves == 4){
							wildPokemon.performMove4(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove4()));
						}
						else 
							label2 = new JLabel("Nothing Happened...?");
						
						if(p.faint() == true){
							System.out.printf("Your Pokemon has fainted.\n");
							frame.dispose();				
						}
						
						center.add(label2);
						frame.revalidate();
						System.out.printf("%f/%f\n", p.getMaxHealth(), p.health);
						System.out.printf("%f/%f\n", wildPokemon.getMaxHealth(), wildPokemon.health);
						
						
						break;
					case "3":
						p.performMove3(wildPokemon);
						label = new JLabel(String.format("%s used %s!", p.getName(), p.getMove3()));
						center.add(label);
						if (wildPokemon.faint() == true){
							int experienceIncrease = 10;
							int newXP = p.getXP() + experienceIncrease;
							p.setXP(newXP);
							System.out.printf("%s was defeated.\n%s gained %d experience!\n", wildPokemon.getName(), p.getName(), newXP);
							if (p.getXP() >= (10 + ((p.getLVL() - 1) * 10))){
								p.levelUP();
								JOptionPane.showMessageDialog(frame, String.format("Level: %d\n"
										+ "Attack: %d\nDefense: %d\nHealth: %.2f\n", p.getLVL(), p.getAttack(), p.getDefense(), p.getMaxHealth()));
								System.out.printf("%s leveled up!\n", p.getName());
							}
							p.resetStats();
						}
						
						
						if(moves == 1){
							wildPokemon.performMove1(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove1()));
						}
						else if(moves == 2){
							wildPokemon.performMove2(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove2()));
						}
						else if(moves == 3){
							wildPokemon.performMove3(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove3()));
						}
						else if(moves == 4){
							wildPokemon.performMove4(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove4()));
						}
						else 
							label2 = new JLabel("Nothing Happened...?");
						
						if(p.faint() == true){
							System.out.printf("Your Pokemon has fainted.\n");
							frame.dispose();		
						}
						
						center.add(label2);
						frame.revalidate();
						System.out.printf("%f/%f\n", p.getMaxHealth(), p.health);
						System.out.printf("%f/%f\n", wildPokemon.getMaxHealth(), wildPokemon.health);
						
						
						break;
					case "4":
						p.performMove4(wildPokemon);
						label = new JLabel(String.format("%s used %s!", p.getName(), p.getMove4()));
						center.add(label);
						
						if (wildPokemon.faint() == true){
							int experienceIncrease = 10;
							int newXP = p.getXP() + experienceIncrease;
							p.setXP(newXP);
							System.out.printf("%s was defeated.\n%s gained %d experience!\n", wildPokemon.getName(), p.getName(), newXP);
							if (p.getXP() >= (10 + ((p.getLVL() - 1) * 10))){
								p.levelUP();
								JOptionPane.showMessageDialog(frame, String.format("Level: %d\n"
										+ "Attack: %d\nDefense: %d\nHealth: %.2f\n", p.getLVL(), p.getAttack(), p.getDefense(), p.getMaxHealth()));
								System.out.printf("%s leveled up!\n", p.getName());
							}
							p.resetStats();
						}
							
						if(moves == 1){
							wildPokemon.performMove1(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove1()));
						}
						else if(moves == 2){
							wildPokemon.performMove2(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove2()));
						}
						else if(moves == 3){
							wildPokemon.performMove3(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove3()));
						}
						else if(moves == 4){
							wildPokemon.performMove4(p);
							label2 = new JLabel(String.format("%s used %s!",wildPokemon.getName(), wildPokemon.getMove4()));
						}
						else 
							label2 = new JLabel("Nothing Happened...?");
						
						if(p.faint() == true){
							System.out.printf("Your Pokemon has fainted.\n");
							frame.dispose();		
						}
						
						center.add(label2);
						frame.revalidate();
						System.out.printf("%f/%f\n", p.getMaxHealth(), p.health);
						System.out.printf("%f/%f\n", wildPokemon.getMaxHealth(), wildPokemon.health);
						
						
							
							//frame.dispose();
						
						break;
					}
					}catch(Exception ex) {System.out.printf("Please use the number corresponding to the move.\n");}
					
					
				}
			});
			
			west.add(pokemon);
			south.add(done);
			east.add(opponent);
			center.add(fightLabel);
			
		}
		frame.add(south, BorderLayout.SOUTH);
		frame.add(west, BorderLayout.WEST);
		frame.add(east, BorderLayout.EAST);
		frame.add(center, BorderLayout.CENTER);
		frame.setVisible(true);
		
		
		
		
		
		
		
		
		
		
	}

	
	public void actionPerformed(ActionEvent e){
		
		
	}
}
