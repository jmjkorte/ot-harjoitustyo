
package fi.janneKortemaki.gui;
import fi.janneKortemaki.logics.Logics;
import java.sql.*;
import java.util.Scanner;
import java.util.*;
public class UserInterface {
    
    private Scanner scanner;
    private Logics logics;
    private String username;
    
    public UserInterface(Scanner textScanner) {
        this.scanner = textScanner;
        this.logics = new Logics();
        
    }
    
    public void start(){
        while(true){
            System.out.println("Tervetuloa Mielialapäiväkirja -sovellukseen.");
            System.out.println("Kirjaudu antamalla käyttäjätunnuksesi (x lopettaa ohjelman):");
             this.username = scanner.nextLine();
            if (username== "x"){
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
        while(true){
            System.out.println("Tervetuloa " + this.username + "!");
            System.out.println("Valitse seuraavista:");
            System.out.println("1 - Perusta potilas");
            System.out.println("2 - Poista potilas");
            System.out.println("3 - Tutki potilaiden tietoja");
            System.out.println("4 - Tutki tilastoja");
            System.out.println("5 - Kirjaudu ulos");
            System.out.println("99 - Lopeta");

            int choice = Integer.valueOf(scanner.nextLine());

            if (choice == 99){
                break;
            }
            else if (choice == 5) {
                start();
            }

        }
    }    
        
    
    
    public void patientView() {
    
    
    }
}