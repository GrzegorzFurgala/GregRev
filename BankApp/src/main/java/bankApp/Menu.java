package bankApp;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Menu
{
	private static final Logger logger = LogManager.getLogger(Menu.class);
    String firstlastName;
    String uName;
    String usernameL;
    int  uPassword;
    int passwordL;
    boolean access = true;

    public void konto()
     {
    		System.out.println("=========================");
    		System.out.println("Welcome to The Funny Bank");
    		System.out.println("=========================");
            System.out.println("1) Create new account");
            System.out.println("2) Log into account");
            System.out.println("3) Exit app");
            System.out.println("-------------------------");
            System.out.println("4) Bank Employee");
            System.out.println("=========================");

        int choice = -1;
            do
            {
                try
                {
                    Scanner scanner = new Scanner(System.in);
                    choice = Integer.parseInt(scanner.nextLine());

                }
                catch (NumberFormatException e)
                {
                    System.out.println("Please select only numbers");
                }
                if (choice < 1 || choice > 4)
                {
                    System.out.println("please select numbers from 1 to 4");
                }
            } while (choice < 1 || choice > 4);


            switch (choice)
            {
                case 1:

                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please provide your first name and last name");
                    firstlastName = scanner.nextLine();
                    System.out.println("Please provide your username");
                    uName = scanner.nextLine();

                    try
                    {
                        System.out.println("Please provide your password");
                        uPassword = scanner.nextInt();
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("==================================================");
                        System.out.println("The password should be numerical");
                        System.out.println("Please create your account with numerical password");
                        System.out.println("==================================================");                                                                             
                        konto();
                    }

                    LogginSys signIn = new LogginSys();              
                    signIn.signIn(firstlastName, uName, uPassword);   		
                                        
                    System.out.println("=============================================");
                    System.out.println(" You have created your first account");
                    System.out.println(" Log into your account with your credentials");
                    System.out.println("=============================================");
                    konto();
                    break;

                case 2:

                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("============================================");
                    System.out.println(" Log into your account with your credentials");
                    System.out.println("=============================================");
                    System.out.println("Please provide your username");
                    usernameL = scanner1.nextLine();
                    System.out.println("Please provide your password");
                    passwordL = scanner1.nextInt();

                    LogginSys signIn1 = new LogginSys();
                    String a = signIn1.loggIn(usernameL);  // wysylam usernameL wprowadzone przez usera zeby pobrac username z bazy i porownac 
                    int b = signIn1.loggIn1(usernameL);	   // wysylam usernameL wprowadzone przez usera zeby pobrac password z bazy i porownac 
                                       
                    String i = signIn1.username1;                   
                    int j = signIn1.password1;
                    
                    
                    for(int c = 1; c<=1; c++)
                    {
                        for(int d = 0; d < i.length(); d++)
                        {
                            if (i.charAt(d) == usernameL.charAt(d))
                            {


                            } 
                            else 
                            {
                                access = false;
                            }
                        }

                    }
					
						
                    if(access == true && j == passwordL)
                    {
                        Account acc = new Account();
                        acc.accMenu(usernameL);   
                    }
                    else
                    {
                        System.out.println("Username or password is incorrect try to log in one more time");
                        access = true;
                        konto();
                    }
                    break;
                                
                case 3:
                    System.out.println("===============================");
                    System.out.println("Thank you for visiting our Bank");
                    System.out.println("===============================");
                    logger.info("End application");
                    System.exit(0);
                    break;            
                case 4:

                                      
                    
                	Bank bank = new Bank();
                	bank.bankMenu();
                	
                	break;
                    
                    

            }
            
        }

}
