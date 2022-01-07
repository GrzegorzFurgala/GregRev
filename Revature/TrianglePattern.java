package Com.Revature;

public class TrianglePattern 
{

    public void pattern()
    {
        int i = 1;
        int rows = 4;
        int j = 1;


        for (i = 1; i <= rows; i++)
        {
            for (j = 1; j <= i; j++)
            {
                if (j % 2 == 0)
                {
                    System.out.print("0");
                } else
                {
                    System.out.print("1");
                }
            }
            System.out.println();
        }
    }
	
}
