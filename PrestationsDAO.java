package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bean.Prestations;
import javafx.collections.ObservableList;

public class PrestationsDAO extends DAO<Prestations> {

	public int create(Prestations prestations, String libellePrestation) throws ClassNotFoundException, SQLException {
		Connection cnx = getConnexion();
        PreparedStatement pst = null;
        int nblignes = 0;
        String requeteSQL = "INSERT INTO prestations (nomprestation , dateheureprestation, idTypePrestation ) values(?, ?, ?)";  

        System.out.println("beforexecute");
        pst = cnx.prepareStatement(requeteSQL);
        pst.setString(1, prestations.getNomPrestation());
        pst.setInt(2, prestations.getDateHeurePrestation());
        pst.setInt(3, new typePrestationDAO().findId(libellePrestation));
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
        String req = "select COUNT(*) as total from typeprestation";
        PreparedStatement pst = cnx.prepareStatement(req);
        ResultSet jeu = pst.executeQuery();
        while(jeu.next()) {
        	i = jeu.getInt("total");
        }
        
		return i ;
		
	}

	


	public int delete(int id) throws ClassNotFoundException, SQLException {
        Connection cnx = getConnexion();
        PreparedStatement pst = null;
        int nblignes = 0;
        String requeteSQL = "DELETE from prestations where idPrestation ="+id;

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
	public boolean update(Prestations obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int findId(String nomPrestation) throws ClassNotFoundException, SQLException {
		Connection cnx = getConnexion();
        PreparedStatement pst = null;
        ResultSet table = null;
        int i = 0;
        String requeteSQL = "SELECT idPrestation FROM prestations where nomPrestation = ? ";
        
        System.out.println("beforexecute");
        pst = cnx.prepareStatement(requeteSQL);
        pst.setString(1, nomPrestation);
        try {
            table = pst.executeQuery();
            while(table.next())
            {
            i = table.getInt("idPrestation");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        pst.close();
        cnx.close();
        return  i;
	}





	@Override
	public ObservableList<Prestations> findAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public ObservableList<Prestations> findNom() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public ArrayList<Prestations> findAll() throws ClassNotFoundException, SQLException {
//		Connection cnx = getConnexion();
//        ArrayList<Prestations> listePresta = new ArrayList<>();
//        
//        String req = "select nomPrestation , dateHeurePrestation, typePrestation from prestation";
//        PreparedStatement pst = cnx.prepareStatement(req);
//      
//        ResultSet jeu = pst.executeQuery();
//        while(jeu.next()){
//        	
//        	Prestations prest = new Prestations();
//        	prest.setDateHeurePrestation(dateHeurePrestation);
//        	prest.setNomPrestation(nomPrestation);
//        	prest.setTypePrestation(typePrestation);
//      
//        	listePresta.add(prest);
//        	
//        }
//        
//       return null;
//	}
//	



}
