/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import com.mysql.cj.xdevapi.PreparableStatement;
import jakarta.resource.cci.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.*;
/**
 *
 * @author alexg
 */
public class Conexion {
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/proyecto?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String JDBC_USER="root";
    private static final String JDBC_PASS="";
    private static BasicDataSource dataSource;
    
    
public static DataSource getDataSource(){
    if (dataSource == null) {
        dataSource = new BasicDataSource(); // Inicializa dataSource si es nulo
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(JDBC_USER);
        dataSource.setPassword(JDBC_PASS);
        dataSource.setInitialSize(50);
    }
    return dataSource;
}

    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
    public static void Close(ResultSet rs){
        try {
            rs.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
        public static void Close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
                public static void Close(Connection con){
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
