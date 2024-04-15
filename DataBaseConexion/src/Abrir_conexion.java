import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Abrir_conexion {

    private static Connection conexion;

    // Método estático para obtener la conexión
    public static Connection obtenerConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Empresa", "root", "111297");
        }
        return conexion;
    }
}
