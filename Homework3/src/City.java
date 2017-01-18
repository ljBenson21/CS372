/**
*This class is the model for the very small Town of Lazy Town
*@author LJ Benson
*@version 1.00, 06 January 2017
*/



import java.util.ArrayList;

public class City {

	public static void main(String[] args) {
		
		ArrayList<Person> LazyTown = new ArrayList<Person>();
		ArrayList<Building> LazyBuild = new ArrayList<Building>();
		
		
		Building b1 = new CityHall("Lazy Hall", "5864 N. Main Street");
		Building b2 = new School("Lazy School", "153 W. Lansing Avenue");
		Person p1 = new Police(Police.policeRole.Sargent,"Bob", 34, "456-789-5134");
		Person p2 = new Police(Police.policeRole.Patrol, "Shelly" , 25, "456-568-5589");
		Person p3 = new Police(Police.policeRole.Chief, "Wilt", 51, "456-221-2656");
		Person p4 = new Police(Police.policeRole.Captain,"Connor", 29, "858-256-3636");
		Person p5 = new Child("Reese's","Brucie", 10, "456-996-4525");
		Person p6 = new Child("Skittles","Trina", 13, "456-226-5478");
		Person p7 = new Child("Laffy Taffy","Maurice", 12, "456-231-4598");
		Person p8 = new Teacher(12, "General Education","Melina", 26, "456-555-6987");
		
		((School)b2).addPeople(p5);
		((School)b2).addPeople(p6);
		((School)b2).addPeople(p7);
		((School)b2).addPeople(p8);
		((CityHall)b1).addPeople(p1);
		((CityHall)b1).addPeople(p2);
		((CityHall)b1).addPeople(p3);
		((CityHall)b1).addPeople(p4);
		
		LazyBuild.add(b1);
		LazyBuild.add(b2);
		LazyTown.add(p1);
		LazyTown.add(p2);
		LazyTown.add(p3);
		LazyTown.add(p4);
		LazyTown.add(p5);
		LazyTown.add(p6);
		LazyTown.add(p7);
		LazyTown.add(p8);
		
		
		
		for (Person f: LazyTown)
		{
			System.out.printf(f.toString());
		}
		System.out.printf("\n");
		for (Building b: LazyBuild){
			System.out.printf(b.toString());
		}
		System.out.printf("\n");
		
		((School)b2).printStudents();
		System.out.printf("\n");
		
		((School)b2).printTeach();
		System.out.printf("\n");
		
		((CityHall)b1).printOfficers();
		System.out.printf("\n");
		
		
		((Teacher)p8).Pay();
		((Police)p1).Pay();
		((Police)p2).Pay();
		((Police)p3).Pay();
		((Police)p4).Pay();
		
		System.out.printf("\n");
		
		Window w = new Window(LazyTown, LazyBuild);
		
	}

}
