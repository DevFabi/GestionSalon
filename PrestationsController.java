package controller;

import java.sql.SQLException;

import DAO.typePrestationDAO;
import application.Main;
import bean.TypePrestation;
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

public class PrestationsController {

	@FXML
	private AnchorPane AnchorPane_Prestations;
	@FXML
	private Button bt_AccueilPrestations;
	@FXML
	private Button bt_CreationPrestations;
	@FXML
	private Button bt_SuppressionPrestation;
	@FXML
    private TableView<TypePrestation> tablePrestation;
    @FXML
    private TableColumn<TypePrestation, String>  nom;
    @FXML
    private TableColumn<TypePrestation, Integer>  prix;
    @FXML
    private Button search;
    
    
    @FXML
    private void initialize ()  {
         nom.setCellValueFactory(cellData -> cellData.getValue().getLibellePrestationProperty());
         prix.setCellValueFactory(cellData -> cellData.getValue().getPrixPrestationProperty().asObject());
 }
    
    @FXML
    private void searchUser(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
    
    	try {
            ObservableList<TypePrestation> empData = new typePrestationDAO().findAll();
            
            tablePrestation.setItems(empData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    
	@FXML
	private void goBack(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/Selection.fxml"));
           AnchorPane AnchorPane_Prestations = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) bt_AccueilPrestations.getScene().getWindow();
                Scene scene = bt_AccueilPrestations.getScene();
                scene.setRoot(AnchorPane_Prestations);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	@FXML
	private void goCreationPrestations(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/CreationPrestation.fxml"));
           AnchorPane AnchorPane_Prestations = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) bt_CreationPrestations.getScene().getWindow();
                Scene scene = bt_CreationPrestations.getScene();
                scene.setRoot(AnchorPane_Prestations);
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
           AnchorPane AnchorPane_Prestations = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) bt_SuppressionPrestation.getScene().getWindow();
                Scene scene = bt_SuppressionPrestation.getScene();
                scene.setRoot(AnchorPane_Prestations);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

}
