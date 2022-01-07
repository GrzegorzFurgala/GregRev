package Com.Revature;


public class Q15 implements Q15interf
{
    double a = 10;
    double b = 3;



    @Override
    public void addition()
    {
        System.out.println(a+b);
    }
    @Override
    public void subtraction()
    {
        System.out.println(a-b);
    }
    @Override
    public void multiplication()
    {
        System.out.println(a*b);
    }

    @Override
    public void division()
    {
        System.out.println(a/b);
    }

}
	
