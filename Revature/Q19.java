package Com.Revature;

import java.util.ArrayList;

public class Q19
{

	public void q19()
    {
        ArrayList<Integer> q19 = new ArrayList<Integer>();
        ArrayList<Integer> prime = new ArrayList<>();
        
        int even = 0;
        int odd = 0;
        int counter = 0;
        int j = 1;

        for(int i = 1; i<= 10; i++)
        {
            q19.add(i);        //creating ArrayList 1-10
            System.out.println(q19.get(i-1));
            while(j <= i )
            {
                if(i%j == 0)
                {
                    counter+=1;
                }
                j++;
            }
            j=1;

            if(counter == 2)
            {
                prime.add(i);         //checking primes
            }
            counter = 0;

            if(i % 2 == 0)
              {
                even +=i;               // checking even
              }
              else if(i % 2 == 1)
              {
                odd += i;               // checkin odd
              }

        }
        System.out.println("Orginal list");
        System.out.println("------------------");
        System.out.println(even+" -adding even numbers");
        System.out.println("-------------------");
        System.out.println(odd+" -adding odd numbers");
        System.out.println("-------------------");

            for(int s = 0; s < prime.size(); s++)
            {
                for(int l = 0; l < q19.size(); l++)
                {
                   if(prime.get(s) == q19.get(l))
                   {
                       q19.remove(l);           //removing primes from the list
                   }
                }
            }

        for(int f = 0; f < q19.size(); f++ )
        {
            System.out.println(q19.get(f));
        }
        System.out.println("List after Primes removal");
    }
}
