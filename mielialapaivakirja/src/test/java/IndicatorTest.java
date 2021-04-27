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
    public void ConstructorWorksRight() {
        assertEquals("TestIndicator(1-5)", indicator.toString());
    }
    
    @Test
    public void setNameOfIndicatorWorksRight() {
        indicator.setNameOfIndicator("Alternative");
        assertEquals("Alternative", indicator.getNameOfIndicator());
    }
    
    @Test
    public void setMinValueWorksRigh() {
        indicator.setMinValue(3);
        assertEquals(3, indicator.getMinValue());
    }
    
    @Test
    public void setMaxValueWorksRigh() {
        indicator.setMaxValue(7);
        assertEquals(7, indicator.getMaxValue());
    }
    
    @Test
    public void setCriticalValueWorksRigh() {
        indicator.setCriticalValue(6);
        assertEquals(6, indicator.getCriticalValue());
    }
    
}
