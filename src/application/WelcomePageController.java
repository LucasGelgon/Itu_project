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
	
	/**
	 * Is used to define the class model
	 * @param model Model to be set 
	 */
	public void set_model(Model model) {
		this.model = model;
	}
	
	/**
	 * Callback function called when the page button is clicked
	 * @param event Pointer to the event, in this case the clicked_button
	 * @throws IOException
	 */
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
