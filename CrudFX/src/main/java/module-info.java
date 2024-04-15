module com.example.crudfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.crudfx to javafx.fxml;
    exports com.example.crudfx;
}