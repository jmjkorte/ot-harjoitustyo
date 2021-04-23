
package fi.mielialapaivakirja.logics;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;


public class Diary {
    private ArrayList<Indicator> indicators;
    private ArrayList<Entry> entries;
    private Scanner scanner;
    
    public Diary() {
        this.indicators = new ArrayList();
        this.entries = new ArrayList();
        this.scanner = new Scanner(System.in);
    }
    
    public void createIndicator(String name, int min, int max, int criticalValue, int lowerOrHigher) {
        this.indicators.add(new Indicator(name, min, max, criticalValue, lowerOrHigher));
        
    }

    public ArrayList<Indicator> getIndicators() {
        return indicators;
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }
    
    public void printAllIndicators() {
        if (indicators.isEmpty()) {
            System.out.println("Indikaattoreita ei löydy.");
            return;
        }    
        for (Indicator indicator: this.indicators) {
            System.out.println(indicator.toString());
        }
    }
    
    public void printNameOfAllIndicators() {
        for (Indicator indicator: this.indicators) {
            System.out.println(indicator.getNameOfIndicator());
        }
    }
    
    public void makeEntry(LocalDate date) {
        for (Indicator indicator: this.indicators) {
            System.out.println("Anna arvo indikaattorille " + indicator.toString());
            int valueOfEntry = Integer.valueOf(scanner.nextLine());
            this.entries.add(new Entry(date, indicator, valueOfEntry));
            if (valueOfEntry < indicator.getMaxValue()) {
                System.out.println("HUOM! Antamasi arvo alittaa kriittisen arvon.");
                System.out.println("Ole tarvittaessa yhteydessä terapeuttiisi.");
            }
        }
    }
        
    public void printAllEntries() {
        for (Entry entry: this.entries) {
            System.out.println(entry.toString());
        }
    }
    
    public void printEntriesOfChosenIndicator(String name) {
        for (Entry entry: this.entries) {
            if (name.equals(entry.getIndicatorOfEntry().getNameOfIndicator())) {
                System.out.println(entry.getDateOfEntry() + " " + entry.getIndicatorOfEntry().getNameOfIndicator() + ":" + entry.getValueOfEntry());
            }
        }
    }    
        
    public void printEntriesOfChosenDate(LocalDate chosenDate) {
        for (Entry entry: this.entries) {
            if (chosenDate.equals(entry.getDateOfEntry())) {
                System.out.println(entry.getDateOfEntry() + " " + entry.getIndicatorOfEntry().getNameOfIndicator() + ":" + entry.getValueOfEntry());
            }

        }
    }
}
        
    
    
    

