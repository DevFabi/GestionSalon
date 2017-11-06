package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClientDAO extends DAO<Client>{

	@Override
	public int create(Client client) throws ClassNotFoundException, SQLException {
		Connection cnx = getConnexion();
        PreparedStatement pst = null;
        int nblignes = 0;
        String requeteSQL = "INSERT INTO client (nomClient, prenomClient, ageClient, emailClient) values(?, ?, ?, ?)";
        
        System.out.println("beforexecute");
        pst = cnx.prepareStatement(requeteSQL);
        pst.setString(1, client.getNomClient());
        pst.setString(2, client.getPrenomClient());
        pst.setInt(3, client.getAgeClient());
        pst.setString(4, client.getEmailClient());
        try {
            nblignes = pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }
        pst.close();
        cnx.close();
        return nblignes;
	}


	public int delete(int  id) throws ClassNotFoundException, SQLException {   
        Connection cnx = getConnexion();
        PreparedStatement pst = null;
        int nblignes = 0;
        String requeteSQL = "DELETE from client where idClient ="+id;

        System.out.println("beforexecute");
        pst = cnx.prepareStatement(requeteSQL);
        try {
            nblignes = pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        pst.close();
        cnx.close();
        return nblignes;
    }

	@Override
	public boolean update(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int findId(String nomClient) throws ClassNotFoundException, SQLException {
		Connection cnx = getConnexion();
        PreparedStatement pst = null;
        ResultSet table = null;
        int i = 0;
        String requeteSQL = "SELECT idClient FROM client where nomClient = ? ";
        
        System.out.println("beforexecute");
        pst = cnx.prepareStatement(requeteSQL);
        pst.setString(1, nomClient);
        try {
            table = pst.executeQuery();
            while(table.next())
            {
            i = table.getInt("idClient");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        cnx.close();
        return  i;
	}

	@Override
	public ObservableList<Client> findAll() throws ClassNotFoundException, SQLException {
		ObservableList<Client> liste = 	FXCollections.observableArrayList();
		Connection cnx = getConnexion();
        String req = "select nomClient , prenomClient, ageClient, emailClient from client";
        PreparedStatement pst = cnx.prepareStatement(req);
        ResultSet jeu = pst.executeQuery();
        while(jeu.next()){
        	Client clie = new Client();
        	clie.setNomClient(jeu.getString("nomClient"));
        	clie.setPrenomClient(jeu.getString("prenomClient"));
        	clie.setAgeClient(jeu.getInt("ageClient"));
        	clie.setEmailClient(jeu.getString("emailClient"));
        	clie.setMyCheck(false);
        	liste.add(clie);
        }
        return liste;
	}
	
	@Override
	public ObservableList<Client> findNom() throws ClassNotFoundException, SQLException {
		ObservableList<Client> listeN = FXCollections.observableArrayList();
		Connection cnx = getConnexion();
        String req = "select nomClient , prenomClient from client";
        PreparedStatement pst = cnx.prepareStatement(req);
      
        ResultSet jeu = pst.executeQuery();
        while(jeu.next()){
        	Client clie = new Client();
        	clie.setNomClient(jeu.getString("nomClient"));
        	clie.setPrenomClient(jeu.getString("prenomClient"));
        	listeN.add(clie);
        }
        return listeN;
	}


	@Override
	public int total() throws ClassNotFoundException, SQLException {
		int i = 0;
		Connection cnx = getConnexion();
        String req = "select COUNT(*) as total from client";
        PreparedStatement pst = cnx.prepareStatement(req);
        ResultSet jeu = pst.executeQuery();
        while(jeu.next()) {
        	i = jeu.getInt("total"); 
        }
        
		return i ;
		
	}
	
	
// ANCIENNE VERSION AVEC L'ARRAYLIST A LA PLACE DE L'OBSERVABLELIST
	
//	@Override 
//	public ArrayList<Client> findAll() throws ClassNotFoundException, SQLException {
//		Connection cnx = getConnexion();
//        ArrayList<Client> liste = new ArrayList<>();
//        
//        String req = "select nomClient , prenomClient, ageClient, emailClient from client";
//        PreparedStatement pst = cnx.prepareStatement(req);
//      
//        ResultSet jeu = pst.executeQuery();
//        while(jeu.next()){
//        	Client clie = new Client();
//        	clie.setNomClient(jeu.getString("nomClient"));
//        	clie.setPrenomClient(jeu.getString("prenomClient"));
//        	clie.setAgeClient(jeu.getInt("ageClient"));
//        	clie.setEmailClient(jeu.getString("emailClient"));
//        	liste.add(clie);
//        	
//        }
//        
//        return liste;
//	}

}
