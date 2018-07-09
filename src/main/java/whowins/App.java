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
        database.createConnection();
        System.out.println( "Hello World!" );
    }
}
