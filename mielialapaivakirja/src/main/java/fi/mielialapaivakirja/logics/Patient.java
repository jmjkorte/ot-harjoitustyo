
package fi.mielialapaivakirja.logics;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Date;

public class Patient {
    final String surname;
    final String firstname;
    final LocalDate dateOfBirth;
    
    final String username;
    public Diary diary;
     
   
    private Patient patient;
    private PatientInformationSystem pis;
    public Patient(String surName, String firstName, LocalDate bornDate, String username) {
        this.surname = surName;
        this.firstname = firstName;
        this.dateOfBirth = bornDate;
        this.username = username;
        this.diary = new Diary();
    
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
    
    public Date getDatePfBirthAsDate() {
        Date date = Date.valueOf(dateOfBirth);
        return date;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public Diary getDiary() {
        return this.diary;
    }
    
   
    

    @Override
    public String toString() {
        return surname + ", " + firstname + ", s. " + getFormattedDate(dateOfBirth);
    }
    
    public String getFormattedDate(LocalDate date) {
        String formattedDay = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return formattedDay;
    }
    
   
    
    

    

    
            
            
}
