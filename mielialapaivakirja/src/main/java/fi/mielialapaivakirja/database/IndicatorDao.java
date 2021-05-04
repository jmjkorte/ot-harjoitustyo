
package fi.mielialapaivakirja.database;

import fi.mielialapaivakirja.logics.Indicator;
import java.util.ArrayList;
import java.sql.SQLException;

public interface IndicatorDao {
    void create(String surname, String firstname, Indicator indicator) throws SQLException;
    ArrayList<Indicator> list(String surname, String firstname) throws SQLException;
}
