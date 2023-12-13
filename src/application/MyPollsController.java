package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
/**
 * Controller of MyPolls
 * @author Robin
 *
 */
public class MyPollsController {

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
	 * Change the Page to the FeedPoll Page
	 * @param event
	 * @throws IOException
	 */
	public void FeedPoll_button(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
		root = loader.load();
		HomePageController controller = loader.getController() ;
		controller.set_model(model);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		controller.show_HomePage();
		stage.setScene(scene);
		stage.show();
		return;
	}
	/**
	 *  Change the Page to the MyPolls page
	 * @param event
	 * @throws IOException
	 */
	public void MyPolls_button(ActionEvent event) throws IOException {
		return;
	}
	/**
	 *  Change the Page to the MyAccount Page
	 * @param event
	 * @throws IOException
	 */
	public void MyAccount_button(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("AccountPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	/**
	 *  Change the Page to the Login Page and show a pop-up with successful disconnection
	 * @param event
	 * @throws IOException
	 */
	public void Logout_button(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ConnectionPage.fxml"));
		root = loader.load();
		ConnectionPageController controller = loader.getController() ;
		controller.set_model(model);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		AlertPopUp.afficherAlerte(AlertType.INFORMATION, "Logout Succesfull", "You have been correctly disconnected");
		
	}
}
