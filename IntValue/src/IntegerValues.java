import java.util.Scanner;
public class IntegerValues {

	public static void main(String[] args) {
		char[] values = { 'A' , 'B', 'C','a','b','c','0','1','2','5','^','+','/',' ' };
		for (char c : values)
		{
			System.out.printf("The character %c has a UniCode number of %d\n" , c, ((int) c));
		}

	}

}
