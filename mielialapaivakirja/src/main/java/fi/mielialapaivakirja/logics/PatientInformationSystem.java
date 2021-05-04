
package fi.mielialapaivakirja.logics;
import fi.mielialapaivakirja.database.DatabaseCreator;
import fi.mielialapaivakirja.database.PatientDaoJDBC;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import strman.Strman;


public class PatientInformationSystem {
    private HashMap<String, Integer> userRoles;
    private ArrayList<Patient> patients;
    private ArrayList<Patient> archive;
    private PatientDaoJDBC patientDao;
    private Scanner scanner;
    public Patient patient;
    
    
    public PatientInformationSystem(Scanner scanner) {
        this.userRoles = new HashMap();
        this.patients = new ArrayList<>();
        this.archive = new ArrayList<>();
        this.patientDao = new PatientDaoJDBC();
        
    }
    
   
    
    public int check(String username) {
        if (userRoles.containsKey(username) && userRoles.get(username) == 1) {
            return 1;
        }
        if (userRoles.containsKey(username) && userRoles.get(username) == 2) {
            for (Patient person : this.patients) {
                if (person.getUsername().equals(username)) {
                    this.patient = person;
                    break;
                }
            }
            return 2;
        }
        return 3;
    }
    
    public void createTherapist(String username) {
        this.userRoles.put(username, 1);
    }
    
    public void createPatient(String surname, String firstname, LocalDate bornDate, String username) throws SQLException  {
        Patient p = new Patient(surname, firstname, bornDate, username);
        this.patients.add(p);
        this.patientDao.create(p);
        userRoles.put(username, 2);
        Collections.sort(patients, Comparator.comparing(Patient::getSurname));
        System.out.println("Potilas luotu onnistuneesti.");
        
        
    }
    
    public void loadPatients(ArrayList<Patient> patients) {
        for (Patient patient: patients) {
            this.patients.add(patient);
            this.userRoles.put(patient.getUsername(), 2);
        }
    }
    
    public void printAllPatients() {
        for (int i = 0; i < patients.size(); i++) {
            System.out.println(patients.get(i).getSurname() + " " + patients.get(i).getFirstname() + ", s. " + getFormattedDate(patients.get(i).getDateOfBirth()));
        }
    }
    
    public boolean choosePatient(String surname, String firstname) {
       
        for (Patient person : patients) {
            if (person.getFirstname().equals(firstname) && person.getSurname().equals(surname)) {
                this.patient = person;
                return true;
            } 
        }
        System.out.println("Potilasta ei löytynyt.");        
        return false;
    }
    
    public void archivePatient(String  surname, String firstname) {
        Patient found = null;
        for (Patient person : patients) {
            if (person.getFirstname().equals(firstname) && person.getSurname().equals(surname)) {
                found = person;               
            }    
        }
        if (Objects.nonNull(found)) {
            this.archive.add(found);
            this.patients.remove(found);
        } else {
            System.out.println("Potilasta ei löytynyt.");
        }
        
        if (this.patient == patient) {
            this.patient = null;
        }
    }
    
    public void returnPatientFromArchive(String surname, String firstname) {
        Patient found = null;
        for (Patient person : archive) {
            if (person.getFirstname().equals(firstname) && person.getSurname().equals(surname)) {
                found = person;
            }
        } 
        if (Objects.nonNull(found)) {
            this.archive.remove(found);
            this.patients.add(found);
            Collections.sort(this.patients, Comparator.comparing(Patient::getSurname));
        } else {
            System.out.println("Potilasta ei löytynyt.");
        }
        
    }
    
    
   
    public Patient getPatient() {
        return this.patient;
    
    }
    
    public void initTestEnvironment() throws SQLException {
        patients.add(new Patient("Kiesila", "Kalle", LocalDate.of(1980, 10, 10), "kalle"));
        userRoles.put("kalle", 2);
        patients.add(new Patient("Kekkonen", "Urho-Kaleva", LocalDate.of(1910, 7, 1), "urkki"));
        userRoles.put("urkki", 2);
        patients.add(new Patient("Koivisto", "Mauno-Henrik", LocalDate.of(2001, 12, 12), "manu"));
        userRoles.put("manu", 2);
        patients.add(new Patient("Niinisto", "Sauli", LocalDate.of(1951, 12, 4), "sale"));
        userRoles.put("sale", 2);
        patients.add(new Patient("Halonen", "Tarja", LocalDate.of(1990, 11, 1), "tarja"));
        userRoles.put("tarja", 2);
        userRoles.put("test", 1);
        Collections.sort(this.patients, Comparator.comparing(Patient::getSurname));
        choosePatient("Koivisto", "Mauno-Henrik");
        for (Patient patient: this.patients) {
            patientDao.create(patient);
        }
        this.patient.diary.createIndicator("Surullisuus", 0, 5, 1, 1);
        this.patient.diary.createIndicator("Aktiivisuus", 0, 10, -1, -1);
        ArrayList<Patient> list = patientDao.list();
    }
    
    public String getFormattedDate(LocalDate date) { //siirretään metodi toiseen luokkaan
        
        String formattedDay = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return formattedDay;
    }
     
   
    
    
       
        
        
    
}
