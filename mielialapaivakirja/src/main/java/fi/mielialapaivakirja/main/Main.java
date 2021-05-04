
package fi.mielialapaivakirja.main;
import fi.mielialapaivakirja.ui.UiInit;
import java.util.Scanner;
import java.sql.*;
import java.io.File;
public class Main {
    
       
    public static void main(String[] args) throws SQLException, Exception {
        Scanner scanner = new Scanner(System.in);
        UiInit ui = new UiInit(scanner);
        
        ui.start();
        
    }
}
