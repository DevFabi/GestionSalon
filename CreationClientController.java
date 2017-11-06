package controller;

import java.sql.SQLException;

import DAO.ClientDAO;
import DAO.DAO;
import application.Main;
import bean.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CreationClientController {
	
	@FXML
	private AnchorPane AnchorPane_CreationClient;
	@FXML
	private Button bt_AccueilClientCreation;
	@FXML
	private Button bt_CreationClientCreation;
	@FXML
	private Button bt_SuppressionClientCreation;
	@FXML
	private TextField txf_nomClient;
	@FXML
	private TextField  txf_prenomClient;
	@FXML
	private TextField  txf_ageClient;
	@FXML
	private TextField  txf_emailClient;
	@FXML
	private Button bt_ajoutClientCreation;
    @FXML
    private TextArea resultArea;
    @FXML
    private Label label;

    
    @FXML
	private void goSuppression(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/SupClient.fxml"));
           AnchorPane AnchorPane_CreationClient = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) bt_SuppressionClientCreation.getScene().getWindow();
                Scene scene = bt_SuppressionClientCreation.getScene();
                scene.setRoot(AnchorPane_CreationClient);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
    
	@FXML
	private void backAccueil(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/Selection.fxml"));
           AnchorPane AnchorPane_CreationClient = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) bt_AccueilClientCreation.getScene().getWindow();
                Scene scene = bt_AccueilClientCreation.getScene();
                scene.setRoot(AnchorPane_CreationClient);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
    @FXML
    private void ajouterClient(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
    	if (isInputValid()) {
    	
    	DAO<Client> ClientDAO = new ClientDAO();
        Client client = new Client();
       	client.setNomClient(txf_nomClient.getText());
       	client.setPrenomClient(txf_prenomClient.getText());
       	client.setAgeClient(Integer.parseInt(txf_ageClient.getText()));
       	client.setEmailClient(txf_emailClient.getText());
       	ClientDAO.create(client);
    	txf_nomClient.clear();
        txf_prenomClient.clear();
        txf_ageClient.clear();
        txf_emailClient.clear(); }}
    	
    	
	private boolean isInputValid() {
		String errorMessage = "";
		if (txf_nomClient.getText() == null || txf_nomClient.getText().length() == 0) {
			errorMessage += "Veuillez entrer un nom \n";
		}
		if (txf_prenomClient.getText() == null || txf_prenomClient.getText().length() == 0) {
			errorMessage += "Veuillez entrer un prénom \n";
		}
		if (txf_ageClient.getText() == null || txf_ageClient.getText().length() == 0) {
			errorMessage += "Veuillez entrer un age \n";
		}
		if (txf_emailClient.getText() == null || txf_emailClient.getText().length() == 0) {
			errorMessage += "Veuillez entrer un e-mail \n";
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