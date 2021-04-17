
package fi.mielialapaivakirja.userAccount;
import java.time.LocalDate;

public class UserAccount {
    private String firstname;
    private String surname;
    private LocalDate dateOfBirth;
    private String username;
    private int role;
    
    public UserAccount(String surname, String firstname, LocalDate dateOfBirth, String username, int role) {
        this.firstname = firstname;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.role = role;
    }
    
    
}
