package controller;

import java.sql.SQLException;

import DAO.ClientDAO;
import DAO.CoiffeurDAO;
import DAO.DAO;
import DAO.prestationEffectueeDAO;
import DAO.typePrestationDAO;
import application.Main;
import bean.Client;
import bean.Coiffeur;
import bean.TypePrestation;
import bean.prestationEffectuee;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class PrestationEncaissementController {
	
	@FXML
	private AnchorPane AnchorPane_Encaissement;
	@FXML
	private Button bt_accueil;
	@FXML
	private Button valider;
	@FXML
	private ComboBox<Client> client;
	@FXML
	private ComboBox<Coiffeur> coiffeur;
	@FXML
	private ComboBox<TypePrestation> prestation;
	
	@FXML
	private void goBack(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/Selection.fxml"));
           AnchorPane AnchorPane_Encaissement = (AnchorPane) loader.load();
                Stage stage =  (Stage) bt_accueil.getScene().getWindow();
                Scene scene = bt_accueil.getScene();
                scene.setRoot(AnchorPane_Encaissement);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	@FXML
	  private void initialize ()  {
		// COMBOBOX CLIENT
		ObservableList<Client> empData = null ;
		try {
			DAO<Client> ClientDAO = new ClientDAO();
			Client client = new Client();
			 empData = ClientDAO.findNom();
		}catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
		client.setItems(empData);
		StringConverter<Client> conv = new StringConverter<Client>() {
			@Override
			public Client fromString(String string) {
				return null;
			}

			@Override
			public String toString(Client clie) {
				
				return clie.getNomClient() + " " +clie.getPrenomClient();
			}
		};
		client.setConverter(conv);
		client.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(client.getValue().getNomClient());
        });
		
		// COMBOBOX COIFFEUR
		ObservableList<Coiffeur> empData2 = null ;
		try {
			DAO<Coiffeur> CoiffeurDAO = new CoiffeurDAO();
			Coiffeur coiffeur = new Coiffeur();
			 empData2 = CoiffeurDAO.findNom();
		}catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
		coiffeur.setItems(empData2);
		StringConverter<Coiffeur> conv2 = new StringConverter<Coiffeur>() {
			@Override
			public Coiffeur fromString(String string) {
				return null;
			}

			@Override
			public String toString(Coiffeur coif) {
				
				return coif.getNomCoiffeur() + " " +coif.getPrenomCoiffeur();
			}
		};
		coiffeur.setConverter(conv2);
		coiffeur.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(coiffeur.getValue().getNomCoiffeur());
        });
		//COMBOBOX PRESTATIONTYPE
		ObservableList<TypePrestation> empData3 = null ;
		try {
			DAO<TypePrestation> typePrestationDAO = new typePrestationDAO();
			TypePrestation prestation = new TypePrestation();
			 empData3 = typePrestationDAO.findNom();
		}catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
		prestation.setItems(empData3);
		StringConverter<TypePrestation> conv3 = new StringConverter<TypePrestation>() {
			@Override
			public TypePrestation fromString(String string) {
				return null;
			}

			@Override
			public String toString(TypePrestation prestation) {
				
				return prestation.getLibellePrestation();
			}
		};
		prestation.setConverter(conv3);
		prestation.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(prestation.getValue().getLibellePrestation());
        });
			}
		
	@FXML
    private void valider(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		
		DAO<Coiffeur> CoiffeurDAO = new CoiffeurDAO();
		Coiffeur coif = new Coiffeur();
		DAO<Client> ClientDAO = new ClientDAO();
		DAO<TypePrestation> typePrestationDAO = new typePrestationDAO();
		DAO<prestationEffectuee> prestationEffectueeDAO = new prestationEffectueeDAO();
		try {
			prestationEffectueeDAO.create(client.getValue().getNomClient(), prestation.getValue().getLibellePrestation(), coiffeur.getValue().getNomCoiffeur());
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
    }	
	
	@FXML
    private void CbClient(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
    }
	@FXML
    private void CbCoiffeur(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
	}
	@FXML
    private void CbPrestation(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
	}
}
