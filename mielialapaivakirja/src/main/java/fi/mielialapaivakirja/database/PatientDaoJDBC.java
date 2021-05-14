
package fi.mielialapaivakirja.database;
import fi.mielialapaivakirja.logics.Patient;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class PatientDaoJDBC implements PatientDao {
    
    @Override
    public void create(Patient patient) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:testdatabase.db");
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Patients(surname, firstname, username, dateOfBirth, archived) VALUES(?, ?, ?, ?, ?)");
        stmt.setString(1, patient.getSurname());
        stmt.setString(2, patient.getFirstname());
        stmt.setString(3, patient.getUsername());
        stmt.setDate(4, patient.getDateOfBirthAsDate());
        stmt.setInt(5, 0);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
    
    @Override
    public Patient read(String surname, String firstname) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:testdatabase.db");
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Patients WHERE surname = ? and firstname = ?");
        stmt.setString(1, surname);
        stmt.setString(2, firstname);
        ResultSet rs = stmt.executeQuery();
        if (!rs.next()) {
            rs.close();
            stmt.close();
            conn.close();
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
    
    @Override
    public void archive(String surname, String firstname, int way) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:testdatabase.db");
        PreparedStatement stmt = conn.prepareStatement("UPDATE Patients SET archived = ? WHERE surname = ? AND firstname = ?");
        stmt.setInt(1, way);
        stmt.setString(2, surname);
        stmt.setString(3, firstname);
        stmt.executeUpdate();
        
    }
    
    
    @Override 
    public ArrayList<Patient> list() throws SQLException {
        ArrayList<Patient> list = new ArrayList();
        Connection conn = DriverManager.getConnection("jdbc:sqlite:testdatabase.db");
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Patients WHERE archived = 0");
        ResultSet rs = stmt.executeQuery();
        if (!rs.next()) {
            return null;
        }
        do { 
            Date date = rs.getDate("dateOfBirth");
            LocalDate dateOfBirth = date.toLocalDate();
            Patient p = new Patient(rs.getString("surname"), rs.getString("firstname"), dateOfBirth, rs.getString("username"));
            list.add(p);
        } while (rs.next());  
        stmt.close();
        rs.close();
        conn.close();
        return list;
    
    }
    
}
