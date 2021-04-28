
package fi.mielialapaivakirja.ui;
import fi.mielialapaivakirja.logics.PatientInformationSystem;
import fi.mielialapaivakirja.database.PatientDao;
import fi.mielialapaivakirja.database.DatabaseCreator;
import java.util.Scanner;
import strman.Strman;
import java.sql.*;



public class UiInit {
    private Scanner scanner;
    private PatientInformationSystem pis;
    
    public UiInit(Scanner scanner) {
        this.scanner = scanner;
        this.pis = new PatientInformationSystem(scanner);
    }
    public void start() throws SQLException{
        
        System.out.println("Tervetuloa Mielialapäiväkirja -sovellukseen.");
        System.out.println("Sinulla on mahdollisuus kirjautua sovellukseen testikäyttäjänä, ");
        System.out.println("jolloin potilastietojärjestelmään on luotu testiterapeutti(username: 'test' ja ");
        System.out.println("viisi testipotilasta:(usernames: 'kalle', 'urkki', 'manu', 'sale' , 'tarja'");
        System.out.println("HUOM! Tässä vaiheessa sovelluskehitystä on tärkeää, että uloskirjautumisen");
        System.out.println("jälkeen et kirjaudu sovellukseen enää uudelleen testikäyttäjänä.");
        while (true) {
            System.out.println("Haluatko kirjautua testikäyttäjänä (K/E)? (X lopettaa sovelluksen)");
            String testUser = scanner.nextLine().toUpperCase();
            if (testUser.equals("K")) {
                pis.initTestEnvironment();
                oldUser();
            } else if (testUser.equals("E")) {
                System.out.println("Onko sinulle luotu käyttäjätunnus Mielialapäiväkirjaan(K/E)?");
                String hasUsername = scanner.nextLine().toUpperCase();
                if (hasUsername.equals("K")) {
                    oldUser();
                } else if (testUser.equals("E")) {
                    newUser();
                } else if (testUser.equals("X")) {
                    System.exit(0);
                }
            } else {
                System.out.println("Väärä valinta.");
            }
        }
    }

    public void oldUser() {
        System.out.println("Kirjaudu antamalla käyttäjätunnuksesi ('x' lopettaa ohjelman):");
        String username = scanner.nextLine().toLowerCase();
        if (username.equals("x")) {
            System.out.println("Hyvää päivänjatkoa!");
            System.exit(0);
        }
        int role = this.pis.check(username);
        if (role == 1) {
            UiTherapist uiT = new UiTherapist(this.scanner, pis);
            uiT.start();

        } else if (role == 2) {
            UiPatient uiP = new UiPatient(this.scanner, pis);
            uiP.start();

        } else if (role == 3) {
            System.out.println("Käyttäjätunnusta ei löydy.");

        }
    }

    public void newUser() {
        while (true) {
            System.out.println("Oletko terapeutti, joka on kirjautumassa sovellukseen ensimmäistä kertaa(K/E)?");
            String areYouTherapist = scanner.nextLine().toUpperCase();
            if (areYouTherapist.equals("K")) {
                System.out.println("Luo käyttäjätunnus:");
                String username = scanner.nextLine().toLowerCase();
                pis.createTherapist(username);
                break;
            } else if (areYouTherapist.equals("E")) {
                System.out.println("Mikäli olet potilas ja sinulla ei ole käyttäjätunnuksia, ");
                System.out.println("on sinun oltava yhteydessä terapeuttiisi tunnusten luomiseksi.");
                System.exit(0);
            } else {
                System.out.println("Väärä valinta.");
            }     
        }
    }
       
}
