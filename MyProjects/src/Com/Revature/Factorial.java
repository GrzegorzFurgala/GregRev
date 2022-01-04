package Com.Revature;

public class Factorial
{
    public void factorial(int factorial)
    {

        int result = 1;     

        for(int i = 2; i <= factorial; i++)
        {
            result = result * i;
           
        }

        System.out.println(result);
        
    }	    
	
}
