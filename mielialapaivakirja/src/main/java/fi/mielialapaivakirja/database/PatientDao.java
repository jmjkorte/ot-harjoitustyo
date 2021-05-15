
package fi.mielialapaivakirja.database;
import fi.mielialapaivakirja.logics.Patient;
import java.util.*;
        

public interface PatientDao {
    void create(Patient patient);
    Patient read(String surname, String firstname);
    void archive(String surname, String firstname, int way);
    ArrayList<Patient> list(); 
    
    
}
