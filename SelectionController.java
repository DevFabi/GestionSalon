package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SelectionController {
	
	@FXML
	private AnchorPane SelectionFont;
	@FXML
	private Button SelectionCreationClient;
	@FXML
	private Button SelectionNouvellePrestaEncaissement;
	@FXML
	private Button SelectionCoiffeurs;
	@FXML
	private Button SelectionClients;
	@FXML
	private Button SelectionPrestations;
	@FXML
	private Button SelectionStatistiques;
	
	@FXML
	private void CreationClientPage(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/CreationClient.fxml"));
           AnchorPane SelectionFont = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) SelectionCreationClient.getScene().getWindow();
                Scene scene = SelectionCreationClient.getScene();
                scene.setRoot(SelectionFont);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	@FXML
	private void CoiffeurPage(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/Coiffeurs.fxml"));
           AnchorPane SelectionFont = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) SelectionCoiffeurs.getScene().getWindow();
                Scene scene = SelectionCoiffeurs.getScene();
                scene.setRoot(SelectionFont);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	@FXML
	private void NouvellePrestaEncaissement(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/PrestationEncaissement.fxml"));
           AnchorPane SelectionFont = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) SelectionNouvellePrestaEncaissement.getScene().getWindow();
                Scene scene = SelectionNouvellePrestaEncaissement.getScene();
                scene.setRoot(SelectionFont);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	@FXML
	private void ClientPage(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/Clients.fxml"));
           AnchorPane SelectionFont = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) SelectionClients.getScene().getWindow();
                Scene scene = SelectionClients.getScene();
                scene.setRoot(SelectionFont);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}
}
	@FXML
	private void PrestationsPage(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/Prestations.fxml"));
           AnchorPane SelectionFont = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) SelectionPrestations.getScene().getWindow();
                Scene scene = SelectionPrestations.getScene();
                scene.setRoot(SelectionFont);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}}
	@FXML
	private void StatistiquePage(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/Statistiques.fxml"));
           AnchorPane SelectionFont = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) SelectionStatistiques.getScene().getWindow();
                Scene scene = SelectionStatistiques.getScene();
                scene.setRoot(SelectionFont);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}}
}
