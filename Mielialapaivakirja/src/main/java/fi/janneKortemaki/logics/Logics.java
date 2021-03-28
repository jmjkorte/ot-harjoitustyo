
package fi.janneKortemaki.logics;
import java.util.ArrayList;
import java.util.HashMap;

public class Logics {
    private HashMap<String, Integer> userRoles;
    
    public Logics() {
        this.userRoles = new HashMap();
        userRoles.put("testTherapist", 1);
        userRoles.put("testPatient", 2);
    }
    
   
    
    public int check(String username){
        if (userRoles.containsKey(username) && userRoles.get(username) == 1){
            return 1;
        }
        if (userRoles.containsKey(username) && userRoles.get(username) == 2){
            return 2;
        }
        return 3;
    }
}
