package bankApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bank
{
	private static final Logger logger = LogManager.getLogger(Bank.class);
	double amount;
	
	
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
	                System.out.println("--------------------------------------------");              
	                 System.out.println("1) View All Accounts");
	                 System.out.println("2) View Individual Account");
	                 System.out.println("3) Delete Account");
	                 System.out.println("4) Deposit");
	                 System.out.println("5) Withdraw");
	                 System.out.println("6) Transfer");
	                 System.out.println("7) Edit Account");
	                 System.out.println("8) Go back System Menu");
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
	                		bankMenu();
	                	break;
	           
	                	case 2:
	                		System.out.println("Enter account number");
	                		
	                		 Scanner scanner = new Scanner(System.in);
	        	        	 int id_account = Integer.parseInt(scanner.nextLine());
	        	        	 
	        	        	 individualAccount(id_account);
	        	        	 bankMenu();
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
		                     System.out.println();
	        	        	 bankMenu();
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
	                        	System.out.println("-----------------------------");
	                        	System.out.println("You can NOT deposit 0 or less");
	                        	System.out.println("-----------------------------");
	                        	System.out.println();
	                            bankMenu();
	                        }     
	                                
	                        System.out.println("--------------------------------------------");
	                        System.out.println("Enter account number");
	                        System.out.println("--------------------------------------------");   
	                        id_account = sc1.nextInt();				              
	                        
	                        deposit(id_account,amount );
	                        bankMenu();
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
	                        withdrawal(id_account, amount);
	                                                      	                                     
	                        bankMenu();
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
	                        	                      	                                   
	                        System.out.println("--------------------------------------------");
	                        System.out.println("Enter the account number to which to transfer the money");
	                        System.out.println("--------------------------------------------");
	                        
	                        int id_account2 = sc3.nextInt(); 
	                        	                        	                        
	                        withdrawal(id_account,amount);
	                        deposit(id_account2,amount);	                                                      	                                     
	                        bankMenu();
	                        break;	
	                  		
	                  	case 7:  	
	                  		
	                  		
	    	             System.out.println("--------------------------------------------");              
	   	                 System.out.println("1) Change Full Name");
	   	                 System.out.println("2) Change Username");
	   	                 System.out.println("3) Change Password");
	   	                 System.out.println("4) Change Balance");
	   	                 System.out.println("5) Back To System Menu");
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
			        	        	 bankMenu();
			                	break;
	                  	
			                	case 2:	
	                  	
			                 		 System.out.println("Enter account number");	                		
			                		 Scanner sc7 = new Scanner(System.in);
			        	        	 id_account = Integer.parseInt(sc7.nextLine());
			        	        	 
			                		 System.out.println("Enter NEW username");	                		
			                		 Scanner sc8 = new Scanner(System.in);
			        	        	 String newUsername = sc8.nextLine();
			        	        	         	        	 
			        	        	 uUsername(id_account, newUsername);        	        	 	        	        	 
			        	        	 bankMenu();			        	   			        	        	 
			                	break;
			                		
			                  	case 3:	
				                  	
			                 		 System.out.println("Enter account number");	                		
			                		 Scanner sc9 = new Scanner(System.in);
			        	        	 id_account = Integer.parseInt(sc9.nextLine());
			        	        	 
			                		 System.out.println("Enter NEW password");	                		
			                		 Scanner sc10 = new Scanner(System.in);
			        	        	 int newPassword = Integer.parseInt(sc10.nextLine());
			        	        	         	        	 
			        	        	 uPassword(id_account, newPassword);        	        	 	        	        	 
			        	        	 bankMenu();			        	   			        	        	 
			                	break;
			                	
			                  	case 4:	
				                  	
			                 		 System.out.println("Enter account number");	                		
			                		 Scanner sc11 = new Scanner(System.in);
			        	        	 id_account = Integer.parseInt(sc11.nextLine());
			        	        	 
			                		 System.out.println("Change account balance to: ");	                		
			                		 Scanner sc12 = new Scanner(System.in);
			        	        	 double newBalance = Integer.parseInt(sc12.nextLine());
			        	        	         	        	 
			        	        	 uBalance(id_account, newBalance);        	        	 	        	        	 
			        	        	 bankMenu();			        	   			        	        	 
			                	break;
			                		
			                  	case 5:					                  	   	        	 	        	        	 
			        	        	 bankMenu();			        	   			        	        	 
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
			      	                System.out.println("Please select one option from 1 to 7");			                				                	
			                  	}  
			                  			                  	
	                  	case 8:        				                  	
	                  		bankMenu();	    	               		        	   			        	        	 
	                	break;			                	
            			                  	
	                  	default:
	      	                System.out.println("Please select one option from 1 to 8");	     	
			                  				                  	                  		                  			
	                }
	            	            
	            case 2:
	                
	            	 System.out.println("Welcome to Bank Employee account");  
	            	 System.out.println("--------------------------------------------");              
  	                 System.out.println("1) View all accounts");
  	                 System.out.println("2) View individual account");  	                
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
  	                		 System.out.println("Please select only numbers");
  	                	}
  	                	
  	        	       	if (select < 1 || select > 2)
  	        	        {
  	        	             System.out.println("please select numbers from 1 to 2");
  	        	        }   	
  	                } while (select< 1 || select > 2);	
	                
	                switch (select)
	                {
	                case 1:
	                	
	                	allAccounts();
	                	break;
	                	
	                case 2:
	                	
	                	System.out.println("Enter account number");
	                	Scanner sc4 = new Scanner(System.in);
	                	int id_account = Integer.parseInt(sc4.nextLine());
	                	
	                	individualAccount(id_account);
	                	break;		                              
	                }
	                              	                	              	                
	                bankMenu();
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
	                System.out.println("Please select one option from 1 to 4");
              
	       }
        }   
    
       
    //-----------View----All----Accounts-------------//
    
    
   public void allAccounts()
   {
	   
	   try
		{
			Class.forName("org.postgresql.Driver");
			
			String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
			String username ="usbtquop";
			String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";			
			Connection connection = DriverManager.getConnection(connectionString,username,password);
			java.sql.Statement statement = connection.createStatement();
																		
				ResultSet result = statement.executeQuery("Select * from account");	
			
				System.out.println("Account nr / Full name / username / password / balance");
				System.out.println("--------------------------------------------------------");
					
				while(result.next())
				{
				
				System.out.println(result.getInt("id_account")+"      / "+result.getString("firstlastname")+" / "+result.getString("username")+" / "
								  +result.getString("password")+" / "+result.getDouble("balance"));	
				
				//System.out.println("Id: " + result.getInt("apartment_id")+", price: "+ result.getString("price"));		
				}
				System.out.println("--------------------------------------------------------");	
								
		}
		catch(ClassNotFoundException e)	
		{
				e.printStackTrace();			
		}		
		catch(SQLException e)	
		{
				e.printStackTrace();				
		}				
   
   }
        
   //-----------View----Individual----Account-------------// 
    
   public void individualAccount(int id_account)
   {
	   
	   try
		{
			Class.forName("org.postgresql.Driver");
			
			String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
			String username ="usbtquop";
			String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";			
			Connection connection = DriverManager.getConnection(connectionString,username,password);
			java.sql.Statement statement = connection.createStatement();
																		
				ResultSet result = statement.executeQuery("Select * from account WHERE id_account = \'"+id_account+"\' ");	
				
				System.out.println();
				System.out.println();
				System.out.println("Account nr / Full name / username / password / balance");
				System.out.println("--------------------------------------------------------");
				
					
				while(result.next())
				{
				
				System.out.println(result.getInt("id_account")+"      / "+result.getString("firstlastname")+" / "+result.getString("username")+" / "
								  +result.getString("password")+" / "+result.getDouble("balance"));	
				
				//System.out.println("Id: " + result.getInt("apartment_id")+", price: "+ result.getString("price"));		
				}
				System.out.println("--------------------------------------------------------");	
				System.out.println();
				
		}
		catch(ClassNotFoundException e)	
		{
				e.printStackTrace();			
		}		
		catch(SQLException e)	
		{
				e.printStackTrace();				
		}				
   
   }
  
   
 //-----------Delete----Individual----Account-------------// 
   
   public void deleteAccount(int id_account)
   {
	   
	   try
		{
			Class.forName("org.postgresql.Driver");
			
			String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
			String username ="usbtquop";
			String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";			
			Connection connection = DriverManager.getConnection(connectionString,username,password);
			java.sql.Statement statement = connection.createStatement();
																		
				ResultSet result = statement.executeQuery("DELETE from account WHERE id_account = \'"+id_account+"\' ");	
			

								
		}
		catch(ClassNotFoundException e)	
		{
				e.printStackTrace();			
		}		
		catch(SQLException e)	
		{
				e.printStackTrace();				
		}				
   
   }
   
   //------------------------DEPOSIT----------------------------------------------//
   
   
   public void deposit(int id_account , double amount ) // deposit money to ballance
	{
				
		try
			{
				Class.forName("org.postgresql.Driver");			
				String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
				String username ="usbtquop";
				String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";			
				Connection connection = DriverManager.getConnection(connectionString,username,password);
				java.sql.Statement statement = connection.createStatement();
																						
				ResultSet result = statement.executeQuery("Update account set balance = balance + \'"+amount+"\' WHERE id_account = \'"+id_account+"\' ");
										
			}
			catch(ClassNotFoundException e)	
			{
					e.printStackTrace();			
			}		
			catch(SQLException e)	
			{
					e.printStackTrace();				
			}
					
	}
   
   
   //------------------------------WITHDRAWAL----------------------------------//
   
   
   public void withdrawal(int id_account, double amount ) // withdraw money from balance
	{
				
		try
			{
				Class.forName("org.postgresql.Driver");			
				String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
				String username ="usbtquop";
				String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";			
				Connection connection = DriverManager.getConnection(connectionString,username,password);
				java.sql.Statement statement = connection.createStatement();
																						
		
				ResultSet result = statement.executeQuery("select balance from account WHERE id_account = \'"+id_account+"\' ");
				
				
				while(result.next())
				{			
					double cballance = result.getDouble("balance");
					
					if(amount > cballance)
					{
						System.out.println("---------------------------");
						System.out.println("You don't have enough money");
						System.out.println("Your current balance: "+cballance);
						System.out.println("---------------------------");
						
						bankMenu();
						
					}	
					
					
				}
												
				
				ResultSet result2 = statement.executeQuery("Update account set balance = balance - \'"+amount+"\' WHERE id_account = \'"+id_account+"\' ");
										
			}
			catch(ClassNotFoundException e)	
			{
					e.printStackTrace();			
			}		
			catch(SQLException e)	
			{
					e.printStackTrace();				
			}
					
	}
   
   
   //------------------------------TRANSFER-------------------------------------//
   
   public void transfer(int id_account, double amount, int id_account2 ) // withdraw money from balance
	{
				
		try
			{
				Class.forName("org.postgresql.Driver");			
				String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
				String username ="usbtquop";
				String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";			
				Connection connection = DriverManager.getConnection(connectionString,username,password);
				java.sql.Statement statement = connection.createStatement();
																						
		
				ResultSet result = statement.executeQuery("select balance from account WHERE id_account = \'"+id_account+"\' ");
				
				
				while(result.next())
				{			
					double cballance = result.getDouble("balance");
					
					if(amount > cballance)
					{
						System.out.println("---------------------------");
						System.out.println("You don't have enough money");
						System.out.println("Your current balance: "+cballance);
						System.out.println("---------------------------");
						
						bankMenu();
						
					}											
				}
																
				ResultSet result2 = statement.executeQuery("Update account set balance = balance - \'"+amount+"\' WHERE id_account = \'"+id_account+"\' ");
				
				
			}
			catch(ClassNotFoundException e)	
			{
					e.printStackTrace();			
			}		
			catch(SQLException e)	
			{
					e.printStackTrace();				
			}
					
	}
   
  //-----------------------------Update------Full-------Name---------------------------------------// 
   
   public void uFullName(int id_account , String newFullname) 
	{			
		try
			{
				Class.forName("org.postgresql.Driver");			
				String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
				String username ="usbtquop";
				String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";			
				Connection connection = DriverManager.getConnection(connectionString,username,password);
				java.sql.Statement statement = connection.createStatement();
																						
				ResultSet result = statement.executeQuery("Update account set firstlastname = \'"+newFullname+"\' WHERE id_account = \'"+id_account+"\' ");
										
			}
			catch(ClassNotFoundException e)	
			{
					e.printStackTrace();			
			}		
			catch(SQLException e)	
			{
					e.printStackTrace();				
			}					
	}
   
 //-------------------Update------------username----------------//  
   
   public void uUsername(int id_account , String newUsername) 
	{			
		try
			{
				Class.forName("org.postgresql.Driver");			
				String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
				String username ="usbtquop";
				String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";			
				Connection connection = DriverManager.getConnection(connectionString,username,password);
				java.sql.Statement statement = connection.createStatement();
																						
				ResultSet result = statement.executeQuery("Update account set username = \'"+newUsername+"\' WHERE id_account = \'"+id_account+"\' ");
										
			}
			catch(ClassNotFoundException e)	
			{
					e.printStackTrace();			
			}		
			catch(SQLException e)	
			{
					e.printStackTrace();				
			}					
	}
   
   
   public void uPassword(int id_account , int newPassword) 
 	{			
 		try
 			{
 				Class.forName("org.postgresql.Driver");			
 				String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
 				String username ="usbtquop";
 				String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";			
 				Connection connection = DriverManager.getConnection(connectionString,username,password);
 				java.sql.Statement statement = connection.createStatement();
 																						
 				ResultSet result = statement.executeQuery("Update account set password = \'"+newPassword+"\' WHERE id_account = \'"+id_account+"\' ");
 										
 			}
 			catch(ClassNotFoundException e)	
 			{
 					e.printStackTrace();			
 			}		
 			catch(SQLException e)	
 			{
 					e.printStackTrace();				
 			}					
 	}
    
   public void uBalance(int id_account , double newBalance) 
 	{			
 		try
 			{
 				Class.forName("org.postgresql.Driver");			
 				String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
 				String username ="usbtquop";
 				String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";			
 				Connection connection = DriverManager.getConnection(connectionString,username,password);
 				java.sql.Statement statement = connection.createStatement();
 																						
 				ResultSet result = statement.executeQuery("Update account set balance = \'"+newBalance+"\' WHERE id_account = \'"+id_account+"\' ");
 										
 			}
 			catch(ClassNotFoundException e)	
 			{
 					e.printStackTrace();			
 			}		
 			catch(SQLException e)	
 			{
 					e.printStackTrace();				
 			}					
 	}
    
}

	

