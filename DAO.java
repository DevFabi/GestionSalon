package DAO;

import java.sql.Connection;
import java.sql.SQLException;


import javafx.collections.ObservableList;

public abstract class DAO<T> {
   
		public static Connection getConnexion() throws ClassNotFoundException, SQLException 
        {
	     Connection cnx = Connect.getInstance().getConnection();
	        return cnx;
	    }
	  
	  public int create(T obj, String libellePrestation)throws ClassNotFoundException, SQLException  { return 0 ;} 
	  public int create(String nomCoiffeur, String nomClient, String nomPrestation)throws ClassNotFoundException, SQLException  { return 0 ;} 
	  public int create(T obj) throws ClassNotFoundException, SQLException  { return 0 ;} 

	  public abstract int delete(int id) throws ClassNotFoundException, SQLException ;

	  public abstract boolean update(T obj);
	  public abstract int total() throws ClassNotFoundException, SQLException;
	  
	  public abstract ObservableList<T> findAll() throws ClassNotFoundException, SQLException;
	  public abstract ObservableList<T> findNom() throws ClassNotFoundException, SQLException;
	  
	  public abstract int findId (String nom) throws ClassNotFoundException, SQLException;

}
