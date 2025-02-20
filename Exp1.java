import java.util.Scanner;

public class Exp1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a number: ");
		try {
			double number = scanner.nextDouble();

			if (number < 0) {
				System.out.println("Error: Cannot calculate the square root of a negative number.");
			} else {
				double squareRoot = Math.sqrt(number);
				System.out.println("The square root of " + number + " is " + squareRoot);
			}
		} catch (Exception e) {
			System.out.println("Error: Invalid input. Please enter a numeric value.");
		}

		scanner.close();
	}
}
