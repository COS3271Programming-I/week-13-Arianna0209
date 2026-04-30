package week131;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BikeRideSimulatorAPP {
	
	static Scanner userinput = new Scanner(System.in);
	
	// Method for making sure the user can only enter the three options for change:
	static String selectChange(String prompt) {
		System.out.print(prompt);
		while (true) {
			String answer = userinput.nextLine();
			answer = answer.toLowerCase();
			if (answer.equals("g") || answer.equals("s") || answer.equals("c")) {
				return answer;
			}
			else {
				System.out.println("Invalid input. Please enter \"g\", \"s\", or \"c\"");
				continue;
			}
		}
	}
	
	// Method for making sure the user can only enter the three options for change:
	static String yesOrNo(String message) {
		String response;
		while (true) {
			System.out.print(message);
			response = userinput.nextLine();
			response = response.toLowerCase();
			if (response.equals("yes") || response.equals("no")) {
				return response;
			}
			else {
				System.out.println("Please enter \"yes\" or \"no\".");
				continue;
			}
			
		}
	}
	
	// Method for trapping InputMismatchException error on integers:
	static int intTry(String message) {
		int response;
		while (true) {
			try {
				System.out.print(message);
				response = userinput.nextInt();
				userinput.nextLine();
				return response;
			} 
			catch (InputMismatchException e) {
				System.out.println("Please enter a valid integer number (no decimal point).\n");
				userinput.nextLine();
				continue;
			}
		}
	}
	
	public static void main(String[] args) {
		// Introduce the user to the program.
		System.out.println("Welcome to the bike ride simulator."
				+ "\nEnter information about your bike below::");
	
		
		// Have the user enter information about their bike:
		System.out.print("\nOwner: ");
		String owner = userinput.nextLine();
		
		System.out.print("Type: ");
		String type = userinput.nextLine();
		
		int gear = intTry("Current gear: ");
		
		int speed = intTry("Current speed: ");
		
		int cadence = intTry("Current cadence: ");
		
		
		// Make a new bike:
		Bicycle bike1 = new Bicycle(cadence, speed, gear, type, owner);
		
		// Show the user their bike details:
		System.out.println("\n" + bike1.getInfo());
		
		
		// Have the user change information about their bike:
		String again = "yes";
		while (again.equals("yes")) {
		
			// Have the user select gear, speed, or cadence to change:
			String choice = selectChange("\nEnter \"g\", \"s\", or \"c\" to adjust the gear, "
				+ "\nspeed, or cadence, respectively: ");
			
			// Allow the user to change what they chose:
			if (choice.equals("g")) {
				int newValue = intTry("\nEnter what you would like to change the gear to."
						+ "\nEnter whole numbers only: ");
				bike1.setGear(newValue);
			}
			else if (choice.equals("s")) {
				int newValue = intTry("\nEnter what you would like to change the speed to."
						+ "\nEnter whole numbers only: ");
				bike1.setSpeed(newValue);
			}
			else if (choice.equals("c")) {
				int newValue = intTry("\nEnter what you would like to change the cadence to."
						+ "\nEnter whole numbers only: ");
				bike1.setCadence(newValue);
			}
			
			// Show the user the bike ride's new status:
			System.out.println("\n" + bike1.getInfo());
			
			// Ask the user if they would like to change anything else:
			again = yesOrNo("\nWould you like to change anything else about your bike's status? ");
		}
		
		// If the user is done:
		System.out.println("\nThank you for using the bike ride simulator!"
				+ "\nYou have reached your destination.");
		
		// Reset the info:
		bike1.setGear(1);
		bike1.setSpeed(0);
		bike1.setCadence(0);
		
		// Show the user the bike ride's final status:
		System.out.println("\n" + bike1.getInfo());
		
		// Tell the user the program ended:
		System.out.println("\nProgram ended.");
	}

}