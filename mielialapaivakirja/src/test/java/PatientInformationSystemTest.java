import fi.mielialapaivakirja.logics.PatientInformationSystem;
import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PatientInformationSystemTest {
   PatientInformationSystem pis; 
   
    
    @Before
    
    public void setUp() {
        Scanner scanner = new Scanner(System.in);
        pis = new PatientInformationSystem(scanner);
        pis.createPatient("Kallio", "Kyosti", 1900, 12, 3, "kyosti");
    }
    
    @Test
    public void CapitalizeWorksRight(){
        String works = pis.capitalize("wOrKiNg");
        assertEquals("Working", works);
    
    }
    
    @Test
    public void ChekReturnsRightRole(){
        assertEquals(2, pis.check("kyosti"));
    }
    
    @Test
    public void ChoosePatientWorks(){
        assertTrue(pis.choosePatient("Kallio", "Kyosti"));
    }
}
    
   
