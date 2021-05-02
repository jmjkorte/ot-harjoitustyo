
package fi.mielialapaivakirja.logics;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;
import fi.mielialapaivakirja.database.IndicatorDao;
import fi.mielialapaivakirja.database.IndicatorDaoJDBC;

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
        
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstname() {
        return firstname;
    }
    
    /** Creates an new instance of the class Indicator and adds it to private ArrayList.
     * 
     * @param name  Name of an indicator.
     * @param min   Min value of an indicator.
     * @param max   Max value of an indicator.
     * @param criticalValue Critical value of an indicator.
     * @param lowerOrHigher Indicates if user is interested of lower or higher values than critical value. 
     */
    public void createIndicator(String name, int min, int max, int criticalValue, int lowerOrHigher) {
        this.indicators.add(new Indicator(name, min, max, criticalValue, lowerOrHigher));
        
        
    }

    public ArrayList<Indicator> getIndicators() {
        return indicators;
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }
    
    public void loadIndicators(Indicator indicator) {
        this.indicators.add(indicator);
    }
    
    public void loadEntries(Entry entry) {
        this.entries.add(entry);
    }
    
    /** Prints names, min values and max values of patient's indicators.
     *
     */
    public void printAllIndicators() { //muutetaan palauttavaksi metodiksi!
        if (indicators.isEmpty()) {
            System.out.println("Indikaattoreita ei löydy.");
            return;
        }    
        for (Indicator indicator: this.indicators) {
            System.out.println(indicator.toString());
        }
    }
    
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
    public void makeEntry(LocalDate date) {
        for (Indicator indicator: this.indicators) {
            System.out.println("Anna arvo indikaattorille " + indicator.toString());
            int valueOfEntry = Integer.valueOf(scanner.nextLine());
            this.entries.add(new Entry(date, indicator, valueOfEntry));
            if (valueOfEntry < indicator.getCriticalValue()) {
                System.out.println("HUOM! Antamasi arvo alittaa kriittisen arvon.");
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
        
    
    
    

