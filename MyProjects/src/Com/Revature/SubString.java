package Com.Revature;

public class SubString
{

	public void subString (String str, int idx)
	{
		
	        String result = "";

	        char [] myArray = str.toCharArray();  // str i turn into myArray

	        for(int i = 0; i <= idx; i++)        // using for loop,  idx (numbers of loop we get as argument)
	        {
	            result = result  + myArray[i];

	        }

	        System.out.println(result);
				
	}
	
}
