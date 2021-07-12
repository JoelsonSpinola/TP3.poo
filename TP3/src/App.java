import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class App extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override/*Call home page*/
    public void start(Stage primaryStage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/home.fxml"));
        Parent root = loader.load(); 

        Scene scene= new Scene(root);

        //Controller controller = loader.getController(); 

        //scene.getStylesheets().add("hellojava.css");

        primaryStage.setTitle("Summer");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}