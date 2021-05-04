
package fi.mielialapaivakirja.ui;
import fi.mielialapaivakirja.logics.PatientInformationSystem;
import fi.mielialapaivakirja.logics.Init;
import fi.mielialapaivakirja.database.PatientDaoJDBC;
import fi.mielialapaivakirja.database.DatabaseCreator;
import java.util.Scanner;
import strman.Strman;
import java.sql.*;
import java.io.File;



public class UiInit {
    private Scanner scanner;
    private PatientInformationSystem pis;
    private Init init;
    public UiInit(Scanner scanner) {
        this.scanner = scanner;
        this.pis = new PatientInformationSystem(scanner);
        this.init = new Init(this.scanner, this.pis);
        
    }
    public void start() throws Exception{
        
        
        init.dataBaseConnect("testdatabase.db");
        pis.createTherapist("test");
        oldUser();
        
        }
        
    

    public void oldUser() throws SQLException {
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
