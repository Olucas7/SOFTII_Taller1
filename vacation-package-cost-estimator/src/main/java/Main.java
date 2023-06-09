
// Copyright (C) 2020
// All rights reserved
import java.util.Scanner;

public class Main {

	/**
	 * Summary of JavaDoc will be here.
	 *
	 * @author Oscar Lucas
	 * @param args Arguments
	 * 
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the destination of the vacation (Paris, New York City):");
		String destination = scanner.nextLine();

		System.out.println("Enter the number of travelers:");
		int numTravelers = scanner.nextInt();

		System.out.println("Enter the duration of the vacation in days:");
		int duration = scanner.nextInt();

		int baseCost = 1000;
		int additionalCost = 0;

		// Calculate additional cost based on destination
		if ("Paris".equalsIgnoreCase(destination)) { 
			additionalCost = 500;
		} else if ("New York City".equalsIgnoreCase(destination)) {  
			additionalCost = 600;
		}

		int totalCost = baseCost + additionalCost;

		// Apply group discount
		if (numTravelers > 4 && numTravelers < 10) {
			totalCost -= totalCost * 0.1; // 10% discount
		} else if (numTravelers > 10) {
			totalCost -= totalCost * 0.2; // 20% discount
		}

		// Apply penalty fee for duration less than 7 days
		if (duration < 7) {
			totalCost += 200;
		}

		// Apply promotion policy
		if (duration > 30 || numTravelers == 2) {
			totalCost -= 200;
		}

		// Check for group size limit
		if (numTravelers > 80) {
			System.out.println("The vacation package is not available for groups of more than 80 persons.");
			totalCost = -1;
		}

		// Add-ons selection
		System.out.println("Select optional add-ons (Y/N):");
		String addOns = scanner.next();

		int addOnsCost = 0;

		if ("Y".equalsIgnoreCase(addOns)) {  
			System.out.println("All-Inclusive Package - $200 per traveler");
			System.out.println("Adventure Activities Package - $150 per traveler");
			System.out.println("Spa and Wellness Package - $100 per traveler");

			System.out.println("Enter the number of travelers for each add-on:");
			int numAllInclusive = scanner.nextInt();
			int numAdventure = scanner.nextInt();
			int numSpa = scanner.nextInt();

			addOnsCost = (numAllInclusive * 200) + (numAdventure * 150) + (numSpa * 100);
		}

		// Calculate total cost with add-ons
		totalCost += addOnsCost;

		if (totalCost >= 0) {
			System.out.println("Total cost of the vacation package: $" + totalCost);
		} else {
			System.out.println("Invalid input data.");
		}

		scanner.close();
	}

}
