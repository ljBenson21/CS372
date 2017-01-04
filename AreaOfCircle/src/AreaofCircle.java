import java.util.Scanner;
public class AreaofCircle {
	public static void main(String[] args) 
	{
		System.out.printf("Please enter the radius for a circle that you would like "
				+ "to know the area of: ");
		Scanner input = new Scanner(System.in);
		int r = input.nextInt();
		
		final double pi = 3.14;	
		double area = pi * (r*r);
		
		System.out.printf("The area of the circle with given radius %d is %f", r, area);

	}

}
