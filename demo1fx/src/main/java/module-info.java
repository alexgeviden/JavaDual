module com.example.demo1fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo1fx to javafx.fxml;
    exports com.example.demo1fx;
}