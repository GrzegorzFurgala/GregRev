package Com.Revature;

public class BubbleSort 
{
	
	public void bubbleSort()
    {

        int [] numbers = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};

        int i = 0;
             
        while( i < numbers.length - 1 )        // the number of loops need to be perform
        {
                 	
        	int j = 0;

            while( j < numbers.length - 1)		// "-1" is required in order to not go beyond the index
            {
                if(numbers[j] > numbers[j+1])  //  when number with lower index is greater than number with higher we need to switch them 
                {
                    int first = numbers[j];
                    int second = numbers[j + 1];	// temporary variables in order to switch numbers

                    numbers[j] = second;
                    numbers[j + 1] = first;
                }
                j++;
            }
            i++;
        }

        
        for(int k = 0; k < numbers.length; k++)   // after while loop is finished, we need to display new array order
        {
            System.out.println(numbers[k]);
        }

    }
		
}
