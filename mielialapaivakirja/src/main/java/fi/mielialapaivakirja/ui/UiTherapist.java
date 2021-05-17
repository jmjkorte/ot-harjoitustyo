
package fi.mielialapaivakirja.ui;
import fi.mielialapaivakirja.logics.PatientInformationSystem;
import fi.mielialapaivakirja.logics.Patient;
import fi.mielialapaivakirja.logics.Indicator;
import fi.mielialapaivakirja.logics.Entry;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;
import strman.Strman; 

public class UiTherapist {
    private UiHelper helper;
    private Scanner scanner;
    private Patient patient;
    private PatientInformationSystem pis;
    
    public UiTherapist(Scanner scanner, PatientInformationSystem pis) {
        this.scanner = scanner;
        this.helper = new UiHelper();
        this.pis = pis;
        this.patient = null;
    }
    
    public void start() {
        
        this.patient = pis.getPatient();
        System.out.println("Tervetuloa.");
        System.out.println("Tänään on " + helper.getFormattedToday());
        while(true){
            System.out.println("Paina <Enter> jatkaaksesi");
            scanner.nextLine();
            System.out.println("Valitse seuraavista:");
            System.out.println("1 - Perusta potilas");
            System.out.println("2 - Arkistoi tai palauta potilas");
            System.out.println("3 - Tulosta potilaat");
            System.out.println("4 - Valitse potilas");
            System.out.println("5 - Luo mittari");
            System.out.println("6 - Tulosta kaikki mittarit");
            System.out.println("7 - Tulosta potilaan päiväkirja");
            System.out.println("0 - Kirjaudu ulos");
            System.out.println("99 - Lopeta");
            
            System.out.print("> ");

            String number = (scanner.nextLine());
            if (helper.checkIfNumber(number) == false) {
                continue;
            }
            int choice = Integer.valueOf(number);
            

            if (choice == 99){
                System.out.println("Hyvää päivänjatkoa!");
                System.exit(0);
            } else if (choice == 0) {
                break;
            } else if (choice == 1){
                newPatient();
            } else if (choice ==2) {
                System.out.println("Haluatko arkistoida (1) vai palauttaa (2) potilaan arkistosta?");
                int archiveOrReturn = Integer.valueOf(scanner.nextLine());
                String[] patientsName = askName();
                if (archiveOrReturn == 1){
                    pis.archivePatient(patientsName[0], patientsName[1]);
                }
                else if (archiveOrReturn ==2){
                    pis.returnPatientFromArchive(patientsName[0], patientsName[1]);
                }
                
            } else if (choice ==3) {
                ArrayList<Patient> patients = pis.getPatients();
                for (Patient patient : patients) {
                    System.out.println(patient.toString());
                }
            } else if (choice ==4) {
                String username = askUsername();
                boolean patientExists = pis.choosePatient(username);
                if (patientExists){
                    this.patient = pis.getPatient();
                    System.out.println("Potilas " + this.patient.getSurname() + ", " + this.patient.getFirstname() + " valittu.");
                }
                else {
                    System.out.println("Käyttäjätunnusta " + username +  " ei löytynyt");
                    if (Objects.nonNull(this.patient)) {
                        System.out.println("Valittuna on potilas " + this.patient.toString() + ".");
                    }
                }    
            } else if (choice == 5){
                if (Objects.nonNull(this.patient)){
                    System.out.println("Olet luomassa indikaattoria potilaalle " + this.patient.getSurname() + ", " + this.patient.getFirstname());
                    System.out.println("Anna mittarin nimi:");
                    String nameOfIndicator = helper.capitalize(scanner.nextLine());
                    if (this.patient.diary.checkIfIndicatorExists(nameOfIndicator) == true) {
                        continue;
                    }
                    System.out.println("Anna mittarin minimiarvo:");
                    int minValue = Integer.valueOf(scanner.nextLine());
                    System.out.println("Anna mittarin maksimiarvo:");
                    int maxValue = Integer.valueOf(scanner.nextLine());
                    System.out.println("Haluatko luoda mittarille kriittisen arvon (K/E)?");
                    String criticalYesOrNo = scanner.nextLine().toUpperCase();
                    while (true) {
                        if (criticalYesOrNo.equals("K")){
                            while(true) {
                                System.out.println("Anna kriittinen arvo väliltä " + (minValue +1) + "-" + (maxValue -1));
                                int criticalValue = Integer.valueOf(scanner.nextLine());
                                if (criticalValue > minValue && criticalValue < maxValue) {
                                        while(true){
                                            System.out.println("Haluatko hälyytystoiminnon kriittisen arvon alittavista(1) vai ylittävistä(2) merkinnöistä?");
                                            int lowerOrHigher = Integer.valueOf(scanner.nextLine());
                                            if (lowerOrHigher != 1 && lowerOrHigher != 2) {
                                                System.out.println("Väärä valinta.");

                                                } else {
                                                this.patient.diary.createIndicator(nameOfIndicator, minValue, maxValue, criticalValue, lowerOrHigher);
                                                 break;
                                            } 
                                        } break;
                                    } break;
                                } break;    



                                } else {
                                        this.patient.diary.createIndicator(nameOfIndicator, minValue, maxValue, 1000, 1000);
                                        break;
                                }
                            }
                }
                
            } else if (choice == 6) {
                if (Objects.nonNull(this.patient)) {
                    ArrayList<Indicator>  indicators = this.patient.diary.getAllIndicators();
                    if (indicators.isEmpty()) {
                        System.out.println("Mittareita ei ole luotu.");
                        continue;
                    } else {
                        for (Indicator indicator: indicators) {
                            System.out.println(indicator.toString());
                        }
                    }        
                } else {
                    System.out.println("Potilasta ei ole valittu.");
                }    
                    
            } else if (choice == 7) {
                if (Objects.nonNull(this.patient)) {
                    ArrayList<Entry> entries = new ArrayList();
                    if (entries.isEmpty()) {
                        System.out.println("Merkintöjä ei ole luotu.");
                        continue;
                    } else {
                        for (Entry entry: entries) {
                            System.out.println(entry.toString());
                        }
                    }
                } else {
                    System.out.println("Potilasta ei ole valittu.");
                }
            }
        }    
    }
    private void  newPatient() {
        int bornYear;
        int bornMonth;
        int bornDay;
        LocalDate borndate = null;
        String[] patientsName = askName();
        while (true) {
            while (true){
                System.out.println("Syntymäaika, vuosi(yyyy):");
                bornYear = Integer.valueOf(scanner.nextLine());
                if (bornYear > 1900 && bornYear < 2010 && bornYear == (int)bornYear){
                    break;
                } else{
                    System.out.println("Virhe!");
                }
            }
            while (true){
                System.out.println("Kuukausi(mm)");
                bornMonth = Integer.valueOf(scanner.nextLine());
                if (bornMonth >= 1 && bornMonth <= 12 && bornMonth == (int)bornMonth){
                    break;
                } else {
                    System.out.println("Virhe!");
                }
            }
            while (true){
                System.out.println("Päivä(dd)");    
                bornDay = Integer.valueOf(scanner.nextLine());
                if (bornDay >=1 && bornDay < 31 && bornDay == (int)bornDay){
                    break;
                } else {
                    System.out.println("Virhe!");
                }
            }
            boolean rightDate = helper.checkDate(bornYear, bornMonth, bornDay);
            if (rightDate == false) {
                continue;
            } else {
                borndate = LocalDate.of(bornYear, bornMonth, bornDay);
            break;  
            }
        }    
        
        System.out.println("Käyttäjätunnus:");
        String patientsUsername = scanner.nextLine();
        
        pis.createPatient(patientsName[0], patientsName[1], borndate, patientsUsername);
        
    }
        public String[] askName(){

        System.out.println("Anna sukunimi: ");
        String surname = scanner.nextLine();
        surname = helper.capitalize(surname);
        System.out.println("Anna etunimi: ");
        String firstname = scanner.nextLine();
        firstname = helper.capitalize(firstname);
        String[] name = {surname, firstname};
        return name;
       }

       public String askUsername() {
           System.out.println("Anna potilaan käyttäjätunnus: ");
           String username = scanner.nextLine();
           username = username.toLowerCase();
           return username;
       }
 
    
    public LocalDate giveDate(){
        while (true) {
            LocalDate chosenDate = null;
            System.out.println("Anna vuosi: ");
            System.out.print("> ");
            int year = Integer.valueOf(scanner.nextLine());
            System.out.println("Anna kuukausi: ");
            System.out.print("> ");
            int month = Integer.valueOf(scanner.nextLine());
            System.out.println("Anna päivä: ");
            System.out.print("> ");
            int day = Integer.valueOf(scanner.nextLine());
            boolean right = helper.checkDate(year, month, day);
            if (right == false) {
                continue;
            }
            return chosenDate;
        }
    }    
    
    

    
}
