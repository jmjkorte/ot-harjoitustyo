
package fi.mielialapaivakirja.userAccount;
import java.time.LocalDate;

public class userAccount {
    private String firstname;
    private String surname;
    private LocalDate dateOfBirth;
    private String username;
    
    public userAccount(String surname, String firstname, LocalDate dateOfBirth, String username){
        this.firstname = firstname;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
    }
    
    
}
