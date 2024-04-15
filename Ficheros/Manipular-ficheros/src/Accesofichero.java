import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Accesofichero {
    public static void main(String[] args) throws Exception {
        
        /*Leer_fichero acceso = new Leer_fichero();
        Escribir_fichero escritura = new Escribir_fichero();

        escritura.escribe();

        acceso.lee();*/


        /*File archivo = new File("fichero.txt");
        System.out.println(archivo.getAbsolutePath());
        System.out.println(archivo.exists());*/
       
       /* 
        File ruta = new File("./");
        String[] nombres_archivos = ruta.list();
       
        for (int i = 0; i < nombres_archivos.length; i++) {
            String nombre_archivo = nombres_archivos[i];
            System.out.println(nombre_archivo);}
            */
        
        
            /*    
             // Especificar el archivo y el directorio de destino
        File archivofuente = new File("fichero.txt");
        File directoriodestino = new File("archivoscopiados");

        // Copiar el archivo al directorio de destino
        try {

            Path fuente = Paths.get(archivofuente.toURI());
            Path destino = Paths.get(directoriodestino.toURI()).resolve(fuente.getFileName());
            Files.copy(fuente, destino);
            System.out.println("Archivo copiado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al copiar el archivo: " + e.getMessage());
        }
        */
/* 
         // Crear un nuevo directorio
        File directory = new File("creado");
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Directorio creado correctamente.");
            } else {
                System.out.println("Error al crear el directorio.");
            }
        } else {
            System.out.println("El directorio ya existe.");
        }

        // Crear un nuevo archivo dentro del directorio
        File file = new File(directory, "nuevo_archivo.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("Archivo creado correctamente.");
            } else {
                System.out.println("Error al crear el archivo.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }*/
            }
}



class Leer_fichero {

public void lee(){
   
    try{

        FileReader entrada= new FileReader("./fichero.txt");
        BufferedReader mibuffer = new BufferedReader(entrada);
        //int c= entrada.read();
        String linea = "";
        while (linea != null) {
            
            
            System.out.println(linea);
            linea= mibuffer.readLine();
        }
        entrada.close();
    }

    catch(IOException e){
        System.out.println("No se ha encontrado el archivo");
    }
}

}
class Escribir_fichero{
    public void escribe(){

    try{
        FileWriter escritura = new FileWriter("./fichero.txt");
        escritura.write("Hola mundo");
        escritura.close();

    }

    catch(IOException e){
        System.out.println("No se ha encontrado el archivo");
    }

}}