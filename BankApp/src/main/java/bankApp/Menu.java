package bankApp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu
{

    String firstlastName;
    String username;
    String usernameL;
    int  password;
    int passwordL;
    boolean access = true;

    public void konto()
     {
            System.out.println("=======================");
            System.out.println("1) Create new account");
            System.out.println("2) Log into account");
            System.out.println("3) Exit app");
            System.out.println("=======================");

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
                    System.out.println("please select numbers from 1 to 3");
                }
            } while (choice < 1 || choice > 4);


            switch (choice)
            {
                case 1:

                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please provide your first name and last name");
                    firstlastName = scanner.nextLine();
                    System.out.println("Please provide your username");
                    username = scanner.nextLine();

                    try
                    {
                        System.out.println("Please provide your password");
                        password = scanner.nextInt();
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("==================================================");
                        System.out.println("The password should be numerical");
                        System.out.println("Please create your account with numerical password");
                        System.out.println("==================================================");
                        konto();
                    }

                   /*       zapis danych do pliku txt
                    try
                   {
                       PrintWriter zapis = new PrintWriter("nazwa_pliku.txt");
                       zapis.println(firstlastName+" "+username+" "+password);
                       zapis.close();

                   }
                   catch(Exception e)
                   {
                       System.out.println(e.getMessage());

                   }*/


                    System.out.println("============================================");
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

                    for(int j = 1; j<=1; j++)
                    {
                        for(int i = 0; i < username.length(); i++)
                        {
                            if (username.charAt(i) == usernameL.charAt(i))
                            {


                            } else {
                                access = false;
                            }
                        }

                    }

                    System.out.println(username);


                    if(access == true && password == passwordL)
                    {
                        Account acc = new Account();
                        acc.accMenu(firstlastName);
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
                    System.exit(0);

            }
        }
	
	
	
}
