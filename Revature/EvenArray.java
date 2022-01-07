package Com.Revature;

public class EvenArray 
{
	
    public static void evenA()
    {
        int[] evenArray = new int[100];

        for(int i = 1; i < 100; i++)
        {
            evenArray[i] = i+1;
        }

        for(int e : evenArray)
        {
            if(e%2 == 0)
            {
                System.out.println(e);
            }

        }
       }
	

}
