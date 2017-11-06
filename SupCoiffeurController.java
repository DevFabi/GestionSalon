package controller;

import java.sql.SQLException;

import DAO.CoiffeurDAO;
import DAO.DAO;
import application.Main;
import bean.Coiffeur;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SupCoiffeurController {
	
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
//    @FXML
//    private TableColumn<Client, Boolean> select;
    @FXML
    private Button search;
    @FXML
    private Button supprimer;
	
	
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
	private void goSuppression(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/SupCoiffeur.fxml"));
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
//    	select.setCellFactory(factory-> new CheckBoxTableCell<Client, Boolean>());
    	
//    	activeCol.setCellValueFactory(new PropertyValueFactory<>("myCheck"));
    	/*activeCol.setCellFactory(new Callback<TableColumn<Client,Boolean>, TableCell<Client,Boolean>>() {
			
			@Override
			public TableCell<Client, Boolean> call(TableColumn<Client, Boolean> p) {
				CheckBoxTableCell<Client, Boolean> cell = new CheckBoxTableCell<Client, Boolean>();
				cell.setAlignment(Pos.CENTER);
				return cell;
			}
		});*/
    	tableCoiffeurs.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
         nomColumn.setCellValueFactory(cellData -> cellData.getValue().getNomCoiffeurProperty());
         prenomColumn.setCellValueFactory(cellData -> cellData.getValue().getPrenomCoiffeurProperty());
//         select.setCellValueFactory(cellData -> cellData.getValue().getMyCheckProperty());
         
    }
    @FXML
    private void supprimer (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
    	int selectedIndex = tableCoiffeurs.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0 ) {
    	
        	Coiffeur coif =   tableCoiffeurs.getSelectionModel().getSelectedItem();
        	DAO<Coiffeur> CoiffeurDAO = new CoiffeurDAO();
        	CoiffeurDAO.delete(CoiffeurDAO.findId(coif.getNomCoiffeur()));
        	tableCoiffeurs.refresh();
		}else {
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Pas de selection");
	        alert.setHeaderText("Vous n'avez pas selectionné de coiffeur");
	        alert.setContentText("Appuyez sur search, puis selectionnez une ligne pour la supprimer");
	        alert.showAndWait();
		}
        	
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
