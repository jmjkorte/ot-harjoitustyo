
package fi.janneKortemaki.logics;
import fi.janneKortemaki.logics.Patient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Logics {
    private HashMap<String, Integer> userRoles;
    private ArrayList<Patient> patients;
    private Scanner scanner;
    
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
        patients.add(new Patient(surname, firstname, bornYear, bornMonth, bornDay));
        //Miten sortataan aakkosjärjestykseen?
        System.out.println("Potilas luotu onnistuneesti.");
        
        
    }
    
    public void printAllPatients(){
        for(int i=0; i < patients.size();i++){
            System.out.println(patients.get(i).getSurname() + " " + patients.get(i).getFirstname() + " " + patients.get(i).getDateOfBirth());
        }
    }
    
     private void initTestEnvironment(){
        patients.add(new Patient("Kiesilä", "Kalle", 1980, 10, 10));
        patients.add(new Patient("Kekkonen", "Urho-Kaleva", 1910, 7, 1));
        patients.add(new Patient("Koivisto", "Mauno-Henrik", 2001, 12, 12));
        patients.add(new Patient("Niinistö", "Sauli", 1951, 12, 4));
        patients.add(new Patient("Halonen", "tarja", 1990, 11, 1));
    }
       
        
        
    
}
