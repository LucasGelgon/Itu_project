package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConnectionPageController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField username_field;
	@FXML
	private PasswordField password_field;
	
	
	@FXML
	public void Login_button(ActionEvent event) throws IOException {
		System.out.println(password_field.getText());
		if((username_field.getText().equals("Robin")) && (password_field.getText().equals("toto"))) {
			System.out.println("ok");
		}
		else {
			System.out.println("pas ok");
		}
		
		
	}
	
}
