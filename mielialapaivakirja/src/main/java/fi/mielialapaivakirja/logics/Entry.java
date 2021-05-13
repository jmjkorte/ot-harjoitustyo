
package fi.mielialapaivakirja.logics;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** Class represents an entry in patient's diary.
 *
 * @author jmjkorte
 */
public class Entry {
    private LocalDate dateOfEntry;
    private Indicator indicatorOfEntry;
    private int valueOfEntry;
    
    /**
     *Constructor of the class Entry.
     * @param date  Date of an entry.
     * @param indicator Indicator which an entry concerns.
     * @param value Value of indicator in given date .
     */
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
    public Date getDateOfEntryAsDate() {
        Date date = Date.valueOf(getDateOfEntry());
        return date;
    }

    public int getValueOfEntry() {
        return valueOfEntry;
    }

    /** Represents String presentation of an instance
     *
     * @return Date, name of an indicator and value of an entry.
     */
    @Override
    public String toString() {
        return "Päivämäärä: " + getDate(dateOfEntry) + ", " + indicatorOfEntry.getNameOfIndicator() + ": " + valueOfEntry;
    }
    
    
    public String getDate(LocalDate date) {  // Tämä toiseen luokkaan.
        String formattedDay = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return formattedDay;
    }
    
    
    
}
