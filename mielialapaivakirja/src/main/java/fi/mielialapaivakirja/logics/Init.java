
package fi.mielialapaivakirja.logics;
import fi.mielialapaivakirja.database.DatabaseCreator;
import fi.mielialapaivakirja.database.PatientDaoJDBC;
import fi.mielialapaivakirja.database.PatientDao;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Init {
    
    private PatientDao patientDao;
    private PatientInformationSystem pis;
    
    public Init(Scanner scanner) {
        this.pis = new PatientInformationSystem(scanner);
        this.patientDao = new PatientDaoJDBC();
    }
    
    
    public void dataBaseConnect(String dbname) throws Exception {
        File file = new File(dbname);
            if (file.exists()) {
                loadPatientsFromDatabase();
        }
            else {
                System.out.println("Luodaan tietokanta");
                DatabaseCreator dbc = new DatabaseCreator();
                dbc.createDatabase();
                
            }
    }
    
    public void loadPatientsFromDatabase() throws SQLException {
         ArrayList<Patient> list = patientDao.list();
        for(Patient patient: list) {
            pis.loadPatients(patient);
        }
    }
    
    
}
