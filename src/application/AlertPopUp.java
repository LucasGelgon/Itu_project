package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 * This class is used to manage pop-ups
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
        // Création d'une fenêtre d'alerte d'information
        Alert alerte = new Alert(type);

        // Configuration du titre et du contenu de l'alerte
        alerte.setTitle(title);
        alerte.setHeaderText(null); // Pour ne pas afficher l'en-tête
        alerte.setContentText(content);

        // Affichage de l'alerte et attente de sa fermeture
        alerte.showAndWait();
    }
}
