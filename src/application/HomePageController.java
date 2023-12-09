package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomePageController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void FeedPoll_button(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("./UI/HomePage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void MyPolls_button(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("./UI/MyPolls.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void MyAccount_button(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("./UI/AccountPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void Logout_button(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("./UI/ConnectionPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	

}
