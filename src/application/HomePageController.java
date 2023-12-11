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

public class HomePageController {
	
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
	@FXML private ChoiceBox<String> CB_Q3;
	@FXML private ProgressBar PB1_Q3;
	@FXML private ProgressBar PB2_Q3;
	@FXML private ProgressBar PB3_Q3;
	@FXML private Label label1_Q3;
	@FXML private Label label2_Q3;
	@FXML private Label label3_Q3;
	@FXML private HBox hbox_Q4;
	@FXML private VBox vbox_Q4;
	@FXML private Label label_Q4;
	@FXML private ChoiceBox<String> CB_Q4;
	@FXML private ProgressBar PB1_Q4;
	@FXML private ProgressBar PB2_Q4;
	@FXML private ProgressBar PB3_Q4;
	@FXML private Label label1_Q4;
	@FXML private Label label2_Q4;
	@FXML private Label label3_Q4;
	
	
	public void set_model(Model model) {
		this.model = model;
		username_field.setText(model.getUser());
		
	}
	
	public void FeedPoll_button(ActionEvent event) throws IOException {
		return;
	}
	
	public void MyPolls_button(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("MyPolls.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void MyAccount_button(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("AccountPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
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
	
	@FXML
	public void Q1_button_yes(ActionEvent event) throws IOException {
		model.setAnswered(model.getIndexUser(), 0, true);
		model.get_Poll().get(0).set_raw_data(1);
		refresh_Q1();
		hbox_Q1.setVisible(false);
		vbox_Q1.setVisible(true);
		
	}
	
	@FXML
	public void Q1_button_no(ActionEvent event) throws IOException {
		model.setAnswered(model.getIndexUser(), 0, true);
		model.get_Poll().get(0).set_raw_data(2);
		refresh_Q1();
		hbox_Q1.setVisible(false);
		vbox_Q1.setVisible(true);
		
	}
	
	@FXML
	public void Q2_button_yes(ActionEvent event) throws IOException {
		model.setAnswered(model.getIndexUser(), 1, true);
		model.get_Poll().get(1).set_raw_data(2);
		refresh_Q2();
		hbox_Q2.setVisible(false);
		vbox_Q2.setVisible(true);
		
	}
	
	@FXML
	public void Q2_button_no(ActionEvent event) throws IOException {
		model.setAnswered(model.getIndexUser(), 1, true);
		model.get_Poll().get(1).set_raw_data(2);
		refresh_Q2();
		hbox_Q2.setVisible(false);
		vbox_Q2.setVisible(true);
		
	}
	
	
	
	@FXML
	public void Q3_button(ActionEvent event) throws IOException {
		if(CB_Q3.getSelectionModel().getSelectedIndex()<0) {
			AlertPopUp.afficherAlerte(AlertType.ERROR, "Error", "No answer selected");
			return;
		}
		model.setAnswered(model.getIndexUser(), 2, true);
		model.get_Poll().get(2).set_raw_data(CB_Q3.getSelectionModel().getSelectedIndex()+1);
		refresh_Q3();
		hbox_Q3.setVisible(false);
		vbox_Q3.setVisible(true);
		
	}
	
	@FXML
	public void Q4_button(ActionEvent event) throws IOException {
		if(CB_Q4.getSelectionModel().getSelectedIndex()<0) {
			AlertPopUp.afficherAlerte(AlertType.ERROR, "Error", "No answer selected");
			return;
		}
		model.setAnswered(model.getIndexUser(), 3, true);
		model.get_Poll().get(3).set_raw_data(CB_Q4.getSelectionModel().getSelectedIndex()+1);
		refresh_Q4();
		hbox_Q4.setVisible(false);
		vbox_Q4.setVisible(true);
		
	}
	
	
	public boolean check_poll(int i){
            return((model.getAnswered().get(i-1))== true);
            
	}
	
	public void refresh_Q1() {
		label_Q1.setText(model.get_Poll().get(0).getQuestion());
		yes_PB_Q1.setProgress(model.get_Poll().get(0).getValues().get(0));
		no_PB_Q1.setProgress(model.get_Poll().get(0).getValues().get(1));
		yes_label_Q1.setText(df.format(model.get_Poll().get(0).getValues().get(0)*100)+"%");
		no_label_Q1.setText(df.format(model.get_Poll().get(0).getValues().get(1)*100)+"%");
		if(check_poll(1)) {
			hbox_Q1.setVisible(false);
			vbox_Q1.setVisible(true);
		}
	}
		
	public void refresh_Q2() {
			label_Q2.setText(model.get_Poll().get(1).getQuestion());
			yes_PB_Q2.setProgress(model.get_Poll().get(1).getValues().get(0));
			no_PB_Q2.setProgress(model.get_Poll().get(1).getValues().get(1));
			yes_label_Q2.setText(df.format(model.get_Poll().get(1).getValues().get(0)*100)+"%");
			no_label_Q2.setText(df.format(model.get_Poll().get(1).getValues().get(1)*100)+"%");
			if(check_poll(2)) {
				hbox_Q2.setVisible(false);
				vbox_Q2.setVisible(true);
			}
	}
	
	public void refresh_Q3() {
		CB_Q3.getItems().addAll(model.get_Poll().get(2).get_choices());
		label_Q3.setText(model.get_Poll().get(2).getQuestion());
		label1_Q3.setText(model.get_Poll().get(2).get_choices()[0]+" "+df.format(model.get_Poll().get(2).getValues().get(0)*100)+"%");
		label2_Q3.setText(model.get_Poll().get(2).get_choices()[1]+" "+df.format(model.get_Poll().get(2).getValues().get(1)*100)+"%");
		label3_Q3.setText(model.get_Poll().get(2).get_choices()[2]+" "+df.format(model.get_Poll().get(2).getValues().get(2)*100)+"%");
		PB1_Q3.setProgress(model.get_Poll().get(2).getValues().get(0));
		PB2_Q3.setProgress(model.get_Poll().get(2).getValues().get(1));
		PB3_Q3.setProgress(model.get_Poll().get(2).getValues().get(2));
		if(check_poll(3)) {
			hbox_Q3.setVisible(false);
			vbox_Q3.setVisible(true);
		}
	}
		
	public void refresh_Q4() {
		CB_Q4.getItems().addAll(model.get_Poll().get(3).get_choices());
		label_Q4.setText(model.get_Poll().get(3).getQuestion());
		label1_Q4.setText(model.get_Poll().get(3).get_choices()[0]+" "+df.format(model.get_Poll().get(3).getValues().get(0)*100)+"%");
		label2_Q4.setText(model.get_Poll().get(3).get_choices()[1]+" "+df.format(model.get_Poll().get(3).getValues().get(1)*100)+"%");
		label3_Q4.setText(model.get_Poll().get(3).get_choices()[2]+" "+df.format(model.get_Poll().get(3).getValues().get(2)*100)+"%");
		PB1_Q4.setProgress(model.get_Poll().get(3).getValues().get(0));
		PB2_Q4.setProgress(model.get_Poll().get(3).getValues().get(1));
		PB3_Q4.setProgress(model.get_Poll().get(3).getValues().get(2));
		if(check_poll(4)) {
			hbox_Q4.setVisible(false);
			vbox_Q4.setVisible(true);
		}
		
	}
	
	public void show_HomePage() {
		refresh_Q1();
		refresh_Q2();
		refresh_Q3();
		refresh_Q4();
		
	}
	

}
