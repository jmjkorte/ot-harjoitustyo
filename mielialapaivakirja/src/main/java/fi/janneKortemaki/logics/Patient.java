
package fi.janneKortemaki.logics;

import java.time.*;

public class Patient {
    final String surname;
    final String firstname;
    final LocalDate dateOfBirth;
    
    public Patient(String surName, String firstName, int year, int month, int date){
        this.surname = surName;
        this.firstname = firstName;
        this.dateOfBirth = LocalDate.of(year, month, date);
        
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
        return "Patient{" + "sukunimi=" + surname + ", etunimi=" + firstname + ", syntymäaika=" + dateOfBirth + '}';
    }
    
   
    
    

    

    
            
            
}
