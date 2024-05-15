module org.example.oneroundeddes_gr7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens Controllers to javafx.fxml;
    exports app;
}