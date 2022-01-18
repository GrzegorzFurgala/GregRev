package bankApp;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Account extends Menu
{
	private static final Logger logger = LogManager.getLogger(Account.class);
	int accountNumber = 0;
    double amount = 0;    

    public void accMenu(String usernameL)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome back "+usernameL+"!");
        System.out.println("===============================================");
        System.out.println("Select option");
        System.out.println("===============================================");
        System.out.println("1) Check balance");
        System.out.println("2) Deposit");
        System.out.println("3) Withdraw");
        System.out.println("4) Transfer");
        System.out.println("5) Main menu");
        System.out.println("6) Exit app");

        int option = scanner.nextInt();

        switch (option)
        {
            case 1:
                System.out.println("--------------------------------------------");              
                LogginSys balance = new LogginSys();
                balance.accBalance(usernameL);                                      //funkcja sprawdzania balance z klasy LogginSys             
                System.out.println("--------------------------------------------");
                logger.info("Account balance - checking");               
                accMenu(usernameL);
                break;
            case 2:
                System.out.println("--------------------------------------------");
                System.out.println("How much you would like to deposit?");
                System.out.println("--------------------------------------------");
                              
                amount = scanner.nextDouble();
                if(amount <= 0)
                {
                    System.out.println("You can not deposit 0 or less");
                    accMenu(usernameL);
                }     
                               
                LogginSys deposit = new LogginSys();              
                deposit.accBalance(usernameL);				//metoda accBalance wyciagamy aktualny stan konta i przypisujemy do zmiennej currentBalance               
                double currentBalance = deposit.balance;                               
                currentBalance  += amount;					// obliczamy nowy balanc dodajac kwote od uzytkownika amount                               
                deposit.deposit(usernameL, currentBalance);   		//metoda deposit dodaje pieniadze do balance w bazie danych               
                logger.info("Deposit: added "+amount+" to the balance");
                accMenu(usernameL);					  		//powrot do menu kunta	                                    
                break;
            case 3:
                System.out.println("--------------------------------------------");
                System.out.println("How much you would like to withdraw?");
                System.out.println("--------------------------------------------");
                amount = scanner.nextDouble();                                                    
                LogginSys withdrawal = new LogginSys();
                withdrawal.accBalance(usernameL);
                double currentBalance1 = withdrawal.balance;
                
                if(amount > currentBalance1)
                {
                	System.out.println("------------------------------");
                	System.out.println("You dont have enough money");
                    System.out.println("You current balance is: "+currentBalance1);
                    System.out.println("Try one more time");
                    System.out.println("------------------------------");
                    accMenu(usernameL);
                }
                                              
                currentBalance1 -= amount;
                withdrawal.withdrawal(usernameL, currentBalance1);               
                logger.info("Withdrawal: "+amount);
                accMenu(usernameL);
                break;
                  
            case 4:
                System.out.println("-------------------------------");
                System.out.println("Enter enter the transfer amount");
                System.out.println("--------------------------------");
                amount = scanner.nextDouble();
                System.out.println("-------------------------------");
                System.out.println("Enter account number ");
                System.out.println("--------------------------------");
                accountNumber = scanner.nextInt();
                                          
               
                LogginSys withdrawal1 = new LogginSys();
                withdrawal1.accBalance(usernameL);
                double currentBalance2 = withdrawal1.balance;
                
                System.out.println(currentBalance2);
                
                if(amount > currentBalance2)
                {
                	System.out.println("------------------------------");
                	System.out.println("You dont have enough money");
                    System.out.println("You current balance is: "+currentBalance2);
                    System.out.println("Try one more time");
                    System.out.println("------------------------------");
                    accMenu(usernameL);
                }
                
                currentBalance2 -= amount;
                withdrawal1.withdrawal(usernameL, currentBalance2);
                
                withdrawal1.transfer(accountNumber, amount);
                
                logger.info("Transfer. Amount: "+amount+" for account number: "+accountNumber);
                accMenu(usernameL);
                break;

            case 5:
            	Menu menu = new Menu();            	
            	menu.konto();
                break;
                       
            case 6:
                System.out.println("===============================");
                System.out.println("Thank you for visiting our Bank");
                System.out.println("===============================");
                logger.info("End application");
                System.exit(0);
                break;

            	default:
                System.out.println("Please select one option from 1 or 6");
                                       
                              
        }
    }


   		
}
