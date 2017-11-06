package controller;

import java.sql.SQLException;

import DAO.DAO;
import DAO.typePrestationDAO;
import application.Main;
import bean.TypePrestation;
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

public class CreationPrestationController {
	
	@FXML
	private AnchorPane pageAjoutPrestaBd;
	@FXML
	private Button bt_AccueilPrestationCreation;
	@FXML 
	private Button bt_SuppressionPrestationCreation;
	@FXML 
	private Button AjoutPrestationBd;
	@FXML
	private TextField nom;
	@FXML
	private TextField prix;
	@FXML
	private TextField dateheure;
	
	@FXML
	private void goBack(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/Selection.fxml"));
           AnchorPane pageAjoutPrestaBd = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) bt_AccueilPrestationCreation.getScene().getWindow();
                Scene scene = bt_AccueilPrestationCreation.getScene();
                scene.setRoot(pageAjoutPrestaBd);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	@FXML
	private void goSuppression(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/SupPrestation.fxml"));
           AnchorPane pageAjoutPrestaBd = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) bt_SuppressionPrestationCreation.getScene().getWindow();
                Scene scene = bt_SuppressionPrestationCreation.getScene();
                scene.setRoot (pageAjoutPrestaBd);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	@FXML
	private void goCreation (ActionEvent actionEvent) throws SQLException, ClassNotFoundException  {
		if (isInputValid()) {
	DAO<TypePrestation> typePrestationDAO = new typePrestationDAO();
	TypePrestation prestation = new TypePrestation();
	prestation.setLibellePrestation(nom.getText());
	prestation.setPrixPrestation(Integer.parseInt(prix.getText()));
	typePrestationDAO.create(prestation);
	nom.clear();
	prix.clear();} 
	}
	
	 private boolean isInputValid() {
			String errorMessage = "";
			if (nom.getText() == null || nom.getText().length() == 0) {
				errorMessage += "Veuillez entrer un nom \n";
			}
			if (prix.getText() == null || prix.getText().length() == 0) {
				errorMessage += "Veuillez entrer un prix \n";
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
