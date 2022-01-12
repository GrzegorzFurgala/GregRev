package bankApp;

import java.util.Scanner;

public class Account extends Menu
{

    double balance = 0;
    double amount = 0;

    public void accMenu(String firstlastName)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome back "+firstlastName+"!");
        System.out.println("===============================================");
        System.out.println("Select option");
        System.out.println("===============================================");
        System.out.println("1) Check balance");
        System.out.println("2) Deposit");
        System.out.println("3) Withdraw");
        System.out.println("4) Exit app");

        int option = scanner.nextInt();

        switch (option)
        {
            case 1:
                System.out.println("--------------------------------------------");
                System.out.println("Balance: "+balance);
                System.out.println("--------------------------------------------");
                accMenu(firstlastName);
                break;
            case 2:
                System.out.println("--------------------------------------------");
                System.out.println("How much you would like to deposit?");
                System.out.println("--------------------------------------------");
                amount = scanner.nextDouble();
                deposit(amount, firstlastName);

                break;
            case 3:
                System.out.println("--------------------------------------------");
                System.out.println("How much you would like to withdraw?");
                System.out.println("--------------------------------------------");
                amount = scanner.nextDouble();
                withdraw(amount, firstlastName);
                break;
            case 4:
                System.out.println("===============================");
                System.out.println("Thank you for visiting our Bank");
                System.out.println("===============================");
                System.exit(0);
                break;

                default:
                System.out.println("Please use optios from 1 to 4");
        }
    }


    public void withdraw(double amount, String firstlastName)
    {
        if(amount > balance)
        {
            System.out.println("You dont have enough money");
            accMenu(firstlastName);
        }
        balance -= amount;
        System.out.println("You have withdrawn "+ amount);
        System.out.println("Your balance: " + balance);
        accMenu(firstlastName);
    }


    public void deposit(double amount, String firstlastName)
    {
        if(amount < 0)
        {
            System.out.println("You can not deposit 0 or less");
            accMenu(firstlastName);
        }
        balance += amount;
        System.out.println("You have deposit "+ amount);
        System.out.println("Your balance: " + balance);
        accMenu(firstlastName);

    }

	
	
	
	
	
	
}
