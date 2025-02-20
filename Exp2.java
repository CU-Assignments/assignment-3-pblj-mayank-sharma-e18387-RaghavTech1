import java.util.Scanner;

class ATM {
	private final String correctPin = "1234";
	private double balance = 3000;

	public void withdraw(double amount) throws Exception {
		if (amount > balance) {
			throw new Exception("Error: Insufficient balance. Current Balance: " + balance);
		} else {
			balance -= amount;
			System.out.println("Withdrawal successful. Remaining Balance: " + balance);
		}
	}

	public void checkPin(String enteredPin) throws Exception {
		if (!enteredPin.equals(correctPin)) {
			throw new Exception("Error: Invalid PIN.");
		}
	}

	public double getBalance() {
		return balance;
	}
}

public class Exp2 {
	public static void main(String[] args) {
		ATM atm = new ATM();
		Scanner scanner = new Scanner(System.in);

		try {
			// Ask for PIN
			System.out.print("Enter PIN: ");
			String enteredPin = scanner.nextLine();
			atm.checkPin(enteredPin);

			// Ask for withdrawal amount
			System.out.print("Withdraw Amount: ");
			double amount = scanner.nextDouble();
			atm.withdraw(amount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// Always show the remaining balance
			System.out.println("Current Balance: " + atm.getBalance());
		}

		scanner.close();
	}
}
