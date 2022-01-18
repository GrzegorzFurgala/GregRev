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

        
    	/*		
                System.out.println( "Hello, user!" );
                logger.trace("We've just greeted the user!");
                logger.debug("We've just greeted the user!");
                logger.info("We've just greeted the user!");
                logger.warn("We've just greeted the user!");
                logger.error("We've just greeted the user!");
                logger.fatal("We've just greeted the user!");
         */   

        
    }	
	
}
