package com.example.demo1fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creamos un nodo de texto con el mensaje
        Text mensaje = new Text("Buenas tardes");

        // Creamos un contenedor de tipo StackPane
        StackPane root = new StackPane();
        root.getChildren().add(mensaje);

        // Creamos la escena con el contenedor y el tamaño deseado
        Scene scene = new Scene(root, 300, 200);

        // Establecemos la escena en el escenario principal (stage)
        primaryStage.setScene(scene);

        // Establecemos el título de la ventana
        primaryStage.setTitle("Saludo de buenas tardes");

        // Mostramos la ventana
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
