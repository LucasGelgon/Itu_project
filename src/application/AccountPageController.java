package application;

import java.io.IOException;
import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccountPageController {

    @FXML
    private Label nameLabel;
    
    @FXML
    private Label surnameLabel;

    @FXML
    private Label ageLabel;
    
    @FXML
    private Label emailLabel;

    @FXML
    private Label badgesLabel;

    public void initialize(User user) {
        usernameLabel.setText("Name: " + user.getUsername());
        usernameLabel.setText("Surname: " + user.getUsername());
        ageLabel.setText("Age: " + user.getAge());
        emailLabel.setText("Email: " + user.getEmail());
        badgesLabel.setText("Badges: " + user.getBadges());
    }
}
