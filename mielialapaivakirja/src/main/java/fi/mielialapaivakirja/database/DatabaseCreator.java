
package fi.mielialapaivakirja.database;
import java.sql.*;
import java.util.*;

/** Class creates new SQLLite database.
 *
 * 
 */
public class DatabaseCreator {
    final Connection conn;
    public DatabaseCreator() throws SQLException {
        this.conn = DriverManager.getConnection("jdbc:sqlite:testdatabase.db");
        
    }
    
    /** Creates an new SQLLite database.
     * 
     * Database consists of tables 'Patients', 'Indicators' and 'Entries'.
     * @throws SQLException
     */
    public void createDatabase() throws SQLException {
        Statement s = conn.createStatement();
        s.execute("CREATE TABLE Patients (id INTEGER PRIMARY KEY, surname TEXT, firstname TEXT, username TEXT UNIQUE, dateOFBirth DATE)");
        s.execute("CREATE TABLE Indicators (id INTEGER PRIMARY KEY, nameOfindicator TEXT, minvalue INTEGER, maxvalue INTEGER,"
                + "criticalValue INTEGER, lowerOrHigher INTEGER, patient_id INTEGER REFERENCES Patients)");
        s.execute("CREATE TABLE Entries (id INTEGER PRIMARY KEY, value INTEGER, date DATE, patient_id REFERENCES Patients, indicator_id REFERENCES Indicators)");
        s.execute("PRAGMA foreign_keys=ON");
        
    }
    
    
}
