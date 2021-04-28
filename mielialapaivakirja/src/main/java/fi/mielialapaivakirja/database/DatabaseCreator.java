
package fi.mielialapaivakirja.database;
import java.sql.*;
import java.util.*;

public class DatabaseCreator {
    final Connection db;
    public DatabaseCreator() throws SQLException {
        this.db = DriverManager.getConnection("jdbc:sqlite:testdatabase.db");
        
    }
    
    public void createDatabase() throws SQLException {
        Statement s = db.createStatement();
        s.execute("CREATE TABLE Patients (id INTEGER PRIMARY KEY, surname TEXT, firstname TEXT, username TEXT UNIQUE, dateOFBirth DATE)");
        s.execute("CREATE TABLE Indicators (id INTEGER PRIMARY KEY, indicator TEXT, minvalue INTEGER, maxvalue INTEGER, patient_id INTEGER REFERENCES Patients)");
        s.execute("CREATE TABLE Entries (id INTEGER PRIMARY KEY, value INTEGER, date DATE, patient_id REFERENCES Patients, indicator_id REFERENCES Indicators)");
        s.execute("PRAGMA foreign_keys=ON");
    }
    
    
}
