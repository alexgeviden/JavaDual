/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Web;

import Datos.ClienteDao;
import Dominio.Cliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 *
 * @author alexg
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             List<Cliente> listaClientes = new ClienteDao().listar(); // Método para obtener la lista de clientes
            request.setAttribute("clientes", listaClientes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Clientes.jsp");
            dispatcher.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Recibir el parámetro de acción del cliente (editar, eliminar, insertar, etc.)
    String action = request.getParameter("action");

    if (null != action) // Si la acción es editar, redirigir a una página de edición
        switch (action) {
        
            case "editar":
                    String dniEditar = request.getParameter("dni"); 
                    // Obtener el cliente correspondiente al DNI
                    Cliente clienteEditar = new ClienteDao().buscarPorDNI(dniEditar);
                    // Añadir el cliente al request como atributo
                    request.setAttribute("cliente", clienteEditar);
                    // Redirigir a la página de edición
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarCliente.jsp");
                    dispatcher.forward(request, response);



              
                break;
                   case "update": {
                    // Obtener los parámetros del formulario de edición
                    String nombre = request.getParameter("nombre");
                    String dni = request.getParameter("dni");
                    String correo = request.getParameter("correo");
                    String tel = request.getParameter("tel");

                    // Crear un objeto Cliente con los nuevos datos
                    Cliente clienteActualizado = new Cliente(nombre, dni, correo, tel);

                    // Llamar al método de actualización en ClienteDao
                    boolean actualizacionExitosa = new ClienteDao().actualizar(clienteActualizado);

                    if (actualizacionExitosa) {
                        // Si la actualización fue exitosa, redirigir a la página de clientes
                        response.sendRedirect(request.getContextPath() + "/index.jsp");
                    } else {
                        // Si la actualización falló, redirigir a una página de error o volver a la página de edición
                        response.sendRedirect(request.getContextPath() + "/editar-cliente.jsp?dni=" + dni);
                    }
                    break;
                }



            case "eliminar":{
                 String dni = request.getParameter("dni");
                Cliente cliente = new Cliente();
                cliente.setDNI(dni);
                new ClienteDao().borrar(cliente);
               dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
                    // Si no hay returnUrl, redirigir a una página predeterminada
                 
                
                    break;
                }
            case "insertar":{
                String nombre = request.getParameter("nombre");
                String dni = request.getParameter("dni");
                String correo = request.getParameter("correo");
                String tel = request.getParameter("tel");
                Cliente cliente = new Cliente(nombre, dni, correo, tel);
                new ClienteDao().insertar(cliente);
                 // Redirigir al usuario de vuelta a la página anterior
               dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
                    // Si no hay returnUrl, redirigir a una página predeterminada
                  
                
                    break;
                }
            default:
                break;
        }

    // Redirigir de vuelta a la página de clientes después de realizar la acción
                RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
}

    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
