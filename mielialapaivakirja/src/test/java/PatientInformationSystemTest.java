import fi.mielialapaivakirja.logics.PatientInformationSystem;
import fi.mielialapaivakirja.logics.Patient;
import java.time.LocalDate;
import java.time.Month;
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
    public void CheckReturnsPatient() {
        assertTrue(pis.check("kyosti"));
    }
    
    @Test
    public void CheckReturnsFalseIfPatientNotFound() {
        assertFalse(pis.check("seppo"));
    }    

    
    @Test
    public void ChoosePatientWorks() {
        assertTrue(pis.choosePatient("kyosti"));
    }
    
    @Test
    public void CreatePatientCreatesPatientRight() {
        LocalDate date = LocalDate.of(2021, 5, 16);
        pis.createPatient("Mannerheim", "Carl", date, "kalle");
        pis.choosePatient("kalle");
        assertEquals("Mannerheim, Carl, s. 16.05.2021. Käyttäjätunnus: kalle", pis.patient.toString());
    }
    
    @Test
    public void ArchivePatientRemovesPatientFromList() {
        pis.archivePatient("Kallio", "Kyosti");
        ArrayList<Patient> patients = pis.getPatients();
        assertTrue(patients.isEmpty());
    }
    
    
  
    

}    
   
    
   
