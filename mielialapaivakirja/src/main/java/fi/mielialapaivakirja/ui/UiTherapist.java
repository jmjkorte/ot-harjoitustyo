
package fi.mielialapaivakirja.ui;
import fi.mielialapaivakirja.logics.PatientInformationSystem;
import fi.mielialapaivakirja.logics.Patient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Objects;
import strman.Strman;

public class UiTherapist {
    private Scanner scanner;
    private Patient patient;
    private PatientInformationSystem pis;
    
    public UiTherapist(Scanner scanner, PatientInformationSystem pis) {
        this.scanner = scanner;
        this.pis = pis;
        this.patient = null;
    }
    
    public void start(){
        
        this.patient = pis.getPatient();
        System.out.println("Tervetuloa.");
        System.out.println("Tänään on " + getFormattedTodday());
        while(true){
            System.out.println("Paina <Enter> jatkaaksesi");
            scanner.nextLine();
            System.out.println("Valitse seuraavista:");
            System.out.println("1 - Perusta potilas");
            System.out.println("2 - Arkistoi tai palauta potilas");
            System.out.println("3 - Tulosta potilaat");
            System.out.println("4 - Valitse potilas");
            System.out.println("5 - Tulosta kaikkien potilaiden tiedot");
            System.out.println("6 - Luo indikaattori");
            System.out.println("7 - Tulosta kaikki indikaattorit");
            System.out.println("0 - Kirjaudu ulos");
            System.out.println("99 - Lopeta");
            
            System.out.print("> ");

            int choice = Integer.valueOf(scanner.nextLine());

            if (choice == 99){
                System.out.println("Hyvää päivänjatkoa!");
                System.exit(0);
            } else if (choice == 0) {
                break;
            } else if (choice == 1){
                newPatient();
            } else if (choice ==2) {
                System.out.println("Haluatko arkistoida(1) vai palauttaa(2) potilaan arkistosta?");
                int archiveOrReturn = Integer.valueOf(scanner.nextLine());
                String[] patientsName = askName();
                System.out.println(patientsName[1]);
                if (archiveOrReturn == 1){
                    pis.archivePatient(patientsName[0], patientsName[1]);
                }
                if (archiveOrReturn ==2){
                    pis.returnPatientFromArchive(patientsName[0], patientsName[1]);
                }
                
            } else if (choice ==3) {
                pis.printAllPatients(); 
            } else if (choice ==4) {
                String[] patientsName = askName();
                boolean patientExists = pis.choosePatient(patientsName[0], patientsName[1]);
                if (patientExists){
                    this.patient = pis.getPatient();
                    System.out.println("Potilas " + this.patient.toString() + " valittu.");
                }
                else {
                    System.out.println("Potilasta " + (patientsName[0]) + ", " + patientsName[1] + " ei löytynyt");
                    System.out.println("Valittuna on potilas " + this.patient.toString() + ".");
                }
            } else if (choice == 5){
                pis.printAllPatients();
            } else if (choice == 6){
                if (Objects.nonNull(this.patient)){
                    System.out.println("Olet luomassa indikaattoria potilaalle " + this.patient.toString());
                    System.out.println("Anna indikaattorin nimi:");
                    String nameOfIndicator = scanner.nextLine();
                    System.out.println("Anna indikaattorin minimiarvo:");
                    int minValue = Integer.valueOf(scanner.nextLine());
                    System.out.println("Anna indikaattorin maksimiarvo:");
                    int maxValue = Integer.valueOf(scanner.nextLine());
                    System.out.println("Haluatko luoda indikaattorille kriittisen arvon (K/E)?");
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
                                        System.out.println("Kriittinen arvo ei ole välillä " + minValue + "-" + maxValue + ".");
                                        System.out.println("");
                                        break;
                                }
                            }
                
            } else if (choice == 7){
                System.out.println(this.patient.diary.getIndicators());
            }
            
            else {
                System.out.println("Väärä valinta.");
            }
            

        }
        }    
        
    }

    private void  newPatient(){
        int bornYear;
        int bornMonth;
        int bornDate;
        String[] patientsName = askName();
        while(true){
            System.out.println("Syntymäaika, vuosi(yyyy):");
            bornYear = Integer.valueOf(scanner.nextLine());
            if (bornYear > 1900 && bornYear < 2010 && bornYear == (int)bornYear){
                break;
            } else{
                System.out.println("Virhe!");
            }
        }
        
        
        while(true){
            System.out.println("Kuukausi(mm)");
            bornMonth = Integer.valueOf(scanner.nextLine());
            if (bornMonth >= 1 && bornMonth <= 12 && bornMonth == (int)bornMonth){
                break;
            } else {
                System.out.println("Virhe!");
            }
        }
        while(true){
        System.out.println("Päivä(dd)");    
        bornDate = Integer.valueOf(scanner.nextLine());
         if (bornDate >=1 && bornDate < 31 && bornDate == (int)bornDate){
                break;
            } else {
                System.out.println("Virhe!");
            }
        }
        LocalDate borndate = LocalDate.of(bornYear, bornMonth, bornDate);
        
        System.out.println("Käyttäjätunnus:");
        String patientsUsername = scanner.nextLine();
        
        pis.createPatient(patientsName[0], patientsName[1], borndate, patientsUsername);
        
        
    
        
    }
        public String[] askName(){
        
        System.out.println("Anna sukunimi: ");
        String surname = scanner.nextLine();
        surname = capitalize(surname);
        System.out.println("Anna etunimi: ");
        String firstname = scanner.nextLine();
        firstname = capitalize(firstname);
        String[] name = {surname, firstname};
        return name;
       }
    
    public String capitalize(String name) {
        if (name.contains("-")) {
            String[] parts = name.split("-");
            String part1 = Strman.capitalize(parts[0]);
            String part2 = Strman.capitalize(parts[1]);
            String capName = part1 + "-" + part2;
            return capName;
        }
        String capName = Strman.capitalize(name);
        return capName;
    }
    public String getFormattedTodday(){
            LocalDate today = LocalDate.now();
        String formattedDay = today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return formattedDay;
    }
    
    public String getFormattedDate(LocalDate date) {
        String formattedDay = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return formattedDay;
    }
    
    public LocalDate setDate(){
         System.out.println("Anna vuosi: ");
        System.out.print("> ");
        int year = Integer.valueOf(scanner.nextLine());
        System.out.println("Anna kuukausi: ");
        System.out.print("> ");
        int month = Integer.valueOf(scanner.nextLine());
        System.out.println("Anna päivä: ");
        System.out.print("> ");
        int day = Integer.valueOf(scanner.nextLine());
        LocalDate chosenDate = LocalDate.of(year, month, day);
        return chosenDate;
    }
    
}
