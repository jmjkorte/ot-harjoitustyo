
package fi.mielialapaivakirja.logics;
import fi.mielialapaivakirja.logics.Patient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import strman.Strman;


public class Logics {
    private HashMap<String, Integer> userRoles;
    private ArrayList<Patient> patients;
    
    private Scanner scanner;
    private Patient patient;
    
    
    public Logics(Scanner scanner) {
        this.userRoles = new HashMap();
        this.patients = new ArrayList<>();
        userRoles.put("test", 1);
        userRoles.put("testPatient", 2);
        initTestEnvironment();
    }
    
   
    
    public int check(String username){
        if (userRoles.containsKey(username) && userRoles.get(username) == 1){
            return 1;
        }
        if (userRoles.containsKey(username) && userRoles.get(username) == 2){
            return 2;
        }
        return 3;
    }
    
    public void createPatient(String surname, String firstname, int bornYear, int bornMonth, int bornDay){
        patients.add(new Patient(capitalize(surname), capitalize(firstname), bornYear, bornMonth, bornDay));
        Collections.sort(patients, Comparator.comparing(Patient::getSurname));
        System.out.println("Potilas luotu onnistuneesti.");
        
        
    }
    
    public void printAllPatients(){
        for(int i=0; i < patients.size();i++){
            System.out.println(patients.get(i).getSurname() + " " + patients.get(i).getFirstname() + " " + patients.get(i).getDateOfBirth());
        }
    }
    
    public boolean choosePatient(String surname, String firstname){
        surname = capitalize(surname);
        firstname = capitalize(firstname);
        
        for(Patient person : patients){
            if (person.getFirstname().equals(firstname) && person.getSurname().equals(surname)){
                this.patient = person;
                return true;
            }
            
        }
        return false;
    }
    
    
    public void newIndicator(String nameOfIndicator, int minValue, int maxValue) {
        this.patient.createIndicator(nameOfIndicator, minValue, maxValue);
    
}
    public String getPatient(){
        return this.patient.getSurname() + " " + this.patient.getFirstname();
    
}
    public void printAllIndicators(){
        this.patient.printAllIndicators();
    }
    
     private void initTestEnvironment(){
        patients.add(new Patient("Kiesilä", "Kalle", 1980, 10, 10));
        patients.add(new Patient("Kekkonen", "Urho-Kaleva", 1910, 7, 1));
        patients.add(new Patient("Koivisto", "Mauno-Henrik", 2001, 12, 12));
        patients.add(new Patient("Niinistö", "Sauli", 1951, 12, 4));
        patients.add(new Patient("Halonen", "Tarja", 1990, 11, 1));
        Collections.sort(this.patients, Comparator.comparing(Patient::getSurname));
    }
     
    private String capitalize(String name){
        if(name.contains("-")){
            String[] parts = name.split("-");
            String part1 = Strman.capitalize(parts[0]);
            String part2 = Strman.capitalize(parts[1]);
            String capName = part1 + "-" + part2;
            return capName;
        }
       String capName = Strman.capitalize(name);
       return capName;
    }
       
        
        
    
}
