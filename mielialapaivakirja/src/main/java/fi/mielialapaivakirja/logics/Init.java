
package fi.mielialapaivakirja.logics;
import fi.mielialapaivakirja.database.*;
import fi.mielialapaivakirja.logics.Diary;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Init {
    
    private PatientDao patientDao;
    private IndicatorDao indicatorDao;
    private EntryDao entryDao;
    private PatientInformationSystem pis;
    
    public Init(Scanner scanner, PatientInformationSystem pis) {
        this.pis = pis;
        this.patientDao = new PatientDaoJDBC();
        this.indicatorDao = new IndicatorDaoJDBC();
        this.entryDao = new EntryDaoJDBC();
        
    }
    
    
    public void dataBaseConnect(String dbname) {
        File file = new File(dbname);
        
        if (file.exists()) {
            loadFromDatabase();
        } else {
            DatabaseCreator dbc = new DatabaseCreator();
            dbc.createDatabase();
            
            //pis.initTestEnvironment();
        }
    }
    
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
