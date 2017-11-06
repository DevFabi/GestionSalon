package controller;

import java.sql.SQLException;

import DAO.ClientDAO;
import application.Main;
import bean.Client;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ClientsController {
		
		@FXML
		private AnchorPane AnchorPane_Clients;
		@FXML
		private Button bt_AccueilClient;
		@FXML
		private Button bt_CreationClient;
		@FXML
		private Button bt_SuppressionClient;
		@FXML
	    private TableView<Client> tableClients;
	    @FXML
	    private TableColumn<Client, String>  nomColumn;
	    @FXML
	    private TableColumn<Client, String>  prenomColumn;
	    @FXML
	    private TableColumn<Client, Integer> ageColumn;
	    @FXML
	    private TableColumn<Client, String> emailColumn;
	    @FXML
	    private Button search;
	

	
	@FXML
	private void goBack(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/Selection.fxml"));
           AnchorPane AnchorPane_Clients = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) bt_AccueilClient.getScene().getWindow();
                Scene scene = bt_AccueilClient.getScene();
                scene.setRoot(AnchorPane_Clients);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	@FXML
	private void goSuppression(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/SupClient.fxml"));
           AnchorPane AnchorPane_Clients = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) bt_SuppressionClient.getScene().getWindow();
                Scene scene = bt_SuppressionClient.getScene();
                scene.setRoot(AnchorPane_Clients);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

    @FXML
    private void initialize ()  {

    	 nomColumn.setCellValueFactory(cellData -> cellData.getValue().getNomClientProperty());
         prenomColumn.setCellValueFactory(cellData -> cellData.getValue().getPrenomClientProperty());
    	 ageColumn.setCellValueFactory(cellData -> cellData.getValue().getAgeClientProperty().asObject());
         emailColumn.setCellValueFactory(cellData -> cellData.getValue().getEmailClientProperty());
       
    }

    
    
	@FXML
	private void goCreationClients(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/CreationClient.fxml"));
           AnchorPane AnchorPane_Clients = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) bt_CreationClient.getScene().getWindow();
                Scene scene = bt_CreationClient.getScene();
                scene.setRoot(AnchorPane_Clients);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
    @FXML
    private void searchUser(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
    
    	try {
            ObservableList<Client> empData = new ClientDAO().findAll();
            //Populate Employees on TableView
            tableClients.setItems(empData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
}
