
package fi.mielialapaivakirja.main;
import fi.mielialapaivakirja.ui.UiInit;
import java.util.Scanner;
import java.sql.*;
public class Main {
    
       
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        UiInit ui = new UiInit(scanner);
        
        ui.start();
        
    }
}
