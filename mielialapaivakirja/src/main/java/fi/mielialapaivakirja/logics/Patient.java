
package fi.mielialapaivakirja.logics;

import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Patient {
    final String surname;
    final String firstname;
    final LocalDate dateOfBirth;
    final String username;
    public ArrayList<Indicator> indicators; 
    private HashMap<LocalDate, HashMap<String, Integer>> diary;
    private ArrayList<LocalDate> entriesMade;
    
    public Patient(String surName, String firstName, int year, int month, int date, String username) {
        this.surname = surName;
        this.firstname = firstName;
        this.dateOfBirth = LocalDate.of(year, month, date);
        this.username = username;
        this.indicators = new ArrayList();
        this.diary = new HashMap();
        this.entriesMade = new ArrayList();
        
    }
    
    public void createIndicator(String nameOfIndicator, int minValue, int maxValue) {
        this.indicators.add(new Indicator(nameOfIndicator, minValue, maxValue));
    }
    
    public void printAllIndicators() {
        for (Indicator indicator : this.indicators) {
            System.out.println(indicator.getNameOfIndicator() + ": minimiarvo " + indicator.getMinValue() + ", maksimiarvo " + indicator.getMaxValue());
        }
    }
    
    public void printIndicators() { //tämä on testi, lopullisessa palautus ilman printtiä
        for (Indicator indicator: indicators) {
            System.out.println(indicator.toString());
        }
    }
    
    public void makeEntry(LocalDate date, int value, int index) {
            indicators.get(index).setValue(value);
            HashMap<String, Integer> indicatorAndValue = new HashMap();
            indicatorAndValue.put(indicators.get(index).getNameOfIndicator(), value);
            diary.put(date, indicatorAndValue);
            entriesMade.add(date);
            
    }
    
    public void printDiary(){
        for (LocalDate day: this.entriesMade) {
            System.out.println(day);
            for ()
        }
    }
    
    public String getSurname() {
        return surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    public String getUsername(){
        return this.username;
    }
    
   
    

    @Override
    public String toString() {
        return surname + ", " + firstname + ", s. " + dateOfBirth;
    }
    
   
    
    

    

    
            
            
}
