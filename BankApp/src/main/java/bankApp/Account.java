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
        
    	try
    	{
	    	LogginSys log = new LogginSys();
	        
	        log.accountNumber(usernameL);
	         	        
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.println();
	        System.out.println("Welcome back "+usernameL+"! Account number: "+log.id);
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
	                balance.accBalance(usernameL);                                                 
	                System.out.println("--------------------------------------------");
	                
	                System.out.println("Press Enter key to continue...");
	                Scanner s1 = new Scanner(System.in);
	                s1.nextLine();	
	                             
	                
	                logger.info("Username: "+usernameL+", checking account balance");               
	                accMenu(usernameL);
	                break;
	            case 2:
	                System.out.println("--------------------------------------------");
	                System.out.println("How much you would like to deposit?");
	                System.out.println("--------------------------------------------");
	                              
	                amount = scanner.nextDouble();
	
	                
	                if(amount <= 0)
	                {                 
	            	 	System.out.println("---------------------------------");
	                    System.out.println(">>You can not deposit 0 or less<<");	                       
	                    System.out.println(">>Please try one more time<<");
	                    System.out.println("---------------------------------");             
	                    System.out.println("Press Enter key to continue...");
		                Scanner s2 = new Scanner(System.in);
		                s2.nextLine();	
	                    accMenu(usernameL);
	                }     
	                               
	                LogginSys deposit = new LogginSys();                                          
	                deposit.deposit(usernameL, amount);   		            
	                logger.info("Username: "+usernameL+", deposit: added "+amount+" to the balance");
	                accMenu(usernameL);					  		                                    
	                break;
	            case 3:
	                System.out.println("--------------------------------------------");
	                System.out.println("How much you would like to withdraw?");
	                System.out.println("--------------------------------------------");
	                amount = scanner.nextDouble();                                                    
	                LogginSys withdrawal = new LogginSys();
	                withdrawal.accBalance(usernameL);
	                double currentBalance = withdrawal.balance;
	                
	                if(amount > currentBalance)
	                {
	                	System.out.println();
	                	System.out.println("----------------------------------------------");
	                	System.out.println(">>You dont have enough money>>");
	                    System.out.println(">>You current balance is: "+currentBalance+"<<");
	                    System.out.println(">>Try one more time<<");
	                    System.out.println("----------------------------------------------");
	                    System.out.println("Press Enter key to continue...");
		                Scanner s2 = new Scanner(System.in);
		                s2.nextLine();		                    
	                    accMenu(usernameL);
	                }
	                                              
	                withdrawal.withdrawal(usernameL, amount);               
	                logger.info("Username: "+usernameL+", withdrawal: "+amount);
	                accMenu(usernameL);
	                break;
	                  
	            case 4:
	                System.out.println("--------------------------------------------------");
	                System.out.println("Enter the transfer amount for transfer");
	                System.out.println("--------------------------------------------------");
	                amount = scanner.nextDouble();
	                System.out.println("--------------------------------------------------");
	                System.out.println("Enter the account number to which it will be sent ");
	                System.out.println("--------------------------------------------------");
	                accountNumber = scanner.nextInt();
	                                          
	               
	                LogginSys withdrawal1 = new LogginSys();
	                withdrawal1.accBalance(usernameL);
	                double currentBalance2 = withdrawal1.balance;
	                
	                System.out.println(currentBalance2);
	                
	                if(amount > currentBalance2)
	                {
	                	System.out.println();
	                	System.out.println("----------------------------------------------");
	                	System.out.println(">>You dont have enough money>>");
	                    System.out.println(">>You current balance is: "+currentBalance2+"<<");
	                    System.out.println(">>Try one more time<<");
	                    System.out.println("----------------------------------------------");
	                    System.out.println("Press Enter key to continue...");
		                Scanner s2 = new Scanner(System.in);
		                s2.nextLine();	                    
	                    accMenu(usernameL);
	                }
	                
	                withdrawal1.withdrawal(usernameL, amount);              
	                withdrawal1.transfer(accountNumber, amount);            
	                logger.info("Username: "+usernameL+", transfer: "+amount+" for account number: "+accountNumber);
	                
	                System.out.println();
                	System.out.println("----------------------------------------------");
                	System.out.println(">>The transfer of "+amount+" was successful >>");                   
                    System.out.println("----------------------------------------------");
                    System.out.println("Press Enter key to continue...");
	                Scanner s2 = new Scanner(System.in);
	                s2.nextLine();	      
	                	                
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
	                
	            	System.out.println("----------------------------------------");
	                System.out.println(">>Please select one option from 1 or 6<<");
	                System.out.println("----------------------------------------");	
	            		
	                accMenu(usernameL);                       
	                              
	        }
                    
	    }
	    catch(Exception e)
	    {
	    	System.out.println();
	    	System.out.println("--------------------------------");
	        System.out.println(">>The Entry should be numeric<<");
	        System.out.println("--------------------------------");		        
	        System.out.println("Press Enter key to continue...");
	        Scanner s2 = new Scanner(System.in);
            s2.nextLine();	
            accMenu(usernameL);
	    }
      	
    }

}
