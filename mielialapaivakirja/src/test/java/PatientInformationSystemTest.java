import fi.mielialapaivakirja.logics.PatientInformationSystem;
import java.time.LocalDate;
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
        LocalDate bornDate = LocalDate.of(1920, 3, 1);
        pis.createPatient("Kallio", "Kyosti", bornDate, "kyosti");
    }
    
    @Test
    public void CapitalizeWorksRight(){
        String works = pis.capitalize("wOrKiNg");
        assertEquals("Working", works);
    
    }
    
    @Test
    public void ChekReturnsRightRoleToPatient(){
        assertEquals(2, pis.check("kyosti"));
    }
    
    @Test
    public void ChoosePatientWorks(){
        assertTrue(pis.choosePatient("Kallio", "Kyosti"));
    }
    
    @Test
   
    }
}
    
   
