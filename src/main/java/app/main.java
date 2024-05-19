package app;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Load Welcome Page initially
        Navigator.navigate(stage, Navigator.WELCOMING_PAGE);
        stage.setResizable(false); //
    }

    public static void main(String[] args) {
        launch(args);
    }
}
