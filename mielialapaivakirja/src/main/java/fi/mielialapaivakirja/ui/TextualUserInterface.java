
package fi.mielialapaivakirja.ui;
import fi.mielialapaivakirja.logics.Logics;
import java.sql.*;
import java.util.Scanner;
import java.util.*;
public class TextualUserInterface {
    
    private Scanner scanner;
    private Logics logics;
    private String username;
    
    public TextualUserInterface(Scanner textScanner) {
        this.scanner = textScanner;
        this.logics = new Logics(this.scanner);
        
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
            int role = this.logics.check(username);
            if (role == 1){
                therapistView();

            } else if (role ==2){
                patientView();

            } else if (role ==3) {
                System.out.println("Käyttäjätunnusta ei löydy.");
                
            }

        }
    }
    
    public void therapistView(){
        System.out.println("Tervetuloa " + this.username + "!");
        while(true){
            System.out.println("Paina mitä tahansa näppäintä jatkaaksesi");
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
                logics.printAllPatients(); 
            } else if (choice ==4) {
                System.out.println("Anna potilaan sukunimi:");
                String surname = scanner.nextLine();
                System.out.println("Anna potilaan etunimi:");
                String firstname = scanner.nextLine();
                boolean patientExists = logics.choosePatient(surname, firstname);
                if (patientExists){
                    System.out.println("Potilas " + logics.getPatient() + " valittu.");
                }
                else {
                    System.out.println("Potilasta " + surname + ", " + firstname + "ei löytynyt");
                    System.out.println("Valittuna on potilas " + logics.getPatient() + ".");
                }
            } else if (choice == 5){
                logics.printAllPatients();
            } else if (choice == 6){
                System.out.println("Olet luomassa indikaattoria potilaalle " + logics.getPatient());
                System.out.println("Anna indikaattorin nimi:");
                String nameOfIndicator = scanner.nextLine();
                System.out.println("Anna indikaattorin minimiarvo:");
                int minValue = Integer.valueOf(scanner.nextLine());
                System.out.println("Anna indikaattorin maksimiarvo:");
                int maxValue = Integer.valueOf(scanner.nextLine());
                logics.newIndicator(nameOfIndicator, minValue, maxValue);
            } else if (choice == 7){
                logics.printAllIndicators();
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
        
        logics.createPatient(surName, firstName, bornYear, bornMonth, bornDate);
        
        
    }
        
    
    
    public void patientView() {
    
    
    }
    
    
    
    
   
        
    
}