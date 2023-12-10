package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertPopUp {

    public static void afficherAlerte(AlertType type,String title,String content) {
        // Cr�ation d'une fen�tre d'alerte d'information
        Alert alerte = new Alert(type);

        // Configuration du titre et du contenu de l'alerte
        alerte.setTitle(title);
        alerte.setHeaderText(null); // Pour ne pas afficher l'en-t�te
        alerte.setContentText(content);

        // Affichage de l'alerte et attente de sa fermeture
        alerte.showAndWait();
    }
}
