
package fi.mielialapaivakirja.main;
import fi.mielialapaivakirja.ui.UiInit;
import java.util.Scanner;

public class Main {
    
       
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UiInit ui = new UiInit(scanner);
        
        ui.start();
        
    }
}
