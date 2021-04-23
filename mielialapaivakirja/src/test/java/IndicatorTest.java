import fi.mielialapaivakirja.logics.Indicator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class IndicatorTest {
    Indicator indicator;
    
   
    @Before
    public void setUp() {
        indicator = new Indicator("TestIndicator", 1, 5, 1000, 1000);
    }
    
    @Test
    public void ConstructorWorksRight(){
        assertEquals("TestIndicator(1-5)", indicator.toString());
    }
}
