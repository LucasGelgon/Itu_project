package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This class is used to manage pop-ups
 * 
 * @author Robin
 *
 */
public class AlertPopUp {
	
	
	/**
	 * This static method can be used to display Pop-Ups to the user to notify them of an action
	 * 
	 * @param type Type of alert to be displayed 
	 * @param title Alert header
	 * @param content Error message
	 */
    public static void afficherAlerte(AlertType type,String title,String content) {
        Alert alerte = new Alert(type);

        alerte.setTitle(title);
        alerte.setHeaderText(null); 
        alerte.setContentText(content);
        alerte.showAndWait();
    }
}
