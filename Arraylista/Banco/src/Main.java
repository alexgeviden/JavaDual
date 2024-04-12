import java.io.IOException;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
// PRUEBA DE LISTAS


        Cliente cliente1 = new Cliente("Juan Perez", "1234567890", 1000.0);
        Cliente cliente2 = new Cliente("Maria Lopez", "2345678901", 2000.0);
        Cliente cliente3 = new Cliente("Carlos Garcia", "3456789012", 3000.0);
        Cliente cliente4 = new Cliente("Ana Martinez", "4567890123", 4000.0);
        Cliente cliente5 = new Cliente("Luis Ramirez", "5678901234", 5000.0);
        Cliente cliente6 = new Cliente("Laura Gonzalez", "6789012345", 6000.0);
        Cliente cliente7 = new Cliente("Pedro Sanchez", "7890123456", 7000.0);
        Cliente cliente8 = new Cliente("Elena Rodriguez", "8901234567", 8000.0);
        Cliente cliente9 = new Cliente("Sofia Fernandez", "9012345678", 9000.0);
        Cliente cliente10 = new Cliente("Diego Gomez", "0123456789", 10000.0);
        Cliente cliente11 = new Cliente("Juan Perez", "1234567890", 1000.0);
//
//        HashSet<Cliente> clientesBanco=new HashSet<Cliente>();
//        // Agregar los objetos Cliente al HashSet
//        clientesBanco.add(cliente1);
//        clientesBanco.add(cliente2);
//        clientesBanco.add(cliente3);
//        clientesBanco.add(cliente4);
//        clientesBanco.add(cliente5);
//        clientesBanco.add(cliente6);
//        clientesBanco.add(cliente7);
//        clientesBanco.add(cliente8);
//        clientesBanco.add(cliente9);
//        clientesBanco.add(cliente10);
//
//
//        LinkedList<Cliente> cli = new LinkedList<Cliente>();
//        cli.add(cliente3);
//        cli.add(cliente4);
//        cli.add(cliente7);
//
//        System.out.println(cli.size());
//        ListIterator<Cliente> it=cli.listIterator();
//        it.next();
//        it.add(cliente6);
//        for (Cliente buclecli : cli){
//            System.out.println(buclecli.getNombre());
//        }

        // Creamos un TreeSet para almacenar los nombres , esta clase nos sirve para ver datos en un orden especifico
//        TreeSet<String> nombres = new TreeSet<>(new ComparadorLongitud());
//
//        // Agregamos algunos nombres al TreeSet
//        nombres.add("Juan");
//        nombres.add("María");
//        nombres.add("Carlos");
//        nombres.add("Ana");
//        nombres.add("Pedro");
//
//        // Imprimimos los nombres en orden alfabético
//        System.out.println("Nombres en orden alfabético:");
//        for (String nombre : nombres) {
//            System.out.println(nombre);
//        }


//        Probando el iterador
//        Iterator<Cliente> it = clientesBanco.iterator();
//        while (it.hasNext()){
//            String nombrecli= it.next().getNombre();
//            System.out.println(nombrecli);
//        }
//        for (Cliente cliente : clientesBanco) {
//            System.out.println(cliente);
//        }

//        Prueba del metodo equals
//        if (cliente1.equals(cliente11)){
//            System.out.println("Son el mismo Cliente");
//        }else {
//            System.out.println("Son distintos clientes");
//        }

        // CREAR UN MAP
        HashMap<String, Cliente> clientela = new HashMap<String , Cliente>();

        clientela.put("A01" , cliente2);
        clientela.put("B02" , cliente4);

            System.out.println(clientela);

        clientela.remove("B02");

            System.out.println(clientela);

        for (Map.Entry<String, Cliente> entry : clientela.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }

       }

    // Implementamos un comparador personalizado para ordenar las palabras por longitud
    static class ComparadorLongitud implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            // Comparamos las longitudes de las cadenas y devolvemos el resultado
            return Integer.compare(s1.length(), s2.length());
        }
    }
    }
