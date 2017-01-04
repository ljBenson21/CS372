import java.util.Scanner;
public class BodyMassIndex {

	public static void main(String[] args) {
		System.out.printf("Please enter your weight (in lbs): ");
		Scanner input1 = new Scanner(System.in), input2 = new Scanner(System.in);
		int weight = input1.nextInt();
		System.out.printf("Now enter your height (in inches): ");
		int height = input2.nextInt();
		
		double BMI = (weight * 703)/(height * height);
		
		System.out.printf("Your BMI or body mass index is %f.\n\n", BMI);
		
		System.out.printf("BMI values:\nUnderweight: less that 18.5\n"
				+ "Normal: between 18.6 and 24.9\nOverweight: between 25 and 29.9\n"
				+ "Obese: 30 or more\n\n");
		

	}

}
