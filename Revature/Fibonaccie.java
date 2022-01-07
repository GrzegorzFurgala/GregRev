package Com.Revature;

public class Fibonaccie
{

    public void fibo (int a)
    {
        int numberA = 0;
        int numberB = 1;
        int fibo = 0;
        String result = "0, 1, ";  // I know it is not good but is working ;-)
  
        
        while (fibo <= a )				//loop will perform until fibo is lower or equal than "a" (argument we sent to this function)
        {
            fibo = numberA + numberB;   // fibo is the sum of numberA and numberB

            if(fibo > a)				// this is to avoid situation when the sum of numberA and numberB ("fibo") is higher than "a" and will be add to result.
            {							// so if condition is true (fibo is higher than "a" we print result and use break to exit function.
                System.out.println(result);
                break;
            }

            result += fibo + ", ";       // here I'm adding next numbers to the result

            numberA = numberB;           // I switch those variables. According to Fibonaccie rule every folloing number ist a sum of previous two
            numberB = fibo;
        }
    }
	
	
	
}
