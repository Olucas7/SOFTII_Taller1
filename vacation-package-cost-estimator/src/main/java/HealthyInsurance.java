// Copyright (C) 2020
// All rights reserved
import java.util.Scanner;

/**
 * Summary of JavaDoc will be here.
 *
 * @author Oscar Lucas
 */
public class HealthyInsurance {
	
	/**
	   * Static variable that contains the base of premium.
	   */
	public static int BASE_PREMIUM = 500;

	/**
	   * Main of the application, this main will be run.
	   *
	   * @param args Arguments
	   */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    System.out.println("Type your age");
	    int age = scanner.nextInt();
	    System.out.println("Type your gender \n 0)Male \n 1)Female");
	    int res = scanner.nextInt();
	    char gender = res == 0 ? 'M' : 'F';
	    System.out.println("What is your civil state? \n 0)single \n 1)married ");
	    boolean married = scanner.nextInt() == 1;
	    Customer customer = new Customer(age, gender, married);
	    verify_business_rules(customer);
	    System.out.println(verify_business_rules(customer));

	    scanner.close();

	}
	
	/**
	   * Static function which verify the rules of the business.
	   *
	   * @param customer Receive a Customer object to verify if the customer complies with the rules.
	   * @return An integer with the amount of premium or -1 in error.
	   */
	public static int verify_business_rules(Customer customer) {
	    int premiumPlan = 500;
	    if (validatePolitics(customer)) {

	      if (!customer.isMarried() && customer.isMale() && customer.ageLessThan(25)) {
	        premiumPan += 1500;
	      } else if (!customer.isMale() || customer.isMarried()) {
	        premiumPan -= 200;
	      } else if (customer.ageMoreThan(45) && customer.ageLessThan(65)) {
	        premiumPan -= 100;
	      }
	      return premiumPan;
	    } else {
	      return -1;
	    }
	  }
	
	  /**
	   * Static function to validate if the Customer given as parameter complies with
	   * the Politics of the company.
	   *
	   * @param customer The Customer object which will be validated.
	   * @return True if it's OK, or false if the customer don't complies with the
	   *         rules of the company.
	   */
	public static boolean validatePolitics(Customer customer) {
	    return customer.ageLessThan(80);
	  }

}
