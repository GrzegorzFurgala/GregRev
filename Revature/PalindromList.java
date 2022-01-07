package Com.Revature;

import java.util.ArrayList;

public class PalindromList
{

	public void palindromes()
    {
        ArrayList<String> wordList = new ArrayList<String>();

        wordList.add("karan");
        wordList.add("madam");
        wordList.add("tom");
        wordList.add("civic");
        wordList.add("radar");
        wordList.add("jimmy");
        wordList.add("kayak");
        wordList.add("john");
        wordList.add("refer");
        wordList.add("billy");
        wordList.add("did");

        ArrayList<String> palindromList = new ArrayList<>();

        
        for(int i = 0; i < wordList.size(); i++)
        {
            int wordLength = wordList.get(i).length() / 2;   // how many characters is to check in front and on the back of every word
            int counter = 0;

            for(int j = 0; j < wordLength; j++ )				
            {
                char symbolFront = wordList.get(i).charAt(j);
                char symbolBack = wordList.get(i).charAt(wordList.get(i).length() - 1 - j);

                if(symbolFront == symbolBack )
                {
                    counter = counter + 1;
                }

                if(symbolFront == symbolBack &&  wordLength == 1 || symbolFront == symbolBack && counter == 2)
                {
                    palindromList.add(wordList.get(i));
                    counter = 0;
                    continue;
                }
                else if (symbolFront != symbolBack)
                {
                    counter = 0;
                    continue;
                }
            }
        }

        for(String e : palindromList)
        {
            System.out.println(e);
        }


    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
