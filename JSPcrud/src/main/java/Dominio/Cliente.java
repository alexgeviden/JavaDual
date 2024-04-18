/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Dominio;

/**
 *
 * @author alexg
 */
public class Cliente {
    private String Nombre;
    private String DNI; 
    private String Correo;
    private String Tel;

    public Cliente(String Nombre, String DNI, String Correo, String Tel) {
        this.Nombre = Nombre;
        this.DNI = DNI;
        this.Correo = Correo;
        this.Tel = Tel;
    }
    
    public Cliente(){}

    public String getNombre() {
        return Nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getTel() {
        return Tel;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    @Override
    public String toString() {
        return "Cliente{" + "Nombre=" + Nombre + ", DNI=" + DNI + ", Correo=" + Correo + ", Tel=" + Tel + '}';
    }
    
}
