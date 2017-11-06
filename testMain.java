package views;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import DAO.ClientDAO;
import DAO.CoiffeurDAO;
import DAO.DAO;
import DAO.PrestationsDAO;
import DAO.prestationEffectueeDAO;
import DAO.typePrestationDAO;
import bean.Client;
import bean.Coiffeur;
import bean.Prestations;
import bean.TypePrestation;
import bean.prestationEffectuee;

public class testMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {



	DAO<prestationEffectuee> prestationEffectueeDAO = new prestationEffectueeDAO();
	prestationEffectueeDAO prest = new prestationEffectueeDAO();
	System.out.println(prest.totalCoiffeur());
//		
//		DAO<TypePrestation> typePrestationDAO = new typePrestationDAO();
//		int i = typePrestationDAO.total();
//		System.out.println(i);

		// TODO Auto-generated method stub

//		DAO<TypePrestation> typePrestationDAO = new typePrestationDAO();
//	    try {
//			ArrayList<TypePrestation>  liste = typePrestationDAO.findAll();
//			for(TypePrestation c : liste)
//				System.out.println(c);
//
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}


//		DAO<Coiffeur> coiffeurDAO = new CoiffeurDAO();
//	    try {
//			ArrayList<Coiffeur>  liste =coiffeurDAO.findAll();
//			for(Coiffeur c : liste)
//				System.out.println(c);
//
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}}}

//	DAO<Client> clientDAO = new ClientDAO();
//	try{
//		ArrayList<Client> liste = clientDAO.findAll();
//		for(Client c : liste)
//			System.out.println(c);
//	} catch (ClassNotFoundException | SQLException e){
//		e.printStackTrace();
//	}}
//	}

//		RECHERCHE ID
//		int i = 0 ;
//		DAO<TypePrestation> typePrestationDAO = new typePrestationDAO();
//	    try {
//			i = typePrestationDAO.findId("coupe enfant");
//			System.out.println(i);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//	}


//		CREATION TYPE PRESTATION
//		int i = 0 ;
//		DAO<TypePrestation> typePrestationDAO = new typePrestationDAO();
//		TypePrestation typeprestation = new TypePrestation("Coupe enfant", 20);
//	    try {
//			i = typePrestationDAO.create(typeprestation);
//			System.out.println(i);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//	}

//CREATION PRESTATION
//	int i ;
//
//	TypePrestation typePrestation = new TypePrestation("Coupe homme", 30);
//	Prestations prestation = new Prestations("presta1", 60, typePrestation);
//	DAO<Prestations> PrestationsDAO = new PrestationsDAO();
//	try {
//		i = PrestationsDAO.create(prestation, "Coupe homme");
//		System.out.println(i);
//	} catch (ClassNotFoundException | SQLException e) {
//		// TODO: handle exception
//		e.printStackTrace();
//	}
//
//	}}

// CREATION PRESTATIONEFFECTUEE


//		int y ;
//
//		DAO<Coiffeur> CoiffeurDAO = new CoiffeurDAO();
//		DAO<Client> ClientDAO = new ClientDAO();
//		DAO<TypePrestation> typePrestationDAO = new typePrestationDAO();
//		DAO<prestationEffectuee> prestationEffectueeDAO = new prestationEffectueeDAO();
//		try {
//			y = prestationEffectueeDAO.create("Belet", "Test", "Jean");
//			System.out.println(y);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		}



 //CREATION CLIENT..
//		int i = 0 ;
//		DAO<Client> ClientDAO = new ClientDAO();
//		Client client = new Client("Jean", "Charle", 42, "zzdkd@zff.com");
//	    try {
//			i = ClientDAO.create(client);
//			System.out.println(i);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//	}}
		//DELETE
//		int i  ;
//		DAO<Coiffeur> CoiffeurDAO = new CoiffeurDAO();
//	    try {
//			i = CoiffeurDAO.delete(1);
//			System.out.println(i);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
	}
	}


