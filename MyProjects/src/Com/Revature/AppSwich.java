package Com.Revature;
import java.time.LocalDate;
import java.util.Scanner;

public class AppSwich 
{


    public static void aplication()
    {

        Scanner scanner = new Scanner(System.in);

        System.out.println("please select on of 3 following option");
        System.out.println("1. square root");
        System.out.println("2. display today’s date");
        System.out.println("3. Split the string and store it in a string array");

        int option = scanner.nextInt();

          switch (option)
          {
              case 1:
                  System.out.println("provide the number");
                  double y = Math.sqrt(scanner.nextInt());
                  System.out.println(y);
                  break;
              case 2:
                  LocalDate data = LocalDate.now();
                  System.out.println(data);
                  break;
              case 3:
                 String s = "I am learning Core Java";
                 String[] strArray = s.split(" ",5);

                  for(String e : strArray)
                  {
                      System.out.println(e);
                  }
                  break;
          }
          scanner.close();
    }
}