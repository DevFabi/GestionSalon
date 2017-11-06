package controller;

import java.sql.SQLException;

import DAO.CoiffeurDAO;
import application.Main;
import bean.Coiffeur;
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

public class CoiffeursController {

	@FXML
	private AnchorPane AnchorPane_Coiffeurs;
	@FXML
	private Button bt_AccueilCoiffeur;
	@FXML
	private Button bt_CreationCoiffeur;
	@FXML
	private Button bt_SuppressionCoiffeur;
	@FXML
    private TableView<Coiffeur> tableCoiffeurs;
    @FXML
    private TableColumn<Coiffeur, String>  nomColumn;
    @FXML
    private TableColumn<Coiffeur, String>  prenomColumn;
    @FXML
    private Button search;
    
	@FXML
	private void goSuppression(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/SupCoiffeur.fxml"));
           AnchorPane AnchorPane_Coiffeurs = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) bt_SuppressionCoiffeur.getScene().getWindow();
                Scene scene = bt_SuppressionCoiffeur.getScene();
                scene.setRoot(AnchorPane_Coiffeurs);
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
           AnchorPane AnchorPane_Coiffeurs = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) bt_AccueilCoiffeur.getScene().getWindow();
                Scene scene = bt_AccueilCoiffeur.getScene();
                scene.setRoot(AnchorPane_Coiffeurs);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	@FXML
	private void goCreation(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/CreationCoiffeur.fxml"));
           AnchorPane AnchorPane_Coiffeurs = (AnchorPane) loader.load();
//            BorderPane mainFrame = (BorderPane) loader.load();
                Stage stage =  (Stage) bt_CreationCoiffeur.getScene().getWindow();
                Scene scene = bt_CreationCoiffeur.getScene();
                scene.setRoot(AnchorPane_Coiffeurs);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
    @FXML
    private void initialize ()  {
         nomColumn.setCellValueFactory(cellData -> cellData.getValue().getNomCoiffeurProperty());
         prenomColumn.setCellValueFactory(cellData -> cellData.getValue().getPrenomCoiffeurProperty());
 }
    
    @FXML
    private void searchUser(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
    
    	try {
            ObservableList<Coiffeur> empData = new CoiffeurDAO().findAll();
            //Populate Employees on TableView
            tableCoiffeurs.setItems(empData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
}
