import fi.mielialapaivakirja.logics.Entry;
import fi.mielialapaivakirja.logics.Indicator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Month;

public class EntryTest {
    Entry testEntry;
    Indicator testIndicator;
    
    @Before
    public void setUp() {
        testIndicator = new Indicator("testIndicator", 1, 5, 1000, 1000);
        LocalDate testDate = LocalDate.of(2021, 3, 1);
        testEntry = new Entry(testDate, testIndicator, 3);
    }
    
    @Test
    public void constructorWorksRight() {
        assertEquals("Päivämäärä: 01.03.2021, testIndicator: 3", testEntry.toString());
    }
    
    
    
}
