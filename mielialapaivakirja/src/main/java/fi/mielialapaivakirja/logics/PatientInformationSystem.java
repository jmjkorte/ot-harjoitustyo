
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

/** Represents patient information system which records personal data of the patients.
 *
 * 
 */
public class PatientInformationSystem {
    private HashMap<String, Integer> userRoles;
    private ArrayList<Patient> patients;
    private PatientDaoJDBC patientDao;
    private Scanner scanner;

    /** Instance of the class Patient.
     *
     */
    public Patient patient;
    
    /** Comstructor of the class.
     *
     * @param scanner
     */
    public PatientInformationSystem(Scanner scanner) {
        this.userRoles = new HashMap();
        this.patients = new ArrayList<>();
        this.patientDao = new PatientDaoJDBC();
        
    }
    
    /** Checks if patient / therapist has valid username.
     *
     * @param username
     * @return 1 if username with therapist status,
     * 2 if username with patient status,
     * 3 if username not found.
     */
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
    
    /** Creates a new therapist.
     *
     * @param username
     */
    public void createTherapist(String username) {
        this.userRoles.put(username, 1);
    }
    
    /** Creates a patient
     * 
     * Method creates an instance of the class Patient and adds it to private ArrayList 'patients'.
     * The patient is also added to database table 'Patients'.
     * @param surname   Surname of a patient. 
     * @param firstname Firstname of a patient.
     * @param bornDate  Borndate of a patient.
     * @param username  Userna,e of a patient.
     * @throws SQLException
     */
    public void createPatient(String surname, String firstname, LocalDate bornDate, String username) throws SQLException  {
        Patient p = new Patient(surname, firstname, bornDate, username);
        this.patients.add(p);
        this.patientDao.create(p);
        userRoles.put(username, 2);
        Collections.sort(patients, Comparator.comparing(Patient::getSurname));
        System.out.println("Potilas luotu onnistuneesti.");
        
        
    }
    
    /** Takes a list of patients as parameter and adds them to private ArrayList 'patients'.
     *
     * @param patients
     */
    public void loadPatients(ArrayList<Patient> patients) {
        for (Patient patient: patients) {
            this.patients.add(patient);
            this.userRoles.put(patient.getUsername(), 2);
        }
    }
    
    /** Prints all the patients in private ArrayList 'patients'.
     *
     */
    public void printAllPatients() {
        for (int i = 0; i < patients.size(); i++) {
            System.out.println(patients.get(i).getSurname() + " " + patients.get(i).getFirstname() + ", s. " + getFormattedDate(patients.get(i).getDateOfBirth()));
        }
    }
    
    /** Changes the value of private variable 'patient'.
     *
     * @param surname   Surname of a patient.
     * @param firstname Firstname of a patient.
     * @return
     */
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
    
    /** Adds patient to private ArrayList 'archive' and removes it from private ArrayList 'patients'.
     *
     * @param surname   Surname of a patient.
     * @param firstname Firstname of a patient.
     */
    public void archivePatient(String  surname, String firstname) throws SQLException {
        Patient found = null;
        for (Patient person : patients) {
            if (person.getFirstname().equals(firstname) && person.getSurname().equals(surname)) {
                found = person;               
            }    
        }
        if (Objects.nonNull(found)) {
            this.patients.remove(found);
            patientDao.archive(found.getSurname(), found.getFirstname(), 1);
        } else {
            System.out.println("Potilasta ei löytynyt.");
        }
        
        if (this.patient == patient) {
            this.patient = null;
        }
    }
    
    /** Adds patient to private ArrayList 'patients' and removes it from private ArrayList 'archive'.
     *
     * @param surname
     * @param firstname
     */
    public void returnPatientFromArchive(String surname, String firstname) throws SQLException {
                
        patientDao.archive(surname, firstname, 0);
        this.patients.add(patientDao.read(surname, firstname));
        
    }
    
    
    
   
    public Patient getPatient() {
        return this.patient;
    
    }
    
    /** Creates patients for test purposes.
     *
     * @throws SQLException
     */
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
    
    private String getFormattedDate(LocalDate date) { 
        
        String formattedDay = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return formattedDay;
    }
     
   
    
    
       
        
        
    
}
