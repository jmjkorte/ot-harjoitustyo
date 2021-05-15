
package fi.mielialapaivakirja.logics;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Date;

/** Represents an patient.
 * 
 * 
 */
public class Patient {
    final String surname;
    final String firstname;
    final LocalDate dateOfBirth;
    
    final String username;

    /** Diary has instances of the classes Indicator and Entry.
     *
     * 
     */
    public Diary diary;
     
   
    private Patient patient;
    private PatientInformationSystem pis;

    /** Constructor for the class Patient. Creates also instance of the class Diary.
     *
     * @param surname   Surname of patient given by user.
     * @param firstname First name of patient given by user.
     * @param bornDate  Born date of patient given by user.
     * @param username  Username of patient given by user.
     */
    public Patient(String surname, String firstname, LocalDate bornDate, String username) {
        this.surname = surname;
        this.firstname = firstname;
        this.dateOfBirth = bornDate;
        this.username = username;
        this.diary = new Diary(surname, firstname);
    
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
    
    public Date getDateOfBirthAsDate() {
        Date date = Date.valueOf(dateOfBirth);
        return date;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public Diary getDiary() {
        return this.diary;
    }
    
    /**
     * Returns a String presentation of an instance without username.
     * @return surname, firstname and date of birth of an instance of the class.
     */
    @Override
    public String toString() {
        return surname + ", " + firstname + ", s. " + getFormattedDate(dateOfBirth) + ". Käyttäjätunnus: " + username;
    }
    
    private String getFormattedDate(LocalDate date) {
        String formattedDay = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return formattedDay;
    }
    
   
    
    

    

    
            
            
}
