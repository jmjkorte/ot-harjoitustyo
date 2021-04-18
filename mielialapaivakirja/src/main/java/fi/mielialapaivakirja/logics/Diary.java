
package fi.mielialapaivakirja.logics;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;


public class Diary {
    private ArrayList<Indicator> indicators;
    private ArrayList<Entry> entries;
    private Scanner scanner;
    
    public Diary(){
        this.indicators = new ArrayList();
        this.entries = new ArrayList();
        this.scanner = new Scanner(System.in);
    }
    
    public void createIndicator(String name, int min, int max) {
        this.indicators.add(new Indicator(name, min, max));
        
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
        for (Indicator indicator: this.indicators){
            System.out.println(indicator.toString());
        }
    }
    
    public void makeEntry(LocalDate date){
        for(Indicator indicator: this.indicators){
            System.out.println("Anna arvo indicaattorille " + indicator.toString());
            int valueOfEntry = Integer.valueOf(scanner.nextLine());
            this.entries.add(new Entry(date, indicator, valueOfEntry));
        }
    }
        
    public void printAllEntries(){
        for(Entry entry: this.entries){
            System.out.println(entry.toString());
        }
    }
        
    
    
    
}
