package bankApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

public class BankDao 
{

	   String emp_username;
	   int emp_password;
	   double balance;
	
	public String adminUsername(String adminUsername) // emp_username from database account
	{
			
		try
		{
			Class.forName("org.postgresql.Driver");
			
			String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
			String username ="usbtquop";
			String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";			
			Connection connection = DriverManager.getConnection(connectionString,username,password);
			java.sql.Statement statement = connection.createStatement();
																		
				ResultSet result = statement.executeQuery("Select emp_username from employee WHERE emp_username = \'"+adminUsername+"\' "
						+ "and job = \'admin\'");	
			
								
				//ResultSet result = statement.executeQuery("Select emp_username from employee WHERE emp_username = \'"+adminUsername+"\' ");	
				
				while(result.next())
				{
					emp_username = result.getString("emp_username");				
				}
				
			connection.close();	
							
		}
		catch(ClassNotFoundException e)	
		{
				e.printStackTrace();			
		}		
		catch(SQLException e)	
		{
				e.printStackTrace();				
		}				
			
		return emp_username;
	}
	
	
	
	public int adminPassword(String adminUsername) //  password from database "account"
	{
					
		try
		{
			Class.forName("org.postgresql.Driver");			
			String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
			String username ="usbtquop";
			String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";		
			Connection connection = DriverManager.getConnection(connectionString,username,password);
			java.sql.Statement statement = connection.createStatement();
																
		
				ResultSet result = statement.executeQuery("Select emp_password from employee WHERE emp_username = \'"+adminUsername+"\'"
						+ "and job = \'admin\'");						
								
						
				while(result.next())
				{
					emp_password = result.getInt("emp_password");
										
				}
				
				connection.close();
							
		}
		catch(ClassNotFoundException e)	
		{
				e.printStackTrace();			
		}		
		catch(SQLException e)	
		{
				e.printStackTrace();				
		}
					
		return emp_password;
	}
	
	

	
	public String employeeUsername(String adminUsername) // emp_username from database account
	{
			
		try
		{
			Class.forName("org.postgresql.Driver");
			
			String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
			String username ="usbtquop";
			String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";			
			Connection connection = DriverManager.getConnection(connectionString,username,password);
			java.sql.Statement statement = connection.createStatement();
																		
				ResultSet result = statement.executeQuery("Select emp_username from employee WHERE emp_username = \'"+adminUsername+"\' "
						+ "and job = \'employee\'");	
			
								
				//ResultSet result = statement.executeQuery("Select emp_username from employee WHERE emp_username = \'"+adminUsername+"\' ");	
				
				while(result.next())
				{
					emp_username = result.getString("emp_username");				
				}
				
			connection.close();	
							
		}
		catch(ClassNotFoundException e)	
		{
				e.printStackTrace();			
		}		
		catch(SQLException e)	
		{
				e.printStackTrace();				
		}				
			
		return emp_username;
	}
	
	
	public int employeePassword(String adminUsername) //  password from database "account"
	{
					
		try
		{
			Class.forName("org.postgresql.Driver");			
			String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
			String username ="usbtquop";
			String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";		
			Connection connection = DriverManager.getConnection(connectionString,username,password);
			java.sql.Statement statement = connection.createStatement();
																
		
				ResultSet result = statement.executeQuery("Select emp_password from employee WHERE emp_username = \'"+adminUsername+"\'"
						+ "and job = \'employee\'");						
			
						
				while(result.next())
				{
					emp_password = result.getInt("emp_password");
										
				}
				
				connection.close();
							
		}
		catch(ClassNotFoundException e)	
		{
				e.printStackTrace();			
		}		
		catch(SQLException e)	
		{
				e.printStackTrace();				
		}
					
		return emp_password;
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
											
					}
					System.out.println("--------------------------------------------------------");	
						
					connection.close();
					
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
										
					}
					System.out.println("--------------------------------------------------------");	
					System.out.println();
					
					connection.close();
					
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
				
				connection.close();		
									
			}
			catch(ClassNotFoundException e)	
			{
					e.printStackTrace();			
			}		
			catch(PSQLException e)
			{
				
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
					
					connection.close();
					
				}
				catch(ClassNotFoundException e)	
				{
						e.printStackTrace();			
				}		
				catch(PSQLException e)
				{
					
				}
				catch(SQLException e)	
				{
						e.printStackTrace();				
				}	
						
		}
	
	   //------------------------BALANCE-----------------------------------//
		
	   public double accBalance( int id_account) //checking balance
		{
				
			try
			{
				Class.forName("org.postgresql.Driver");		
				String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
				String username ="usbtquop";
				String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";		
				Connection connection = DriverManager.getConnection(connectionString,username,password);
				java.sql.Statement statement = connection.createStatement();
																			
				ResultSet result = statement.executeQuery("Select balance from account WHERE id_account = \'"+id_account+"\' ");	
				
				while(result.next())
				{			
					balance = result.getInt("balance");
					//System.out.println("Your account balance: "+result.getInt("balance"));				
				}
				
				connection.close();			
				
			}
			catch(ClassNotFoundException e)	
			{
					e.printStackTrace();			
			}		
			catch(SQLException e)	
			{
					e.printStackTrace();				
			}
				
			return balance;
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
														
							Bank bank = new Bank();
							bank.bankMenu();
							
						}										
					}
													
					
					ResultSet result2 = statement.executeQuery("Update account set balance = balance - \'"+amount+"\' WHERE id_account = \'"+id_account+"\' ");
					
					connection.close();
											
				}
				catch(ClassNotFoundException e)	
				{
						e.printStackTrace();			
				}		
				catch(PSQLException e)
				{
					
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
							
							Bank bank = new Bank();
							bank.bankMenu();
																					
						}											
					}
																	
					ResultSet result2 = statement.executeQuery("Update account set balance = balance - \'"+amount+"\' WHERE id_account = \'"+id_account+"\' ");
					
					connection.close();
									
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
					
					connection.close();
				}
				catch(ClassNotFoundException e)	
				{
						e.printStackTrace();			
				}		
				catch(PSQLException e)
				{
					
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
					
					connection.close();
					
				}
				catch(ClassNotFoundException e)	
				{
						e.printStackTrace();			
				}		
				catch(PSQLException e)
				{
					
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
	 						
	 				connection.close();
	 				
	 			}
	 			catch(ClassNotFoundException e)	
	 			{
	 					e.printStackTrace();			
	 			}		
				catch(PSQLException e)
				{
					
				}
				catch(SQLException e)	
				{
						e.printStackTrace();				
				}						
	 	}
	   
	   //-----------------------UPDATE----------------BALLANCE-------------------------------//
	   	   
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
	 					
	 				connection.close();
	 				
	 			}
	 			catch(ClassNotFoundException e)	
	 			{
	 					e.printStackTrace();			
	 			}		
				catch(PSQLException e)
				{
					
				}
				catch(SQLException e)	
				{
						e.printStackTrace();				
				}		
	 			 		
	 	}
	   	   	   
}
