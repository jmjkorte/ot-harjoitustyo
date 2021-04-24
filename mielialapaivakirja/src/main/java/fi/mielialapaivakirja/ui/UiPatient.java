
package fi.mielialapaivakirja.ui;
import fi.mielialapaivakirja.logics.PatientInformationSystem;
import fi.mielialapaivakirja.logics.Patient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import strman.Strman;
public class UiPatient {
    
    private Scanner scanner;
    private Patient patient;
    
    public UiPatient(Scanner scanner, PatientInformationSystem pis) {
        this.scanner = scanner;
        this.patient = pis.getPatient();
    }
    
    public void start(){
         while (true){
            
            System.out.println("Paina <Enter> jatkaaksesi.");
            scanner.nextLine();
            System.out.println("Valitse seuraavista:");
            System.out.println("1 - Tee kirjaus päiväkirjaan");
            System.out.println("2 - Tarkastele päiväkirjaa");
            System.out.println("3 - Tulosta päiväkirja");
            System.out.println("4 - Tulosta mittarit");
            System.out.println("0 - Kirjaudu ulos");
            System.out.println("99 - Lopeta");

            System.out.print("> ");
            String patientsChoice = scanner.nextLine();

            if (patientsChoice.equals("0")) {
                start();
            } else if (patientsChoice.equals("1")) {
                System.out.println("Tänään on " + LocalDate.now());
                System.out.println("Haluatko tehdä kirjauksen tälle päivälle (k/e)?");
                String entryForToday = scanner.nextLine();
                if (entryForToday.equals("k") || entryForToday.equals("K")) {
                    LocalDate now = LocalDate.now();
                    this.patient.diary.makeEntry(now);
                    
                }
                if (entryForToday.equals("e") || entryForToday.equals("E")){
                    this.patient.diary.makeEntry(setDate());
                }
                    
            } else if (patientsChoice.equals("2")) {
                System.out.println("Voit tutkia kirjauksiasi päivämäärän tai indikaattorin nimen perusteella.");
                System.out.println("Valitse seuraavista:");
                System.out.println("1 - Tarkastelu indikaattorin perusteella");
                System.out.println("2 - Tarkastelu päivämäärän perusteella");
                System.out.print("> ");
                int chosenAlternative = Integer.valueOf(scanner.nextLine());
                if (chosenAlternative == 1){
                    System.out.println("Valitse seuraavista vaihtoehdoista kirjoittamalla indikaattorin nimi: ");
                    this.patient.diary.printNameOfAllIndicators();
                    System.out.print("> ");
                    String chosenIndicator = scanner.nextLine();
                    this.patient.diary.printEntriesOfChosenIndicator(chosenIndicator);
                } else if (chosenAlternative == 2){
                    this.patient.diary.printEntriesOfChosenDate(setDate());
                    
                    
                }
                
            } else if (patientsChoice.equals("3")) {
                this.patient.diary.printAllEntries();
            } else if (patientsChoice.equals("4")) {
                this.patient.diary.printAllIndicators();
            } else if (patientsChoice.equals("99")) {
                System.out.println("Hyvää päivänjatkoa!");
                System.exit(0);
            } else {
                System.out.println("Väärä valinta.");
            }
        
        
        }
        
    
    
    }
    
    public String getDate(){
        LocalDate today = LocalDate.now();
        String formattedDay = today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
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
    
    public String[] askName(){
        
        System.out.println("Anna sukunimi: ");
        String surname = capitalize(scanner.nextLine());
        System.out.println("Anna etunimi: ");
        String firstname = capitalize(scanner.nextLine());
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
    
    
    
}

