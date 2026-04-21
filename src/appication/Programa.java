package appication;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Programa {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			
			sc.nextLine();
			
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			
			System.out.print("Initial balance: ");
			Double inicialBalance = sc.nextDouble();
			
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			
			Account acc = new Account(number,holder,inicialBalance,withdrawLimit);
					
			System.out.println("");
			System.out.print("Enter amount for withdraw: ");
			Double amount = sc.nextDouble();
		
			acc.withdraw(amount);
			System.out.print("New balance: " + String.format("%.2f", acc.getBalance()));
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		
		sc.close();		
	}
}
