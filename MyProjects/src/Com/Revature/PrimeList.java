package Com.Revature;

import java.util.ArrayList;

public class PrimeList 
{

	 public static void prime()
	    {
	        ArrayList<Integer> primeList = new ArrayList<>();

	        for(int i = 1; i <=100; i++ )
	        {
	            primeList.add(i);
	        }

	        int counter = 0;
	        String result = "";

	        for (int i = 1; i <= primeList.size() - 1; i++)
	        {
	            for (int j = 1; j <= primeList.get(i); j++)
	            {
	                if (i % j == 0)
	                {
	                    counter++;
	                }
	            }

	            if (counter == 2)
	            {
	                result += i + ", ";
	            }
	            counter = 0;
	        }
	        System.out.println(result);
	    }	
}
