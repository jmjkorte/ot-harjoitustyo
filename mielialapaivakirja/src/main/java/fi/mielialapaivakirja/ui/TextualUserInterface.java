
package fi.mielialapaivakirja.ui;
import fi.mielialapaivakirja.logics.PatientInformationSystem;
import fi.mielialapaivakirja.logics.Patient;
import java.sql.*;
import java.util.Scanner;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class TextualUserInterface {
    
    private Scanner scanner;
    private PatientInformationSystem patientInformationSystem;
    private String username;
    private Patient patient;
    
    public TextualUserInterface(Scanner textScanner) {
        this.scanner = textScanner;
        this.patientInformationSystem = new PatientInformationSystem(this.scanner);
        
    }
    
    public void start(){
        while(true){
            System.out.println("Tervetuloa Mielialapäiväkirja -sovellukseen.");
            System.out.println("Kirjaudu antamalla käyttäjätunnuksesi (x lopettaa ohjelman):");
             this.username = scanner.nextLine();
            if (username.equals("x")){
                System.out.println("Hyvää päivänjatkoa!");
                break;
            }
            int role = this.patientInformationSystem.check(username);
            if (role == 1){
                therapistView();

            } else if (role == 2){
                patientView();

            } else if (role == 3) {
                System.out.println("Käyttäjätunnusta ei löydy.");
                
            }

        }
    }
    
    public void therapistView(){
        this.patient = patientInformationSystem.getPatient();
        System.out.println("Tervetuloa " + this.username + "!");
        System.out.println("Tänään on " + getDate());
        while(true){
            System.out.println("Paina <Enter> jatkaaksesi");
            scanner.nextLine();
            System.out.println("Valitse seuraavista:");
            System.out.println("1 - Perusta potilas");
            System.out.println("2 - Poista potilas");
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
                start();
            } else if (choice == 1){
                newPatient();
            } else if (choice ==2) {
                System.out.println("Toimintoa ei ole vielä luotu."); 
            } else if (choice ==3) {
                patientInformationSystem.printAllPatients(); 
            } else if (choice ==4) {
                System.out.println("Anna potilaan sukunimi:");
                String surname = scanner.nextLine();
                System.out.println("Anna potilaan etunimi:");
                String firstname = scanner.nextLine();
                boolean patientExists = patientInformationSystem.choosePatient(surname, firstname);
                if (patientExists){
                    this.patient = patientInformationSystem.getPatient();
                    System.out.println("Potilas " + this.patient.toString() + " valittu.");
                }
                else {
                    System.out.println("Potilasta " + surname + ", " + firstname + "ei löytynyt");
                    System.out.println("Valittuna on potilas " + this.patient.toString() + ".");
                }
            } else if (choice == 5){
                patientInformationSystem.printAllPatients();
            } else if (choice == 6){
                System.out.println("Olet luomassa indikaattoria potilaalle " + this.patient.toString());
                System.out.println("Anna indikaattorin nimi:");
                String nameOfIndicator = scanner.nextLine();
                System.out.println("Anna indikaattorin minimiarvo:");
                int minValue = Integer.valueOf(scanner.nextLine());
                System.out.println("Anna indikaattorin maksimiarvo:");
                int maxValue = Integer.valueOf(scanner.nextLine());
                this.patient.diary.createIndicator(nameOfIndicator, minValue, maxValue);
            } else if (choice == 7){
                System.out.println(this.patient.diary.getIndicators());
            }
            
            else {
                System.out.println("Väärä valinta.");
            }
            

        }
        
        
    }

    private void  newPatient(){
        int bornYear;
        int bornMonth;
        int bornDate;
        System.out.println("Sukunimi: ");
        String surName = scanner.nextLine();
        System.out.println("Etunimi: ");
        String firstName = scanner.nextLine();
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
        
        System.out.println("Käyttäjätunnus:");
        String user = scanner.nextLine();
        
        patientInformationSystem.createPatient(surName, firstName, bornYear, bornMonth, bornDate, user);
        
        
    }
        
    
    
    public void patientView() {
        this.patient = patientInformationSystem.getPatient();
        System.out.println("Tervetuloa " + patientInformationSystem.getPatient());
        
        System.out.println("Tänään on "  + getDate());
        
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
    
    
    
    
   
        
    
}