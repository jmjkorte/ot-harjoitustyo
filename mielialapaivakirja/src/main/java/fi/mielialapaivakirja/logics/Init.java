
package fi.mielialapaivakirja.logics;
import fi.mielialapaivakirja.database.*;
import fi.mielialapaivakirja.logics.Diary;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/** The class has methods for initialising application.
 *
 * 
 */
public class Init {
    
    private PatientDao patientDao;
    private IndicatorDao indicatorDao;
    private EntryDao entryDao;
    private PatientInformationSystem pis;
    
    /** Constructor of a class.
     *
     * @param scanner
     * @param pis   PatientInformationSystem
     */
    public Init(Scanner scanner, PatientInformationSystem pis) {
        this.pis = pis;
        this.patientDao = new PatientDaoJDBC();
        this.indicatorDao = new IndicatorDaoJDBC();
        this.entryDao = new EntryDaoJDBC();
        
    }
    
    /** Checks if database exists. 
     *  If database exists, it calls method 'loadFromDatabase'. If database doesn't exist, method creates new database.
     */
    public void dataBaseConnect() {
        File file = new File("database.db");
        
        if (file.exists()) {
            loadFromDatabase();
        } else {
            DatabaseCreator dbc = new DatabaseCreator();
            dbc.createDatabase();
            //pis.initTestEnvironment();
        }
    }
    
    /** Loads data from database for application.
     *
     */
    public void loadFromDatabase() {
        ArrayList<Patient> patientList = patientDao.list();
        pis.loadPatients(patientList);
        for (Patient patient: patientList) { 
            ArrayList<Indicator> indicatorList = indicatorDao.list(patient.getSurname(), patient.getFirstname());
            if (indicatorList != null) {   
                patient.diary.loadIndicators(indicatorList);
                
                for (Indicator indicator: indicatorList) {
                    ArrayList<Entry> entryList = entryDao.list(patient.getSurname(), patient.getFirstname(), indicator);
                    if (entryList != null) {
                        patient.diary.loadEntries(entryList);
                    }
                }
                
            }
            
        }
    }
    
    
}
