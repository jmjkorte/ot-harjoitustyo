
package fi.mielialapaivakirja.database;

import fi.mielialapaivakirja.logics.Indicator;
import java.util.ArrayList;

/** Interface for handling data from the table 'Indicators'.
 *
 * 
 */
public interface IndicatorDao {
    void create(String surname, String firstname, Indicator indicator);
    ArrayList<Indicator> list(String surname, String firstname);
}
