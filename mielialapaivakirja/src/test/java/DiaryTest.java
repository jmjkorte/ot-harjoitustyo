
import fi.mielialapaivakirja.logics.Diary;
import fi.mielialapaivakirja.logics.Entry;
import fi.mielialapaivakirja.logics.Indicator;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Assert;



public class DiaryTest {
    
   
    Diary diary;
    LocalDate testDate;
    Indicator indicator;
    Indicator indicator2;
    Entry entry;
    
    @Before
    public void setUp() {
        diary = new Diary("Paasio", "Pertti");
        testDate = LocalDate.of(2021, 3, 1);
        indicator = new Indicator("indicator", 1, 10, 2, 1);
        indicator2 = new Indicator("indicator", 1, 10, 4, 2);
        entry = new Entry(testDate, indicator, 5); 
    }
    
    @Test
    public void createIndicatorReturnsRightName()  {
        diary.createIndicator("test", 1, 5, 0, 1);
        ArrayList<String> list = new ArrayList();
        String name ="";
        list = diary.getNamesOfAllIndicators();
        for(String each: list){
            name = each;
        }
        
        assertEquals("test", name);
        
    }
    
    @Test
    public void createIndicatorAddsIndicatorToList() {
        diary.createIndicator("test", 1, 5, 0, 1);
        ArrayList<Indicator> l = diary.getAllIndicators();
        Indicator i = l.get(0);
        assertEquals("test (1-5)", i.toString());
    }
    
    @Test
    public void getNamesOfAllIndicatorsReturnsRightSizeOfList() {
        diary.createIndicator("test", 1, 5, 0, 1);
        ArrayList<Indicator> testList = diary.getNamesOfAllIndicators();
        assertTrue(testList.size()==1);
    }
    
    
    @Test
    public void testIfFalseEntryDoesNotExist() {
        LocalDate date = LocalDate.of(2021, 1, 1);
        assertFalse(diary.checkIfEntryExists(date));
    }
    
 
    
    @Test
    public void checkIndicatorWorksWithRightIndicator() {
        diary.createIndicator("testIndicator", 1, 5, 0, 3);
        assertTrue(diary.checkIfIndicatorExists("testIndicator"));
    }
    
    @Test
    public void checkIndicatorWorksWithWrongIndicator() {
        assertFalse(diary.checkIfIndicatorExists("falseIndicator"));
    }
    
    @Test
    public void makeEntryReturnsTrueIfUnderCriticalValue() {
        this.diary.createIndicator("s", 0, 0, 0, 0);
        assertTrue(diary.makeEntry(testDate, indicator, 1));
        
        
    }
    
    @Test
    public void makeEntryReturnsFalseIfNotUnderCriticalValue() {
        this.diary.createIndicator("s", 0, 0, 0, 0);
        assertFalse(diary.makeEntry(testDate, indicator, 3));
        
        
    }
   
    @Test
    public void makeEntryReturnsTrueIfOverCriticalValue() {
        this.diary.createIndicator("s", 0, 0, 0, 0);
        assertTrue(diary.makeEntry(testDate, indicator2, 5));
    }
    
    @Test
    public void makeEntryReturnsFalseIfNotOverCriticalValue() {
        this.diary.createIndicator("s", 0, 0, 0, 0);
        assertFalse(diary.makeEntry(testDate, indicator2, 3));
    }
    
    
    
    
   
        
   
    
    
    
   
}
