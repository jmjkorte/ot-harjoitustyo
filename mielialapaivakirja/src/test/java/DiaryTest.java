
import fi.mielialapaivakirja.logics.Diary;
import fi.mielialapaivakirja.logics.Entry;
import fi.mielialapaivakirja.logics.Indicator;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;


public class DiaryTest {
    
   
    Diary testDiary;
    Indicator testIndicator;
    Entry testEntry;
    
    @Before
    public void setUp() {
        testDiary = new Diary();
        LocalDate testDate = LocalDate.of(2021, 3, 1);
        testEntry = new Entry(testDate, testIndicator, 3);
    }
    
    @Test
    public void createIndicatorReturnsRightName() {
        testDiary.createIndicator("anotherIndicator", 0, 10, 10, 1);
        ArrayList<String> list = new ArrayList();
        String name ="";
        list = testDiary.getNamesOfAllIndicators();
        for(String each: list){
            name = each;
        }
        
        assertEquals("anotherIndicator", name);
        
    }
    
    @Test
    public void getNamesOfAllIndicatorsReturnsEmptyListIfNoIndicators() {
        ArrayList<Indicator> testList = testDiary.getNamesOfAllIndicators();
        assertTrue(testList.isEmpty());
    }
    
    //@Test
  //  public void 
    
   
}
