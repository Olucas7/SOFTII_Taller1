import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Vacation Package Cost Estimator System");
		
		Scanner scanner = new Scanner(System.in);
        
        // Get user input
        System.out.print("Enter destination of the vacation: ");
        String destination = scanner.nextLine();
        System.out.println("");
        
        System.out.print("Enter number of travelers: ");
        int numTravelers = scanner.nextInt();
        System.out.println("");
        
        System.out.print("Enter duration of the vacation in days: ");
        int duration = scanner.nextInt();
        System.out.println("");
        
        // Calculate total cost
        int baseCost = 1000;
        int additionalCost = 0;
        int groupDiscount = 0;
        int penaltyFee = 0;
        int promotionDiscount = 0;
        
        if (destination.equalsIgnoreCase("Paris")) {
            additionalCost = 500;
        } else if (destination.equalsIgnoreCase("New York City")) {
            additionalCost = 600;
        }
        
        if (numTravelers > 4 && numTravelers < 10) {
            groupDiscount = 10;
        } else if (numTravelers > 10) {
            groupDiscount = 20;
        }
        
        if (duration < 7) {
            penaltyFee = 200;
        }
        
        if (duration > 30 || numTravelers == 2) {
            promotionDiscount = 200;
        }
        
        int totalCost = baseCost + additionalCost - promotionDiscount - penaltyFee;
        totalCost -= (totalCost * groupDiscount) / 100;
        
        // Check if the input data is valid
        if (totalCost < 0 || numTravelers > 80) {
            totalCost = -1;
        }
        
        // Print the total cost or error message
        if (totalCost >= 0) {
            System.out.println("Total cost of the vacation package: $" + totalCost);
        } else {
            System.out.println("Invalid input data. Please check your inputs.");
        }
        
        scanner.close();
	}

}
