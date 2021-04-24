
import fi.mielialapaivakirja.logics.Patient;  

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;
import java.time.Month;
import static org.junit.Assert.*;


public class PatientTest {
    
    Patient testPatient;
      
    @Before
    public void setUp() {
        LocalDate bornDate = LocalDate.of(1920, 3, 1);
        testPatient = new Patient("Kallio", "Kyosti", bornDate, "kyosti");
        
    }
    
    
    @Test
    public void ConstructorCreatesNameAndDateOfBirthRight() {
        LocalDate secondBornDate = LocalDate.of(1921, 9, 10);
        Patient patient = new Patient("Ahtisaari", "Martti", secondBornDate, "mara");
        assertEquals("Ahtisaari, Martti, s. 10.09.1921", patient.toString());
    }
    
    @Test
    public void ConstructorCreatesUserNameRight(){
        
        assertEquals("kyosti", testPatient.getUsername());
    }
    
    
    
   
    
}
