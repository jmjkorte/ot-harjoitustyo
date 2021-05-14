
package fi.mielialapaivakirja.database;
import fi.mielialapaivakirja.logics.Patient;
import java.sql.*;
import java.util.*;
        

public interface PatientDao {
    void create(Patient patient) throws SQLException;
    Patient read(String surname, String firstname) throws SQLException;
    void archive(String surname, String firstname, int way) throws SQLException;
    ArrayList<Patient> list() throws SQLException; 
    
    
}
