import java.util.Scanner;

public class OddOrEven {
	public static void main (String[] args)
	{
		System.out.printf("Please enter an integer: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		if (n%2 == 0)
		{
			System.out.printf("The number %d is an even number.\n\n", n);
		}
		else 
		{
			System.out.printf("The number %d is an odd number.\n\n", n);
		}
		input.close();
	}
}
