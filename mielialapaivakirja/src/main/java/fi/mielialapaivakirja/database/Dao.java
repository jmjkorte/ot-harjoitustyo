
package fi.mielialapaivakirja.database;
import java.sql.*;
import java.util.*;
        

public interface Dao<T, K> {
    void create(T object) throws SQLException;
    T read(K key) throws SQLException;
    //T update(T object) throws SQLException;
    void delete(K key) throws SQLException;
    ArrayList<T> list() throws SQLException; 
    
    
}
