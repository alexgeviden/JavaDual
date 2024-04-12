public class Docente extends Persona{
    String asignatura;

    public Docente(String nom, int edad , String asignatura , String genero){
        super(nom, edad, "Docente" , genero);
        this.asignatura= asignatura;
    }

    @Override
    public int getEdad() {
        return super.getEdad();
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public String getTipo() {
        return super.getTipo();
    }

    public String getAsignatura() {
        return asignatura;
    }

    @Override
    public String toString() {
        return super.toString() + ", Asignatura : " + this.asignatura;
    }

    @Override
    public void setEdad(int edad) {
        super.setEdad(edad);
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public void setSexo(String sexo) {
        super.setSexo(sexo);
    }

    @Override
    public void setTipo(String tipo) {
        super.setTipo(tipo);
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

}
