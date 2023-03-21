module com.example.ejercicio2jfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejercicio2jfx to javafx.fxml;
    exports com.example.ejercicio2jfx;
}