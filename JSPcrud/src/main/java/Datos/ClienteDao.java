

package Datos;

import Dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexg
 */
public class ClienteDao {
    
    private static final String sql_select = "Select * from clientes";
    private static final String sql_select_where ="Select * from clientes where DNI like '?'";
    private static final String sql_insert ="insert into clientes (Nombre , DNI , Correo , Tel) values (?,?,?,?)";
    private static final String sql_delete = "delete from clientes where DNI LIKE ?";
    


public static void main(String[] args) {
    ClienteDao clienteDao = new ClienteDao();
    List<Cliente> listaClientes = clienteDao.listar();
    
    // Iterate over the list and print each client's information
    for (Cliente cliente : listaClientes) {
        System.out.println(cliente); // Assuming Cliente class has a meaningful toString() method
    }
}

public List<Cliente> listar() {
    
    List<Cliente> clientes = new ArrayList<>();
    try (Connection con = Conexion.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql_select);
            ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            String DNI = rs.getString("DNI");
            String Nombre = rs.getString("Nombre");
            String Correo = rs.getString("Correo");
            String Tel = rs.getString("Tel");
            clientes.add(new Cliente(Nombre, DNI, Correo, Tel));
            
        }
    } catch (SQLException e) {
        // Manejo específico de excepciones de SQL
        e.printStackTrace();
        // Podrías lanzar una excepción personalizada aquí si lo deseas
    } catch (Exception e) {
        // Manejo genérico de excepciones
        e.printStackTrace();
    }
    return clientes;
}

    public Cliente buscar(Cliente cliente){
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        
     
        try {
            con=Conexion.getConnection();
            stmt=con.prepareStatement(sql_select_where);
            stmt.setString(1, cliente.getDNI());
            rs=stmt.executeQuery();
            rs.next();
              
                String Nombre = rs.getString("Nombre");
                String Correo = rs.getString("Correo");
                String Tel = rs.getString("Tel");
                
                
                cliente.setNombre(Nombre);
                cliente.setCorreo(Correo);
                cliente.setTel(Tel);
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally{
            Conexion.Close((jakarta.resource.cci.ResultSet) rs);
            Conexion.Close(con);
            Conexion.Close(stmt);
        }
        
        
        
        return cliente;
    }
}
