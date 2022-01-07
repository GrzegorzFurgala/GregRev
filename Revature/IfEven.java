package Com.Revature;

public class IfEven 
{

	public void isEven(double x)
    {
     
        double y = Math.round(x/2);
        double z = x / 2;

        if(z==y)
        {
            System.out.println("number "+x+" is EVEN!");
        }
        else
        {
            System.out.println("number "+x+" is NOT EVEN!");
        }
    }	
}
