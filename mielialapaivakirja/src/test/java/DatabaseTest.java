import fi.mielialapaivakirja.database.DatabaseCreator;
import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jmjkorte
 */
public class DatabaseTest {
    private DatabaseCreator db;
    
    public DatabaseTest() {
    }
    
    
    @Before
    public void setUp() {
        db = null;
        db = new DatabaseCreator();
    }
    
   

    
}
