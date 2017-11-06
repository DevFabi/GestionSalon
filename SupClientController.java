package controller;

import java.sql.SQLException;

import DAO.ClientDAO;
import DAO.DAO;
import application.Main;
import bean.Client;
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

public class SupClientController {
	
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
//    @FXML
//    private TableColumn<Client, Boolean> select;
    @FXML
    private Button search;
    @FXML
    private Button supprimer;

	
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
    	tableClients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
         nomColumn.setCellValueFactory(cellData -> cellData.getValue().getNomClientProperty());
         prenomColumn.setCellValueFactory(cellData -> cellData.getValue().getPrenomClientProperty());
    	 ageColumn.setCellValueFactory(cellData -> cellData.getValue().getAgeClientProperty().asObject());
         emailColumn.setCellValueFactory(cellData -> cellData.getValue().getEmailClientProperty());
//         select.setCellValueFactory(cellData -> cellData.getValue().getMyCheckProperty());
         
    }
    @FXML
    private void supprimer (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
    	
    	int selectedIndex = tableClients.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0 ) { 
        	Client clie =   tableClients.getSelectionModel().getSelectedItem();
        	DAO<Client> ClientDAO = new ClientDAO();
        	ClientDAO.delete(ClientDAO.findId(clie.getNomClient()));
        	tableClients.refresh();
    }else {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Pas de selection");
        alert.setHeaderText("Vous n'avez pas selectionné de client");
        alert.setContentText("Appuyez sur search, puis selectionnez une ligne pour la supprimer");
        alert.showAndWait();
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
