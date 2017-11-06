package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import bean.prestationEffectuee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

public class prestationEffectueeDAO extends DAO<prestationEffectuee>{

	public static Connection getConnexion() throws ClassNotFoundException, SQLException{
     Connection cnx = Connect.getInstance().getConnection();
        return cnx;
    }

	public int create(String nomClient, String libellePrestation, String nomCoiffeur ) throws ClassNotFoundException, SQLException {
		Connection cnx = getConnexion();
        PreparedStatement pst = null;
        int nblignes = 0;
        String requeteSQL = "INSERT INTO prestationseffectuee (idClientPre, idTypePrestationPre, idCoiffeurPre) values(?, ?, ?)";

        System.out.println("beforexecute");
        pst = cnx.prepareStatement(requeteSQL);

        pst.setInt(1, new ClientDAO().findId(nomClient));
        pst.setInt(2, new typePrestationDAO().findId(libellePrestation));
        pst.setInt(3, new CoiffeurDAO().findId(nomCoiffeur));
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
        String requeteSQL = "DELETE from prestationseffectuee where idPrestationsEffectuees ="+id;

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
	public boolean update(prestationEffectuee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int findId(String nom) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ObservableList<prestationEffectuee> findAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList<prestationEffectuee> findNom() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int total() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
//	public static ObservableList<prestationEffectuee> totalCoiffeurs() throws ClassNotFoundException, SQLException {
//		Map<String,Integer> map = new HashMap<String,Integer>();
//		ObservableMap<String,Integer> observableMap = FXCollections.observableMap(map);
//		prestationEffectueeDAO.totalCoiffeur();
//		map.put(null, null);
//		return null;
//		
//	}
	
	public ObservableMap<String,Integer> totalCoiffeur() throws ClassNotFoundException, SQLException {
		int i = 0;
		String y = null;
		Connection cnx = getConnexion();
        String req = "SELECT nomCoiffeur , COUNT(idPrestationsEffectuees) as total FROM `prestationseffectuee`, coiffeur WHERE prestationseffectuee.idCoiffeurPre = coiffeur.idCoiffeur GROUP BY nomCoiffeur;";
        PreparedStatement pst = cnx.prepareStatement(req);
        Map<String,Integer> map = new HashMap<String,Integer>();
  		ObservableMap<String,Integer> observableMap = FXCollections.observableMap(map);
        ResultSet jeu = pst.executeQuery();
        while(jeu.next()) {

        	i = jeu.getInt("total");
        	y = jeu.getString("nomCoiffeur");
//        	System.out.println(y);
//        	System.out.println(i);
        	 
      		observableMap.put(y,i);
      		System.out.println(observableMap);

        }
      
		return observableMap;
	} 
	



}
