package controller;


import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

import DAO.ClientDAO;
import DAO.CoiffeurDAO;
import DAO.DAO;
import DAO.prestationEffectueeDAO;
import application.Main;
import bean.Client;
import bean.Coiffeur;
import bean.prestationEffectuee;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StatistiquesController {
	
	@FXML
	private AnchorPane Statistiques;
	@FXML
	private Button bt_AccueilClient;
	@FXML
	private PieChart pieChart;
	@FXML
	private BarChart<String, Integer> barChart;
	@FXML
	private CategoryAxis cat;
	@FXML
	private NumberAxis numb;

    @FXML
    private void initialize () throws ClassNotFoundException, SQLException  {
    	DAO<Client> ClientDAO = new ClientDAO();
    	DAO<Coiffeur> CoiffeurDAO = new CoiffeurDAO();
    	pieChart.getData().setAll(new PieChart.Data("Clients", ClientDAO.total()),  
                new PieChart.Data("Coiffeurs", CoiffeurDAO.total())
        ); 
    	DAO<prestationEffectuee> prestationEffectueeDAO = new prestationEffectueeDAO();
    	prestationEffectueeDAO prest = new prestationEffectueeDAO();
    	ObservableMap<String, Integer> mapstat = prest.totalCoiffeur();
    	// Boucle pour parcourir l'observableMap
    	for( Map.Entry<String, Integer> e : mapstat.entrySet()) {
//    		cat.setLabel("Coiffeurs");
//    		numb.setLabel("Nombres de prestations");
    	 XYChart.Series dataSeries1 = new XYChart.Series(); 
    	 // On affiche les données parcourues avec e.getKey et e.getValue
         dataSeries1.getData().add(new XYChart.Data(e.getKey(), e.getValue()));
//         dataSeries1.getData().add(new XYChart.Data("C#", 4.429));
//         dataSeries1.getData().add(new XYChart.Data("PHP", 2.792));
    	
    	
         barChart.getData().addAll(dataSeries1); }
    	 
//    	DAO<prestationEffectuee> prestationEffectueeDAO = new prestationEffectueeDAO();
//    	prestationEffectueeDAO prest = new prestationEffectueeDAO();
//    	barChart.getData().setAll(new BarChart<String, Integer>(prest.totalCoiffeur()));
//   
    }
	
	@FXML
	private void goBack(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader().getResource("views/Selection.fxml"));
           AnchorPane Statistiques = (AnchorPane) loader.load();
                Stage stage =  (Stage) bt_AccueilClient.getScene().getWindow();
                Scene scene = bt_AccueilClient.getScene();
                scene.setRoot(Statistiques);
                stage.setScene(scene);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
}
