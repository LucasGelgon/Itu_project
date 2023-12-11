package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * Controller to manage the Connection Page interactions
 * @author Robin
 *
 */
public class ConnectionPageController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	private Model model;
	
	@FXML private TextField username_field;
	@FXML private PasswordField password_field;
	@FXML private TextField user_field;
	@FXML private TextField login_field;
	
	public void set_model(Model model) {
		this.model = model;
	}
	
	/**
	 * Log the user when clicking on LogIn. If the user and the passsword are in the database load the next Page (HOMEPAGE),
	 * if not show an error popup
	 * @param event
	 * @throws IOException
	 */
	@FXML public void Login_button(ActionEvent event) throws IOException {
		int index = model.check_user(username_field.getText(), password_field.getText());
		if (index>=0) {
			model.setIndexUser(index);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
			root = loader.load();
			HomePageController controller = loader.getController() ;
			controller.set_model(model);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			controller.show_HomePage();
			stage.show();
		}
		else {
			AlertPopUp.afficherAlerte(AlertType.ERROR,"Login error","The username or password do not match");
		}
		
		
	}
	
	/**
	 * Register a new user when clicking on register with the content of user and password field.
	 *  Show a popup to inform the user that an account has been created.
	 * @param event
	 * @throws IOException
	 */
	@FXML public void Register_button(ActionEvent event) throws IOException {
		
		boolean info = model.add_user(user_field.getText(), login_field.getText());
		if (info) {
			AlertPopUp.afficherAlerte(AlertType.INFORMATION,"Account added","Your account has been created");
		}else {
			AlertPopUp.afficherAlerte(AlertType.ERROR,"Account creation error","Check text fields");
		}
		
	}
	

	
}
