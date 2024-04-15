import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Mostrar el menú
            System.out.println("Menú:");
            System.out.println("1. Mostrar Datos");
            System.out.println("2. Insertar Datos");
            System.out.println("3. Eliminar Datos");
            System.out.println("4. Salir");
            System.out.print("Ingrese su elección: ");

            // Leer la opción del usuario
            int opcion = scanner.nextInt();
            scanner.nextLine();
            // Realizar una acción basada en la opción elegida
            switch (opcion) {
                case 1:
                    Conecta_Empresa.mostrar();
                    break;
                case 2:

                    // Pedir al usuario que ingrese su nombre
                    System.out.print("Ingresa tu nombre: ");
                    String nombre = scanner.nextLine();

                    // Pedir al usuario que ingrese su correo
                    System.out.print("Ingresa tu correo: ");
                    String correo = scanner.nextLine();

                    // Pedir al usuario que ingrese su teléfono
                    System.out.print("Ingresa tu teléfono: ");
                    String telefono = scanner.nextLine();

                    // Pedir al usuario que ingrese su departamento
                    System.out.print("Ingresa tu departamento: ");
                    int departamento = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer del scanner

                    Modificador_db.insercion(nombre , correo , telefono , departamento);
                    break;
                case 3:

                    // Pedir al usuario que ingrese el ID a eliminar
                    System.out.print("Ingresa el ID del empleado a eliminar: ");
                    String idString = scanner.nextLine();

                    try {
                        int id = Integer.parseInt(idString); // Convertir la cadena a entero
                        Modificador_db.Eliminar(id);
                        System.out.println("Empleado eliminado correctamente");
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Ingresa un ID válido (número entero)");
                    }
                    break;
                case 4:
                    scanner.close();
                    System.out.println("Saliendo del programa...");
                    System.exit(0); // Salir del programa
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }


        }
    }
