import java.util.Objects;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

public class Cliente {

    private String nombre;
    private String numCuenta;
    private double saldo;
    public Cliente(String nombre , String numcuenta , double saldo) {
        this.nombre=nombre;
        this.numCuenta=numcuenta;
        this.saldo=saldo;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    @Override
    public String toString() {
        return  "nombre='" + nombre + '\'' +
                ", saldo=" + saldo +
                ", numCuenta='" + numCuenta + '\'';
    }



    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(numCuenta, other.numCuenta)
				&& Double.doubleToLongBits(saldo) == Double.doubleToLongBits(other.saldo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, numCuenta, saldo);
	}
}
