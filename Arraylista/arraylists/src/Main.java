import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> asignaturas = new ArrayList<>();


        asignaturas.add("Matematicas");
        asignaturas.add("Ciencias");
        asignaturas.add("Historia");
        asignaturas.add("Inglés");
        asignaturas.add("Literatura");

        Docente primer = new Docente("Jose Alberto" , 37 , "Matematicas" , "Masculino");
        Alumno num1 = new Alumno("Martin Gomez" , 23 , "Masculino" , "1A" , asignaturas);
        primer.setAsignatura("Literatura");
        System.out.println(primer);
        System.out.println("-----------------------------------------");
        System.out.println(num1);
    }

    public  static void Introducirlista(String[] datos){



        List<String> listanombre = new ArrayList<>(Arrays.asList(datos));
        listanombre.remove("Jose");
        listanombre.add(1 , "Angel");
        System.out.println(listanombre);
        System.out.println("El tamaño del arraylist es  " + listanombre.size());

        for (int i = 0; i < listanombre.size(); i++) {
            System.out.println("En el puesto " + i + " está : " + listanombre.get(i));
        }

    }
}
