package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomePage.fxml"));
			Parent root = loader.load();
			WelcomePageController controller = loader.getController() ;
			Model model = new Model();
			controller.set_model(model);
			Scene scene1 = new Scene(root);
			stage.setScene(scene1);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
