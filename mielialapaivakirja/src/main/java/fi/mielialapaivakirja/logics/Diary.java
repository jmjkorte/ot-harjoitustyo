
package fi.mielialapaivakirja.logics;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;
import java.sql.SQLException;
import fi.mielialapaivakirja.database.IndicatorDao;
import fi.mielialapaivakirja.database.IndicatorDaoJDBC;
import fi.mielialapaivakirja.database.EntryDao;
import fi.mielialapaivakirja.database.EntryDaoJDBC;

/** Represents an instance of Diary. 
 *  An instance of diary is created by constructor of the class Patient.
 *  Patient's diary consists of instances of the class Indicator and the class Entry.
 * @author jmjkorte
 */
public class Diary {
    private ArrayList<Indicator> indicators;
    private ArrayList<Entry> entries;
    private Scanner scanner;
    private String surname;
    private String firstname;
    private IndicatorDao indicatorDao;
    private EntryDao entryDao;
    
    
    /** Constructor of the class Diary.
     *
     */
    public Diary(String surname, String firstname) {
        this.surname = surname;
        this.firstname = firstname;
        this.indicators = new ArrayList();
        this.entries = new ArrayList();
        this.scanner = new Scanner(System.in);
        this.indicatorDao = new IndicatorDaoJDBC();
        this.entryDao = new EntryDaoJDBC();
        
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstname() {
        return firstname;
    }
    
    /** Creates an new instance of the class Indicator, adds it to private ArrayList and creates row to the database.
     * 
     * @param nameOfIndicator  Name of an indicator.
     * @param min   Min value of an indicator.
     * @param max   Max value of an indicator.
     * @param criticalValue Critical value of an indicator.
     * @param lowerOrHigher Indicates if user is interested of lower or higher values than critical value. 
     */
    public void createIndicator(String nameOfIndicator, int min, int max, int criticalValue, int lowerOrHigher) throws SQLException {
        Indicator i = new Indicator(nameOfIndicator, min, max, criticalValue, lowerOrHigher);
        this.indicators.add(i);
        this.indicatorDao.create(this.surname, this.firstname, i);
        
    }

    public ArrayList<Indicator> getIndicators() {
        return indicators;
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }
    
    /** Takes a list of indicators as parameter and adds them to private ArrayList 'indicators'.
     *
     * @param indicators
     */
    public void loadIndicators(ArrayList<Indicator> indicators) {
        for (Indicator indicator: indicators) {
            this.indicators.add(indicator);
        }
    }
    
    /** Takes a list of entries as parameter and adds them to private ArrayList 'entries'.
     *
     * @param entries   List of entries.
     */
    public void loadEntries(ArrayList<Entry> entries) {
        if (this.entries.isEmpty()) {
            System.out.println("Merkintöjä ei löytynyt.");
            return;
        }
        for (Entry entry: entries) {
            this.entries.add(entry);
        }
    }
    
    /** Prints names, min values and max values of patient's indicators.
     *
     */
    public void printAllIndicators() { //muutetaan palauttavaksi metodiksi!
        if (this.indicators.isEmpty()) {
            System.out.println("Indikaattoreita ei löydy.");
            return;
        }    
        for (Indicator indicator: this.indicators) {
            System.out.println(indicator);
            
        }
    }
    
    /** Returns names of all of patient's indicators.
     *
     * @return names of all indicators.
     */
    public ArrayList getNamesOfAllIndicators() { 
        ArrayList<String> names = new ArrayList();
        for (Indicator indicator: this.indicators) {
            names.add(indicator.getNameOfIndicator());
        }
        return names;
    }
    
    /** Constructs an new instance of the class Entry and adds it to private ArrayList.
     *
     * @param date  Date when entry is made.
     */
    public void makeEntry(LocalDate date) throws SQLException {
        for (Indicator indicator: this.indicators) {
            System.out.println("Anna arvo indikaattorille " + indicator.toString());
            int valueOfEntry = Integer.valueOf(scanner.nextLine());
            Entry e = new Entry(date, indicator, valueOfEntry);
            this.entries.add(e);
            this.entryDao.create(e, surname, firstname, indicator.getNameOfIndicator());
            
            if (indicator.getLowerOrHigher() == 1 && valueOfEntry < indicator.getCriticalValue()) {
                System.out.println("HUOM! Antamasi arvo alittaa kriittisen arvon.");
                System.out.println("Ole tarvittaessa yhteydessä terapeuttiisi.");
            } else if (indicator.getLowerOrHigher() == 2 && valueOfEntry < indicator.getCriticalValue()) {
                System.out.println("HUOM! Antamasi arvo ylittää kriittisen arvon.");
                System.out.println("Ole tarvittaessa yhteydessä terapeuttiisi.");
            }
        }
    }
        
    /** Prints all patient's entries in private ArrayList.
     *
     */
    public void printAllEntries() { //muutetaan palauttavaksi metodiksi!
        for (Entry entry: this.entries) {
            System.out.println(entry.toString());
        }
    }
    
    /** Prints all entries of chosen indicator added to private ArrayList.
     *
     * @param name  Name of an indicator.
     */
    public void printEntriesOfChosenIndicator(String name) { //muutetaan palauttavaksi metodiksi!
        for (Entry entry: this.entries) {
            if (name.equals(entry.getIndicatorOfEntry().getNameOfIndicator())) {
                System.out.println(entry.getDateOfEntry() + " " + entry.getIndicatorOfEntry().getNameOfIndicator() + ":" + entry.getValueOfEntry());
            }
        }
    }    
        
    /** Prints all entries of chosen date added to private ArrayList.
     *
     * @param chosenDate    Date when entry is made.
     */
    public void printEntriesOfChosenDate(LocalDate chosenDate) { //muutetaan palauttavaksi metodiksi!
        for (Entry entry: this.entries) {
            if (chosenDate.equals(entry.getDateOfEntry())) {
                System.out.println(entry.getDateOfEntry() + " " + entry.getIndicatorOfEntry().getNameOfIndicator() + ":" + entry.getValueOfEntry());
            }

        }
    }
}
        
    
    
    

