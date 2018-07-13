package whowins;

import whowins.persistence.Database;
import whowins.persistence.DatabaseImpl;

public class App
{
    public static void main( String[] args )
    {
        Database database = new DatabaseImpl();
        database.createConnection();
        System.out.println( "Hello World!" );
    }
}
