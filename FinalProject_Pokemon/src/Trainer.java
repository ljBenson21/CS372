

import java.util.*;

public class Trainer {
	String name;
	int pokeballs;
	int money;
	public int fullHeals = 5;
	public ArrayList<Pokemon> Team = new ArrayList<Pokemon>();
	public Trainer(){
		
	}
	
	//////////////GETTER FUNCTIONS//////////////////
	public String getName() { return name;}
	public int getBalls() { return pokeballs;}
	int getMoney() { return money;}
	
	////////////////SETTER FUNCTIONS///////////////////
	public void setName(String n) { name = n;} 
	public void setPokeballs(int b) { pokeballs = b;}
	public void setMoney(int m) { money = m;}
	
	public void addTeamMembers(Pokemon p1){
		Team.add(p1);
	}
	public Pokemon getPokemon(int index){
		return Team.get(index);
	}
	
	public Boolean defeatedTeam(){
		int count = 0;
		for (int i=0; i < Team.size(); i++){
			if ( Team.get(i).faint() == true){
				count++;
				if (count == Team.size()+1)
					return true;
				else 
					return false;
				}
		}
		return false;
	}
	
	}

