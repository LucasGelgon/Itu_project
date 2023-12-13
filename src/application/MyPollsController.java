package application;

import java.io.IOException;
import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
	DecimalFormat df = new DecimalFormat("###.##");
	@FXML private Label username_field;
	@FXML private HBox hbox_Q1;
	@FXML private VBox vbox_Q1;
	@FXML private ProgressBar yes_PB_Q1;
	@FXML private ProgressBar no_PB_Q1;
	@FXML private Label yes_label_Q1;
	@FXML private Label no_label_Q1;
	@FXML private Label label_Q1;
	@FXML private HBox hbox_Q2;
	@FXML private VBox vbox_Q2;
	@FXML private ProgressBar yes_PB_Q2;
	@FXML private ProgressBar no_PB_Q2;
	@FXML private Label yes_label_Q2;
	@FXML private Label no_label_Q2;
	@FXML private Label label_Q2;
	@FXML private HBox hbox_Q3;
	@FXML private VBox vbox_Q3;
	@FXML private Label label_Q3;
	@FXML private ProgressBar PB1_Q3;
	@FXML private ProgressBar PB2_Q3;
	@FXML private ProgressBar PB3_Q3;
	@FXML private Label label1_Q3;
	@FXML private Label label2_Q3;
	@FXML private Label label3_Q3;
	@FXML private HBox hbox_Q4;
	@FXML private VBox vbox_Q4;
	@FXML private Label label_Q4;
	@FXML private ProgressBar PB1_Q4;
	@FXML private ProgressBar PB2_Q4;
	@FXML private ProgressBar PB3_Q4;
	@FXML private Label label1_Q4;
	@FXML private Label label2_Q4;
	@FXML private Label label3_Q4;
	
	
	/**
	 * Is used to define the class model
	 * @param model Model to be set 
	 */
	public void set_model(Model model) {
		this.model = model;
		username_field.setText(model.getUser());
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
	
	public void addPoll_button (ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("PollCreation.fxml"));
		root = loader.load();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	
		
	}
	
	/**
	 * check if the poll i is already answered by the current user
	 * @param i poll to check
	 * @return boolean true or false
	 */
	public boolean check_poll(int i){
            return((model.getAnswered().get(i-1))== true);
            
	}
	
	/**
	 * Update the result of the Question 1
	 */
	public void refresh_Q1() {
		if(check_poll(1)) {
			label_Q1.setText(model.get_Poll().get(0).getQuestion());
			yes_PB_Q1.setProgress(model.get_Poll().get(0).getValues().get(0));
			no_PB_Q1.setProgress(model.get_Poll().get(0).getValues().get(1));
			yes_label_Q1.setText(df.format(model.get_Poll().get(0).getValues().get(0)*100)+"%");
			no_label_Q1.setText(df.format(model.get_Poll().get(0).getValues().get(1)*100)+"%");
			label_Q1.setVisible(true);
			vbox_Q1.setVisible(true);
			
		}

	}
	/**
	 * Update the result of the Question 2
	 *
	 */
	public void refresh_Q2() {
		if(check_poll(2)) {
			label_Q2.setText(model.get_Poll().get(1).getQuestion());
			yes_PB_Q2.setProgress(model.get_Poll().get(1).getValues().get(0));
			no_PB_Q2.setProgress(model.get_Poll().get(1).getValues().get(1));
			yes_label_Q2.setText(df.format(model.get_Poll().get(1).getValues().get(0)*100)+"%");
			no_label_Q2.setText(df.format(model.get_Poll().get(1).getValues().get(1)*100)+"%");
			label_Q2.setVisible(true);
			vbox_Q2.setVisible(true);
		}

	}
	/**
	 * Update the result of the Question 3
	 */
	
	public void refresh_Q3() {
		if(check_poll(3)) {
			label_Q3.setText(model.get_Poll().get(2).getQuestion());
			label1_Q3.setText(model.get_Poll().get(2).get_choices()[0]+" "+df.format(model.get_Poll().get(2).getValues().get(0)*100)+"%");
			label2_Q3.setText(model.get_Poll().get(2).get_choices()[1]+" "+df.format(model.get_Poll().get(2).getValues().get(1)*100)+"%");
			label3_Q3.setText(model.get_Poll().get(2).get_choices()[2]+" "+df.format(model.get_Poll().get(2).getValues().get(2)*100)+"%");
			PB1_Q3.setProgress(model.get_Poll().get(2).getValues().get(0));
			PB2_Q3.setProgress(model.get_Poll().get(2).getValues().get(1));
			PB3_Q3.setProgress(model.get_Poll().get(2).getValues().get(2));
			label_Q3.setVisible(true);
			vbox_Q3.setVisible(true);
		}
	}
	
	/**
	 * Update the result of the Question 4
	 */
	
	public void refresh_Q4() {
		if(check_poll(4)) {
			label_Q4.setText(model.get_Poll().get(3).getQuestion());
			label1_Q4.setText(model.get_Poll().get(3).get_choices()[0]+" "+df.format(model.get_Poll().get(3).getValues().get(0)*100)+"%");
			label2_Q4.setText(model.get_Poll().get(3).get_choices()[1]+" "+df.format(model.get_Poll().get(3).getValues().get(1)*100)+"%");
			label3_Q4.setText(model.get_Poll().get(3).get_choices()[2]+" "+df.format(model.get_Poll().get(3).getValues().get(2)*100)+"%");
			PB1_Q4.setProgress(model.get_Poll().get(3).getValues().get(0));
			PB2_Q4.setProgress(model.get_Poll().get(3).getValues().get(1));
			PB3_Q4.setProgress(model.get_Poll().get(3).getValues().get(2));
			label_Q4.setVisible(true);
			vbox_Q4.setVisible(true);
		}
		
	}
	
	/**
	 * Function to show the correct and up in time result to the user. Should be use each time the HomePage is show-up or refresh
	 */
	public void show_MyPollsAnswered() {
		refresh_Q1();
		refresh_Q2();
		refresh_Q3();
		refresh_Q4();
		
	}
	
	
	
	
}
