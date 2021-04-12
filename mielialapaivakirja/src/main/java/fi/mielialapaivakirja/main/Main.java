
package fi.mielialapaivakirja.main;
import fi.mielialapaivakirja.ui.TextualUserInterface;
import java.util.Scanner;

public class Main {
    
       
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        TextualUserInterface ui = new TextualUserInterface(scanner);
        
        ui.start();
        
    }
}
