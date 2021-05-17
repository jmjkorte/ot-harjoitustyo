package fi.mielialapaivakirja.database;
import fi.mielialapaivakirja.logics.Entry;
import fi.mielialapaivakirja.logics.Indicator;
 
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

/** The class handles SQL queries of entries.
 *
 *
 */
public class EntryDaoJDBC implements EntryDao {
    
    /** Creates an entry to database.
     *
     * @param entry     Instance from the class Entry.
     * @param surname   Surname of a patient.
     * @param firstname Firstname of a patient.
     * @param nameOfIndicator   Name of an indicator.
     */
    @Override
    public void create(Entry entry, String surname, String firstname, String nameOfIndicator)  {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
            PreparedStatement stmt = conn.prepareStatement("SELECT id FROM Patients WHERE Surname=? AND Firstname=?");
            stmt.setString(1, surname);
            stmt.setString(2, firstname);
            ResultSet r = stmt.executeQuery();
            int patientId = r.getInt("id");
            stmt = conn.prepareStatement("SELECT id FROM Indicators WHERE nameOfIndicator=?");
            stmt.setString(1, nameOfIndicator);
            r = stmt.executeQuery();
            int indicatorId = r.getInt("id");
            stmt = conn.prepareStatement("INSERT INTO Entries(value, date, patient_id, indicator_id) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, entry.getValueOfEntry());
            stmt.setDate(2, entry.getDateOfEntryAsDate());
            stmt.setInt(3, patientId);
            stmt.setInt(4, indicatorId);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Virhe:" + e.getMessage());
        }
        
    }
    
    /** Returns a list of entries.
     *
     * @param surname   Surname of a patient.
     * @param firstname Firstname of a patient.
     * @param indicator Instance from the class Indicator.
     * @return  An ArrayList of all entries with given parameters.
     */
    @Override
    public ArrayList<Entry> list(String surname, String firstname, Indicator indicator) {
        ArrayList<Entry> entries = new ArrayList();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
            PreparedStatement stmt = conn.prepareStatement("SELECT id FROM Patients WHERE Surname=? AND Firstname=?");

            stmt.setString(1, surname);
            stmt.setString(2, firstname);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                return null;
            }
            int patientId = rs.getInt("id");

            stmt = conn.prepareStatement("SELECT id FROM Indicators WHERE nameOfIndicator = ?");
            stmt.setString(1, indicator.getNameOfIndicator());
            rs = stmt.executeQuery();
            if (!rs.next()) {

                return null;
            }
            int indicatorId = rs.getInt("id");
            stmt.close();

            stmt = conn.prepareStatement("SELECT * FROM Entries WHERE indicator_id = ?");
            stmt.setInt(1, indicatorId);
            rs = stmt.executeQuery();
            if (!rs.next()) {
                stmt.close();
                rs.close();
                conn.close();
                return null;
            }
            do {
                Date date = rs.getDate("date");
                LocalDate dateOfEntry = date.toLocalDate();
                Entry e = new Entry(dateOfEntry, indicator, rs.getInt("value"));
                entries.add(e);
            } while (rs.next());
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Virhe: " + e.getMessage());
        } return entries;
    }
       
}
