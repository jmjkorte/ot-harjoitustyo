package fi.mielialapaivakirja.ui;

import fi.mielialapaivakirja.logics.PatientInformationSystem;
import fi.mielialapaivakirja.logics.Init;
import fi.mielialapaivakirja.database.PatientDaoJDBC;
import fi.mielialapaivakirja.database.DatabaseCreator;
import java.util.Scanner;
import strman.Strman;
import java.sql.*;
import java.io.*;

public class UiInit {

    private Scanner scanner;
    private PatientInformationSystem pis;
    private Init init;

    public UiInit(Scanner scanner) {
        this.scanner = scanner;
        this.pis = new PatientInformationSystem(scanner);
        this.init = new Init(this.scanner, this.pis);

    }

    public void start() {

        init.dataBaseConnect("testdatabase.db");

        while (true) {
            System.out.println("Haluatko kirjautua potilaana (1) vai terapeuttina (2)?");
            System.out.println("'x' lopettaa sovelluksen.");
            System.out.print("> ");
            String choice = scanner.nextLine();
            if (choice.equals("X") || choice.equals("x")) {
                System.out.println("Hyvää päivänjatkoa!");
                System.exit(0);
            } else if (!choice.equals("1") && !choice.equals("2")) {
                System.out.println("Väärä valinta!");
            } else if (choice.equals("1"))  {
                System.out.println("Kirjaudu antamalla käyttäjätunnuksesi ('x' lopettaa ohjelman):");
                System.out.print("> ");
                String username = scanner.nextLine().toLowerCase();
                if (username.equals("x")) {
                    System.out.println("Hyvää päivänjatkoa!");
                    System.exit(0);
                }
                if (this.pis.check(username)) {
                    UiPatient uiP = new UiPatient(this.scanner, pis);
                    uiP.start();
            
                } else {    
                    System.out.println("Käyttäjätunnusta ei löydy.");
                }
    
            } else if (choice.equals("2")) {
                UiTherapist uiT = new UiTherapist(this.scanner, pis);
                uiT.start();
            }
            
        }

    }
   
}
