package Com.Revature;

public class ReverseString
{

    public void reverseStr(String myString)
    {

        char[] myArray = myString.toCharArray();  // change "myString" into myArray


        for(char e : myArray)  //this is to show myArrey before "reverse"
        {
            System.out.print(e);
        }

        System.out.println("\n" + "--------------------------------------------"); // this is just to create dotted line in the console 

        for(int i = myArray.length - 1; i >= 0; i-- )	// here I use iteration from backward using decrementation "i--"
        {
            myString = "";
            myString = myString + myArray[i];
            System.out.print(myString);
        }

    }
	
	
}
