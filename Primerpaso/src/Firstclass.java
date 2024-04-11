import javax.swing.JOptionPane;


public class Firstclass {
    public static void main(String[] args) {
       
        Datospersona();
    }
        
    public static void Datospersona(){
        // Array de strings para almacenar los encabezados de los datos de una persona


        String[] encabezados = {"Nombre", "Apellido", "Edad"};

        // Array bidimensional para almacenar los datos de las personas
        String[][] personas = new String[20][3];

      
        for (int i = 0; i < 2; i++) {
            
            String datonombre = JOptionPane.showInputDialog("Ingrese el nombre de la persona");
            String datoapellido = JOptionPane.showInputDialog("Ingrese el apellido de la persona");
            String datoedad = JOptionPane.showInputDialog("Ingrese la edad de la persona");
        
           
            if (datonombre == null || datoapellido == null || datoedad == null) {
                break;
            }
         
            personas[i][0] = datonombre;
            personas[i][1] = datoapellido;
            personas[i][2] = datoedad;
        }

        // Construir el texto que se mostrará en el JOptionPane
        StringBuilder message = new StringBuilder();
    
        for (int j = 0; j < encabezados.length; j++) {
            message.append(encabezados[j]).append(" ");
        }
        message.append("\n"); 
       
        for (int i = 0; i < personas.length; i++) {

            // Si los datos de la persona no están nulos, se agregan al mensaje
            if (personas[i][0] != null && personas[i][1] != null && personas[i][2] != null) {
                for (int j = 0; j < personas[i].length; j++) {
                    message.append(personas[i][j] + " , ");
                }
                message.append("\n"); 
            }
        }

        // Si no hay datos para mostrar, no se muestra
        if (message.length() > 0) {
          
            JOptionPane.showMessageDialog(null, message.toString(), "Datos de Personas", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
