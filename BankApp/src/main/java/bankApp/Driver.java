package bankApp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Driver
{

	private static final Logger logger = LogManager.getLogger(Driver.class);

	
    public static void main(String[] args) 
    {

        Menu menu = new Menu();
        logger.info("Start application");	
        menu.konto();

        


        
    }	
	
}
