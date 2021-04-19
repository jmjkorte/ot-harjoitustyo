
package fi.mielialapaivakirja.logics;

import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Patient {
    final String surname;
    final String firstname;
    final LocalDate dateOfBirth;
    final String username;
    public Diary diary;
     
   
    
    public Patient(String surName, String firstName, int year, int month, int date, String username) {
        this.surname = surName;
        this.firstname = firstName;
        this.dateOfBirth = LocalDate.of(year, month, date);
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
    
    public String getUsername() {
        return this.username;
    }
    
    public Diary getDiary() {
        return this.diary;
    }
    
   
    

    @Override
    public String toString() {
        return surname + ", " + firstname + ", s. " + dateOfBirth;
    }
    
   
    
    

    

    
            
            
}
