
package fi.mielialapaivakirja.database;
import fi.mielialapaivakirja.logics.Patient;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;


public class PatientDaoJDBC implements PatientDao {
    
    @Override
    public void create(Patient patient) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:testdatabase.db");
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Patients "
                + " (surname, firstname, username, dateOfBirth)"
                + " VALUES(?, ?, ?, ?)");
        stmt.setString(1, patient.getSurname());
        stmt.setString(2, patient.getFirstname());
        stmt.setString(3, patient.getUsername());
        stmt.setDate(4, patient.getDatePfBirthAsDate());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
    
    @Override
    public Patient read(Integer key) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:testdatabase.db");
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Asiakas WHERE id = ?");
        stmt.setInt(1, key);
        ResultSet rs = stmt.executeQuery();
        if (!rs.next()) {
            return null;
        }
        
        Date date = rs.getDate("dateOfBirth");
        LocalDate dateOfBirth = date.toLocalDate();
        
        Patient p = new Patient(rs.getString("surname"), rs.getString("firstname"), dateOfBirth, rs.getString("username"));
        stmt.close();
        rs.close();
        conn.close();
        
        return p;
        
    }
    
    //@Override
    //public Patient update(Integer key) {
        //toteutetaan myöhemmin
    //    return null;
    //}
    
    @Override 
    public void delete(Integer key){
        //toteutetaan myöhemmin
    }
    
    @Override 
    public ArrayList<Patient> list() throws SQLException {
        ArrayList<Patient> list = new ArrayList();
        Connection conn = DriverManager.getConnection("jdbc:sqlite:testdatabase.db");
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Patients");
        ResultSet rs = stmt.executeQuery();
        if (!rs.next()) {
            return null;
        }
        while (rs.next()) {
            Date date = rs.getDate("dateOfBirth");
            LocalDate dateOfBirth = date.toLocalDate();
            Patient p = new Patient(rs.getString("surname"), rs.getString("firstname"), dateOfBirth, rs.getString("username"));
            list.add(p);
                
        }
        stmt.close();
        rs.close();
        conn.close();

    return list;
    
    }
    
}
