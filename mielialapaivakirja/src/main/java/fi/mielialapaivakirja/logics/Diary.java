
package fi.mielialapaivakirja.logics;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;
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
     * @param lowerOrHigher Indicates if user is interested of lower(1) or higher(2) values than critical value. 
     */
    public void createIndicator(String nameOfIndicator, int min, int max, int criticalValue, int lowerOrHigher) {
    
            Indicator i = new Indicator(nameOfIndicator, min, max, criticalValue, lowerOrHigher);
            this.indicators.add(i);
            this.indicatorDao.create(this.surname, this.firstname, i);
            
    }
    
    /** Checks if indicator with given name exists in private ArrayList 'indicators'.
     *
     * @param name  Name of indicator
     * @return  True if indicator exists, false if doesn't exist.
     */
    public boolean checkIfIndicatorExists(String name) {
        for (Indicator indicator: this.indicators) {
            if (indicator.getNameOfIndicator().equals(name)) {
                return true;
            }
        }
        return false;
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
        for (Entry entry: entries) {
            this.entries.add(entry);
        }
    }
    
    /** Returns ArrayList of patient's indicators.
     *
     */
    public ArrayList<Indicator> getAllIndicators() { //muutetaan palauttavaksi metodiksi!   
        return this.indicators;
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
    public boolean makeEntry(LocalDate date, Indicator indicator, int value) {
        if (this.indicators.isEmpty()) {
            return false;
        }
        Entry e = new Entry(date, indicator, value);
        this.entries.add(e);
        this.entryDao.create(e, surname, firstname, indicator.getNameOfIndicator());    
        if (indicator.getLowerOrHigher() == 1 && value < indicator.getCriticalValue()) {
            return true;
        } else if (indicator.getLowerOrHigher() == 2 && value > indicator.getCriticalValue()) {
            return true;
        }
        return false;        
    }    
      
    /** Checks if entry with given date exists in private ArrayList 'entries'.
     *
     * @param date  Date of entry.
     * @return  true if entry exists, false if it doesn't exist.
     */
    public boolean checkIfEntryExists(LocalDate date) {
        for (Entry entry: this.entries) {
            if (entry.getDateOfEntry().equals(date)) {
                return true;
            }
        }
        return false;
    }
        
    /** Returns all patient's entries as ArrayList.
     *
     * @return ArryList of all patient's entries.
     */
    public ArrayList getAllEntries() {
        return this.entries;
    }
    
    /** Returns all entries of chosen indicator added to private ArrayList.
     *
     * @param name  Name of an indicator.
     * @return ArrayList of chosen entries.
     */
    public ArrayList<Entry> getEntriesOfChosenIndicator(String name) { 
        ArrayList<Entry> chosenEntries = new ArrayList();
        for (Entry entry: entries) {
            if (entry.getIndicatorOfEntry().getNameOfIndicator().equals(name)) {
                chosenEntries.add(entry);
            }
        }
        return chosenEntries;
    }    
        
    /** Prints all entries of chosen date added to private ArrayList.
     *
     * @param chosenDate    Date when entry is made.
     * @return  ArrayList of chosen entries.
     */
    public ArrayList getEntriesOfChosenDate(LocalDate chosenDate) {
        ArrayList<Entry> chosenEntries = new ArrayList();
        this.entries.stream().filter((entry) -> (chosenDate.equals(entry.getDateOfEntry()))).forEachOrdered((entry) -> {
            chosenEntries.add(entry);
        });
        return chosenEntries;
    }
}
        
    
    
    

