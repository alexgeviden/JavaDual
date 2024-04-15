public abstract class Persona {

    String nombre;
    int edad;
    String tipo;
    String sexo;
    public Persona(String nom , int edad , String tipo , String genero){
        this.edad = edad;
        this.nombre = nom;
        this.tipo = tipo;
        this.sexo = genero;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Nombre : " + this.nombre + " , " + "Edad : " + this.edad + " , " + "Sexo : " + this.sexo + " , " + "Tipo : " + this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
