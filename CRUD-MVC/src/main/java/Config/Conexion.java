package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author a925660
 */
public class Conexion {

    private static Connection conexion;

    // Método estático para obtener la conexión
    public static Connection obtenerConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "");
        }
        return conexion;
    }
    
}
