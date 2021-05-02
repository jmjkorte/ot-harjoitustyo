package fi.mielialapaivakirja.database;
import fi.mielialapaivakirja.logics.Indicator;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;


public class IndicatorDaoJDBC implements IndicatorDao {
    
    @Override
    public void create(String surname, String firstname, Indicator indicator) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:testdatabase.db");
       
        PreparedStatement stmt = conn.prepareStatement("SELECT id FROM Patients WHERE Surname=? AND Firstname=?");
        stmt.setString(1, surname);
        stmt.setString(2, firstname);
        ResultSet r = stmt.executeQuery();
        int patientId = r.getInt("id");
        
        stmt = conn.prepareStatement("INSERT INTO Indicators "
                + "(indicator, minvalue, maxvalue, patient_id)"
                + "VALUES (?, ?, ?, ?)");
        stmt.setString(1, indicator.getNameOfIndicator());
        stmt.setInt(2, indicator.getMinValue());
        stmt.setInt(3, indicator.getMaxValue());
        stmt.setInt(4, patientId);
        
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
    
    @Override
    public ArrayList<Indicator> list() throws SQLException {
        ArrayList<Indicator> list = new ArrayList();
        Connection conn = DriverManager.getConnection("jdbc:sqlite:testdatabase.db");
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Indicators");
        ResultSet rs = stmt.executeQuery();
        if (!rs.next()) {
            return null;
        }
        while (rs.next()) {
            Indicator i = new Indicator(rs.getString("indicator"), rs.getInt("minvalue"), rs.getInt("maxvalue"), 
                    rs.getInt("criticalValue"), rs.getInt("lowerOrHigher"));
            list.add(i);     
        }
        return list;
    }
}
