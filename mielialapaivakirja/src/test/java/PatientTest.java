
import fi.mielialapaivakirja.logics.Patient;  

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PatientTest {
    
    Patient testPatient;
      
    @Before
    public void setUp() {
        testPatient = new Patient("Kallio", "Kyosti", 1900, 12, 3, "kyosti");
    }
    
    
    @Test
    public void ConstructorCreatesNameAndDateOfBirthRight() {
        Patient patient = new Patient("Ahtisaari", "Martti", 1921, 9, 10, "mara");
        assertEquals("Ahtisaari, Martti, s. 1921-09-10", patient.toString());
    }
    
    @Test
    public void ConstructorCreatesUserNameRight(){
        
        assertEquals("kyosti", testPatient.getUsername());
    }
    
    
    
   
    
}
