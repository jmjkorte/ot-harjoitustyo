
package fi.mielialapaivakirja.database;
import fi.mielialapaivakirja.logics.Indicator;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

/** The class handles SQL queries of indicators.
 *
 * @author jmjkorte
 */
public class IndicatorDaoJDBC implements IndicatorDao {
    
    /** Creates an indicator to database.
     *
     * @param surname   Surname of a patient.
     * @param firstname Firstname of a patient.
     * @param indicator Instance from the class Indicator.
     */
    @Override
    public void create(String surname, String firstname, Indicator indicator) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");

            PreparedStatement stmt = conn.prepareStatement("SELECT id FROM Patients WHERE Surname=? AND Firstname=?");
            stmt.setString(1, surname);
            stmt.setString(2, firstname);
            ResultSet r = stmt.executeQuery();
            int patientId = r.getInt("id");


            stmt = conn.prepareStatement("INSERT INTO Indicators "
                    + "(nameOfIndicator, minvalue, maxvalue, criticalValue, lowerOrHigher, patient_id)"
                    + "VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, indicator.getNameOfIndicator());
            stmt.setInt(2, indicator.getMinValue());
            stmt.setInt(3, indicator.getMaxValue());
            stmt.setInt(4, indicator.getCriticalValue());
            stmt.setInt(5, indicator.getLowerOrHigher());
            stmt.setInt(6, patientId);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Virehe: " + e.getMessage());
        }
    }
    
    /** Returns a list of indicators.
     *
     * @param surname   Surname of a patient.
     * @param firstname Firstname of a patient.
     * @return  An ArrayList of all entries of a patient given by parameters. 
     */
    @Override
    public ArrayList<Indicator> list(String surname, String firstname) {
        ArrayList<Indicator> list = new ArrayList();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
            PreparedStatement stmt = conn.prepareStatement("SELECT id FROM Patients WHERE surname = ? AND firstname = ?");
            stmt.setString(1, surname);
            stmt.setString(2, firstname);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                rs.close();
                stmt.close();
                conn.close();
                return null;
            }
            int patientId = rs.getInt("id");
            stmt = conn.prepareStatement("SELECT * FROM Indicators WHERE patient_id = ?");
            stmt.setInt(1, patientId);
            rs = stmt.executeQuery();
            if (!rs.next()) {
                rs.close();
                stmt.close();
                conn.close();
                return null;
            }
            while (rs.next()) {
                Indicator i = new Indicator(rs.getString("nameOfindicator"), rs.getInt("minvalue"), rs.getInt("maxvalue"), 
                        rs.getInt("criticalValue"), rs.getInt("lowerOrHigher"));
                list.add(i);     
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        return list;
    }
}
