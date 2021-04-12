/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import fi.mielialapaivakirja.logics.Patient;  
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jmjkorte
 */
public class PatientTest {
    
    public PatientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ConstructorCreatesNameAndDateOfBirthRight() {
        Patient patient = new Patient("Ahtisaari", "Martti", 1921, 9, 10);
        assertEquals("Ahtisaari, Martti, s. 1921-09-10", patient.toString());
    }
}
