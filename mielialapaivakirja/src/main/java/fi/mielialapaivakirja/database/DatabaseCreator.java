
package fi.mielialapaivakirja.database;
import java.sql.*;

/** Class creates new SQLLite database.
 *
 * 
 */
public class DatabaseCreator {
    
    
    
    /** Creates an new SQLLite database.
     * 
     * Database consists of tables 'Patients', 'Indicators' and 'Entries'.
     */
    public void createDatabase() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqllite:testdatabase.db");
            Statement s = conn.createStatement();
            s.execute("CREATE TABLE Patients (id INTEGER PRIMARY KEY, surname TEXT, firstname TEXT, username TEXT UNIQUE, dateOFBirth DATE, archived INT)");
            s.execute("CREATE TABLE Indicators (id INTEGER PRIMARY KEY, nameOfindicator TEXT, minvalue INTEGER, maxvalue INTEGER,"
                + "criticalValue INTEGER, lowerOrHigher INTEGER, patient_id INTEGER REFERENCES Patients)");
            s.execute("CREATE TABLE Entries (id INTEGER PRIMARY KEY, value INTEGER, date DATE, patient_id INTEGER REFERENCES Patients, indicator_id INTEGER REFERENCES Indicators)");
            s.execute("PRAGMA foreign_keys=ON");
        } catch (SQLException e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }
    
    
}
