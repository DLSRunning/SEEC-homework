import java.util.Scanner;

public class CurrencyCalculation {

	public static void main(String[] args) {
		float euros = 0.00f;
		float rate = 0.00f;
		System.out.println("How many euros are you exchanging?");
		Scanner scan = new Scanner(System.in);
		if(scan.hasNextFloat()) {
			euros = scan.nextFloat();
		}

		System.out.println("What is the exchange rate?");

		if(scan.hasNextFloat()) {
			rate = scan.nextFloat();
		}

		float dollars = euros * rate / 100;
		System.out.println(String.format("%.2f",euros) + " euros at an exchange rate of " + String.format("%.2f",rate) + " is " + String.format("%.2f",dollars) + " U.S. dollars.");
		scan.close();
	}
}
