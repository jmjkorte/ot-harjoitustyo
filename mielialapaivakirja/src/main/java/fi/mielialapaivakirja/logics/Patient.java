
package fi.mielialapaivakirja.logics;

import java.time.*;
import java.util.ArrayList;

public class Patient {
    final String surname;
    final String firstname;
    final LocalDate dateOfBirth;
    private ArrayList<Indicator> diary; //Indikaattorit tulevat päiväkirjaan
    
    public Patient(String surName, String firstName, int year, int month, int date){
        this.surname = surName;
        this.firstname = firstName;
        this.dateOfBirth = LocalDate.of(year, month, date);
        this.diary = new ArrayList<>();
        
        }
    
    public void createIndicator(String nameOfIndicator, int minValue, int maxValue){
        this.diary.add(new Indicator(nameOfIndicator, minValue, maxValue));
    }
    
    public void printAllIndicators(){
        for(Indicator indicator : this.diary){
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
    
    public void printIndicators() { //tämä on testi
        for(Indicator indicator: diary){
            System.out.println(indicator.toString());
        }
    }

    @Override
    public String toString() {
        return surname + ", " + firstname + ", s. " + dateOfBirth;
    }
    
   
    
    

    

    
            
            
}
