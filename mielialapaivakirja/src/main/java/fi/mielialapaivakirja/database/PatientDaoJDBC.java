
package fi.mielialapaivakirja.database;
import fi.mielialapaivakirja.logics.Patient;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

/**Handles SQL queries of patients.
 *
 * 
 */
public class PatientDaoJDBC implements PatientDao {
    
    @Override
    public void create(Patient patient) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Patients(surname, firstname, username, dateOfBirth, archived) VALUES(?, ?, ?, ?, ?)");
            stmt.setString(1, patient.getSurname());
            stmt.setString(2, patient.getFirstname());
            stmt.setString(3, patient.getUsername());
            stmt.setDate(4, patient.getDateOfBirthAsDate());
            stmt.setInt(5, 0);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }    
    
    /** Returns an instance of the class Patient.
     *
     * @param surname   Surname of a patient.
     * @param firstname Firstname of a patient.
     * @return  New instance of the class Patient.
     */
    @Override
    public Patient read(String surname, String firstname) {
        Patient p = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
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

            p = new Patient(rs.getString("surname"), rs.getString("firstname"), dateOfBirth, rs.getString("username"));
            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        return p;
        
    }
    
    /** Sets a right value to a coloumn 'archived' to a patient.
     *
     * @param surname   Surname of a patient.
     * @param firstname Firstname of a patient.
     * @param way    0 = not archived patient, 1 = archived patient
     */
    @Override
    public void archive(String surname, String firstname, int way) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
            PreparedStatement stmt = conn.prepareStatement("UPDATE Patients SET archived = ? WHERE surname = ? AND firstname = ?");
            stmt.setInt(1, way);
            stmt.setString(2, surname);
            stmt.setString(3, firstname);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }
    
    /** Returns a list of patients.
     *
     * @return all the patients from the database.
     */
    @Override 
    public ArrayList<Patient> list() {
        ArrayList<Patient> list = new ArrayList();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
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
        } catch (SQLException e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        return list;
    
    }
    
}
