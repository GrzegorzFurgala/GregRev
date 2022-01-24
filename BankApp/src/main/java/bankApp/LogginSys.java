package bankApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.postgresql.util.PSQLException;

public class LogginSys extends Menu
{
	private static final Logger logger = LogManager.getLogger(LogginSys.class);
	double balance = accBalance(usernameL);
	String username1;
	int password1;
	int id;
	
	
	public void signIn(String firstlastName, String uName, int uPassword ) // store data into database "account"
	{
					
		try
			{
				Class.forName("org.postgresql.Driver");				
				String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
				String username ="usbtquop";
				String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";
				
				Connection connection = DriverManager.getConnection(connectionString,username,password);
				java.sql.Statement statement = connection.createStatement();
																
				ResultSet result = statement.executeQuery("INSERT Into account (firstlastname, username,password, balance) "
						+ "values (\'"+firstlastName+"\' ,\'"+uName+"\', \'"+uPassword+"\', 100)");	
						
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
	
//-----------------------------------------------------------------------------------------------------------------------------------------------//		
	
	public String loggIn(String usernameL) // username from database account
	{
			
		try
		{
			Class.forName("org.postgresql.Driver");
			
			String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
			String username ="usbtquop";
			String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";			
			Connection connection = DriverManager.getConnection(connectionString,username,password);
			java.sql.Statement statement = connection.createStatement();
																		
				ResultSet result = statement.executeQuery("Select username from account WHERE username = \'"+usernameL+"\' ");	
			
				while(result.next())
				{
				username1 = result.getString("username");				
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
			
		return username1;
	}
	 
	//----------------------------------------------------------------------------------------------------//
	
	public int loggIn1(String usernameL) //  password from database "account"
	{
					
		try
		{
			Class.forName("org.postgresql.Driver");			
			String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
			String username ="usbtquop";
			String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";		
			Connection connection = DriverManager.getConnection(connectionString,username,password);
			java.sql.Statement statement = connection.createStatement();
																
		
				ResultSet result = statement.executeQuery("Select password from account WHERE username = \'"+usernameL+"\' ");	
			
				while(result.next())
				{
					password1 = result.getInt("password");
										
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
					
		return password1;
	}
	
	//-----------------------------accountNumber-----------------------------------------------------------//
	public int accountNumber(String usernameL) 
	{
					
		try
		{
			Class.forName("org.postgresql.Driver");			
			String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
			String username ="usbtquop";
			String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";		
			Connection connection = DriverManager.getConnection(connectionString,username,password);
			java.sql.Statement statement = connection.createStatement();
																		
				ResultSet result = statement.executeQuery("Select id_account from account WHERE username = \'"+usernameL+"\' ");	
			
				while(result.next())
				{
					id = result.getInt("id_account");
										
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
					
		return id;
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------------------//
	public double accBalance( String usernameL) //checking balance
	{
			
		try
		{
			Class.forName("org.postgresql.Driver");		
			String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
			String username ="usbtquop";
			String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";		
			Connection connection = DriverManager.getConnection(connectionString,username,password);
			java.sql.Statement statement = connection.createStatement();
																		
			ResultSet result = statement.executeQuery("Select balance from account WHERE username = \'"+usernameL+"\' ");	
			
			while(result.next())
			{			
				balance = result.getInt("balance");
				System.out.println("Your account balance: "+result.getInt("balance"));				
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
	
	//-------------------------------------------------------------------------------------------------------------------------------------------//

	
	public void deposit(String usernameL, double amount ) // deposit money to balance
	{
				
		try
			{
				Class.forName("org.postgresql.Driver");			
				String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
				String username ="usbtquop";
				String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";			
				Connection connection = DriverManager.getConnection(connectionString,username,password);
				java.sql.Statement statement = connection.createStatement();
																						
				ResultSet result = statement.executeQuery("Update account set balance = balance + \'"+amount+"\' WHERE username = \'"+usernameL+"\' ");
				
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
	
	public void withdrawal(String usernameL, double amount ) // withdraw money from balance
	{
				
		try
			{
				Class.forName("org.postgresql.Driver");			
				String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
				String username ="usbtquop";
				String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";			
				Connection connection = DriverManager.getConnection(connectionString,username,password);
				java.sql.Statement statement = connection.createStatement();
																						
				ResultSet result = statement.executeQuery("Update account set balance = balance - \'"+amount+"\' WHERE username = \'"+usernameL+"\' ");
					
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
	
	public void transfer(int accountNumber, double amount ) 
	{
				
		try
			{
				Class.forName("org.postgresql.Driver");			
				String connectionString ="jdbc:postgresql://tyke.db.elephantsql.com:5432/usbtquop";
				String username ="usbtquop";
				String password ="p4dJLY2wuaue4KEwIdLrbz9dYGh3x6Sn";			
				Connection connection = DriverManager.getConnection(connectionString,username,password);
				java.sql.Statement statement = connection.createStatement();
																						
				ResultSet result = statement.executeQuery("Update account set balance = balance + \'"+amount+"\' WHERE id_account = \'"+accountNumber+"\' ");
				
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
