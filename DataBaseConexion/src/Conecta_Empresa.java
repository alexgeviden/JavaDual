import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conecta_Empresa {


    public static void mostrar(){
        try{
            //CREAR CINEXION
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Empresa" , "root" , "111297");
            // Crear Statement
            Statement miStatement = miConexion.createStatement();
            // EJECUTAR SQL
            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM vista_empleados_departamentos");

            // Imprimir encabezados de las columnas
            System.out.println("ID\tNombre\tCorreo\tTelefono\tDepartamento");

            // Recorrer el ResultSet y mostrar los datos
            while (miResultSet.next()) {
                int id = miResultSet.getInt("id_cli");
                String nombre = miResultSet.getString("Nombre");
                String correo = miResultSet.getString("Correo");
                String telefono = miResultSet.getString("telefono");
                String departamento = miResultSet.getString("nombre_departamento");

                System.out.println(id + "\t" + nombre + "\t" + correo + "\t" + telefono + "\t" + departamento);
            }
        }

        catch(Exception e){

            System.out.println("Error en la conexion SQL // Mostrar");
        }
    }

}
