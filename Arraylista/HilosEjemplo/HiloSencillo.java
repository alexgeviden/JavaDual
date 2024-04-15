public class HiloSencillo extends Thread {
    private String mensaje;

    public HiloSencillo(String mensaje) {
        this.mensaje = mensaje;
    }

    public void run() {
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
        // Crear dos hilos con diferentes mensajes
        for (int i = 0; i < 10; i++) {

            new HiloSencillo("Hola desde el Hilo 1").start();
            new HiloSencillo("Hola desde el Hilo 2").start();
        }

    }
}
