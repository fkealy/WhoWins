package whowins;

import whowins.persistence.Database;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Database database = new Database();
        database.createNewInLocation("Fighters");
        System.out.println( "Hello World!" );
    }
}
