import java.util.ArrayList;
import java.util.Scanner;

public class Alumno extends Persona{

    String curso;
    ArrayList<String> asignaturas;

    public Alumno(String nom, int edad, String genero , String curso , ArrayList<String> asignaturas ) {

        super(nom, edad, "Alumno", genero);

        while (edad>18){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce una Edad correcta menos de 18 años");

            edad = Integer.parseInt(scanner.nextLine());
            this.edad = edad;
        }

        this.curso = curso;
        this.asignaturas = asignaturas;
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public int getEdad() {
        return super.getEdad();
    }

    @Override
    public String getTipo() {
        return super.getTipo();
    }

    public String getCurso() {
        return curso;
    }

    public ArrayList<String> getAsignaturas(){
    return  this.asignaturas;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "curso='" + curso + '\'' +
                "} " + super.toString() + ", Asignaturas : " + this.asignaturas;
    }

    public void setAsignaturas(ArrayList<String> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public void setTipo(String tipo) {
        super.setTipo(tipo);
    }

    @Override
    public void setSexo(String sexo) {
        super.setSexo(sexo);
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public void setEdad(int edad) {
        super.setEdad(edad);
    }
}
