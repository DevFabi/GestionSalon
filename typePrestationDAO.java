package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bean.TypePrestation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class typePrestationDAO extends DAO<TypePrestation> {

	@Override
	public int total() throws ClassNotFoundException, SQLException {
		int i = 0;
		Connection cnx = getConnexion();
        String req = "select COUNT(*) as total from typeprestation";
        PreparedStatement pst = cnx.prepareStatement(req);
        ResultSet jeu = pst.executeQuery();
        while(jeu.next()) {
        	i = jeu.getInt("total"); 
        }
        return i ;}

	public int create(TypePrestation typePrestation) throws ClassNotFoundException, SQLException {
		Connection cnx = getConnexion();
  
        PreparedStatement pst = null;
        int nblignes = 0;
        
        String requeteSQL = "INSERT INTO typeprestation (libellePrestation, prixPrestation) values(?, ?)";
        
        System.out.println("beforexecute"); 
        pst = cnx.prepareStatement(requeteSQL);
        
        pst.setString(1, typePrestation.getLibellePrestation());
        pst.setInt(2, typePrestation.getPrixPrestation());

       
            
        try {
            nblignes = pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        pst.close();
        cnx.close();
        return nblignes;
	}
	
	

	public int delete(int id) throws ClassNotFoundException, SQLException {
        Connection cnx = getConnexion();
        
        PreparedStatement pst = null;
        int nblignes = 0;

        String requeteSQL = "DELETE from typeprestation where idTypePrestation ="+id;

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
	public boolean update(TypePrestation obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int findId(String libellePrestation) throws ClassNotFoundException, SQLException {
		Connection cnx = getConnexion();
		  
        PreparedStatement pst = null;
        ResultSet table = null;
        int i = 0;
        String requeteSQL = "SELECT idTypePrestation FROM typeprestation where libellePrestation = ? ";
        
        System.out.println("beforexecute");
        pst = cnx.prepareStatement(requeteSQL);
        pst.setString(1, libellePrestation);
       
        try {
            table = pst.executeQuery();
            while(table.next())
            {
            i = table.getInt("idtypeprestation");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        pst.close();
        cnx.close();
        return  i;
	}

	@Override
	public ObservableList<TypePrestation> findAll() throws ClassNotFoundException, SQLException {
		   Connection cnx = getConnexion();
	       ObservableList<TypePrestation> liste = FXCollections.observableArrayList();
			
	        
	        String req = "select libelleprestation , prixprestation from typeprestation";
	        PreparedStatement pst = cnx.prepareStatement(req);
	      
	        ResultSet jeu = pst.executeQuery();
	        while(jeu.next()){
	        	
	        	
	        	TypePrestation typep = new TypePrestation();
	        	typep.setLibellePrestation(jeu.getString("libellePrestation"));
	        	typep.setPrixPrestation(jeu.getInt("prixPrestation"));
	        	liste.add(typep);
	        	
	        }
	        
	        return liste;
	}

	@Override
	public ObservableList<TypePrestation> findNom() throws ClassNotFoundException, SQLException {
ObservableList<TypePrestation> listeN = FXCollections.observableArrayList();
		
		Connection cnx = getConnexion();
        String req = "select libellePrestation from typeprestation";
        PreparedStatement pst = cnx.prepareStatement(req);
      
        ResultSet jeu = pst.executeQuery();
        while(jeu.next()){
        	TypePrestation tp = new TypePrestation();
        	tp.setLibellePrestation(jeu.getString("libellePrestation"));
        	listeN.add(tp);
        }
        return listeN;
	}
	}

//	@Override
//	public ArrayList<TypePrestation> findAll() throws ClassNotFoundException, SQLException {
//        Connection cnx = getConnexion();
//        ArrayList<TypePrestation> liste = new ArrayList<>();
//        
//        String req = "select libelleprestation , prixprestation from typeprestation";
//        PreparedStatement pst = cnx.prepareStatement(req);
//      
//        ResultSet jeu = pst.executeQuery();
//        while(jeu.next()){
//        	
//        	
//        	TypePrestation typep = new TypePrestation();
//        	typep.setLibellePrestation(jeu.getString("libellePrestation"));
//        	typep.setPrixPrestation(jeu.getInt("prixPrestation"));
//        	liste.add(typep);
//        	
//        }
//        
//        return liste;
//	}




