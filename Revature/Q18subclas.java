package Com.Revature;

import java.util.Locale;

public class Q18subclas extends Q18abstract
{
	boolean checkUppercase(String name)
    {
        char isUpper;
        boolean result = false;

        for(int i = 0; i < name.length(); i++ )
        {
             isUpper = name.charAt(i);

             Character.isUpperCase(isUpper);

             if(Character.isUpperCase(isUpper) == true)
             {
                  result = true;
             }
        }
        System.out.println(result);
        return result;
    }

    String toUpp(String name)
    {

        String name2 = name.toUpperCase(Locale.forLanguageTag(name));

        System.out.println(name2);
        return name2;
    }

    void toInt(String s)
    {

        int result = Integer.parseInt(s) + 10;
        System.out.println(result);

    }
		
}
