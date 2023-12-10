package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Controller of the WelcomePage
 * @author Robin
 * 
 */
public class WelcomePageController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private Model model;
	

	public void set_model(Model model) {
		this.model = model;
	}
	
	public void Start_button(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ConnectionPage.fxml"));
		root = loader.load();
		ConnectionPageController controller = loader.getController() ;
		controller.set_model(model);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
