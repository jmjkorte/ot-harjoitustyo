
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
    
    
    public void dataBaseConnect(String dbname) throws Exception {
        File file = new File(dbname);
        if (file.exists()) {
            loadFromDatabase();
        } else {
            System.out.println("Sovellus on kehitysvaiheessa.");
            System.out.println("Kun uusi tietokanta luodaan, luodaan myös testipotilaat ja testiterapeutti.");
            System.out.println("Testipotilaiden käyttäjätunnukset ovat 'kalle', 'manu', 'sale' ja 'urkki'.");
            System.out.println("Terapeutin käyttäjätunnus on 'test'.");

            DatabaseCreator dbc = new DatabaseCreator();
            dbc.createDatabase();
            pis.initTestEnvironment();
        }
    }
    
    public void loadFromDatabase() throws SQLException  {
        ArrayList<Patient> patientList = patientDao.list();
        pis.loadPatients(patientList);
        for (Patient patient: patientList) { 
            ArrayList<Indicator> indicatorList = indicatorDao.list(patient.getSurname(), patient.getFirstname());
            if (indicatorList != null) {   
                patient.diary.loadIndicators(indicatorList);
                ArrayList<Entry> entryList = new ArrayList();
            
                for (Indicator indicator: indicatorList) {
                    ArrayList<Entry> entriesByIndicator = entryDao.list(patient.getSurname(), patient.getFirstname(), indicator);
                    if (entriesByIndicator != null) {
                        for (Entry entry: entriesByIndicator) {
                            entryList.add(entry);
                        }
                    }
                }
                
            }
            
            
       
            
            
           
            
        }
    }
    
    
}
