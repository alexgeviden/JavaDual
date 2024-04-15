import java.sql.*;

public class Modificador_db {


    public static void insercion(String nombre, String correo, String telefono, int dep) {
        Connection miConexion = null;
        try {
            // Crear conexión
            miConexion = Abrir_conexion.obtenerConexion();

            // Deshabilitar el modo auto-commit para iniciar la transacción
            miConexion.setAutoCommit(false);

            // Llamar al procedimiento almacenado insertar_empleado
            String procedimiento = "CALL insertar_empleado(?, ?, ?, ?)";
            try (CallableStatement miStatement = miConexion.prepareCall(procedimiento)) {
                // Establecer los parámetros del procedimiento almacenado
                miStatement.setString(1, nombre);
                miStatement.setString(2, correo);
                miStatement.setString(3, telefono);
                miStatement.setInt(4, dep);

                // Ejecutar el procedimiento almacenado
                miStatement.execute();
                System.out.println("Empleado " + nombre +  " insertado correctamente");
            } catch (SQLException e) {
                // En caso de error, hacer rollback de la transacción
                miConexion.rollback();
                System.out.println("Error al insertar el empleado: " + e.getMessage());
            }

            // Confirmar la transacción
            miConexion.commit();
        } catch (SQLException e) {
            // En caso de error, lanzar una excepción
            throw new RuntimeException(e);
        } finally {
            // Cerrar la conexión
            if (miConexion != null) {
                try {
                    miConexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void Eliminar(int codigo) throws SQLException {
        Connection miConexion = null;
        try {
            // Obtener conexión y deshabilitar auto-commit
            miConexion = Abrir_conexion.obtenerConexion();
            miConexion.setAutoCommit(false);

            // Preparar la consulta de eliminación
            String consulta = "DELETE FROM Empleado WHERE id_cli=?";
            PreparedStatement miStatement = miConexion.prepareStatement(consulta);
            miStatement.setInt(1, codigo);

            // Ejecutar la consulta de eliminación
            int filasAfectadas = miStatement.executeUpdate();

            // Confirmar la transacción si la eliminación se realizó con éxito
            if (filasAfectadas > 0) {
                miConexion.commit();
                System.out.println("Empleado con código " + codigo + " eliminado correctamente");
            } else {
                System.out.println("No se encontró ningún empleado con el código " + codigo);
            }
        } catch (SQLException e) {
            // En caso de error, hacer rollback de la transacción
            if (miConexion != null) {
                miConexion.rollback();
            }
            System.out.println("Error al eliminar el empleado: " + e.getMessage());
        } finally {
            // Cerrar la conexión
            if (miConexion != null) {
                miConexion.close();
            }
        }
    }


}
