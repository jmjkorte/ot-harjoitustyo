package fi.mielialapaivakirja.database;
import fi.mielialapaivakirja.logics.Entry;
import fi.mielialapaivakirja.logics.Indicator;
import java.sql.*;
import java.util.*;

        

public interface EntryDao {
    void create(Entry entry, String surname, String firstname, String nameofIndicator) throws SQLException;
    ArrayList<Entry> list(String surname, String firstname, Indicator indicator) throws SQLException;
    //T update(T object) throws SQLException;
   // void delete(K key) throws SQLException;
   // ArrayList<T> list() throws SQLException; 
    
    
}