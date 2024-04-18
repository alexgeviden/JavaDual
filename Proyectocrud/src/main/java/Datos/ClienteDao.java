

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
       private static final String sql_update = "UPDATE clientes SET Nombre = ?, Correo = ?, Tel = ? WHERE DNI LIKE ?";
    


public static void main(String[] args) {
    ClienteDao clienteDao = new ClienteDao();
    List<Cliente> listaClientes = clienteDao.listar();
    
    // Iterate over the list and print each client's information
    for (Cliente cliente : listaClientes) {
        System.out.println(cliente); // Assuming Cliente class has a meaningful toString() method
    }
}
// Resto del código de la clase ClienteDao...
 public void insertar(Cliente cliente) {
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql_insert);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getDNI());
            stmt.setString(3, cliente.getCorreo());
            stmt.setString(4, cliente.getTel());
            
            int filasAfectadas = stmt.executeUpdate();
            
            if (filasAfectadas == 0) {
                System.out.println("No se pudo insertar el cliente: " + cliente);
            } else {
                System.out.println("Cliente insertado exitosamente: " + cliente);
            }
        } catch (SQLException e) {
            // Manejo específico de excepciones de SQL
            e.printStackTrace();
        } catch (Exception e) {
            // Manejo genérico de excepciones
            e.printStackTrace();
        } finally {
            // Cierre seguro de recursos
            Conexion.Close(stmt);
            Conexion.Close(con);
        }
    }
public boolean actualizar(Cliente cliente) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
        con = Conexion.getConnection();
        stmt = con.prepareStatement(sql_update);
        stmt.setString(1, cliente.getNombre());
        stmt.setString(2, cliente.getCorreo());
        stmt.setString(3, cliente.getTel());
        stmt.setString(4, cliente.getDNI());
        
        int filasAfectadas = stmt.executeUpdate();
        
        if (filasAfectadas == 0) {
            System.out.println("No se encontró ningún cliente con el DNI: " + cliente.getDNI());
            return false;
        } else {
            System.out.println("Cliente con DNI " + cliente.getDNI() + " actualizado exitosamente.");
            return true;
        }
    } catch (SQLException e) {
        // Manejo específico de excepciones de SQL
        e.printStackTrace();
    } catch (Exception e) {
        // Manejo genérico de excepciones
        e.printStackTrace();
    } finally {
        // Cierre seguro de recursos
        Conexion.Close(stmt);
        Conexion.Close(con);
    }
        return false;
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
            System.out.println(Nombre + " " + DNI + " " + Correo + " " + Tel);
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
public void borrar(Cliente cliente) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
        con = Conexion.getConnection();
        stmt = con.prepareStatement(sql_delete);
        stmt.setString(1, cliente.getDNI());
        
        int filasAfectadas = stmt.executeUpdate();
        
        if (filasAfectadas == 0) {
            System.out.println("No se encontró ningún cliente con el DNI: " + cliente.getDNI());
        } else {
            System.out.println("Cliente con DNI " + cliente.getDNI() + " eliminado exitosamente.");
        }
    } catch (SQLException e) {
        // Manejo específico de excepciones de SQL
        e.printStackTrace();
    } catch (Exception e) {
        // Manejo genérico de excepciones
        e.printStackTrace();
    } finally {
        // Cierre seguro de recursos
        Conexion.Close(stmt);
        Conexion.Close(con);
    }
}
public Cliente buscarPorDNI(String dni) {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Cliente cliente = null;

    try {
        con = Conexion.getConnection();
        stmt = con.prepareStatement(sql_select_where);
        stmt.setString(1, dni);
        rs = stmt.executeQuery();
        
        if (rs.next()) {
            String nombre = rs.getString("Nombre");
            String correo = rs.getString("Correo");
            String tel = rs.getString("Tel");
            
            cliente = new Cliente(nombre, dni, correo, tel);
        } else {
            // Si no se encuentra ningún cliente con el DNI proporcionado, puedes devolver un valor nulo o lanzar una excepción.
            // Aquí, devolvemos null ya que no se encontró ningún cliente con el DNI especificado.
            cliente = null;
        }
    } catch (SQLException e) {
        // Manejo específico de excepciones de SQL
        e.printStackTrace(System.out);
    } catch (Exception e) {
        // Manejo genérico de excepciones
        e.printStackTrace(System.out);
    } finally {
        try {
            // Cierre seguro de recursos en el orden inverso al que se abrieron
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            // Manejo de excepciones al cerrar los recursos
            e.printStackTrace(System.out);
        }
    }
    
    return cliente;
}

   public Cliente buscar(Cliente cliente) {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        con = Conexion.getConnection();
        stmt = con.prepareStatement(sql_select_where);
        stmt.setString(1, cliente.getDNI());
        rs = stmt.executeQuery();
        
        if (rs.next()) {
            String nombre = rs.getString("Nombre");
            String correo = rs.getString("Correo");
            String tel = rs.getString("Tel");
            
            cliente.setNombre(nombre);
            cliente.setCorreo(correo);
            cliente.setTel(tel);
        } else {
            // Si no se encuentra ningún cliente con el DNI proporcionado, podrías devolver un valor nulo o lanzar una excepción.
            cliente = null;
        }
    } catch (SQLException e) {
        // Manejo específico de excepciones de SQL
        e.printStackTrace(System.out);
    } catch (Exception e) {
        // Manejo genérico de excepciones
        e.printStackTrace(System.out);
    } finally {
        try {
            // Cierre seguro de recursos en el orden inverso al que se abrieron
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            // Manejo de excepciones al cerrar los recursos
            e.printStackTrace(System.out);
        }
    }
    
    return cliente;
}
}
