
package fi.mielialapaivakirja.database;
import fi.mielialapaivakirja.logics.Patient;
import java.sql.*;
import java.util.*;
        

public interface PatientDao {
    void create(Patient patient) throws SQLException;
    Patient read(Integer id) throws SQLException;
    //T update(T object) throws SQLException;
    void delete(Integer key) throws SQLException;
    ArrayList<Patient> list() throws SQLException; 
    
    
}
