
package fi.mielialapaivakirja.ui;
import fi.mielialapaivakirja.logics.PatientInformationSystem;
import fi.mielialapaivakirja.logics.Patient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import strman.Strman;
import java.sql.SQLException;
public class UiPatient {
    
    private Scanner scanner;
    private Patient patient;
    private UiHelper helper;
    
    public UiPatient(Scanner scanner, PatientInformationSystem pis) {
        this.scanner = scanner;
        this.patient = pis.getPatient();
        this.helper = new UiHelper();
    }
    
    public void start() {
        System.out.println("Tervetuloa, " + this.patient.getFirstname() + " " + this.patient.getSurname() + "!");
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
            String number = (scanner.nextLine());
            if (helper.checkIfNumber(number) == false) {
                continue;
            }
            int choice = Integer.valueOf(number);

            if (choice == 0) {
                break;
            } else if (choice == 1) {
                System.out.println("Tänään on " + helper.getFormattedToday());
                System.out.println("Haluatko tehdä kirjauksen tälle päivälle (k/e)?");
                String entryForToday = scanner.nextLine();
                if (entryForToday.equals("k") || entryForToday.equals("K")) {
                    LocalDate now = LocalDate.now();
                    this.patient.diary.makeEntry(now);
                    
                }
                if (entryForToday.equals("e") || entryForToday.equals("E")){
                    this.patient.diary.makeEntry(giveDate());
                }
                    
            } else if (choice == 2) {
                System.out.println("Voit tutkia kirjauksiasi päivämäärän tai indikaattorin nimen perusteella.");
                System.out.println("Valitse seuraavista:");
                System.out.println("1 - Tarkastelu indikaattorin perusteella");
                System.out.println("2 - Tarkastelu päivämäärän perusteella");
                System.out.print("> ");
                String chosenAlternative = scanner.nextLine();
                if (chosenAlternative.equals("1")) {
                    System.out.println("Valitse seuraavista vaihtoehdoista kirjoittamalla indikaattorin nimi: ");
                    ArrayList<String> namesOfIndicators = this.patient.diary.getNamesOfAllIndicators();
                    for (String name: namesOfIndicators) {
                        System.out.println(name);
                    }
                    System.out.print("> ");
                    String chosenIndicator = scanner.nextLine();
                    this.patient.diary.printEntriesOfChosenIndicator(chosenIndicator);
                } else if (chosenAlternative.equals("2")){
                    this.patient.diary.printEntriesOfChosenDate(giveDate());
                } else {
                    System.out.println("Väärä valinta!");
                }
                
            } else if (choice == 3) {
                System.out.println("");
                this.patient.diary.printAllEntries();
                System.out.println("");
            } else if (choice == 4) {
                System.out.println("");
                this.patient.diary.printAllIndicators();
                System.out.println("");
            } else if (choice == 5) {
                System.out.println("Hyvää päivänjatkoa!");
                System.exit(0);
            } else {
                System.out.println("Väärä valinta.");
            }
        
        
        }
        
    
    
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

