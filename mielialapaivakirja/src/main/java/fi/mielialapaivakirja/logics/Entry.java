
package fi.mielialapaivakirja.logics;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Entry {
    private LocalDate dateOfEntry;
    private Indicator indicatorOfEntry;
    private int valueOfEntry;
    
    public Entry(LocalDate date, Indicator indicator, int value) {
        this.dateOfEntry = date;
        this.indicatorOfEntry = indicator;
        this.valueOfEntry = value;
    }
    

    public LocalDate getDateOfEntry() {
        return dateOfEntry;
    }

    public Indicator getIndicatorOfEntry() {
        return indicatorOfEntry;
    }

    public int getValueOfEntry() {
        return valueOfEntry;
    }

    @Override
    public String toString() {
        return "Päivämäärä: " + getDate(dateOfEntry) + ", " + indicatorOfEntry + ":" + valueOfEntry;
    }
    
    
    public String getDate(LocalDate date) {
        LocalDate today = LocalDate.now();
        String formattedDay = today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return formattedDay;
    }
    
    
    
}
