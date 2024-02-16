module com.example.shop {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.shop to javafx.fxml;
    exports com.example.shop;
}