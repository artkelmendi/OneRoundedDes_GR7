module org.example.oneroundeddes_gr7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.oneroundeddes_gr7 to javafx.fxml;
    exports org.example.oneroundeddes_gr7;
}