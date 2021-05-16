
package fi.mielialapaivakirja.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import strman.Strman;
import java.util.*;

public class UiHelper {
    
    private Scanner scanner;
    
    public UiHelper() {
        this.scanner = new Scanner(System.in);
    }

    
    public String capitalize(String name) {
        if (name.contains("-")) {
            String[] parts = name.split("-");
            String part1 = Strman.capitalize(parts[0]);
            String part2 = Strman.capitalize(parts[1]);
            String capName = part1 + "-" + part2;
            return capName;
        }
        String capName = Strman.capitalize(name);
        return capName;
    }
    
    public String getFormattedToday(){
        LocalDate today = LocalDate.now();
        String formattedDay = today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return formattedDay;
    }
    
    public String getFormattedDate(LocalDate date) {
        String formattedDay = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return formattedDay;
    }
    
    public boolean checkDate(int year, int month, int day) {
        try {
            LocalDate chosenDate = LocalDate.of(year, month, day);
            return true;
            } catch (Exception e) {
                System.out.println("Virheellinen päivämäärä!");
            }
        return false;
    }
    
    public boolean checkIfNumber(String number) {
        try {
            int value = Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Väärä valinta!");
            return false;
        }
    }
}


