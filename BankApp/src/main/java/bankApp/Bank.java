package bankApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bank extends BankDao
{
	private static final Logger logger = LogManager.getLogger(Bank.class);
	double amount;
	
	String adminUsername;
	int adminPassword;
	boolean access = true;
	
    public void bankMenu()
    {
        
        System.out.println("Welcome to Bank Management Sysytem!");
        System.out.println("===============================================");
        System.out.println("Select option");
        System.out.println("===============================================");
        System.out.println("1) Bank Admins");
        System.out.println("2) Bank Employees");
        System.out.println("3) Bank main menu");
        System.out.println("4) Exit app");
         
        int choice = -1;
        do
        {	 
        	try
        	{
        		 Scanner scanner = new Scanner(System.in);
	        	 choice = Integer.parseInt(scanner.nextLine());
        	}
        	 catch(NumberFormatException e)
        	{
        		 System.out.println("------------------------------");
        		 System.out.println(">>Please select only numbers<<");
        		 System.out.println("------------------------------");
        	}
        	
	       	if (choice < 1 || choice > 4)
	        {
	       		System.out.println("-------------------------------------"); 
	       		System.out.println(">>Please select numbers from 1 to 4<<");
	       		System.out.println("-------------------------------------"); 
	        }   	
        } while (choice < 1 || choice > 4);	
        	
  	         	
        	switch (choice)
	        {
	            case 1:
	                 
                    try
                    {
		            	Scanner scanner1 = new Scanner(System.in);
	                    System.out.println("============================================");
	                    System.out.println(" Log into your account with your credentials");
	                    System.out.println("=============================================");
	                    System.out.println("Please provide your username");
	                    adminUsername = scanner1.nextLine();
	                    System.out.println("Please provide your password");
	                    adminPassword = scanner1.nextInt();	
		            	
	                    adminUsername(adminUsername);                 
	                    adminPassword(adminUsername);
                  
	                    for(int c = 1; c<=1; c++)
	                    {
	                        for(int d = 0; d < adminUsername.length(); d++)
	                        {
	                            if (adminUsername.charAt(d) == emp_username.charAt(d))
	                            {

	                            } 
	                            else 
	                            {
	                            	access = false;
	                            }
	                        }
	                    }
	                             
	                    
	                    if(access != true || adminPassword != emp_password)
	                    {
	                    	System.out.println();
	                    	System.out.println();
	                    	System.out.println("-----------------------------------------------------------------");
	                    	System.out.println(">>Username or password is incorrect try to log in one more time<<");
	                    	System.out.println("-----------------------------------------------------------------");
	                    	System.out.println("Press Enter key to continue...");
	    	                Scanner s1 = new Scanner(System.in);
	    	                s1.nextLine();	
	                        
	                        access = true;
	                        bankMenu();
	                    }
               
                    }
                    catch(NullPointerException e)
                    {	System.out.println();
                    	System.out.println();
                    	System.out.println("-----------------------------------------------------------------");
                    	System.out.println(">>Username or password is incorrect try to log in one more time<<");
                    	System.out.println("-----------------------------------------------------------------");
                    	System.out.println("Press Enter key to continue...");
    	                Scanner s1 = new Scanner(System.in);
    	                s1.nextLine();	
                    	bankMenu();
                    }
                    catch(StringIndexOutOfBoundsException e)
                    {	System.out.println();
                    	System.out.println();
                    	System.out.println("-----------------------------------------------------------------");
                    	System.out.println(">>Username or password is incorrect try to log in one more time<<");
                    	System.out.println("-----------------------------------------------------------------");
                    	System.out.println("Press Enter key to continue...");
    	                Scanner s1 = new Scanner(System.in);
    	                s1.nextLine();	
                    	bankMenu();
                    }
                    catch(InputMismatchException e)                  
                    {	System.out.println();
                    	System.out.println();
                    	System.out.println("------------------------------------------------------");
                    	System.out.println(">>The password should be nummeric, try one more time<<");
                    	System.out.println("------------------------------------------------------");
                    	System.out.println("Press Enter key to continue...");
    	                Scanner s1 = new Scanner(System.in);
    	                s1.nextLine();	
                    	bankMenu();
                    }                   
                    adminMenu();        
            	            
	            case 2:
	                
	            	try
                    {
		            	Scanner scanner1 = new Scanner(System.in);
	                    System.out.println("============================================");
	                    System.out.println(" Log into your account with your credentials");
	                    System.out.println("=============================================");
	                    System.out.println("Please provide your username");
	                    adminUsername = scanner1.nextLine();
	                    System.out.println("Please provide your password");
	                    adminPassword = scanner1.nextInt();	
		            	
	                    employeeUsername(adminUsername);                 
	                    employeePassword(adminUsername);
             
	                    for(int c = 1; c<=1; c++)
	                    {
	                        for(int d = 0; d < adminUsername.length(); d++)
	                        {
	                            if (adminUsername.charAt(d) == emp_username.charAt(d))
	                            {	                            			                            	
	                            } 
	                            else 
	                            {	                            	
	                            	access = false;
	                            }
	                        }
	                    }
	                             
	                    
	                    if(access != true || adminPassword != emp_password)
	                    {
	                    	System.out.println();
	                    	System.out.println();
	                    	System.out.println("-----------------------------------------------------------------");
	                    	System.out.println(">>Username or password is incorrect try to log in one more time<<");
	                    	System.out.println("-----------------------------------------------------------------");
	                    	System.out.println("Press Enter key to continue...");
	    	                Scanner s1 = new Scanner(System.in);
	    	                s1.nextLine();	
	                    	
	                    	access = true;
	                        bankMenu();
	                    }
               
                    }
                    catch(NullPointerException e)
                    {	System.out.println();
                    	System.out.println();
                    	System.out.println("-----------------------------------------------------------------");
                    	System.out.println(">>Username or password is incorrect try to log in one more time<<");
                    	System.out.println("-----------------------------------------------------------------");
                    	System.out.println("Press Enter key to continue...");
    	                Scanner s1 = new Scanner(System.in);
    	                s1.nextLine();	
                    	bankMenu();
                    }
                    catch(StringIndexOutOfBoundsException e)
                    {	System.out.println();
                    	System.out.println();
                    	System.out.println("-----------------------------------------------------------------");
                    	System.out.println(">>Username or password is incorrect try to log in one more time<<");
                    	System.out.println("-----------------------------------------------------------------");
                    	System.out.println("Press Enter key to continue...");
    	                Scanner s1 = new Scanner(System.in);
    	                s1.nextLine();	
                    	bankMenu();
                    }
                    catch(InputMismatchException e)                  
                    {	System.out.println();
                    	System.out.println();
                    	System.out.println("------------------------------------------------------");
                    	System.out.println(">>The password should be nummeric, try one more time<<");
                    	System.out.println("------------------------------------------------------");
                    	System.out.println("Press Enter key to continue...");
    	                Scanner s1 = new Scanner(System.in);
    	                s1.nextLine();	
                    	bankMenu();
                    }	            	       	
	            	 	                              	                	              	                
	            	employeeMenu();
	                break;	                
	            case 3:
	                
	            	Menu menu = new Menu();            	
	            	menu.konto();            	          	
	            	System.out.println("-------------------------------------------------------");
	                System.out.println("You have been looged out from Bank Management Sysytem ");
	                System.out.println("-------------------------------------------------------");                                      				  		            
	                break;
	                
	            case 4:
	                System.out.println("================================");
	                System.out.println("You have left the Funny Bank App");
	                System.out.println("================================");
	                logger.info("End application");
	                System.exit(0);
	                break;
	           
	            default:	                             
                   	System.out.println();
                   	System.out.println("------------------------------------");
                   	System.out.println(">>please select option from 1 to 4<<");
                   	System.out.println("------------------------------------");
                   	System.out.println();
           
	       }
        }   
   
    
    //----------------------ADMIN-----MENU------------------------------//
    
    public void adminMenu()
	{
	    
    	try
    	{
    	System.out.println();
    	System.out.println("Welcome to Admin Account: "+emp_username); 
	    System.out.println("--------------------------------------------");              
	    System.out.println("1) View All Accounts");
	    System.out.println("2) View Individual Account");
	    System.out.println("3) Delete Account");
	    System.out.println("4) Deposit");
	    System.out.println("5) Withdraw");
	    System.out.println("6) Transfer");
	    System.out.println("7) Edit Account");
	    System.out.println("8) Log out from Admin Account");
	    System.out.println("--------------------------------------------");
	   	                
	   int option = -1;
	   do
	   {	 
	   	try
	   	{
	   		 Scanner scanner = new Scanner(System.in);
	       	 option = Integer.parseInt(scanner.nextLine());
	   	}
	   	 catch(NumberFormatException e)
	   	{
	   		 System.out.println("Please select only numbers");
	   	}
	   	
	      	if (option < 1 || option > 8)
	       {
	            System.out.println("please select numbers from 1 to 8");
	       }   	
	   } while (option < 1 || option > 8);	
	   
	   
	   switch (option)
	   {
	   	case 1:
	   		allAccounts();
	   		System.out.println("Press Enter key to continue...");
            Scanner s1 = new Scanner(System.in);
            s1.nextLine();	
	   		logger.info("Bank Admin: all accounts report");	   			
	   		adminMenu();
	   	break;
	
	   	case 2:
	   		System.out.println("Enter account number");
	   		
	   		Scanner scanner = new Scanner(System.in);
	       	int id_account = Integer.parseInt(scanner.nextLine());
	       	 
	       	individualAccount(id_account);
	       	System.out.println("Press Enter key to continue...");
            Scanner s2 = new Scanner(System.in);
            s2.nextLine();	
	       	 
	       	 
	       	logger.info("Bank Admin: individual accounts report for "+id_account);
	       	adminMenu();
	   	break;
	   	
	     	case 3:
	   		System.out.println("Enter account number to be DELETED");
	   		
	   		 Scanner sc = new Scanner(System.in);
	       	 id_account = Integer.parseInt(sc.nextLine());
	       	 
	       	 deleteAccount(id_account);
	       	 
	       	 	System.out.println();
	            System.out.println("-----------------------------------------------");
	       	 	System.out.println("Account number: "+id_account+" has been deleted");	        	        	
	            System.out.println("-----------------------------------------------");
		       	System.out.println("Press Enter key to continue...");
	            Scanner s3 = new Scanner(System.in);
	            s3.nextLine();	
	            
	            logger.info("Bank Admin: deletion of account: "+id_account);
	            adminMenu();
	   	break;
	     	case 4:
	     	   System.out.println();
	           System.out.println("--------------------------------------------");
	           System.out.println("How much you would like to deposit?");
	           System.out.println("--------------------------------------------");
	           System.out.println();
	              
	           Scanner sc1 = new Scanner(System.in);
	           
	           amount = sc1.nextDouble();
	           if(amount <= 0)
	           {
	           	System.out.println();
	           	System.out.println("---------------------------------");
	           	System.out.println(">>You can NOT deposit 0 or less<<");
	           	System.out.println("---------------------------------");
		        
	           	System.out.println("Press Enter key to continue...");
		        Scanner s4 = new Scanner(System.in);
		        s4.nextLine();
	           	adminMenu();
	           }     
	                   
	           System.out.println("--------------------------------------------");
	           System.out.println("Enter account number");
	           System.out.println("--------------------------------------------");   
	           id_account = sc1.nextInt();				              	           
	           deposit(id_account,amount );

	           
	           logger.info("Bank Admin: deposit "+amount+" for account "+id_account);
	           adminMenu();
	   	break;
	   	
	     	case 5:
	   	
	           System.out.println("--------------------------------------------");
	           System.out.println("How much you would like to withdraw?");
	           System.out.println("--------------------------------------------");	                        
	           Scanner sc2 = new Scanner(System.in);	                        
	           amount = sc2.nextDouble();   
	           
	           System.out.println("--------------------------------------------");
	           System.out.println("Account number?");
	           System.out.println("--------------------------------------------");	           	                                        	                      
	           id_account = sc2.nextInt(); 	                      	                        
	           
	           BankDao bankDao = new BankDao();	 
	           double x = bankDao.accBalance(id_account);
	           
	           if(amount > x)
	           {
               	System.out.println();
               	System.out.println("----------------------------------------------");
               	System.out.println(">>You dont have enough money>>");
                System.out.println(">>You current balance is: "+x+"<<");
                System.out.println(">>Try one more time<<");
                System.out.println("----------------------------------------------");
                System.out.println("Press Enter key to continue...");
                Scanner s5 = new Scanner(System.in);
                s5.nextLine();
                adminMenu();
	           }	   
	                     	           
	           withdrawal(id_account, amount);	                                         	                                     
	           adminMenu();
	           logger.info("Bank Admin: withdrawal "+amount+" from account "+id_account);
	           break;
	   	
	     	case 6:   
	     			                  
	           System.out.println("--------------------------------------------");
	           System.out.println("From which account number?");
	           System.out.println("--------------------------------------------");
	           Scanner sc3 = new Scanner(System.in);	           
	           id_account = sc3.nextInt(); 
	     			                  	            		
	           System.out.println("--------------------------------------------");
	           System.out.println("How much you would like to withdraw?");
	           System.out.println("--------------------------------------------");	                        	          	                        
	           amount = sc3.nextDouble();   
	           	                      	      
	           BankDao bankDao1 = new BankDao();	 
	           double x1 = bankDao1.accBalance(id_account);
	           	           
	           
	           if(amount > x1)
	           {
               	System.out.println();
               	System.out.println("----------------------------------------------");
               	System.out.println(">>You dont have enough money>>");
                System.out.println(">>You current balance is: "+x1+"<<");
                System.out.println(">>Try one more time<<");
                System.out.println("----------------------------------------------");
                System.out.println("Press Enter key to continue...");
                Scanner s5 = new Scanner(System.in);
                s5.nextLine();
                adminMenu();
	           }
	           
	           	           	           	           
	           System.out.println("----------------------------------------------------");
	           System.out.println("Enter the account number to which transfer the money");
	           System.out.println("----------------------------------------------------");	           
	           int id_account2 = sc3.nextInt(); 
	           	                        	                        
	           withdrawal(id_account,amount);
	           deposit(id_account2,amount);
	           
	           logger.info("Bank Admin: transfer "+amount+" from account "+id_account+" into "+ id_account2);
	           adminMenu();
	           break;	
	     		
	     	case 7:  	
	     			     		
	        System.out.println("--------------------------------------------");              
	           System.out.println("1) Change Full Name");
	           System.out.println("2) Change Username");
	           System.out.println("3) Change Password");
	           System.out.println("4) Change Balance");
	           System.out.println("5) Admin Menu");
	           System.out.println("6) Back to Main Menu");	   	                
	           System.out.println("--------------------------------------------");
	          	          
	          int selection = -1;
	          do
	          {	 
	          	try
	          	{
	          		 Scanner sc4 = new Scanner(System.in);
	          		selection = Integer.parseInt(sc4.nextLine());
	          	}
	          	 catch(NumberFormatException e)
	          	{
	          		 System.out.println("Please select only numbers");
	          	}
	          	
	  	       	if (selection < 1 || selection > 7)
	  	        {
	  	             System.out.println("please select numbers from 1 to 6");
	  	        }   	
	          } while (selection < 1 || selection > 7);	
	     			                  		
	             	switch (selection)	
	             	{
	           	case 1:
	           		 
	           		 System.out.println("Enter account number");	                		
	           		 Scanner sc5 = new Scanner(System.in);
	   	        	 id_account = Integer.parseInt(sc5.nextLine());
	   	        	 
	           		 System.out.println("Enter NEW first and last name");	                		
	           		 Scanner sc6 = new Scanner(System.in);
	   	        	 String newFullname = sc6.nextLine();
	   	        	         	        	 
	   	        	 uFullName(id_account, newFullname); 
	   	        	 
	   	        	 logger.info("Bank Admin: update, new firstname and last name "+newFullname+" for account "+id_account);
	   	        	 adminMenu();
	           	break;
	     	
	           	case 2:	
	     	
	            	 System.out.println("Enter account number");	                		
	           		 Scanner sc7 = new Scanner(System.in);
	   	        	 id_account = Integer.parseInt(sc7.nextLine());
	   	        	 
	           		 System.out.println("Enter NEW username");	                		
	           		 Scanner sc8 = new Scanner(System.in);
	   	        	 String newUsername = sc8.nextLine();
	   	        	         	        	 
	   	        	 uUsername(id_account, newUsername);
	   	        	 logger.info("Bank Admin: update, new username "+newUsername+" for account "+id_account);
	   	        	 adminMenu();			        	   			        	        	 
	           	break;
	           		
	             	case 3:	
	                 	
	            	 System.out.println("Enter account number");	                		
	           		 Scanner sc9 = new Scanner(System.in);
	   	        	 id_account = Integer.parseInt(sc9.nextLine());
	   	        	 
	           		 System.out.println("Enter NEW password");	                		
	           		 Scanner sc10 = new Scanner(System.in);
	   	        	 int newPassword = Integer.parseInt(sc10.nextLine());
	   	        	         	        	 
	   	        	 uPassword(id_account, newPassword);
	   	        	 logger.info("Bank Admin: update, new password "+newPassword+" for account "+id_account);
	   	        	 adminMenu();			        	   			        	        	 
	           	break;
	           	
	             	case 4:	
	                 	
	             	 System.out.println("Enter account number");	                		
	           		 Scanner sc11 = new Scanner(System.in);
	   	        	 id_account = Integer.parseInt(sc11.nextLine());
	   	        	 
	           		 System.out.println("Change account balance to: ");	                		
	           		 Scanner sc12 = new Scanner(System.in);
	   	        	 double newBalance = Integer.parseInt(sc12.nextLine());
	   	        	         	        	 
	   	        	 uBalance(id_account, newBalance);
	   	        	 logger.info("Bank Admin: update, new balance "+newBalance+" for account "+id_account);       	        	 	        	        	 
	   	        	 adminMenu();			        	   			        	        	 
	           	break;
	           		
	             	case 5:					                  	   	        	 	        	        	 
	             		adminMenu();			        	   			        	        	 
	           	break;	
	           		
	             	case 6:					                  	   	        	 	        	        	 
	             		Menu menu = new Menu();
	             		menu.konto();			        	   			        	        	 
	           	break;		
	           	
	             	case 7:					                  	   	        	 	        	        	 
		                System.out.println("================================");
		                System.out.println("You have left the Funny Bank App");
		                System.out.println("================================");
		                logger.info("End application");
		                System.exit(0);		    	               		        	   			        	        	 
	           	break;			                	
	   			                  	
	             	default:
	             		System.out.println();
	             		System.out.println("----------------------------------------");
	 	                System.out.println(">>Please select one option from 1 to 7<<");
	 	                System.out.println("----------------------------------------");
	 	                System.out.println();
	             	}  
	             			                  	
	     	case 8:        				                  		                  		
	     		bankMenu();	    	               		        	   			        	        	 
	   	break;			                	
			                  	
	     	default:
	     		System.out.println();
	     		System.out.println("----------------------------------------");
	             System.out.println(">>Please select one option from 1 to 7<<");
	             System.out.println("----------------------------------------");
	             System.out.println();
		                  				                  	                  		                  			
	   }   
    	}
    	catch(NumberFormatException e)
    	{
        	
    		System.out.println("----------------------------------------");
            System.out.println(">>The entry should be numeric<<");        
            System.out.println("----------------------------------------");    		
            System.out.println("Press Enter key to continue...");
            Scanner s1 = new Scanner(System.in);
            s1.nextLine();
            adminMenu();
    	}
    	catch(Exception e)
    	{
        	
    		System.out.println("----------------------------------------");
            System.out.println(">>The entry should be numeric<<");        
            System.out.println("----------------------------------------");    		
            System.out.println("Press Enter key to continue...");
            Scanner s1 = new Scanner(System.in);
            s1.nextLine();
            adminMenu();
    	}
    	 	
	}   
       	
    //--------------------Employee---Menu-------------------------------------//
    
    public void employeeMenu()
    	{
    	 	  System.out.println();
    	 	  System.out.println();
    		  System.out.println("Welcome to Bank Employee account: "+emp_username);  
			  System.out.println("--------------------------------------------");              
		      System.out.println("1) View all accounts");
		      System.out.println("2) View individual account");
		      System.out.println("3) Back to System Management Menu");
		      System.out.println("--------------------------------------------");
		       	                
		     int select= -1;
		     do
		     {	 
		     	try
		     	{
		     		Scanner sc4 = new Scanner(System.in);
		     		select = Integer.parseInt(sc4.nextLine());
		     	}
		     	 catch(NumberFormatException e)
		     	{
		     		 
		         	System.out.println();
		         	System.out.println("-----------------------------");
		         	System.out.println(">>Please select only number<<");
		         	System.out.println("-----------------------------");
		         	System.out.println();
		         	
		     	}
		     	
			       	if (select < 1 || select > 3)
			        {
			            
		          	System.out.println();
		          	System.out.println("-------------------------------------");
		          	System.out.println(">>please select numbers from 1 to 3<<");
		          	System.out.println("-------------------------------------");
		          	System.out.println();
			                     	               	        	             
			        }   	
		     } while (select< 1 || select > 3);	
		   
		   switch (select)
		   {
		   case 1:
		   	
		   	allAccounts();
		   	logger.info("Bank Employee: all accounts report");
            System.out.println("Press Enter key to continue...");
            Scanner s5 = new Scanner(System.in);
            s5.nextLine();
		   		   	
		   	employeeMenu();
		   	break;
		   	
		   case 2:
		   	
		   	System.out.println("Enter account number");
		   	Scanner sc4 = new Scanner(System.in);
		   	int id_account = Integer.parseInt(sc4.nextLine());		   	
		   	individualAccount(id_account);
		   	logger.info("Bank Employee: individual accounts report for "+id_account);
		   	System.out.println("Press Enter key to continue...");
            Scanner s6 = new Scanner(System.in);
            s6.nextLine();
		   			   	
		   	employeeMenu();
		   	break;
	   	
		   case 3:
			  bankMenu();
			  break;	
		   }
       
    }
    
}

	

