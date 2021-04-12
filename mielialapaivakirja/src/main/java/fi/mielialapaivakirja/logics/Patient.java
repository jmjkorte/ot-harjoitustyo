
package fi.mielialapaivakirja.logics;

import java.time.*;
import java.util.ArrayList;

public class Patient {
    final String surname;
    final String firstname;
    final LocalDate dateOfBirth;
    private ArrayList<Indicator> indicators;
    
    public Patient(String surName, String firstName, int year, int month, int date){
        this.surname = surName;
        this.firstname = firstName;
        this.dateOfBirth = LocalDate.of(year, month, date);
        this.indicators = new ArrayList<>();
        
        }
    
    public void createIndicator(String nameOfIndicator, int minValue, int maxValue){
        this.indicators.add(new Indicator(nameOfIndicator, minValue, maxValue));
    }
    
    public void printAllIndicators(){
        for(Indicator indicator : this.indicators){
            System.out.println(indicator.getNameOfIndicator() + ": minimiarvo " + indicator.getMinValue() + ", maksimiarvo " + indicator.getMaxValue());
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

    @Override
    public String toString() {
        return surname + ", " + firstname + ", s. " + dateOfBirth;
    }
    
   
    
    

    

    
            
            
}
