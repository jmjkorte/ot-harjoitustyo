
package fi.mielialapaivakirja.database;

import fi.mielialapaivakirja.logics.Indicator;
import java.util.ArrayList;

public interface IndicatorDao {
    void create(String surname, String firstname, Indicator indicator);
    ArrayList<Indicator> list(String surname, String firstname);
}
