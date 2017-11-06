package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bean.Coiffeur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CoiffeurDAO extends DAO<Coiffeur> {


	public int create(Coiffeur coiffeur) throws ClassNotFoundException, SQLException {
		Connection cnx = getConnexion();
        PreparedStatement pst = null;
        int nblignes = 0;
        String requeteSQL = "INSERT INTO coiffeur (nomCoiffeur, prenomCoiffeur) values(?, ?)";
        System.out.println("beforexecute");
        pst = cnx.prepareStatement(requeteSQL);
    
        pst.setString(1, coiffeur.getNomCoiffeur());
        pst.setString(2, coiffeur.getPrenomCoiffeur());
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
	public int total() throws ClassNotFoundException, SQLException {
		int i = 0;
		Connection cnx = getConnexion();
        String req = "select COUNT(*) as total from coiffeur";
        PreparedStatement pst = cnx.prepareStatement(req);
        ResultSet jeu = pst.executeQuery();
        while(jeu.next()) {
        	i = jeu.getInt("total");
        }
        
		return i ;
		
	}
	
	@Override
	public int delete(int  id) throws ClassNotFoundException, SQLException {   
        Connection cnx = getConnexion();
        PreparedStatement pst = null;
        int nblignes = 0;

        String requeteSQL = "DELETE from coiffeur where idCoiffeur ="+id;

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
	public boolean update(Coiffeur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public ObservableList<Coiffeur> findAll() throws ClassNotFoundException, SQLException {
        Connection cnx = getConnexion();
        ObservableList<Coiffeur> liste = 	FXCollections.observableArrayList();
        
        String req = "select nomCoiffeur , prenomCoiffeur from coiffeur";
        PreparedStatement pst = cnx.prepareStatement(req);
        ResultSet jeu = pst.executeQuery();
        while(jeu.next()){
        	Coiffeur coif = new Coiffeur();
        	coif.setNomCoiffeur(jeu.getString("nomCoiffeur"));
        	coif.setPrenomCoiffeur(jeu.getString("prenomCoiffeur"));
        	liste.add(coif);
        }
        
        return liste;
	}

	public int findId(String nomCoiffeur) throws ClassNotFoundException, SQLException {
		Connection cnx = getConnexion();
        PreparedStatement pst = null;
        ResultSet table = null;
        int i = 0;
        String requeteSQL = "SELECT idCoiffeur FROM coiffeur where nomCoiffeur = ? ";
        
        System.out.println("beforexecute");
        pst = cnx.prepareStatement(requeteSQL);
        pst.setString(1, nomCoiffeur);
       
        try {
            table = pst.executeQuery();
            while(table.next())
            {
            i = table.getInt("idCoiffeur");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        pst.close();
        cnx.close();
        return  i;
		
	}

	@Override
	public ObservableList<Coiffeur> findNom() throws ClassNotFoundException, SQLException {
		ObservableList<Coiffeur> listeN = FXCollections.observableArrayList();
		Connection cnx = getConnexion();
        String req = "select nomCoiffeur , prenomCoiffeur from coiffeur";
        PreparedStatement pst = cnx.prepareStatement(req);
      
        ResultSet jeu = pst.executeQuery();
        while(jeu.next()){
        	Coiffeur coif = new Coiffeur();
        	coif.setNomCoiffeur(jeu.getString("nomCoiffeur"));
        	coif.setPrenomCoiffeur(jeu.getString("prenomCoiffeur"));
        	listeN.add(coif);
        }
        return listeN;
	}
	
}
