package fi.mielialapaivakirja.database;
import fi.mielialapaivakirja.logics.Entry;
import fi.mielialapaivakirja.logics.Indicator;
import java.util.*;

/** Interface for handling data from the table 'Entries'.
 *
 * 
 */
public interface EntryDao {
    void create(Entry entry, String surname, String firstname, String nameofIndicator);
    ArrayList<Entry> list(String surname, String firstname, Indicator indicator);
}