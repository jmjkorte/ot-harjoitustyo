
package fi.janneKortemaki.main;
import fi.janneKortemaki.gui.UserInterface;
import java.util.Scanner;

public class Main {
    
       
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(scanner);
        
        ui.start();
        
    }
}