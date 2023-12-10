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

public class ConnectionPageController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	private Model model;
	
	@FXML
	private TextField username_field;
	@FXML
	private PasswordField password_field;
	@FXML
	private TextField user_field;
	@FXML
	private TextField login_field;
	
	public void set_model(Model model) {
		this.model = model;
	}
	
	@FXML
	public void Login_button(ActionEvent event) throws IOException {
		
		if (model.check_user(username_field.getText(), password_field.getText())) {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
			root = loader.load();
			HomePageController controller = loader.getController() ;
			controller.set_model(model);
			
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else {
			AlertPopUp.afficherAlerte(AlertType.ERROR,"Login error","The username or password do not match");
		}
		
		
	}
	
	@FXML
	public void Register_button(ActionEvent event) throws IOException {
		
		boolean info = model.add_user(user_field.getText(), login_field.getText());
		if (info) {
			AlertPopUp.afficherAlerte(AlertType.INFORMATION,"Account added","Your account has been created");
		}else {
			AlertPopUp.afficherAlerte(AlertType.ERROR,"Account creation error","Check text fields");
		}
		
	}
	

	
}
