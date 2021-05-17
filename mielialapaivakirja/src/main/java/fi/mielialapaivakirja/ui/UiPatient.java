
package fi.mielialapaivakirja.ui;
import fi.mielialapaivakirja.logics.PatientInformationSystem;
import fi.mielialapaivakirja.logics.Patient;
import fi.mielialapaivakirja.logics.Entry;
import fi.mielialapaivakirja.logics.Indicator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import strman.Strman;
import java.sql.SQLException;
import java.time.Month;
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
                ArrayList<Indicator> indicators = this.patient.diary.getAllIndicators();
            
                LocalDate date = null;
                System.out.println("Tänään on " + helper.getFormattedToday());
                System.out.println("Haluatko tehdä kirjauksen tälle päivälle (k/e)?");
                String entryForToday = scanner.nextLine();
                if (entryForToday.equals("k") || entryForToday.equals("K")) {
                    if (this.patient.diary.checkIfEntryExists(LocalDate.now())) {
                        System.out.println("Kirjaus on jo luotu tälle päivämäärälle.");
                        continue;
                    } else {
                    date = LocalDate.now();
                    }
                } else if (entryForToday.equals("e") || entryForToday.equals("E")){
                    date = giveDate();
                    if (this.patient.diary.checkIfEntryExists(date)) {
                        System.out.println("Kirjaus on jo luotu tälle päivämäärälle.");
                        continue;
                    }
                }
                for (Indicator indicator: indicators) {
                    System.out.println("Anna arvo indikaattorille " + indicator.toString());
                    int value = Integer.valueOf(scanner.nextLine());
                    this.patient.diary.makeEntry(date, indicator, value);
                    if (this.patient.diary.makeEntry(giveDate(), indicator, value)) {
                        System.out.println("Antamasi arvo alittaa / ylittää kriittisen arvon.");
                        System.out.println("Ole tarvittaessa yhteydessä terapeuttiisi!");
                    }
                    break;
                }
                    
            } else if (choice == 2) {
                ArrayList<Entry> chosenEntries = new ArrayList();
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
                    String chosenIndicator = helper.capitalize(scanner.nextLine());
                    chosenEntries = this.patient.diary.getEntriesOfChosenIndicator(chosenIndicator);
                    for (Entry entry: chosenEntries) {
                        System.out.println(entry);
                    }
                    
                } else if (chosenAlternative.equals("2")) {
                    chosenEntries = this.patient.diary.getEntriesOfChosenDate(giveDate());
                    for (Entry entry: chosenEntries) {
                        System.out.println(entry);
                    }
                    if (chosenEntries.isEmpty()) {
                        System.out.println("Kirjausta ei löydy annetulla päivämäärällä.");
                    }
                } else {
                    System.out.println("Väärä valinta!");
                }
                
            } else if (choice == 3) {
                ArrayList<Entry> entries = this.patient.diary.getAllEntries();
                System.out.println("");
                entries.forEach((entry) -> {
                    System.out.println(entry.toString());
                });
                System.out.println("");

            } else if (choice == 4) {
                ArrayList<Indicator> indicators  = this.patient.diary.getAllIndicators();
                System.out.println("");
                indicators.forEach((indicator) -> {
                System.out.println(indicator.toString());
                });
                System.out.println("");

            } else if (choice == 99) {
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
            chosenDate = LocalDate.of(year, month, day);
            return chosenDate;
        }
    }
    
  
    
    
}

