package controller;

import java.sql.SQLException;

import DAO.CoiffeurDAO;
import DAO.DAO;
import application.Main;
import bean.Coiffeur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CreationCoiffeurController {

	@FXML
	private Button bt_AccueilCoiffeurCreation;
	@FXML
	private AnchorPane AnchorPane_CreationCoiffeurs;
	@FXML
	private TextField  prenomCoiffeur;
	@FXML
	private TextField nomCoiffeur;
	@FXML
	private Button  bt_ajouterCoiffeur;
	@FXML
	private Button bt_SuppressionCoiffeur;

	@FXML
	private void goSuppression(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/SupCoiffeur.fxml"));
           AnchorPane AnchorPane_CreationCoiffeurs = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) bt_SuppressionCoiffeur.getScene().getWindow();
                Scene scene = bt_SuppressionCoiffeur.getScene();
                scene.setRoot(AnchorPane_CreationCoiffeurs);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	@FXML
	private void goBack(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/Selection.fxml"));
           AnchorPane AnchorPane_CreationCoiffeurs = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) bt_AccueilCoiffeurCreation.getScene().getWindow();
                Scene scene = bt_AccueilCoiffeurCreation.getScene();
                scene.setRoot(AnchorPane_CreationCoiffeurs);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
    @FXML
    private void ajouterCoiffeur(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
    	if (isInputValid()) {
           
            DAO<Coiffeur> CoiffeurDAO = new CoiffeurDAO();
            Coiffeur coif = new Coiffeur();
           	coif.setNomCoiffeur(nomCoiffeur.getText());
           	coif.setPrenomCoiffeur(prenomCoiffeur.getText());
            CoiffeurDAO.create(coif);
            nomCoiffeur.clear();
            prenomCoiffeur.clear();
    }
}
    
    private boolean isInputValid() {
		String errorMessage = "";
		if (nomCoiffeur.getText() == null || nomCoiffeur.getText().length() == 0) {
			errorMessage += "Veuillez entrer un nom \n";
		}
		if (prenomCoiffeur.getText() == null || prenomCoiffeur.getText().length() == 0) {
			errorMessage += "Veuillez entrer un prénom \n";
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Champs incomplets");
            alert.setHeaderText("Completez tous les champs");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
		}
	}
}
