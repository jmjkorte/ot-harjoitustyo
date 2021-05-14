package fi.mielialapaivakirja.database;
import fi.mielialapaivakirja.logics.Entry;
import fi.mielialapaivakirja.logics.Indicator;
 
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class EntryDaoJDBC implements EntryDao {
    
    @Override
    public void create(Entry entry, String surname, String firstname, String nameOfIndicator) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:testdatabase.db");
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
        
    }
    
    @Override
    public ArrayList<Entry> list(String surname, String firstname, Indicator indicator) throws SQLException {
        ArrayList<Entry> entries = new ArrayList();
        Connection conn = DriverManager.getConnection("jdbc:sqlite:testdatabase.db");
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
        System.out.println(indicatorId);
        System.out.println(indicator.getNameOfIndicator());
        stmt.close();
        
        stmt = conn.prepareStatement("SELECT * FROM Entries WHERE indicator_id = ?");
        stmt.setInt(1, indicatorId);
        rs = stmt.executeQuery();
        if (!rs.next()) {
            System.out.println("entryä ei löydy");
            stmt.close();
            rs.close();
            conn.close();
            return null;
        }
        do {
            System.out.println("entry löytyy");
            Date date = rs.getDate("date");
            LocalDate dateOfEntry = date.toLocalDate();
            Entry e = new Entry(dateOfEntry, indicator, rs.getInt("value"));
            entries.add(e);
        } while (rs.next());
        stmt.close();
        conn.close();
        return entries;
    }
    
/*    @Override
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
        
    }*/
    
    
}
